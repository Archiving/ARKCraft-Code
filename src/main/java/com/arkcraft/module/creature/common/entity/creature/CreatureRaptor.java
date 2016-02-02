package com.arkcraft.module.creature.common.entity.creature;

import com.arkcraft.module.creature.common.entity.EntityARKCreature;
import com.arkcraft.module.creature.common.entity.SaddleType;
import com.arkcraft.module.creature.common.entitytest.EntityRaptor;

public class CreatureRaptor extends Creature
{
	@Override
	public String getName()
	{
		// TODO Auto-generated method stub
		return "arkcraft.raptor";
	}

	@Override
	public Class<? extends EntityARKCreature> getEntityClass()
	{
		// TODO Auto-generated method stub
		return EntityRaptor.class;
	}

	@Override
	public TamingType getTameType()
	{
		// TODO Auto-generated method stub
		return TamingType.KNOCK_OUT;
	}

	@Override
	public SaddleType getSaddleType()
	{
		// TODO Auto-generated method stub
		return SaddleType.SMALL;
	}

	@Override
	public int getGrowthTime()
	{
		// TODO Auto-generated method stub
		return 12000;
	}

	@Override
	public int getBabySizeXZ()
	{
		// TODO Auto-generated method stub
		return 1;
	}

	@Override
	public int getBabySizeY()
	{
		// TODO Auto-generated method stub
		return 1;
	}

	@Override
	public int getAdultSizeXZ()
	{
		// TODO Auto-generated method stub
		return 2;
	}

	@Override
	public int getAdultSizeY()
	{
		// TODO Auto-generated method stub
		return 2;
	}

	@Override
	public int getTorporKnockout()
	{
		// TODO Auto-generated method stub
		return 50;
	}

	@Override
	public int getTorporLossSpeed()
	{
		// TODO Auto-generated method stub
		return 1;
	}

	@Override
	public int getMeleeDamageBase()
	{
		// TODO Auto-generated method stub
		return 50;
	}

	@Override
	public int getHealthBase()
	{
		// TODO Auto-generated method stub
		return 70;
	}

	@Override
	public int getStaminaBase()
	{
		// TODO Auto-generated method stub
		return 50;
	}

	@Override
	public int getHungerBase()
	{
		// TODO Auto-generated method stub
		return 90;
	}

	@Override
	public int getSpeedBase()
	{
		// TODO Auto-generated method stub
		return 100;
	}

	@Override
	public float getKillXP()
	{
		// TODO Auto-generated method stub
		return 50;
	}

	@Override
	public int getInventorySize()
	{
		// TODO Auto-generated method stub
		return 30;
	}
}