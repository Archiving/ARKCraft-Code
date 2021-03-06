package com.arkcraft.module.creature.client.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

/**
 * Raptor 2 low res - TechneToTabulaImporter Created using Tabula 5.1.0
 */
public class ModelRaptorOld3 extends ModelBase
{
	public ModelRenderer UpperBoddy;
	public ModelRenderer HeadFeathers6;
	public ModelRenderer HeadFeathers6_1;
	public ModelRenderer HeadFeathers6_2;
	public ModelRenderer HeadFeathers6_3;
	public ModelRenderer HeadFeathers6_4;
	public ModelRenderer HeadFeathers6_5;
	public ModelRenderer HeadFeathers6_6;
	public ModelRenderer HeadFeathers6_7;
	public ModelRenderer HeadFeathers6_8;
	public ModelRenderer teeth;
	public ModelRenderer teeth_1;
	public ModelRenderer teeth_2;
	public ModelRenderer teeth_3;
	public ModelRenderer teeth_4;
	public ModelRenderer teeth_5;
	public ModelRenderer Chest;
	public ModelRenderer LowerBoddy1;
	public ModelRenderer LeftUpperArm;
	public ModelRenderer RightUpperArm;
	public ModelRenderer Neck;
	public ModelRenderer LeftLowerArm;
	public ModelRenderer LeftArmFeathers1;
	public ModelRenderer LeftArmFeathers2;
	public ModelRenderer LeftArmFeathers3;
	public ModelRenderer LeftArmFeathers4;
	public ModelRenderer LeftArmFeathers5;
	public ModelRenderer LeftHand1;
	public ModelRenderer LeftHand2;
	public ModelRenderer RightLowerArm;
	public ModelRenderer RightArmFeathers2;
	public ModelRenderer RghtArmFeathers1;
	public ModelRenderer RightArmFeathers4;
	public ModelRenderer RightArmFeathers5;
	public ModelRenderer RightArmFeathers3;
	public ModelRenderer RightHand1;
	public ModelRenderer RightHand2;
	public ModelRenderer Neck4;
	public ModelRenderer Neck2;
	public ModelRenderer Head;
	public ModelRenderer Jaw;
	public ModelRenderer HeadFeathers1;
	public ModelRenderer HeadFeathers2;
	public ModelRenderer HeadFeathers3;
	public ModelRenderer HeadFeathers4;
	public ModelRenderer HeadFeathers5;
	public ModelRenderer HeadFeathers6_9;
	public ModelRenderer HeadFeathers7;
	public ModelRenderer LowerSnout1;
	public ModelRenderer RightEyeball;
	public ModelRenderer LeftEyeball;
	public ModelRenderer UpperSnout;
	public ModelRenderer UpperSnout2;
	public ModelRenderer RightPupill;
	public ModelRenderer LeftPupill;
	public ModelRenderer Neck3;
	public ModelRenderer LowerBoddy2;
	public ModelRenderer LeftLegThigh;
	public ModelRenderer Tail1;
	public ModelRenderer RightLegThigh;
	public ModelRenderer Tail2;
	public ModelRenderer Tail3;
	public ModelRenderer Tail4;
	public ModelRenderer Tail5;
	public ModelRenderer Tailfeathers4;
	public ModelRenderer TailFeathers3;
	public ModelRenderer TailFeathers2;
	public ModelRenderer TailFeathers1;
	public ModelRenderer RightLeg;
	public ModelRenderer RightFoot;
	public ModelRenderer BackRightClaw;
	public ModelRenderer RightOutterFoot;
	public ModelRenderer RightMiddleFoot;
	public ModelRenderer RightInnerFoot;
	public ModelRenderer RightOutterClaw;
	public ModelRenderer RightMiddleClaw;
	public ModelRenderer RightInnerClaw1;
	public ModelRenderer RightInnerClaw2;
	public ModelRenderer LeftLeg;
	public ModelRenderer LeftFoot;
	public ModelRenderer LeftOutterFoot;
	public ModelRenderer LeftMiddleFoot;
	public ModelRenderer LeftInnerFoot;
	public ModelRenderer BackLeftClaw;
	public ModelRenderer LeftOutterClaw;
	public ModelRenderer LeftMiddleClaw;
	public ModelRenderer LeftInnerClaw1;
	public ModelRenderer LeftInnerClaw2;

	public ModelRaptorOld3()
	{
		this.textureWidth = 128;
		this.textureHeight = 128;
		this.UpperSnout2 = new ModelRenderer(this, 1, 24);
		this.UpperSnout2.setRotationPoint(0.5F, -4.05F, 0.33F);
		this.UpperSnout2.addBox(-2.5F, -0.05F, -6.93F, 3, 1, 7, 0.0F);
		this.setRotateAngle(UpperSnout2, 0.06178465552059926F, 0.0F, 0.0F);
		this.Tail2 = new ModelRenderer(this, 0, 106);
		this.Tail2.setRotationPoint(0.0F, -0.358538884765915F, 7.994463703479912F);
		this.Tail2.addBox(-2.5F, -2.4F, -0.1F, 5, 4, 9, 0.0F);
		this.setRotateAngle(Tail2, 0.0349065850398866F, 0.0F, 0.0F);
		this.teeth_2 = new ModelRenderer(this, 0, 0);
		this.teeth_2.setRotationPoint(-1.9F, 1.64F, -17.82F);
		this.teeth_2.addBox(-0.5F, -0.1F, -1.0F, 0, 1, 1, 0.0F);
		this.setRotateAngle(teeth_2, -0.5742133239061343F, 0.0F, 0.0F);
		this.BackLeftClaw = new ModelRenderer(this, 62, 5);
		this.BackLeftClaw.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.BackLeftClaw.addBox(-0.5F, 4.5F, -1.5F, 1, 2, 1, 0.0F);
		this.setRotateAngle(BackLeftClaw, 0.4363323003053663F, 0.0F, 0.0F);
		this.HeadFeathers6_8 = new ModelRenderer(this, 26, 41);
		this.HeadFeathers6_8.setRotationPoint(0.0F, 5.5F, 4.2F);
		this.HeadFeathers6_8.addBox(0.0F, -4.5F, 0.0F, 0, 6, 1, 0.0F);
		this.setRotateAngle(HeadFeathers6_8, -0.890117918517108F, 0.0F, 0.0F);
		this.RightOutterClaw = new ModelRenderer(this, 62, 8);
		this.RightOutterClaw.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.RightOutterClaw.addBox(-0.8999999761581421F, 7.0F, -5.0F, 1, 1, 1, 0.0F);
		this.BackRightClaw = new ModelRenderer(this, 62, 5);
		this.BackRightClaw.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.BackRightClaw.addBox(-0.5F, 4.5F, -1.5F, 1, 2, 1, 0.0F);
		this.setRotateAngle(BackRightClaw, 0.4363323003053663F, 0.0F, 0.0F);
		this.RightFoot = new ModelRenderer(this, 46, 10);
		this.RightFoot.setRotationPoint(0.04F, 0.11F, 5.1F);
		this.RightFoot.addBox(-1.0F, 0.0F, -1.5F, 2, 7, 3, 0.0F);
		this.setRotateAngle(RightFoot, 0.576482251933727F, 0.01815142422074103F,
				-0.10314895879286487F);
		this.LeftLeg = new ModelRenderer(this, 44, 0);
		this.LeftLeg.setRotationPoint(0.69F, 4.51F, -1.1F);
		this.LeftLeg.addBox(-1.0F, -1.0F, -0.5F, 2, 3, 7, 0.0F);
		this.setRotateAngle(LeftLeg, -0.3141592653589793F, -0.06283185307179587F, 0.0F);
		this.HeadFeathers6_3 = new ModelRenderer(this, 26, 41);
		this.HeadFeathers6_3.setRotationPoint(0.0F, 5.4F, -6.3F);
		this.HeadFeathers6_3.addBox(0.0F, -4.5F, 0.0F, 0, 6, 1, 0.0F);
		this.setRotateAngle(HeadFeathers6_3, -0.9529497715889039F, 0.0F, 0.0F);
		this.Neck3 = new ModelRenderer(this, 1, 32);
		this.Neck3.setRotationPoint(0.0F, -5.856559503617325F, -0.20176912694850735F);
		this.Neck3.addBox(-2.5F, -4.5F, -2.5F, 3, 5, 5, 0.0F);
		this.setRotateAngle(Neck3, 0.39863320115550477F, 0.0F, 0.0F);
		this.RightInnerFoot = new ModelRenderer(this, 56, 17);
		this.RightInnerFoot.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.RightInnerFoot.addBox(-0.30000001192092896F, 6.0F, -3.5F, 1, 2, 4, 0.0F);
		this.setRotateAngle(RightInnerFoot, 0.08909425967226049F, -0.20559054771714225F,
				-0.05327424499186149F);
		this.HeadFeathers6_7 = new ModelRenderer(this, 26, 41);
		this.HeadFeathers6_7.setRotationPoint(0.0F, 5.0F, 2.2F);
		this.HeadFeathers6_7.addBox(0.0F, -4.5F, 0.0F, 0, 6, 1, 0.0F);
		this.setRotateAngle(HeadFeathers6_7, -0.8272860654453121F, 0.0F, 0.0F);
		this.RightArmFeathers3 = new ModelRenderer(this, 24, 32);
		this.RightArmFeathers3.setRotationPoint(0.0F, 7.516910420957146E-4F, 0.003412681977403409F);
		this.RightArmFeathers3.addBox(-1.5F, 3.2F, 2.0F, 0, 1, 3, 0.0F);
		this.setRotateAngle(RightArmFeathers3, -0.5061501444538296F, 0.0F, 0.0F);
		this.LowerBoddy1 = new ModelRenderer(this, 6, 75);
		this.LowerBoddy1.setRotationPoint(0.0F, 0.3F, 0.34F);
		this.LowerBoddy1.addBox(2.7F, -4.1F, 2.0F, 1, 9, 8, 0.0F);
		this.setRotateAngle(LowerBoddy1, -0.2722713633111154F, 0.0F, 0.0F);
		this.LeftLowerArm = new ModelRenderer(this, 34, 23);
		this.LeftLowerArm.setRotationPoint(0.7F, 4.06F, 0.85F);
		this.LeftLowerArm.addBox(-1.0F, 0.0F, -5.0F, 2, 2, 5, 0.0F);
		this.setRotateAngle(LeftLowerArm, -0.3141592653589793F, 0.0F, 0.0F);
		this.Jaw = new ModelRenderer(this, 24, 14);
		this.Jaw.setRotationPoint(0.0F, 1.6F, -6.7F);
		this.Jaw.addBox(-2.0F, -0.7F, -6.8F, 4, 2, 7, 0.0F);
		this.setRotateAngle(Jaw, -0.05235987755982988F, 0.0F, 0.0F);
		this.TailFeathers2 = new ModelRenderer(this, 30, 76);
		this.TailFeathers2.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.TailFeathers2.addBox(0.0F, -1.0F, 7.7F, 0, 2, 6, 0.0F);
		this.Tail4 = new ModelRenderer(this, 28, 95);
		this.Tail4.setRotationPoint(0.0F, -0.2F, 8.8F);
		this.Tail4.addBox(-1.0F, -1.0F, -0.2F, 2, 2, 9, 0.0F);
		this.setRotateAngle(Tail4, -0.11239920382843484F, 0.0F, 0.0F);
		this.Tail5 = new ModelRenderer(this, 30, 84);
		this.Tail5.setRotationPoint(0.0F, -0.07F, 9.05F);
		this.Tail5.addBox(-0.5F, -0.5F, -0.3F, 1, 1, 10, 0.0F);
		this.setRotateAngle(Tail5, -0.08726646259971647F, 0.0F, 0.0F);
		this.LeftMiddleClaw = new ModelRenderer(this, 62, 8);
		this.LeftMiddleClaw.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.LeftMiddleClaw.addBox(-0.4000000059604645F, 7.0F, -5.0F, 1, 1, 1, 0.0F);
		this.LeftOutterFoot = new ModelRenderer(this, 56, 10);
		this.LeftOutterFoot.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.LeftOutterFoot.addBox(0.0F, 6.0F, -4.5F, 1, 2, 5, 0.0F);
		this.setRotateAngle(LeftOutterFoot, 0.08920936674176302F, -0.21167289761824615F,
				0.01624963763548582F);
		this.LeftArmFeathers5 = new ModelRenderer(this, 24, 32);
		this.LeftArmFeathers5.setRotationPoint(0.0F, 7.516910420957146E-4F, 0.003412681977403409F);
		this.LeftArmFeathers5.addBox(1.5F, 3.2F, 2.0F, 0, 1, 3, 0.0F);
		this.setRotateAngle(LeftArmFeathers5, -0.5061501444538296F, 0.0F, 0.0F);
		this.LeftMiddleFoot = new ModelRenderer(this, 56, 10);
		this.LeftMiddleFoot.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.LeftMiddleFoot.addBox(-0.30000001192092896F, 6.0F, -4.5F, 1, 2, 5, 0.0F);
		this.setRotateAngle(LeftMiddleFoot, 0.08721356892970994F, -0.003041696135063567F,
				0.03477386194254569F);
		this.LeftOutterClaw = new ModelRenderer(this, 62, 8);
		this.LeftOutterClaw.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.LeftOutterClaw.addBox(-0.10000000149011612F, 7.0F, -5.0F, 1, 1, 1, 0.0F);
		this.RightEyeball = new ModelRenderer(this, 0, 0);
		this.RightEyeball.setRotationPoint(0.0F, -0.3905136139032912F, -0.5710849569018883F);
		this.RightEyeball.addBox(-3.1F, -1.5F, -5.5F, 1, 2, 2, 0.0F);
		this.setRotateAngle(RightEyeball, -0.006981317007977563F, 0.0F, 0.0F);
		this.UpperBoddy = new ModelRenderer(this, 0, 75);
		this.UpperBoddy.setRotationPoint(0.0F, 6.5F, 1.0F);
		this.UpperBoddy.addBox(-3.5F, -3.0F, -4.5F, 7, 8, 8, 0.0F);
		this.setRotateAngle(UpperBoddy, 0.13962634015954636F, -0.0F, 0.0F);
		this.LeftArmFeathers4 = new ModelRenderer(this, 24, 32);
		this.LeftArmFeathers4.setRotationPoint(0.0F, 7.516910420957146E-4F, 0.003412681977403409F);
		this.LeftArmFeathers4.addBox(1.5F, 2.2F, 2.0F, 0, 1, 3, 0.0F);
		this.setRotateAngle(LeftArmFeathers4, -0.3839770968142266F, 0.0F, 0.0F);
		this.RightArmFeathers2 = new ModelRenderer(this, 24, 32);
		this.RightArmFeathers2.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.RightArmFeathers2.addBox(-1.5F, 0.5F, 1.5F, 0, 1, 3, 0.0F);
		this.setRotateAngle(RightArmFeathers2, -0.08726646259971634F, 0.0F, 0.0F);
		this.LeftUpperArm = new ModelRenderer(this, 24, 23);
		this.LeftUpperArm.setRotationPoint(2.0F, 2.63F, -4.05F);
		this.LeftUpperArm.addBox(0.0F, -1.5F, -1.5F, 2, 6, 3, 0.0F);
		this.setRotateAngle(LeftUpperArm, 0.5935864786032714F, 0.12322024519079966F,
				0.1117010721276371F);
		this.RghtArmFeathers1 = new ModelRenderer(this, 24, 32);
		this.RghtArmFeathers1.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.RghtArmFeathers1.addBox(-1.5F, -0.5F, 0.5F, 0, 1, 3, 0.0F);
		this.teeth_4 = new ModelRenderer(this, 0, 0);
		this.teeth_4.setRotationPoint(-1.9F, 1.94F, -20.02F);
		this.teeth_4.addBox(-0.5F, -0.1F, -1.0F, 0, 1, 1, 0.0F);
		this.setRotateAngle(teeth_4, -0.5742133239061343F, 0.0F, 0.0F);
		this.RightArmFeathers5 = new ModelRenderer(this, 24, 32);
		this.RightArmFeathers5.setRotationPoint(0.0F, 7.516910420957146E-4F, 0.003412681977403409F);
		this.RightArmFeathers5.addBox(-1.5F, 2.2F, 2.0F, 0, 1, 3, 0.0F);
		this.setRotateAngle(RightArmFeathers5, -0.3839770968142266F, 0.0F, 0.0F);
		this.HeadFeathers1 = new ModelRenderer(this, 26, 41);
		this.HeadFeathers1.setRotationPoint(0.0F, 0.0F, -1.0F);
		this.HeadFeathers1.addBox(0.0F, -3.0F, -5.0F, 0, 6, 1, 0.0F);
		this.setRotateAngle(HeadFeathers1, -1.0471975511965976F, 0.0F, 0.0F);
		this.LeftPupill = new ModelRenderer(this, 0, 4);
		this.LeftPupill.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.LeftPupill.addBox(4.5F, -1.5F, -2.0F, 1, 2, 1, 0.0F);
		this.setRotateAngle(LeftPupill, 0.0F, 0.7853981633974483F, 0.0F);
		this.TailFeathers3 = new ModelRenderer(this, 30, 63);
		this.TailFeathers3.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.TailFeathers3.addBox(0.0F, -1.5F, 2.7F, 0, 3, 5, 0.0F);
		this.RightMiddleFoot = new ModelRenderer(this, 56, 10);
		this.RightMiddleFoot.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.RightMiddleFoot.addBox(-0.7F, 6.0F, -4.5F, 1, 2, 5, 0.0F);
		this.setRotateAngle(RightMiddleFoot, 0.08726646259971647F, 0.0029670597283903604F,
				-0.03473205211468716F);
		this.LeftInnerFoot = new ModelRenderer(this, 56, 17);
		this.LeftInnerFoot.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.LeftInnerFoot.addBox(-0.699999988079071F, 6.0F, -3.5F, 1, 2, 4, 0.0F);
		this.setRotateAngle(LeftInnerFoot, 0.08909425967226049F, 0.20559054771714225F,
				0.05327424499186149F);
		this.Neck = new ModelRenderer(this, 0, 33);
		this.Neck.setRotationPoint(0.0F, -1.16F, -5.08F);
		this.Neck.addBox(-2.5F, -7.5F, -2.5F, 5, 8, 5, 0.0F);
		this.setRotateAngle(Neck, 0.757472895365539F, 0.0F, 0.0F);
		this.Tail3 = new ModelRenderer(this, 28, 106);
		this.Tail3.setRotationPoint(0.0F, -0.71F, 8.98F);
		this.Tail3.addBox(-1.5F, -1.5F, -0.1F, 3, 3, 9, 0.0F);
		this.setRotateAngle(Tail3, -0.010471975511965976F, 0.0F, 0.0F);
		this.RightLowerArm = new ModelRenderer(this, 34, 23);
		this.RightLowerArm.setRotationPoint(-0.7F, 4.06F, 0.85F);
		this.RightLowerArm.addBox(-1.0F, 0.0F, -5.0F, 2, 2, 5, 0.0F);
		this.setRotateAngle(RightLowerArm, -0.3141592653589793F, 0.0F, 0.0F);
		this.RightArmFeathers4 = new ModelRenderer(this, 24, 36);
		this.RightArmFeathers4.setRotationPoint(0.0F, 7.516910420957146E-4F, 0.003412681977403409F);
		this.RightArmFeathers4.addBox(-1.5F, 1.5F, 1.5F, 0, 1, 4, 0.0F);
		this.setRotateAngle(RightArmFeathers4, -0.20944417161479364F, 0.0F, 0.0F);
		this.LowerSnout1 = new ModelRenderer(this, 0, 14);
		this.LowerSnout1.setRotationPoint(0.0F, 1.5F, -6.7F);
		this.LowerSnout1.addBox(-2.5F, -3.0F, -7.0F, 5, 3, 7, 0.0F);
		this.setRotateAngle(LowerSnout1, 0.06283185307179587F, 0.0F, 0.0F);
		this.LeftLegThigh = new ModelRenderer(this, 28, 0);
		this.LeftLegThigh.setRotationPoint(3.0F, 1.57F, 6.19F);
		this.LeftLegThigh.addBox(-1.0F, -3.0F, -2.5F, 3, 9, 5, 0.0F);
		this.setRotateAngle(LeftLegThigh, -0.23108159296404923F, 0.009773843811168246F,
				-0.1392772743091475F);
		this.LeftInnerClaw1 = new ModelRenderer(this, 62, 5);
		this.LeftInnerClaw1.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.LeftInnerClaw1.addBox(-0.8F, 5.0F, -4.5F, 1, 2, 1, 0.0F);
		this.setRotateAngle(LeftInnerClaw1, 0.08726646259971647F, 0.0F, 0.0F);
		this.LeftInnerClaw2 = new ModelRenderer(this, 62, 2);
		this.LeftInnerClaw2.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.LeftInnerClaw2.addBox(-0.8F, 4.0F, -5.5F, 1, 1, 2, 0.0F);
		this.teeth_1 = new ModelRenderer(this, 26, 52);
		this.teeth_1.setRotationPoint(0.2F, 1.7381283548733533F, -16.821992070620283F);
		this.teeth_1.addBox(-2.5F, -0.1F, -7.0F, 5, 2, 7, 0.0F);
		this.setRotateAngle(teeth_1, 0.19547687622336515F, 0.0F, 0.0F);
		this.UpperSnout = new ModelRenderer(this, 0, 24);
		this.UpperSnout.setRotationPoint(0.5F, -0.30000000000000027F, 0.1999999999999993F);
		this.UpperSnout.addBox(-2.5F, -3.7F, -6.6F, 4, 1, 7, 0.0F);
		this.setRotateAngle(UpperSnout, 0.13962634015954634F, 0.0F, 0.0F);
		this.Neck4 = new ModelRenderer(this, 0, 32);
		this.Neck4.setRotationPoint(0.0F, -6.469988877623424F, 0.13908243393467767F);
		this.Neck4.addBox(-2.5F, -2.5F, -2.5F, 5, 3, 5, 0.0F);
		this.setRotateAngle(Neck4, 0.6143558967020042F, 0.0F, 0.0F);
		this.HeadFeathers2 = new ModelRenderer(this, 26, 41);
		this.HeadFeathers2.setRotationPoint(0.0F, 0.3F, -1.0F);
		this.HeadFeathers2.addBox(0.0F, -5.0F, -4.0F, 0, 6, 1, 0.0F);
		this.setRotateAngle(HeadFeathers2, -1.1344640137963142F, 0.0F, 0.0F);
		this.HeadFeathers6_4 = new ModelRenderer(this, 26, 41);
		this.HeadFeathers6_4.setRotationPoint(0.0F, 5.7F, -3.8F);
		this.HeadFeathers6_4.addBox(0.0F, -4.5F, 0.0F, 0, 6, 1, 0.0F);
		this.setRotateAngle(HeadFeathers6_4, -0.8021533242165939F, 0.0F, 0.0F);
		this.teeth_5 = new ModelRenderer(this, 0, 0);
		this.teeth_5.setRotationPoint(-1.9F, 2.24F, -21.02F);
		this.teeth_5.addBox(-0.5F, -0.1F, -1.0F, 0, 1, 1, 0.0F);
		this.setRotateAngle(teeth_5, -0.5742133239061343F, 0.0F, 0.0F);
		this.Chest = new ModelRenderer(this, 2, 61);
		this.Chest.setRotationPoint(0.0F, 0.28F, -3.07F);
		this.Chest.addBox(-3.0F, -3.0F, -6.5F, 6, 7, 7, 0.0F);
		this.setRotateAngle(Chest, -0.307177948351002F, 0.0F, 0.0F);
		this.HeadFeathers6_6 = new ModelRenderer(this, 26, 41);
		this.HeadFeathers6_6.setRotationPoint(0.0F, 5.2F, 0.2F);
		this.HeadFeathers6_6.addBox(0.0F, -4.5F, 0.0F, 0, 6, 1, 0.0F);
		this.setRotateAngle(HeadFeathers6_6, -0.7644542123735163F, 0.0F, 0.0F);
		this.RightHand2 = new ModelRenderer(this, 34, 30);
		this.RightHand2.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.RightHand2.addBox(-0.9F, 1.0F, -5.0F, 2, 3, 1, 0.0F);
		this.RightInnerClaw1 = new ModelRenderer(this, 62, 5);
		this.RightInnerClaw1.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.RightInnerClaw1.addBox(-0.4000000059604645F, 5.0F, -4.5F, 1, 2, 1, 0.0F);
		this.setRotateAngle(RightInnerClaw1, 0.08726646006107329F, 0.0F, 0.0F);
		this.HeadFeathers5 = new ModelRenderer(this, 26, 41);
		this.HeadFeathers5.setRotationPoint(0.0F, -0.1F, 0.0F);
		this.HeadFeathers5.addBox(0.0F, -5.0F, -1.0F, 0, 6, 1, 0.0F);
		this.setRotateAngle(HeadFeathers5, -1.6580627893946132F, 0.0F, 0.0F);
		this.HeadFeathers6_2 = new ModelRenderer(this, 26, 41);
		this.HeadFeathers6_2.setRotationPoint(0.0F, 3.9F, -8.7F);
		this.HeadFeathers6_2.addBox(0.0F, -4.5F, 0.0F, 0, 6, 1, 0.0F);
		this.setRotateAngle(HeadFeathers6_2, -1.2042771838760875F, 0.0F, 0.0F);
		this.Tailfeathers4 = new ModelRenderer(this, 30, 60);
		this.Tailfeathers4.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.Tailfeathers4.addBox(0.0F, -1.0F, 1.7F, 0, 2, 1, 0.0F);
		this.LeftEyeball = new ModelRenderer(this, 0, 0);
		this.LeftEyeball.setRotationPoint(0.0F, -0.3905136139032912F, -0.5710849569018883F);
		this.LeftEyeball.addBox(2.1F, -1.5F, -5.5F, 1, 2, 2, 0.0F);
		this.setRotateAngle(LeftEyeball, -0.006981317007977563F, 0.0F, 0.0F);
		this.RightUpperArm = new ModelRenderer(this, 24, 23);
		this.RightUpperArm.setRotationPoint(-2.0F, 2.63F, -4.05F);
		this.RightUpperArm.addBox(-2.0F, -1.5F, -1.5F, 2, 6, 3, 0.0F);
		this.setRotateAngle(RightUpperArm, 0.5935864786032714F, -0.12322024519079966F,
				-0.1117010721276371F);
		this.Tail1 = new ModelRenderer(this, 0, 92);
		this.Tail1.setRotationPoint(0.0F, -0.8F, 9.35F);
		this.Tail1.addBox(-3.0F, -3.0F, 0.0F, 6, 6, 8, 0.0F);
		this.setRotateAngle(Tail1, 0.1759291886010284F, 0.0F, 0.0F);
		this.HeadFeathers6_5 = new ModelRenderer(this, 26, 41);
		this.HeadFeathers6_5.setRotationPoint(0.0F, 5.5F, -1.8F);
		this.HeadFeathers6_5.addBox(0.0F, -4.5F, 0.0F, 0, 6, 1, 0.0F);
		this.setRotateAngle(HeadFeathers6_5, -0.7644542123735163F, 0.0F, 0.0F);
		this.LeftArmFeathers2 = new ModelRenderer(this, 24, 32);
		this.LeftArmFeathers2.setRotationPoint(0.0F, 7.516910420957146E-4F, 0.003412681977403409F);
		this.LeftArmFeathers2.addBox(1.5F, 0.5F, 1.5F, 0, 1, 3, 0.0F);
		this.setRotateAngle(LeftArmFeathers2, -0.08727112397519053F, 0.0F, 0.0F);
		this.LeftFoot = new ModelRenderer(this, 46, 10);
		this.LeftFoot.setRotationPoint(-0.04F, -0.09F, 5.0F);
		this.LeftFoot.addBox(-1.0F, 0.0F, -1.5F, 2, 7, 3, 0.0F);
		this.setRotateAngle(LeftFoot, 0.576482251933727F, -0.01815142422074103F,
				0.10314895879286487F);
		this.Neck2 = new ModelRenderer(this, 1, 32);
		this.Neck2.setRotationPoint(1.0F, 2.78F, -1.4F);
		this.Neck2.addBox(-2.5F, -8.5F, -2.5F, 3, 9, 5, 0.0F);
		this.setRotateAngle(Neck2, -0.13473941825396224F, 0.0F, 0.0F);
		this.TailFeathers1 = new ModelRenderer(this, 30, 71);
		this.TailFeathers1.setRotationPoint(0.0F, -0.09902680687415888F, 0.013917310096005053F);
		this.TailFeathers1.addBox(0.0F, -0.5F, 13.7F, 0, 1, 4, 0.0F);
		this.HeadFeathers6 = new ModelRenderer(this, 26, 41);
		this.HeadFeathers6.setRotationPoint(0.0F, 6.1F, 5.8F);
		this.HeadFeathers6.addBox(0.0F, -4.5F, 0.0F, 0, 6, 1, 0.0F);
		this.setRotateAngle(HeadFeathers6, -0.890117918517108F, 0.0F, 0.0F);
		this.RightInnerClaw2 = new ModelRenderer(this, 62, 2);
		this.RightInnerClaw2.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.RightInnerClaw2.addBox(-0.4F, 4.0F, -5.5F, 1, 1, 2, 0.0F);
		this.HeadFeathers4 = new ModelRenderer(this, 26, 41);
		this.HeadFeathers4.setRotationPoint(0.0F, -0.1F, -0.5F);
		this.HeadFeathers4.addBox(0.0F, -6.0F, -2.0F, 0, 6, 1, 0.0F);
		this.setRotateAngle(HeadFeathers4, -1.48352986419518F, 0.0F, 0.0F);
		this.LowerBoddy2 = new ModelRenderer(this, 0, 75);
		this.LowerBoddy2.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.LowerBoddy2.addBox(-3.7F, -4.1F, 2.0F, 7, 9, 8, 0.0F);
		this.teeth_3 = new ModelRenderer(this, 0, 0);
		this.teeth_3.setRotationPoint(-1.9F, 1.94F, -18.92F);
		this.teeth_3.addBox(-0.5F, -0.1F, -1.0F, 0, 1, 1, 0.0F);
		this.setRotateAngle(teeth_3, -0.5742133239061343F, 0.0F, 0.0F);
		this.Head = new ModelRenderer(this, 2, 2);
		this.Head.setRotationPoint(0.0F, -0.26F, 0.43F);
		this.Head.addBox(-3.0F, -3.0F, -7.0F, 6, 6, 6, 0.0F);
		this.setRotateAngle(Head, -1.0716321607245183F, 0.0F, 0.0F);
		this.LeftHand1 = new ModelRenderer(this, 34, 30);
		this.LeftHand1.setRotationPoint(0.0F, 7.669883586203241E-4F, 0.0033798929814690126F);
		this.LeftHand1.addBox(-0.9F, 1.0F, -5.0F, 2, 3, 1, 0.0F);
		this.setRotateAngle(LeftHand1, -0.20944417161479364F, 0.0F, 0.0F);
		this.LeftArmFeathers3 = new ModelRenderer(this, 24, 36);
		this.LeftArmFeathers3.setRotationPoint(0.0F, 7.516910420957146E-4F, 0.003412681977403409F);
		this.LeftArmFeathers3.addBox(1.5F, 1.5F, 1.5F, 0, 1, 4, 0.0F);
		this.setRotateAngle(LeftArmFeathers3, -0.20944417161479364F, 0.0F, 0.0F);
		this.HeadFeathers6_9 = new ModelRenderer(this, 26, 41);
		this.HeadFeathers6_9.setRotationPoint(0.0F, 0.4F, 0.2F);
		this.HeadFeathers6_9.addBox(0.0F, -4.5F, 0.0F, 0, 6, 1, 0.0F);
		this.setRotateAngle(HeadFeathers6_9, -1.7069320084504542F, 0.0F, 0.0F);
		this.LeftHand2 = new ModelRenderer(this, 34, 30);
		this.LeftHand2.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.LeftHand2.addBox(-1.1F, 1.0F, -5.0F, 2, 3, 1, 0.0F);
		this.RightLegThigh = new ModelRenderer(this, 28, 0);
		this.RightLegThigh.setRotationPoint(-3.0F, 1.57F, 6.19F);
		this.RightLegThigh.addBox(-2.0F, -3.0F, -2.5F, 3, 9, 5, 0.0F);
		this.setRotateAngle(RightLegThigh, -0.23108159296404923F, -0.009773843811168246F,
				0.1392772743091475F);
		this.HeadFeathers7 = new ModelRenderer(this, 26, 41);
		this.HeadFeathers7.setRotationPoint(0.0F, 0.0F, 0.5F);
		this.HeadFeathers7.addBox(0.0F, -3.5F, 1.0F, 0, 6, 1, 0.0F);
		this.setRotateAngle(HeadFeathers7, -2.007128639793479F, 0.0F, 0.0F);
		this.RightPupill = new ModelRenderer(this, 0, 4);
		this.RightPupill.setRotationPoint(0.1F, 0.0F, 0.0F);
		this.RightPupill.addBox(0.9F, -1.5F, -5.5F, 1, 2, 1, 0.0F);
		this.setRotateAngle(RightPupill, 0.0F, 0.7853981633974483F, 0.0F);
		this.teeth = new ModelRenderer(this, 0, 0);
		this.teeth.setRotationPoint(-1.9F, 2.34F, -22.32F);
		this.teeth.addBox(-0.5F, -0.1F, -1.0F, 0, 1, 1, 0.0F);
		this.setRotateAngle(teeth, -0.5742133239061343F, 0.0F, 0.0F);
		this.RightLeg = new ModelRenderer(this, 44, 0);
		this.RightLeg.setRotationPoint(-0.49F, 4.51F, -1.1F);
		this.RightLeg.addBox(-1.0F, -1.0F, -0.5F, 2, 3, 7, 0.0F);
		this.setRotateAngle(RightLeg, -0.3141592653589793F, 0.06283185307179587F, 0.0F);
		this.RightOutterFoot = new ModelRenderer(this, 56, 10);
		this.RightOutterFoot.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.RightOutterFoot.addBox(-1.0F, 6.0F, -4.5F, 1, 2, 5, 0.0F);
		this.setRotateAngle(RightOutterFoot, 0.08920936674176302F, 0.21167289761824615F,
				-0.01624963763548582F);
		this.HeadFeathers6_1 = new ModelRenderer(this, 26, 41);
		this.HeadFeathers6_1.setRotationPoint(0.0F, 1.5F, -10.0F);
		this.HeadFeathers6_1.addBox(0.0F, -4.5F, 0.0F, 0, 6, 1, 0.0F);
		this.setRotateAngle(HeadFeathers6_1, -1.5184364492350666F, 0.0F, 0.0F);
		this.RightHand1 = new ModelRenderer(this, 34, 30);
		this.RightHand1.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.RightHand1.addBox(-1.1F, 1.0F, -5.0F, 2, 3, 1, 0.0F);
		this.setRotateAngle(RightHand1, -0.20943951023931945F, 0.0F, 0.0F);
		this.LeftArmFeathers1 = new ModelRenderer(this, 24, 32);
		this.LeftArmFeathers1.setRotationPoint(0.0F, 7.516910420957146E-4F, 0.003412681977403409F);
		this.LeftArmFeathers1.addBox(1.5F, -0.5F, 0.5F, 0, 1, 3, 0.0F);
		this.HeadFeathers3 = new ModelRenderer(this, 26, 41);
		this.HeadFeathers3.setRotationPoint(0.0F, 0.0F, -1.0F);
		this.HeadFeathers3.addBox(0.0F, -6.0F, -3.0F, 0, 6, 1, 0.0F);
		this.setRotateAngle(HeadFeathers3, -1.3089969389957472F, 0.0F, 0.0F);
		this.RightMiddleClaw = new ModelRenderer(this, 62, 8);
		this.RightMiddleClaw.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.RightMiddleClaw.addBox(-0.6000000238418579F, 7.0F, -5.0F, 1, 1, 1, 0.0F);
		this.UpperSnout.addChild(this.UpperSnout2);
		this.Tail1.addChild(this.Tail2);
		this.LeftFoot.addChild(this.BackLeftClaw);
		this.RightOutterFoot.addChild(this.RightOutterClaw);
		this.RightFoot.addChild(this.BackRightClaw);
		this.RightLeg.addChild(this.RightFoot);
		this.LeftLegThigh.addChild(this.LeftLeg);
		this.Neck2.addChild(this.Neck3);
		this.RightFoot.addChild(this.RightInnerFoot);
		this.RightUpperArm.addChild(this.RightArmFeathers3);
		this.UpperBoddy.addChild(this.LowerBoddy1);
		this.LeftUpperArm.addChild(this.LeftLowerArm);
		this.Head.addChild(this.Jaw);
		this.TailFeathers3.addChild(this.TailFeathers2);
		this.Tail3.addChild(this.Tail4);
		this.Tail4.addChild(this.Tail5);
		this.LeftMiddleFoot.addChild(this.LeftMiddleClaw);
		this.LeftFoot.addChild(this.LeftOutterFoot);
		this.LeftUpperArm.addChild(this.LeftArmFeathers5);
		this.LeftFoot.addChild(this.LeftMiddleFoot);
		this.LeftOutterFoot.addChild(this.LeftOutterClaw);
		this.Head.addChild(this.RightEyeball);
		this.LeftUpperArm.addChild(this.LeftArmFeathers4);
		this.RightUpperArm.addChild(this.RightArmFeathers2);
		this.Chest.addChild(this.LeftUpperArm);
		this.RightUpperArm.addChild(this.RghtArmFeathers1);
		this.RightUpperArm.addChild(this.RightArmFeathers5);
		this.Head.addChild(this.HeadFeathers1);
		this.LeftEyeball.addChild(this.LeftPupill);
		this.Tailfeathers4.addChild(this.TailFeathers3);
		this.RightFoot.addChild(this.RightMiddleFoot);
		this.LeftFoot.addChild(this.LeftInnerFoot);
		this.Chest.addChild(this.Neck);
		this.Tail2.addChild(this.Tail3);
		this.RightUpperArm.addChild(this.RightLowerArm);
		this.RightUpperArm.addChild(this.RightArmFeathers4);
		this.Head.addChild(this.LowerSnout1);
		this.LowerBoddy1.addChild(this.LeftLegThigh);
		this.LeftInnerFoot.addChild(this.LeftInnerClaw1);
		this.LeftInnerClaw1.addChild(this.LeftInnerClaw2);
		this.LowerSnout1.addChild(this.UpperSnout);
		this.Neck.addChild(this.Neck4);
		this.Head.addChild(this.HeadFeathers2);
		this.UpperBoddy.addChild(this.Chest);
		this.RightHand1.addChild(this.RightHand2);
		this.RightInnerFoot.addChild(this.RightInnerClaw1);
		this.Head.addChild(this.HeadFeathers5);
		this.Tail5.addChild(this.Tailfeathers4);
		this.Head.addChild(this.LeftEyeball);
		this.Chest.addChild(this.RightUpperArm);
		this.LowerBoddy2.addChild(this.Tail1);
		this.LeftUpperArm.addChild(this.LeftArmFeathers2);
		this.LeftLeg.addChild(this.LeftFoot);
		this.Neck.addChild(this.Neck2);
		this.TailFeathers2.addChild(this.TailFeathers1);
		this.RightInnerClaw1.addChild(this.RightInnerClaw2);
		this.Head.addChild(this.HeadFeathers4);
		this.LowerBoddy1.addChild(this.LowerBoddy2);
		this.Neck4.addChild(this.Head);
		this.LeftLowerArm.addChild(this.LeftHand1);
		this.LeftUpperArm.addChild(this.LeftArmFeathers3);
		this.Head.addChild(this.HeadFeathers6_9);
		this.LeftHand1.addChild(this.LeftHand2);
		this.LowerBoddy2.addChild(this.RightLegThigh);
		this.Head.addChild(this.HeadFeathers7);
		this.RightEyeball.addChild(this.RightPupill);
		this.RightLegThigh.addChild(this.RightLeg);
		this.RightFoot.addChild(this.RightOutterFoot);
		this.RightLowerArm.addChild(this.RightHand1);
		this.LeftUpperArm.addChild(this.LeftArmFeathers1);
		this.Head.addChild(this.HeadFeathers3);
		this.RightMiddleFoot.addChild(this.RightMiddleClaw);
	}

	@Override
	public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
	{
		this.teeth_2.render(f5);
		this.HeadFeathers6_8.render(f5);
		this.HeadFeathers6_3.render(f5);
		this.HeadFeathers6_7.render(f5);
		this.UpperBoddy.render(f5);
		this.teeth_4.render(f5);
		this.teeth_1.render(f5);
		this.HeadFeathers6_4.render(f5);
		this.teeth_5.render(f5);
		this.HeadFeathers6_6.render(f5);
		this.HeadFeathers6_2.render(f5);
		this.HeadFeathers6_5.render(f5);
		this.HeadFeathers6.render(f5);
		this.teeth_3.render(f5);
		this.teeth.render(f5);
		this.HeadFeathers6_1.render(f5);
	}

	/**
	 * This is a helper function from Tabula to set the rotation of model parts
	 */
	public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z)
	{
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}
}
