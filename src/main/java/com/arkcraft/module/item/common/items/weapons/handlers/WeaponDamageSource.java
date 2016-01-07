package com.arkcraft.module.item.common.items.weapons.handlers;

import com.arkcraft.module.item.common.entity.item.projectiles.EntityShootable;
import net.minecraft.entity.Entity;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EntityDamageSourceIndirect;

public class WeaponDamageSource extends EntityDamageSourceIndirect
{
    private EntityShootable projectileEntity;
    private Entity thrower;

    public WeaponDamageSource(String s, EntityShootable projectile, Entity entity)
    {
        super(s, projectile, entity);
        projectileEntity = projectile;
        thrower = entity;
    }

    public Entity getProjectile()
    {
        return projectileEntity;
    }

    @Override
    public Entity getEntity()
    {
        return thrower;
    }

    public static DamageSource causeProjectileWeaponDamage(EntityShootable projectile, Entity entity)
    {
        return (new WeaponDamageSource("weapon", projectile, entity)).setProjectile();
    }
}