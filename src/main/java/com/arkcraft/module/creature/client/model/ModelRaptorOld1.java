package com.arkcraft.module.creature.client.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;

public class ModelRaptorOld1 extends ModelBase
{

	ModelRenderer RightUpperLeg;
	ModelRenderer RightMidLeg;
	ModelRenderer RightLowerLeg;
	ModelRenderer RightFoot;
	ModelRenderer RightClaw1;
	ModelRenderer RightClaw2;
	ModelRenderer RightOuterToe;
	ModelRenderer RightInnerToe;
	ModelRenderer Body;
	ModelRenderer Body2;
	ModelRenderer Back1;
	ModelRenderer Back2;
	ModelRenderer Stomach;
	ModelRenderer LeftUpperLeg;
	ModelRenderer LeftMidLeg;
	ModelRenderer LeftLowerLeg;
	ModelRenderer LeftFoot;
	ModelRenderer LeftOuterToe;
	ModelRenderer LeftInnerToe;
	ModelRenderer LeftClaw1;
	ModelRenderer LeftClaw2;
	ModelRenderer Tail1;
	ModelRenderer Tail2;
	ModelRenderer LeftUpperArm;
	ModelRenderer LeftLowerArm;
	ModelRenderer LeftHand;
	ModelRenderer LeftHandClaw1;
	ModelRenderer LeftHandClaw2;
	ModelRenderer Tail3;
	ModelRenderer Tail4;
	ModelRenderer RightUpperArm;
	ModelRenderer RightLowerArm;
	ModelRenderer RightHand;
	ModelRenderer RightHandClaw1;
	ModelRenderer RightHandClaw2;
	ModelRenderer Tail5;
	ModelRenderer Tail6;
	ModelRenderer Neck;
	ModelRenderer UpperNeck;
	ModelRenderer Head;
	ModelRenderer LowerJaw;
	ModelRenderer UpperJaw;
	ModelRenderer NoseBridge;
	ModelRenderer HeadFeathers;

	public ModelRaptorOld1()
	{
		textureWidth = textureHeight = 64;

		Head = new ModelRenderer(this, 4, 20);
		Head.addBox(-2F, -5F, -3F, 4, 4, 6);
		Head.setRotationPoint(0F, 4F, -11.5F);
		Head.setTextureSize(64, 64);
		Head.mirror = true;
		setRotation(Head, 0.122173F, 0F, 0F);

		LowerJaw = new ModelRenderer(this, 29, 12);
		LowerJaw.addBox(-1.5F, 0F, -5F, 3, 1, 5);
		LowerJaw.setRotationPoint(0F, 2.3F, -14.5F);
		LowerJaw.setTextureSize(64, 64);
		LowerJaw.mirror = true;
		setRotation(LowerJaw, 0.0698132F, 0F, 0F);

		UpperJaw = new ModelRenderer(this, 27, 18);
		UpperJaw.addBox(-2F, 0F, -5F, 4, 2, 5);
		UpperJaw.setRotationPoint(0F, 0.3F, -15F);
		UpperJaw.setTextureSize(64, 64);
		UpperJaw.mirror = true;
		setRotation(UpperJaw, 0.122173F, 0F, 0F);

		NoseBridge = new ModelRenderer(this, 18, 20);
		NoseBridge.addBox(-1F, 0F, -5F, 2, 1, 5);
		NoseBridge.setRotationPoint(0F, -0.6F, -15F);
		NoseBridge.setTextureSize(64, 64);
		NoseBridge.mirror = true;
		setRotation(NoseBridge, 0.2792527F, 0F, 0F);

		HeadFeathers = new ModelRenderer(this, 18, 26);
		HeadFeathers.mirror = true;
		HeadFeathers.addBox(-0.5F, -1F, 0F, 1, 2, 6);
		HeadFeathers.setRotationPoint(0F, -0.3F, -14F);
		HeadFeathers.setTextureSize(64, 64);
		HeadFeathers.mirror = true;
		setRotation(HeadFeathers, 0.2268928F, 0F, 0F);
		HeadFeathers.mirror = false;

		// These parts don't have a common rotation point, but won't matter
		// unless we move them somehow!
		convertToChild(Head, LowerJaw);
		convertToChild(Head, UpperJaw);
		convertToChild(Head, NoseBridge);
		convertToChild(Head, HeadFeathers);

		// Body
		Body = new ModelRenderer(this, 0, 47);
		Body.addBox(-3F, 0F, 0F, 6, 5, 12);
		Body.setRotationPoint(0F, 7F, -7.5F);
		Body.setTextureSize(64, 64);
		Body.mirror = true;
		setRotation(Body, -0.1047198F, 0F, 0F);

		Body2 = new ModelRenderer(this, 24, 38);
		Body2.addBox(-3F, -2F, -5F, 6, 6, 5);
		Body2.setRotationPoint(0F, 9.5F, -6F);
		Body2.setTextureSize(64, 64);
		Body2.mirror = true;
		setRotation(Body2, -0.5410521F, 0F, 0F);

		Back1 = new ModelRenderer(this, 24, 49);
		Back1.addBox(-2.5F, -1F, 0F, 5, 2, 8);
		Back1.setRotationPoint(0F, 6.5F, -9F);
		Back1.setTextureSize(64, 64);
		Back1.mirror = true;
		setRotation(Back1, -0.1396263F, 0F, 0F);

		Back2 = new ModelRenderer(this, 44, 56);
		Back2.addBox(-2F, -1F, 0F, 4, 2, 6);
		Back2.setRotationPoint(0F, 7.6F, -1.3F);
		Back2.setTextureSize(64, 64);
		Back2.mirror = true;
		setRotation(Back2, -0.2792527F, 0F, 0F);

		Stomach = new ModelRenderer(this, 0, 3);
		Stomach.addBox(-2.5F, -2F, 0F, 5, 2, 12);
		Stomach.setRotationPoint(0F, 12.9F, -8F);
		Stomach.setTextureSize(64, 64);
		Stomach.mirror = true;
		setRotation(Stomach, -0.0349066F, 0F, 0F);

		Neck = new ModelRenderer(this, 0, 38);
		Neck.addBox(-2.5F, -5F, -2.5F, 5, 5, 5);
		Neck.setRotationPoint(0F, 9.7F, -9.9F);
		Neck.setTextureSize(64, 64);
		Neck.mirror = true;
		setRotation(Neck, 0.2617994F, 0F, 0F);

		UpperNeck = new ModelRenderer(this, 0, 30);
		UpperNeck.addBox(-2F, -4F, -2.5F, 4, 3, 5);
		UpperNeck.setRotationPoint(0F, 6.5F, -11.1F);
		UpperNeck.setTextureSize(64, 64);
		UpperNeck.mirror = true;
		setRotation(UpperNeck, 0F, 0F, 0F);

		// These parts don't have a common rotation point, but won't matter
		// unless we move them somehow!
		convertToChild(Body, Body2);
		convertToChild(Body, Back1);
		convertToChild(Body, Back2);
		convertToChild(Body, Stomach);
		convertToChild(Body, Neck);
		convertToChild(Body, UpperNeck);

		// Left leg and foot
		LeftUpperLeg = new ModelRenderer(this, 50, 0);
		LeftUpperLeg.addBox(0F, -1F, -2F, 3, 5, 4);
		LeftUpperLeg.setRotationPoint(2.5F, 11F, 0F);
		LeftUpperLeg.setTextureSize(64, 64);
		LeftUpperLeg.mirror = true;
		setRotation(LeftUpperLeg, -0.5759587F, 0F, 0F);

		LeftMidLeg = new ModelRenderer(this, 56, 9);
		LeftMidLeg.addBox(0F, 0F, -4.4F, 2, 8, 2);
		LeftMidLeg.setRotationPoint(2.5F, 11F, 0F);
		LeftMidLeg.setTextureSize(64, 64);
		LeftMidLeg.mirror = true;
		setRotation(LeftMidLeg, 0.5235988F, 0F, 0F);

		LeftLowerLeg = new ModelRenderer(this, 42, 0);
		LeftLowerLeg.addBox(0F, 6.6F, 3.1F, 2, 4, 2);
		LeftLowerLeg.setRotationPoint(2.5F, 11F, 0F);
		LeftLowerLeg.setTextureSize(64, 64);
		LeftLowerLeg.mirror = true;
		setRotation(LeftLowerLeg, -0.4363323F, 0F, 0F);

		LeftFoot = new ModelRenderer(this, 42, 9);
		LeftFoot.addBox(0F, 10.8F, -3.5F, 3, 2, 4);
		LeftFoot.setRotationPoint(2.5F, 11F, 0F);
		LeftFoot.setTextureSize(64, 64);
		LeftFoot.mirror = true;
		setRotation(LeftFoot, 0F, 0F, 0F);

		LeftClaw1 = new ModelRenderer(this, 42, 9);
		LeftClaw1.addBox(0F, 8.2F, -5.8F, 1, 2, 1);
		LeftClaw1.setRotationPoint(2.5F, 11F, 0F);
		LeftClaw1.setTextureSize(64, 64);
		LeftClaw1.mirror = true;
		setRotation(LeftClaw1, 0.2268928F, 0F, 0F);

		LeftClaw2 = new ModelRenderer(this, 44, 6);
		LeftClaw2.addBox(0F, 9F, -5F, 1, 1, 2);
		LeftClaw2.setRotationPoint(2.5F, 11F, 0F);
		LeftClaw2.setTextureSize(64, 64);
		LeftClaw2.mirror = true;
		setRotation(LeftClaw2, 0.0174533F, 0F, 0F);

		LeftOuterToe = new ModelRenderer(this, 36, 0);
		LeftOuterToe.addBox(1.5F, 9.5F, -8.5F, 1, 1, 2);
		LeftOuterToe.setRotationPoint(2.5F, 11F, 0F);
		LeftOuterToe.setTextureSize(64, 64);
		LeftOuterToe.mirror = true;
		setRotation(LeftOuterToe, 0.296706F, -0.122173F, 0F);

		LeftInnerToe = new ModelRenderer(this, 37, 3);
		LeftInnerToe.addBox(1F, 9.6F, -9F, 1, 1, 3);
		LeftInnerToe.setRotationPoint(2.5F, 11F, 0F);
		LeftInnerToe.setTextureSize(64, 64);
		LeftInnerToe.mirror = true;
		setRotation(LeftInnerToe, 0.2617994F, 0.0349066F, 0F);

		convertToChild(LeftFoot, LeftClaw1);
		convertToChild(LeftFoot, LeftClaw2);
		convertToChild(LeftFoot, LeftOuterToe);
		convertToChild(LeftFoot, LeftInnerToe);
		convertToChild(LeftLowerLeg, LeftFoot);
		convertToChild(LeftMidLeg, LeftLowerLeg);
		convertToChild(LeftUpperLeg, LeftMidLeg);

		// Right leg and foot
		RightUpperLeg = new ModelRenderer(this, 50, 0);
		RightUpperLeg.addBox(-3.0F, -1F, -2F, 3, 5, 4);
		RightUpperLeg.setRotationPoint(-2.5F, 11F, 0F);
		RightUpperLeg.setTextureSize(64, 64);
		RightUpperLeg.mirror = true;
		setRotation(RightUpperLeg, -0.5759587F, 0F, 0F);

		RightMidLeg = new ModelRenderer(this, 56, 9);
		RightMidLeg.addBox(-2.0F, 0F, -4.4F, 2, 8, 2);
		RightMidLeg.setRotationPoint(-2.5F, 11F, 0F);
		RightMidLeg.setTextureSize(64, 64);
		RightMidLeg.mirror = true;
		setRotation(RightMidLeg, 0.5235988F, 0F, 0F);

		RightLowerLeg = new ModelRenderer(this, 42, 0);
		RightLowerLeg.addBox(-2.0F, 6.6F, 3.1F, 2, 4, 2);
		RightLowerLeg.setRotationPoint(-2.5F, 11F, 0F);
		RightLowerLeg.setTextureSize(64, 64);
		RightLowerLeg.mirror = true;
		setRotation(RightLowerLeg, -0.4363323F, 0F, 0F);

		RightFoot = new ModelRenderer(this, 42, 9);
		RightFoot.addBox(-3.0F, 10.8F, -3.5F, 3, 2, 4);
		RightFoot.setRotationPoint(-2.5F, 11F, 0F);
		RightFoot.setTextureSize(64, 64);
		RightFoot.mirror = true;
		setRotation(RightFoot, 0F, 0F, 0F);

		RightClaw1 = new ModelRenderer(this, 42, 9);
		RightClaw1.addBox(-1F, 8.2F, -5.8F, 1, 2, 1);
		RightClaw1.setRotationPoint(-2.5F, 11F, 0F);
		RightClaw1.setTextureSize(64, 64);
		RightClaw1.mirror = true;
		setRotation(RightClaw1, 0.2268928F, 0F, 0F);

		RightClaw2 = new ModelRenderer(this, 44, 6);
		RightClaw2.mirror = true;
		RightClaw2.addBox(-1F, 9F, -5F, 1, 1, 2);
		RightClaw2.setRotationPoint(-2.5F, 11F, 0F);
		RightClaw2.setTextureSize(64, 64);
		RightClaw2.mirror = true;
		setRotation(RightClaw2, 0.0174533F, 0F, 0F);

		RightOuterToe = new ModelRenderer(this, 36, 0);
		RightOuterToe.addBox(-2.5F, 9.5F, -8.5F, 1, 1, 2);
		RightOuterToe.setRotationPoint(-2.5F, 11F, 0F);
		RightOuterToe.setTextureSize(64, 64);
		RightOuterToe.mirror = true;
		setRotation(RightOuterToe, 0.296706F, 0.122173F, 0F);

		RightInnerToe = new ModelRenderer(this, 37, 3);
		RightInnerToe.addBox(-2F, 9.6F, -9F, 1, 1, 3);
		RightInnerToe.setRotationPoint(-2.5F, 11F, 0F);
		RightInnerToe.setTextureSize(64, 64);
		RightInnerToe.mirror = true;
		setRotation(RightInnerToe, 0.2617994F, -0.0349066F, 0F);

		convertToChild(RightFoot, RightClaw1);
		convertToChild(RightFoot, RightClaw2);
		convertToChild(RightFoot, RightOuterToe);
		convertToChild(RightFoot, RightInnerToe);
		convertToChild(RightLowerLeg, RightFoot);
		convertToChild(RightMidLeg, RightLowerLeg);
		convertToChild(RightUpperLeg, RightMidLeg);

		// Left Arm and claw
		LeftUpperArm = new ModelRenderer(this, 56, 22);
		LeftUpperArm.addBox(0F, -1F, -1F, 2, 6, 2);
		LeftUpperArm.setRotationPoint(3F, 8.5F, -8F);
		LeftUpperArm.setTextureSize(64, 64);
		LeftUpperArm.mirror = true;
		setRotation(LeftUpperArm, 0.1745329F, 0F, -0.122173F);

		LeftLowerArm = new ModelRenderer(this, 52, 25);
		LeftLowerArm.addBox(0.5F, 1F, 4F, 1, 4, 1);
		LeftLowerArm.setRotationPoint(3F, 8.5F, -8F);
		LeftLowerArm.setTextureSize(64, 64);
		LeftLowerArm.mirror = true;
		setRotation(LeftLowerArm, -1.32645F, 0F, -0.122173F);

		LeftHand = new ModelRenderer(this, 50, 22);
		LeftHand.addBox(0.6F, 4.5F, -5F, 2, 2, 1);
		LeftHand.setRotationPoint(3F, 8.5F, -8F);
		LeftHand.setTextureSize(64, 64);
		LeftHand.mirror = true;
		setRotation(LeftHand, 0.0872665F, 0F, 0F);

		LeftHandClaw1 = new ModelRenderer(this, 48, 25);
		LeftHandClaw1.addBox(1.7F, 1.5F, -8F, 1, 1, 1);
		LeftHandClaw1.setRotationPoint(3F, 8.5F, -8F);
		LeftHandClaw1.setTextureSize(64, 64);
		LeftHandClaw1.mirror = true;
		setRotation(LeftHandClaw1, 0.8203047F, 0F, 0F);

		LeftHandClaw2 = new ModelRenderer(this, 48, 25);
		LeftHandClaw2.addBox(0.5F, 1.5F, -8F, 1, 1, 1);
		LeftHandClaw2.setRotationPoint(3F, 8.5F, -8F);
		LeftHandClaw2.setTextureSize(64, 64);
		LeftHandClaw2.mirror = true;
		setRotation(LeftHandClaw2, 0.8203047F, 0F, 0F);

		convertToChild(LeftHand, LeftHandClaw1);
		convertToChild(LeftHand, LeftHandClaw2);
		convertToChild(LeftLowerArm, LeftHand);
		convertToChild(LeftUpperArm, LeftLowerArm);

		// Left Arm and claw
		RightUpperArm = new ModelRenderer(this, 56, 22);
		RightUpperArm.addBox(-2F, -1F, -1F, 2, 6, 2);
		RightUpperArm.setRotationPoint(-3F, 8.5F, -8F);
		RightUpperArm.setTextureSize(64, 64);
		RightUpperArm.mirror = true;
		setRotation(RightUpperArm, 0.1745329F, 0F, 0.122173F);

		RightLowerArm = new ModelRenderer(this, 52, 25);
		RightLowerArm.addBox(-1.5F, 1F, 4F, 1, 4, 1);
		RightLowerArm.setRotationPoint(-3F, 8.5F, -8F);
		RightLowerArm.setTextureSize(64, 64);
		RightLowerArm.mirror = true;
		setRotation(RightLowerArm, -1.32645F, 0F, 0.122173F);

		RightHand = new ModelRenderer(this, 50, 22);
		RightHand.addBox(-2.6F, 4.5F, -5F, 2, 2, 1);
		RightHand.setRotationPoint(-3F, 8.5F, -8F);
		RightHand.setTextureSize(64, 64);
		RightHand.mirror = true;
		setRotation(RightHand, 0.0872665F, 0F, 0F);

		RightHandClaw1 = new ModelRenderer(this, 48, 25);
		RightHandClaw1.addBox(-2.7F, 1.5F, -8F, 1, 1, 1);
		RightHandClaw1.setRotationPoint(-3F, 8.5F, -8F);
		RightHandClaw1.setTextureSize(64, 64);
		RightHandClaw1.mirror = true;
		setRotation(RightHandClaw1, 0.8203047F, 0F, 0F);

		RightHandClaw2 = new ModelRenderer(this, 48, 25);
		RightHandClaw2.addBox(-1.5F, 1.5F, -8F, 1, 1, 1);
		RightHandClaw2.setRotationPoint(-3F, 8.5F, -8F);
		RightHandClaw2.setTextureSize(64, 64);
		RightHandClaw2.mirror = true;
		setRotation(RightHandClaw2, 0.8203047F, 0F, 0F);

		convertToChild(RightHand, RightHandClaw1);
		convertToChild(RightHand, RightHandClaw2);
		convertToChild(RightLowerArm, RightHand);
		convertToChild(RightUpperArm, RightLowerArm);

		// Tail
		Tail1 = new ModelRenderer(this, 48, 31);
		Tail1.addBox(-2.5F, -2F, 0F, 5, 4, 3);
		Tail1.setRotationPoint(0F, 10.4F, 3F);
		Tail1.setTextureSize(64, 64);
		Tail1.mirror = true;
		setRotation(Tail1, 0F, 0F, 0F);

		Tail2 = new ModelRenderer(this, 52, 38);
		Tail2.addBox(-2F, 0F, 0F, 4, 2, 2);
		Tail2.setRotationPoint(0F, 11.5F, 3.1F);
		Tail2.setTextureSize(64, 64);
		Tail2.mirror = true;
		setRotation(Tail2, 0.4886922F, 0F, 0F);

		Tail3 = new ModelRenderer(this, 34, 31);
		Tail3.addBox(-2F, -2F, 0F, 4, 4, 3);
		Tail3.setRotationPoint(0F, 10.5F, 5F);
		Tail3.setTextureSize(64, 64);
		Tail3.mirror = true;
		setRotation(Tail3, 0.1745329F, 0F, 0F);

		Tail4 = new ModelRenderer(this, 44, 43);
		Tail4.addBox(-1.5F, -1.5F, 0F, 3, 3, 6);
		Tail4.setRotationPoint(0F, 9.6F, 7.5F);
		Tail4.setTextureSize(64, 64);
		Tail4.mirror = true;
		setRotation(Tail4, 0.2094395F, 0F, 0F);

		Tail5 = new ModelRenderer(this, 25, 4);
		Tail5.addBox(-1F, -1F, 0F, 2, 2, 6);
		Tail5.setRotationPoint(0F, 8.2F, 13F);
		Tail5.setTextureSize(64, 64);
		Tail5.mirror = true;
		setRotation(Tail5, 0F, 0F, 0F);

		Tail6 = new ModelRenderer(this, 36, 21);
		Tail6.addBox(-0.5F, -0.5F, 0F, 1, 1, 9);
		Tail6.setRotationPoint(0F, 8.2F, 18.5F);
		Tail6.setTextureSize(64, 64);
		Tail6.mirror = true;
		setRotation(Tail6, -0.1396263F, 0F, 0F);

		// These parts don't have a common rotation point, but won't matter
		// unless we move them somehow!
		convertToChild(Tail5, Tail6);
		convertToChild(Tail4, Tail5);
		convertToChild(Tail3, Tail4);
		convertToChild(Tail2, Tail3);
		convertToChild(Tail1, Tail2);
	}

	public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
	{
		super.render(entity, f, f1, f2, f3, f4, f5);
		setRotationAngles(entity, f, f1, f2, f3, f4, f5);

		if (this.isChild)
		{
			float scaling = 2.0F;
			GlStateManager.pushMatrix();
			GlStateManager.scale(1.0F / scaling, 1.0F / scaling, 1.0F / scaling);
			GlStateManager.translate(0.0F, 24.0F * f5, 0.0F);
			Head.render(f5);
			Body.render(f5);
			LeftUpperLeg.render(f5);
			RightUpperLeg.render(f5);
			LeftUpperArm.render(f5);
			RightUpperArm.render(f5);
			Tail1.render(f5);
			GlStateManager.popMatrix();
		}
		else
		{
			// Adult
			Head.render(f5);
			Body.render(f5);
			LeftUpperLeg.render(f5);
			RightUpperLeg.render(f5);
			LeftUpperArm.render(f5);
			RightUpperArm.render(f5);
			Tail1.render(f5);
		}
	}

	private void setRotation(ModelRenderer model, float x, float y, float z)
	{
		model.rotateAngleX = x;
		model.rotateAngleY = y;
		model.rotateAngleZ = z;
	}

	public void setRotationAngles(Entity e, float f, float f1, float f2, float f3, float f4, float f5)
	{
		super.setRotationAngles(f, f1, f2, f3, f4, f5, e);

		this.RightUpperLeg.rotateAngleX = MathHelper.cos(f * 0.6662F) * 0.9F * f1;
		this.LeftUpperLeg.rotateAngleX = MathHelper.cos(f * 0.6662F + (float) Math.PI) * 0.9F * f1;
	}

	// Use this for parts that have a common rotation point, so they can be
	// rendered together with a single call to the render function
	protected void convertToChild(ModelRenderer parParent, ModelRenderer parChild)
	{
		// move child rotation point to be relative to parent
		parChild.rotationPointX -= parParent.rotationPointX;
		parChild.rotationPointY -= parParent.rotationPointY;
		parChild.rotationPointZ -= parParent.rotationPointZ;
		// make rotations relative to parent
		parChild.rotateAngleX -= parParent.rotateAngleX;
		parChild.rotateAngleY -= parParent.rotateAngleY;
		parChild.rotateAngleZ -= parParent.rotateAngleZ;
		// create relationship
		parParent.addChild(parChild);
	}
}
