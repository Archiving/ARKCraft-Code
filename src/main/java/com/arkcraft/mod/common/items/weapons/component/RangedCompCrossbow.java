package com.arkcraft.mod.common.items.weapons.component;

import com.arkcraft.mod.common.items.weapons.handlers.ReloadHelper;
import com.arkcraft.mod.common.entity.item.projectiles.EntityMetalArrow;
import com.arkcraft.mod.common.entity.item.projectiles.EntityStoneArrow;
import com.arkcraft.mod.common.entity.item.projectiles.EntityTranqArrow;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class RangedCompCrossbow extends RangedComponent
{
	public RangedCompCrossbow()
	{
		super(RangedSpecs.CROSSBOW);
	}
	
	@Override
	public void effectReloadDone(ItemStack itemstack, World world, EntityPlayer entityplayer)
	{
		entityplayer.swingItem();
		world.playSoundAtEntity(entityplayer, "random.click", 0.8F, 1.0F / (weapon.getItemRand().nextFloat() * 0.4F + 0.4F));
	}
	
	public void resetReload(World world, ItemStack itemstack)
	{
		setReloadState(itemstack, ReloadHelper.STATE_NONE);
	}
	
	@Override
	public void fire(ItemStack itemstack, World world, EntityPlayer entityplayer, int i)
	{
		int j = getMaxItemUseDuration(itemstack) - i;
		float f = j / 20F;
		f = (f * f + f * 2.0F) / 3F;
		if (f > 1.0F)
		{
			f = 1.0F;
		}
		f += 0.02F;
		
		if (!world.isRemote)
		{
			EntityStoneArrow entity = new EntityStoneArrow(world, entityplayer, 1.5F / f);
			world.spawnEntityInWorld(entity);
		}
		else if	(!world.isRemote)
		{
			EntityMetalArrow entity = new EntityMetalArrow(world, entityplayer, 1.5F / f);
			world.spawnEntityInWorld(entity);
		}
		else if	(!world.isRemote)
		{
			EntityTranqArrow entity = new EntityTranqArrow(world, entityplayer, 1.5F / f);
			world.spawnEntityInWorld(entity);
		}
		
		int damage = 1;
		if (itemstack.getItemDamage() + damage <= itemstack.getMaxDamage())
		{
			resetReload(world, itemstack);
		}
		itemstack.damageItem(damage, entityplayer);
		
		postShootingEffects(itemstack, entityplayer, world);
		resetReload(world, itemstack);
	}
	
	@Override
	public void effectPlayer(ItemStack itemstack, EntityPlayer entityplayer, World world)
	{
		entityplayer.rotationPitch -= entityplayer.isSneaking() ? 4F : 8F;
	}
	
	@Override
	public void effectShoot(World world, double x, double y, double z, float yaw, float pitch)
	{
		world.playSoundEffect(x, y, z, "random.bow", 1.0F, 1.0F / (weapon.getItemRand().nextFloat() * 0.4F + 0.8F));
	}
}