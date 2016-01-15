package com.arkcraft.module.item.common.guns;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.item.EnumAction;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBow;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.StatCollector;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import com.arkcraft.module.core.ARKCraft;
import com.arkcraft.module.core.GlobalAdditions;
import com.arkcraft.module.item.common.config.KeyBindings;
import com.arkcraft.module.item.common.entity.item.projectiles.EntityProjectile;
import com.arkcraft.module.item.common.entity.item.projectiles.ProjectileType;
import com.arkcraft.module.item.common.items.weapons.bullets.ItemProjectile;
import com.arkcraft.module.item.common.items.weapons.handlers.WeaponModAttributes;
import com.arkcraft.module.item.common.tile.TileInventoryAttachment2;
import com.google.common.collect.HashMultimap;
import com.google.common.collect.Multimap;

public abstract class ItemRangedWeapon extends ItemBow implements IItemWeapon
{
	protected static final int MAX_DELAY = 72000;

	public Set<ItemProjectile> projectiles;
	public final int maxAmmo;

	public ItemRangedWeapon(String name, int durability, int maxAmmo)
	{
		super();
		this.maxAmmo = maxAmmo;
		this.setMaxDamage(durability);
		this.setMaxStackSize(1);
		this.projectiles = new HashSet<ItemProjectile>();
		this.setUnlocalizedName(name);
	}

	@Override
	public String getUnlocalizedName()
	{
		String s = super.getUnlocalizedName();
		return s.substring(s.indexOf('.') + 1);
	}

	public int getMaxAmmo()
	{
		return this.maxAmmo;
	}

	public boolean registerProjectile(ItemProjectile projectile)
	{
		return this.projectiles.add(projectile);
	}

	public boolean isValidProjectile(Item item)
	{
		return this.projectiles.contains(item);
	}

	@Override
	public ModelResourceLocation getModel(ItemStack stack, EntityPlayer player, int useRemaining)
	{
		String jsonPath = ARKCraft.MODID + ":" + this.getUnlocalizedName();
		if (new TileInventoryAttachment2(stack).isScopePresent())
		{
			jsonPath = jsonPath + "_scoped";
		}
		return new ModelResourceLocation(jsonPath, "inventory");
	}

	@Override
	public Random getItemRand()
	{
		return new Random();
	}

	@Override
	public int getMaxItemUseDuration(ItemStack stack)
	{
		return MAX_DELAY;
	}

	@Override
	public boolean canScope(ItemStack stack)
	{
		return new TileInventoryAttachment2(stack).isScopePresent();
	}

	@Override
	public ItemStack onItemRightClick(ItemStack stack, World world, EntityPlayer player)
	{
		if (stack.stackSize <= 0 || player.isUsingItem()) { return stack; }

		if (!world.isRemote && KeyBindings.attachment.isKeyDown())
		{
			// TODO Why no work other way
			// If player not sneaking, open the inventory gui
			if (!player.isSneaking())
			{
				player.openGui(ARKCraft.instance, GlobalAdditions.GUI.ATTACHMENT_GUI.getID(),
						world, 0, 0, 0);
			}

			return stack;
		}

		if (canFire(stack, player))
		{
			// Start aiming weapon to fire
			player.setItemInUse(stack, getMaxItemUseDuration(stack));
		}
		// Check can reload
		else if (hasAmmoInInventory(player))
		{
			// Begin reloading
			soundCharge(stack, world, player);
			player.setItemInUse(stack, getMaxItemUseDuration(stack));
			if (world.isRemote && !player.capabilities.isCreativeMode)
			// i.e. "20 ammo"
			{
				player.addChatMessage(new ChatComponentText(getAmmoQuantity(stack) + StatCollector
						.translateToLocal("chat.ammo")));
			}
		}
		else
		{
			// Can't reload; no ammo
			soundEmpty(stack, world, player);
		}
		return stack;
	}

	@Override
	public EnumAction getItemUseAction(ItemStack stack)
	{
		return EnumAction.NONE;
	}

	@Override
	public void onUsingTick(ItemStack stack, EntityPlayer player, int count)
	{
		if (canReload(stack) && this.getMaxItemUseDuration(stack) - count >= getReloadDuration())
		{
			if (hasAmmoAndConsume(stack, player))
			{
				effectReloadDone(stack, player.worldObj, player);
				player.clearItemInUse();
			}
		}
	}

	private boolean hasAmmoAndConsume(ItemStack stack, EntityPlayer player)
	{
		int ammoFinal = 0;
		for (ItemStack invStack : player.inventory.mainInventory)
		{
			if (invStack != null) if (isValidProjectile(invStack.getItem()))
			{
				int stackSize = invStack.stackSize;
				String type = invStack.getItem().getUnlocalizedName().toUpperCase();
				stack.getTagCompound().setString("ammotype", type);
				int ammo = stackSize < this.getMaxAmmo() - ammoFinal ? stackSize : this
						.getMaxAmmo();
				ammoFinal += ammo;
				invStack.stackSize = stackSize - ammo;
				if (ammoFinal == this.getMaxAmmo()) break;
			}
		}
		if (ammoFinal > 0)
		{
			this.setAmmoQuantity(stack, ammoFinal);
			this.setJustReloaded(stack, true);
			return true;
		}

		return false;
	}

	@Override
	public void onPlayerStoppedUsing(ItemStack stack, World world, EntityPlayer player, int timeLeft)
	{
		if (!isLoaded(stack)) { return; }
		if (canFire(stack, player))
		{
			{
				fire(stack, world, player, timeLeft);
				return;
			}
		}
		this.setJustReloaded(stack, false);
	}

	public boolean canReload(ItemStack stack)
	{
		return getAmmoQuantity(stack) <= 0;
	}

	public boolean canFire(ItemStack stack, EntityPlayer player)
	{
		return (player.capabilities.isCreativeMode || isLoaded(stack)) && !isJustReloaded(stack);
	}

	private boolean isJustReloaded(ItemStack stack)
	{
		if (stack.getTagCompound() != null) return stack.getTagCompound()
				.getBoolean("justReloaded");
		return false;
	}

	private void setJustReloaded(ItemStack stack, boolean bool)
	{
		stack.getTagCompound().setBoolean("justReloaded", bool);
	}

	public boolean hasAmmoInInventory(EntityPlayer player)
	{
		return findAvailableAmmo(player) != null;
	}

	public ItemProjectile findAvailableAmmo(EntityPlayer player)
	{
		for (ItemProjectile projectile : projectiles)
		{
			if (player.inventory.hasItem(projectile)) return projectile;
		}
		return null;
	}

	public int getAmmoQuantityInInventory(ItemStack stack, EntityPlayer player)
	{
		InventoryPlayer inventory = player.inventory;
		String type = getAmmoType(stack);
		Item item = GameRegistry.findItem(ARKCraft.MODID, type);
		int out = 0;
		if (type != null && inventory.hasItem(item))
		{
			for (ItemStack s : inventory.mainInventory)
			{
				if (s.getItem().equals(item))
				{
					out += s.stackSize;
				}
			}
		}
		return out;
	}

	public int getAmmoQuantity(ItemStack stack)
	{
		return stack.getTagCompound().getInteger("ammo");
	}

	public void setAmmoQuantity(ItemStack stack, int ammo)
	{
		stack.getTagCompound().setInteger("ammo", ammo);
	}

	public String getAmmoType(ItemStack stack)
	{
		return stack.getTagCompound().getString("ammotype");
	}

	public boolean isLoaded(ItemStack stack)
	{
		return getAmmoQuantity(stack) > 0;
	}

	public void soundEmpty(ItemStack itemstack, World world, EntityPlayer entityplayer)
	{
		world.playSoundAtEntity(entityplayer, "random.click", 1.0F, 1.0F / 0.8F);
	}

	public void soundCharge(ItemStack stack, World world, EntityPlayer player)
	{
		world.playSoundAtEntity(player,
				ARKCraft.MODID + ":" + this.getUnlocalizedName() + "_reload", 0.7F,
				0.9F / (getItemRand().nextFloat() * 0.2F + 0.0F));
	}

	public abstract int getReloadDuration();

	public void applyProjectileEnchantments(EntityProjectile entity, ItemStack itemstack)
	{
		int damage = EnchantmentHelper.getEnchantmentLevel(Enchantment.power.effectId, itemstack);
		if (damage > 0)
		{
			entity.setDamage(damage);
		}

		int knockback = EnchantmentHelper
				.getEnchantmentLevel(Enchantment.punch.effectId, itemstack);
		if (knockback > 0)
		{
			entity.setKnockbackStrength(knockback);
		}

		if (EnchantmentHelper.getEnchantmentLevel(Enchantment.flame.effectId, itemstack) > 0)
		{
			entity.setFire(100);
		}
	}

	public final void postShootingEffects(ItemStack itemstack, EntityPlayer entityplayer, World world)
	{
		effectPlayer(itemstack, entityplayer, world);
		effectShoot(world, entityplayer.posX, entityplayer.posY, entityplayer.posZ,
				entityplayer.rotationYaw, entityplayer.rotationPitch);
	}

	public abstract void effectPlayer(ItemStack itemstack, EntityPlayer entityplayer, World world);

	public abstract void effectShoot(World world, double x, double y, double z, float yaw, float pitch);

	public void fire(ItemStack stack, World world, EntityPlayer player, int timeLeft)
	{
		if (!world.isRemote)
		{
			String type = this.getAmmoType(stack);
			Object x = null;
			try
			{
				Class<?> c = Class
						.forName("com.arkcraft.module.item.common.entity.item.projectiles." + ProjectileType
								.valueOf(type).getEntity());
				Constructor<?> con = c.getConstructor(World.class, EntityLivingBase.class);
				x = con.newInstance(world, player);

			}
			catch (ClassNotFoundException e)
			{
				e.printStackTrace();
			}
			catch (NoSuchMethodException e)
			{
				e.printStackTrace();
			}
			catch (SecurityException e)
			{
				e.printStackTrace();
			}
			catch (InstantiationException e)
			{
				e.printStackTrace();
			}
			catch (IllegalAccessException e)
			{
				e.printStackTrace();
			}
			catch (IllegalArgumentException e)
			{
				e.printStackTrace();
			}
			catch (InvocationTargetException e)
			{
				e.printStackTrace();
			}
			EntityProjectile projectile = (EntityProjectile) x;
			applyProjectileEnchantments(projectile, stack);
			world.spawnEntityInWorld(projectile);
		}

		this.setAmmoQuantity(stack, this.getAmmoQuantity(stack) - 1);
		int damage = 1;
		if (stack.getItemDamage() + damage > stack.getMaxDamage())
		{
			int ammo = this.getAmmoQuantity(stack);
			String type = this.getAmmoType(stack);
			Item i = GameRegistry.findItem(ARKCraft.MODID, type);
			ItemStack s = new ItemStack(i, ammo);
			player.inventory.addItemStackToInventory(s);
		}

		stack.damageItem(damage, player);
		postShootingEffects(stack, player, world);
	}

	public void effectReloadDone(ItemStack stack, World world, EntityPlayer player)
	{
		// player.swingItem();
	}

	@Override
	public Multimap<String, AttributeModifier> getItemAttributeModifiers()
	{
		Multimap<String, AttributeModifier> multimap = HashMultimap.create();
		this.addItemAttributeModifiers(multimap);
		return multimap;
	}

	public void addItemAttributeModifiers(Multimap<String, AttributeModifier> multimap)
	{
		multimap.put(WeaponModAttributes.RELOAD_TIME.getAttributeUnlocalizedName(),
				new AttributeModifier("Weapon reloadtime modifier", this.getReloadDuration(), 0));
	}

	@Override
	@SideOnly(Side.CLIENT)
	public boolean isFull3D()
	{
		return true;
	}
}
