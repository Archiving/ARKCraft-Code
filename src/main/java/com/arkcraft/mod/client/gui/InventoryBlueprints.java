package com.arkcraft.mod.client.gui;

import com.arkcraft.mod.common.lib.LogHelper;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.InventoryBasic;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;

/***
 * 
 * @author wildbill22
 *
 */
public class InventoryBlueprints extends InventoryBasic {
	
	public InventoryBlueprints(String title, boolean customName, int slotCount) {
		super(title, customName, slotCount);
	}

    public void loadInventoryFromNBT(NBTTagCompound nbt)  {
		final byte NBT_TYPE_COMPOUND = 10;  
		NBTTagList dataForAllBlueprints = nbt.getTagList("Blueprints", NBT_TYPE_COMPOUND);
		loadInventoryFromNBT(dataForAllBlueprints);
    }
    
    public void loadInventoryFromNBT(NBTTagList nbt)  {
        int i;
        for (i = 0; i < this.getSizeInventory(); ++i) {
            this.setInventorySlotContents(i, (ItemStack)null);
        }
        for (i = 0; i < nbt.tagCount(); ++i) {
            NBTTagCompound nbttagcompound = nbt.getCompoundTagAt(i);
            int j = nbttagcompound.getByte("Slot") & 255;

            if (j >= 0 && j < this.getSizeInventory()) {
                this.setInventorySlotContents(j, ItemStack.loadItemStackFromNBT(nbttagcompound));
            }
        }
    }

    public void saveInventoryToNBT(NBTTagCompound nbt) {
        NBTTagList nbttaglist = new NBTTagList();
        for (int i = 0; i < this.getSizeInventory(); ++i) {
            ItemStack itemstack = this.getStackInSlot(i);
            if (itemstack != null) {
                NBTTagCompound nbttagcompound = new NBTTagCompound();
                nbttagcompound.setByte("Slot", (byte)i);
                itemstack.writeToNBT(nbttagcompound);
                nbttaglist.appendTag(nbttagcompound);
                LogHelper.info("InventoryBlueprints: Saved a " + itemstack.getItem() + " to inventory.");
            }
        }
		nbt.setTag("Blueprints", nbttaglist);
    }

    /**
     * Do not give this method the name canInteractWith because it clashes with Container
     */
    public boolean isUseableByPlayer(EntityPlayer player) {
        return false;
    }

    public void openInventory(EntityPlayer player)  {
        super.openInventory(player);
    }

    public void closeInventory(EntityPlayer player) {
        super.closeInventory(player);
    }

	public int getBlueprintSelected() {
		// TODO Auto-generated method stub
		return 0;
	}

	public boolean isCrafting() {
		// TODO Auto-generated method stub
		return false;
	}

	public int getNumBlueprints() {
		// TODO Auto-generated method stub
		return 0;
	}

	public boolean isCraftingOne() {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean isCraftingAll() {
		// TODO Auto-generated method stub
		return false;
	}

	public String getNumToBeCrafted() {
		// TODO Auto-generated method stub
		return null;
	}

	public double fractionCraftingRemainingForItem() {
		// TODO Auto-generated method stub
		return 0;
	}

	public void selectPrevBlueprint() {
		// TODO Auto-generated method stub
		
	}

	public void selectNextBlueprint() {
		// TODO Auto-generated method stub
		
	}

	public void setCraftAllPressed(boolean b, boolean c) {
		// TODO Auto-generated method stub
		
	}

	public void setCraftOnePressed(boolean b, boolean c) {
		// TODO Auto-generated method stub
		
	}    
}
