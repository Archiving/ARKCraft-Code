package com.arkcraft.module.item.client.event;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.client.model.ModelPlayer;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.WorldRenderer;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.event.FOVUpdateEvent;
import net.minecraftforge.client.event.MouseEvent;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.client.event.RenderHandEvent;
import net.minecraftforge.client.event.RenderLivingEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.common.eventhandler.EventPriority;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import org.lwjgl.opengl.GL11;

import com.arkcraft.lib.LogHelper;
import com.arkcraft.module.core.ARKCraft;
import com.arkcraft.module.item.common.items.weapons.handlers.IItemWeapon;
import com.arkcraft.module.item.common.tile.TileInventoryAttachment2;

public class ItemsClientEventHandler
{
	public static void init()
	{
		ItemsClientEventHandler handler = new ItemsClientEventHandler();
		FMLCommonHandler.instance().bus().register(handler);
		MinecraftForge.EVENT_BUS.register(handler);
	}

	private static final ResourceLocation OVERLAY_TEXTURE = new ResourceLocation(ARKCraft.MODID,
			"textures/gui/scope.png");
	public boolean showScopeOverlap = false;
	private Minecraft mc = Minecraft.getMinecraft();

	@SideOnly(Side.CLIENT)
	@SubscribeEvent
	public void onMouseEvent(MouseEvent evt)
	{
		Minecraft mc = Minecraft.getMinecraft();
		EntityPlayer thePlayer = mc.thePlayer;

		if (thePlayer != null && evt.button == 0)
		{
			LogHelper.info("mouse down");
			ItemStack stack = thePlayer.getCurrentEquippedItem();
			if (stack != null)
			{
				IItemWeapon i_item_weapon;
				if (stack.getItem() instanceof IItemWeapon)
				{
					i_item_weapon = (IItemWeapon) stack.getItem();
					TileInventoryAttachment2 inv = new TileInventoryAttachment2(stack);
					if (inv.isScopePresent())
					{
						if (evt.buttonstate)
						{
							showScopeOverlap = true;
						}
						else
						{
							showScopeOverlap = false;
						}
						evt.setCanceled(true);
					}
				}
				else
				{
					i_item_weapon = null;
				}
				// Weapon with scope?
				// if (i_item_weapon != null && i_item_weapon.ifCanScope())
				// {
				// if (evt.buttonstate)
				// {
				// ShowScopeOverlap = true;
				// }
				// else
				// {
				// ShowScopeOverlap = false;
				// }
				// evt.setCanceled(true);
				// }
			}
		}
	}

	@SubscribeEvent
	public void onFOVUpdate(FOVUpdateEvent evt)
	{
		if (mc.gameSettings.thirdPersonView == 0 && showScopeOverlap)
		{
			evt.newfov = 1 / 6.0F;
		}
	}

	@SubscribeEvent
	public void onRenderHand(RenderHandEvent evt)
	{
		if (showScopeOverlap)
		{
			evt.setCanceled(true);
		}
	}

	@SubscribeEvent(priority = EventPriority.NORMAL)
	public void onRender(RenderGameOverlayEvent evt)
	{
		if (evt.type == RenderGameOverlayEvent.ElementType.HELMET)
		{
			if (mc.gameSettings.thirdPersonView == 0 && showScopeOverlap)
			{
				evt.setCanceled(true); // Removes the normal crosshairs and uses
										// just the overlay crosshairs
				LogHelper.info("onRender ShowScopeOverlap = true");
				showScope();
			}
		}
	}

	@SubscribeEvent
	public void holding(RenderLivingEvent.Pre event)
	{
		Minecraft mc = Minecraft.getMinecraft();
		EntityPlayer thePlayer = mc.thePlayer;
		if (!event.isCanceled() & event.entity instanceof EntityPlayer && showScopeOverlap)
		{
			ItemStack stack = thePlayer.getCurrentEquippedItem();
			if (stack != null)
			{
				IItemWeapon i_item_weapon;
				if (stack.getItem() instanceof IItemWeapon)
				{
					i_item_weapon = (IItemWeapon) stack.getItem();
				}
				else
				{
					i_item_weapon = null;
				}
				if (i_item_weapon != null)
				{

					ModelPlayer model = (ModelPlayer) event.renderer.getMainModel();

					model.aimedBow = true;
				}

				/*
				 * ModelPlayer model =
				 * (ModelPlayer)event.renderer.getMainModel();
				 * model.bipedLeftArm.rotateAngleX =
				 * model.bipedLeftArm.rotateAngleX * 0.5F - ((float)Math.PI /
				 * 10F) * (float)model.heldItemLeft; model.heldItemRight = 0;
				 * 
				 * /* if (model.heldItemLeft != 0) {
				 * model.bipedLeftArm.rotateAngleX =
				 * model.bipedLeftArm.rotateAngleX * 0.5F - ((float)Math.PI /
				 * 10F) * (float)model.heldItemLeft; } switch
				 * (model.heldItemRight) { case 0: case 2: default: break; case
				 * 1: model.bipedRightArm.rotateAngleX =
				 * model.bipedRightArm.rotateAngleX * 0.5F - ((float)Math.PI /
				 * 10F) * (float)model.heldItemRight; break; case 3:
				 * model.bipedRightArm.rotateAngleX =
				 * model.bipedRightArm.rotateAngleX * 0.5F - ((float)Math.PI /
				 * 10F) * (float)model.heldItemRight;
				 * model.bipedRightArm.rotateAngleY = -0.5235988F; }
				 */

			}
		}
	}

	public void showScope()
	{
		LogHelper.info("In ShowScope");
		Minecraft mc = Minecraft.getMinecraft();
		GL11.glPushMatrix();
		mc.entityRenderer.setupOverlayRendering();
		GL11.glEnable(GL11.GL_BLEND);
		OpenGlHelper.glBlendFunc(770, 771, 1, 0);
		GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
		GL11.glDisable(GL11.GL_ALPHA_TEST);

		mc.renderEngine.bindTexture(OVERLAY_TEXTURE);

		ScaledResolution res = new ScaledResolution(mc, mc.displayWidth, mc.displayHeight);
		double width = res.getScaledWidth_double();
		double height = res.getScaledHeight_double();

		Tessellator tessellator = Tessellator.getInstance();
		WorldRenderer worldrenderer = tessellator.getWorldRenderer();

		worldrenderer.startDrawingQuads();
		worldrenderer.addVertexWithUV(0.0D, height, -90.0D, 0.0D, 1.0D);
		worldrenderer.addVertexWithUV(width, height, -90.0D, 1.0D, 1.0D);
		worldrenderer.addVertexWithUV(width, 0.0D, -90.0D, 1.0D, 0.0D);
		worldrenderer.addVertexWithUV(0.0D, 0.0D, -90.0D, 0.0D, 0.0D);
		tessellator.draw();

		GL11.glPopMatrix();
	}
}
