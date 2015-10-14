package com.arkcraft.mod.common.items;

import com.arkcraft.mod.common.ARKCraft;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagLong;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.registry.GameRegistry;

import com.arkcraft.mod.GlobalAdditions;
import com.arkcraft.mod.common.entity.EntityCobble;
import com.arkcraft.mod.common.entity.EntityExplosive;

public class ARKSlingshot extends Item {

	public ARKSlingshot(String name) {
		super();
		this.setCreativeTab(GlobalAdditions.tabARK);
		this.setUnlocalizedName(name);
		GameRegistry.registerItem(this, name);
	}

	@Override
	public ItemStack onItemRightClick(ItemStack stack, World w, EntityPlayer p) {
			if (p.capabilities.isCreativeMode
					|| p.inventory
							.consumeInventoryItem(ARKCraftItems.cobble_ball)) {
				setLastUseTime(stack, w.getTotalWorldTime());
				w.playSoundAtEntity(p, "random.bow", 0.5F,
						0.4F / (itemRand.nextFloat() * 0.4F + 0.8F));
				if (!w.isRemote)
					w.spawnEntityInWorld(new EntityCobble(w, p));
			}
			else if(p.capabilities.isCreativeMode || p.inventory.consumeInventoryItem(ARKCraftItems.explosive_ball)) {
				setLastUseTime(stack, w.getTotalWorldTime());
				w.playSoundAtEntity(p, "random.bow", 0.5F, 0.4F / (itemRand.nextFloat() * 0.4F + 0.8F));
				if(!w.isRemote) w.spawnEntityInWorld(new EntityExplosive(w,p));
			}
		return super.onItemRightClick(stack, w, p);
	}

	@Override
	public ModelResourceLocation getModel(ItemStack stack, EntityPlayer player,
			int useRemaining) {
		long ticksSinceLastUse = player.worldObj.getTotalWorldTime() - getLastUseTime(stack);
		if (ticksSinceLastUse < 5)
			return new ModelResourceLocation(ARKCraft.MODID + ":slingshot_pulled",
					"inventory");
		else return null;
	}

	private void setLastUseTime(ItemStack stack, long time) {
		stack.setTagInfo("LastUse", new NBTTagLong(time));
	}

	private long getLastUseTime(ItemStack stack) {
		return stack.hasTagCompound() ? stack.getTagCompound().getLong(
				"LastUse") : 0;
	}

}