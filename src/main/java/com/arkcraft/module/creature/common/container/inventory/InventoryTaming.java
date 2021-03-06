package com.arkcraft.module.creature.common.container.inventory;

import java.util.Arrays;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagIntArray;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.server.gui.IUpdatePlayerListBox;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.ChatComponentTranslation;
import net.minecraft.util.IChatComponent;
import net.minecraft.util.MathHelper;

import com.arkcraft.lib.LogHelper;
import com.arkcraft.module.creature.common.entity.EntityTameableDinosaur;
import com.arkcraft.module.items.ARKCraftItems;
import com.arkcraft.module.items.common.general.ItemARKBase;
import com.arkcraft.module.items.common.general.ItemARKFood;

/**
 * @author wildbill22
 */
public class InventoryTaming implements IInventory, IUpdatePlayerListBox
{
	/**
	 * The dino whose inventory this is.
	 */
	EntityTameableDinosaur entityDino;
	/**
	 * The player who started the taming process (with the GUI).
	 */
	public EntityPlayer playerTaming;

	// Other class variables
	int tick = 20;

	public InventoryTaming(EntityTameableDinosaur entityDino)
	{
		this.entityDino = entityDino;
		TAMING_TIME_FOR_COMPLETION = (short) entityDino.getTamingSeconds();
	}

	// Create and initialize the itemStacks variable that will store store the
	// itemStacks
	public static final int NARCO_SLOTS_COUNT = 1;
	public static final int FOOD_SLOTS_COUNT = 1;
	public static final int TOTAL_SLOTS_COUNT = NARCO_SLOTS_COUNT + FOOD_SLOTS_COUNT;

	public static final int NARCO_SLOT = 0;
	public static final int FOOD_SLOT = 1;
	public static final int FIRST_INPUT_SLOT = NARCO_SLOT;

	private ItemStack[] itemStacks = new ItemStack[TOTAL_SLOTS_COUNT];
	/**
	 * Set true whenever the inventory changes. Nothing sets it false so you
	 * will have to write your own code to check it and reset the value.
	 */
	public boolean inventoryChanged;

	/**
	 * The number of feeding ticks remaining on the current piece of food
	 */
	private int[] feedingTimeRemaining = new int[FOOD_SLOTS_COUNT];
	/**
	 * The initial food value of the currently feeding food (in ticks of feeding
	 * duration)
	 */
	private int[] feedingTimeInitialValue = new int[FOOD_SLOTS_COUNT];

	/**
	 * The number of ticks the dino has been taming
	 */
	private short tamingTime;
	/**
	 * The number of ticks required to tame the dino
	 */
	private short TAMING_TIME_FOR_COMPLETION = 50; // vanilla value is 50
													// seconds

	/**
	 * Number of ticks dino will remain unconscious
	 */
	private short torporTime = 0;
	/**
	 * Torpor time maximum that can be set
	 */
	private static short MAX_TORPOR_TIME = 150;

	@SuppressWarnings("unused")
	private int cachedNumberOfFeedingSlots = -1;

	/**
	 * Returns the amount of food remaining on the currently feeding item in the
	 * given food slot.
	 *
	 * @param foodSlot
	 *            the number of the food slot (1)
	 * @return fraction remaining, between 0 - 1
	 */
	public double fractionOfFoodRemaining(int foodSlot)
	{
		if (feedingTimeInitialValue[foodSlot] <= 0) { return 0; }
		double fraction = feedingTimeRemaining[foodSlot] / (double) feedingTimeInitialValue[foodSlot];
		return MathHelper.clamp_double(fraction, 0.0, 1.0);
	}

	/**
	 * return the remaining feed time of the food in the given slot
	 *
	 * @param foodSlot
	 *            the number of the food slot (1)
	 * @return seconds remaining
	 */
	public int secondsOfFoodRemaining(int foodSlot)
	{
		if (feedingTimeRemaining[foodSlot] <= 0) { return 0; }
		return feedingTimeRemaining[foodSlot];
	}

	/**
	 * Get the number of slots which have food in them.
	 *
	 * @return number of slots with food, 0 - FOOD_SLOTS_COUNT
	 */
	public int numberOfFoodInSlots()
	{
		int foodCount = 0;
		for (int feedingTime : feedingTimeRemaining)
		{
			if (feedingTime > 0)
			{
				++foodCount;
			}
		}
		return foodCount;
	}

	/**
	 * Returns the amount of taming time completed.
	 *
	 * @return fraction remaining, between 0 - 1
	 */
	public double fractionOfTamingTimeComplete()
	{
		double fraction = tamingTime / (double) TAMING_TIME_FOR_COMPLETION;
		return MathHelper.clamp_double(fraction, 0.0, 1.0);
	}

	// This method is called every tick to update the entity, i.e.
	// - see if the food runs out, and if so turn the taming "off" and slowly
	// untames the dino
	// - use any tranquilizer to increase the torpor level
	// - see if the tranquilizer runs out, and "wake" the dino if it does
	// - see if dino is tamed
	// It runs both on the server and the client.
	@Override
	public void update()
	{
		if (tick >= 0)
		{
			tick--;
			return;
		}
		else
		{
			tick = 20;
		}
		// If there is nothing to feed or not unconscious, reset feedTime and
		// return
		if (canTame())
		{
			int numberOfFoodFeeding = feedDino();
			tranqDino();

			// If food is available, keep taming, otherwise start "untaming" it
			// at double speed
			if (numberOfFoodFeeding > 0)
			{
				tamingTime += numberOfFoodFeeding;
			}
			else
			{
				tamingTime -= 2;
			}
			if (tamingTime < 0)
			{
				tamingTime = 0;
			}
			torporTime--;

			// Failed to tame?
			if (torporTime <= 0)
			{
				tamingTime = 0;
				torporTime = 0;
				this.entityDino.setSitting(false);
				this.setTorporTime((short) 0);
				if (this.entityDino.worldObj != null & this.entityDino.worldObj.isRemote)
				{
					LogHelper.info("InventoryTaming - update: setSitting(false) from client");
				}
				else
				{
					LogHelper.info("InventoryTaming - update: setSitting(false) from server");
				}
			}

			// If tamingTime has reached maxTamingTime the dino is tamed
			if (tamingTime >= TAMING_TIME_FOR_COMPLETION)
			{
				setToTamed();
				tamingTime = 0;
				torporTime = 0;
			}
		}
		else
		{
			tamingTime = 0;
		}
	}

	/**
	 * For each food slot: decreases the feed time, checks if feedTimeRemaining
	 * = 0 and tries to consume a new piece of food if one is available
	 *
	 * @return the number of food slots which are being eaten
	 */
	private int feedDino()
	{
		int feedingCount = 0;
		boolean inventoryChanged = false;
		// Iterate over all the food slots
		for (int i = 0; i < FOOD_SLOTS_COUNT; i++)
		{
			int foodSlotNumber = i + FOOD_SLOT;
			if (feedingTimeRemaining[i] > 0)
			{
				--feedingTimeRemaining[i];
				++feedingCount;
			}
			if (feedingTimeRemaining[i] == 0)
			{
				if (itemStacks[foodSlotNumber] != null && getItemFeedTime(itemStacks[foodSlotNumber]) > 0)
				{
					// If the stack in this slot is not null and is fuel, set
					// feedingTimeRemaining & feedingTimeInitialValue to the
					// item's feed time and decrease the stack size
					feedingTimeRemaining[i] = feedingTimeInitialValue[i] = getItemFeedTime(itemStacks[foodSlotNumber]);
					--itemStacks[foodSlotNumber].stackSize;
					++feedingCount;
					inventoryChanged = true;
					// If the stack size now equals 0 set the slot contents to
					// the items container item. This is for fuel
					// items such as lava buckets so that the bucket is not
					// consumed. If the item dose not have
					// a container item getContainerItem returns null which sets
					// the slot contents to null
					if (itemStacks[foodSlotNumber].stackSize == 0)
					{
						itemStacks[foodSlotNumber] = itemStacks[foodSlotNumber].getItem()
								.getContainerItem(itemStacks[foodSlotNumber]);
					}
				}
			}
		}
		if (inventoryChanged)
		{
			markDirty();
		}
		return feedingCount;
	}

	/**
	 * Returns the seconds of feeding time left.
	 *
	 * @return seconds
	 */
	public int secondsOfFeedingTimeLeft()
	{
		if (itemStacks[FOOD_SLOT] != null)
		{
			return itemStacks[FOOD_SLOT].stackSize * feedingTimeInitialValue[0] + feedingTimeRemaining[0];
		}
		else
		{
			return feedingTimeRemaining[0];
		}
	}

	// Tranquilize dino with a berry
	private void tranqDino()
	{
		boolean inventoryChanged = false;
		if (itemStacks[NARCO_SLOT] != null)
		{
			torporTime += getTranqTime(itemStacks[NARCO_SLOT]);
			if (torporTime > MAX_TORPOR_TIME)
			{
				torporTime = MAX_TORPOR_TIME;
			}
			--itemStacks[NARCO_SLOT].stackSize;
			inventoryChanged = true;
			// If the stack size now equals 0 set the slot contents to the items
			// container item. This is for fuel
			// items such as lava buckets so that the bucket is not consumed. If
			// the item dose not have
			// a container item getContainerItem returns null which sets the
			// slot contents to null
			if (itemStacks[NARCO_SLOT].stackSize == 0)
			{
				itemStacks[NARCO_SLOT] = itemStacks[NARCO_SLOT].getItem().getContainerItem(
						itemStacks[NARCO_SLOT]);
			}
		}
		if (inventoryChanged)
		{
			markDirty();
		}
	}

	/**
	 * Check if the dino is tameable
	 *
	 * @return true if taming is complete
	 */
	private boolean canTame()
	{
		return this.entityDino.isTameable() && !this.entityDino.isTamed() && torporTime != 0;
	}

	/**
	 * Tame the dino, if possible
	 *
	 * @return
	 */
	private void setToTamed()
	{
		this.entityDino.setTamed(playerTaming, true);
		this.setTorporTime((short) 0);
		this.entityDino.setIsTaming(false);
		// Copy the taming inventory to the new tamed inventory
		for (int i = 0; i < entityDino.invTaming.getSizeInventory() && i < entityDino.invTamedDino
				.getSizeInventory(); i++)
		{
			entityDino.invTamedDino.setInventorySlotContents(i,
					entityDino.invTaming.getStackInSlot(i));
		}
	}

	// returns the number of ticks the the food will feed. Returns 0 if the item
	// will not feed the dino
	public static short getItemFeedTime(ItemStack stack)
	{
		int feedtime = ItemARKFood.getItemFeedTime(stack);
		return (short) MathHelper.clamp_int(feedtime, 0, Short.MAX_VALUE);
	}

	// returns the number of ticks the food will tranquilize. Returns 0 if the
	// item does not tranquilize
	public static short getTranqTime(ItemStack stack)
	{
		if (stack.getItem() instanceof ItemARKBase) { return (short) MathHelper.clamp_int(
				ItemARKBase.getItemTorporTime(stack), 0, Short.MAX_VALUE); }
		if (stack.getItem() instanceof ItemARKFood) { return (short) MathHelper.clamp_int(
				ItemARKFood.getItemTorporTime(stack), 0, Short.MAX_VALUE); }
		return 0;
	}

	@Override
	public String getName()
	{
		return entityDino.getName();
	}

	@Override
	public boolean hasCustomName()
	{
		return false;
	}

	@Override
	public IChatComponent getDisplayName()
	{
		return this.hasCustomName() ? new ChatComponentText(this.getName()) : new ChatComponentTranslation(
				this.getName());
	}

	@Override
	public int getSizeInventory()
	{
		return itemStacks.length;
	}

	@Override
	public ItemStack getStackInSlot(int index)
	{
		return itemStacks[index];
	}

	@Override
	public ItemStack decrStackSize(int slotIndex, int count)
	{
		ItemStack itemStackInSlot = getStackInSlot(slotIndex);
		if (itemStackInSlot == null) { return null; }

		ItemStack itemStackRemoved;
		if (itemStackInSlot.stackSize <= count)
		{
			itemStackRemoved = itemStackInSlot;
			setInventorySlotContents(slotIndex, null);
		}
		else
		{
			itemStackRemoved = itemStackInSlot.splitStack(count);
			if (itemStackInSlot.stackSize == 0)
			{
				setInventorySlotContents(slotIndex, null);
			}
		}
		markDirty();
		return itemStackRemoved;
	}

	@Override
	public ItemStack getStackInSlotOnClosing(int index)
	{
		return null;
	}

	@Override
	public void setInventorySlotContents(int slotIndex, ItemStack itemstack)
	{
		itemStacks[slotIndex] = itemstack;
		if (itemstack != null && itemstack.stackSize > getInventoryStackLimit())
		{
			itemstack.stackSize = getInventoryStackLimit();
		}
		markDirty();
	}

	@Override
	public int getInventoryStackLimit()
	{
		return 64;
	}

	@Override
	public boolean isUseableByPlayer(EntityPlayer player)
	{
		return entityDino.isUseableByPlayer(player);
	}

	@Override
	public void openInventory(EntityPlayer player)
	{
		// TODO Auto-generated method stub
	}

	@Override
	public void closeInventory(EntityPlayer player)
	{
		// TODO Auto-generated method stub
	}

	@Override
	public boolean isItemValidForSlot(int index, ItemStack stack)
	{
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void clear()
	{
		Arrays.fill(itemStacks, null);
	}

	// Returns double between 0 and 1 representing % full level
	public double unconciousLevel()
	{
		double fraction = torporTime / (double) MAX_TORPOR_TIME;
		return MathHelper.clamp_double(fraction, 0.0, 1.0);
	}

	// Returns double between 0 and 1 representing % full level
	public double tamingLevel()
	{
		double fraction = tamingTime / (double) TAMING_TIME_FOR_COMPLETION;
		return MathHelper.clamp_double(fraction, 0.0, 1.0);
	}

	// Return true if stack will tranquilize the dino
	public boolean isItemValidForNarcoSlot(ItemStack stack)
	{
		if (stack != null && stack.getItem() == ARKCraftItems.narcoBerry || stack.getItem() == ARKCraftItems.narcotics)
		{
			return true;
		}
		else
		{
			return false;
		}
	}

	// Return true if stack is a valid seed for the crop plot
	public boolean isItemValidForFoodSlot(ItemStack stack)
	{
		if (ItemARKFood.getItemFeedTime(stack) > 0)
		{
			return true;
		}
		else
		{
			return false;
		}
	}

	// ------------------------------

	// Fields are used to send non-inventory information from the server to
	// interested clients
	// The container code caches the fields and sends the client any fields
	// which have changed.
	// The field ID is limited to byte, and the field value is limited to short.
	// (if you use more than this, they get cast down
	// in the network packets)
	// If you need more than this, or shorts are too small, use a custom packet
	// in your container instead.

	private static final byte UNCONSCIOUS_FIELD_ID = 0;
	private static final byte TAMING_FIELD_ID = 1;
	private static final byte NUMBER_OF_FIELDS = 2;

	@Override
	public int getField(int id)
	{
		if (id == UNCONSCIOUS_FIELD_ID) { return torporTime; }
		if (id == TAMING_FIELD_ID) { return tamingTime; }
		System.err.println("Invalid field ID in InventoryTaming.getField:" + id);
		return 0;
	}

	@Override
	public void setField(int id, int value)
	{
		if (id == UNCONSCIOUS_FIELD_ID)
		{
			torporTime = (short) value;
		}
		else if (id == TAMING_FIELD_ID)
		{
			tamingTime = (short) value;
		}
		else
		{
			System.err.println("Invalid field ID in InventoryTaming.setField:" + id);
		}
	}

	@Override
	public int getFieldCount()
	{
		return NUMBER_OF_FIELDS;
	}

	@Override
	public void markDirty()
	{
		this.inventoryChanged = true;
	}

	// ------------------------------

	// This is where you save any data that you don't want to lose when the tile
	// entity unloads
	// In this case, it saves the state of the furnace (burn time etc) and the
	// itemstacks stored in the fuel, input, and output slots
	public void saveInventoryToNBT(NBTTagCompound parentNBTTagCompound)
	{
		// to use an analogy with Java, this code generates an array of hashmaps
		// The itemStack in each slot is converted to an NBTTagCompound, which
		// is effectively a hashmap of key->value pairs such
		// as slot=1, id=2353, count=1, etc
		// Each of these NBTTagCompound are then inserted into NBTTagList, which
		// is similar to an array.
		NBTTagList dataForAllSlots = new NBTTagList();
		for (int i = 0; i < this.itemStacks.length; ++i)
		{
			if (this.itemStacks[i] != null)
			{
				NBTTagCompound dataForThisSlot = new NBTTagCompound();
				dataForThisSlot.setByte("Slot", (byte) i);
				this.itemStacks[i].writeToNBT(dataForThisSlot);
				dataForAllSlots.appendTag(dataForThisSlot);
			}
		}
		// the array of hashmaps is then inserted into the parent hashmap for
		// the container
		parentNBTTagCompound.setTag("Items", dataForAllSlots);

		// Save everything else
		parentNBTTagCompound.setTag("burnTimeRemaining", new NBTTagIntArray(feedingTimeRemaining));
		parentNBTTagCompound.setTag("burnTimeInitial", new NBTTagIntArray(feedingTimeInitialValue));
		parentNBTTagCompound.setShort("tamingTime", tamingTime);
		parentNBTTagCompound.setShort("torporTime", torporTime);
	}

	// This is where you load the data that you saved in writeToNBT
	public void loadInventoryFromNBT(NBTTagCompound nbtTagCompound)
	{
		final byte NBT_TYPE_COMPOUND = 10; // See NBTBase.createNewByType() for
											// a listing
		NBTTagList dataForAllSlots = nbtTagCompound.getTagList("Items", NBT_TYPE_COMPOUND);

		Arrays.fill(itemStacks, null); // set all slots to empty
		for (int i = 0; i < dataForAllSlots.tagCount(); ++i)
		{
			NBTTagCompound dataForOneSlot = dataForAllSlots.getCompoundTagAt(i);
			byte slotNumber = dataForOneSlot.getByte("Slot");
			if (slotNumber >= 0 && slotNumber < this.itemStacks.length)
			{
				this.itemStacks[slotNumber] = ItemStack.loadItemStackFromNBT(dataForOneSlot);
			}
		}

		// Load everything else. Trim the arrays (or pad with 0) to make sure
		// they have the correct number of elements
		feedingTimeRemaining = Arrays.copyOf(nbtTagCompound.getIntArray("feedingTimeRemaining"),
				FOOD_SLOTS_COUNT);
		feedingTimeInitialValue = Arrays.copyOf(
				nbtTagCompound.getIntArray("feedingTimeInitialValue"), FOOD_SLOTS_COUNT);
		tamingTime = nbtTagCompound.getShort("tamingTime");
		torporTime = nbtTagCompound.getShort("torporTime");
		cachedNumberOfFeedingSlots = -1;
	}

	/**
	 * Returns true when at max torpor
	 */
	public boolean setTorporTime(short i)
	{
		torporTime = i;
		if (torporTime > MAX_TORPOR_TIME)
		{
			torporTime = MAX_TORPOR_TIME;
			return true;
		}
		return false;
	}

	public int getTorporTime()
	{
		return torporTime;
	}

	// When the world loads from disk, the server needs to send the TileEntity
	// information to the client
	// it uses getDescriptionPacket() and onDataPacket() to do this
	// @Override
	// public Packet getDescriptionPacket() {
	// NBTTagCompound nbtTagCompound = new NBTTagCompound();
	// writeToNBT(nbtTagCompound);
	// final int METADATA = 0;
	// return new S35PacketUpdateTileEntity(this.pos, METADATA, nbtTagCompound);
	// }
	//
	// public void onDataPacket(NetworkManager net, S35PacketUpdateTileEntity
	// pkt) {
	// loadInventoryFromNBT(pkt.getNbtCompound());
	// }

	// ------------------------
}
