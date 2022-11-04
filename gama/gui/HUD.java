package gama.gui;

import org.lwjgl.opengl.GL11;
import org.newdawn.slick.tests.xml.GameData;

import gama.XRay;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.RenderGlobal;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.WorldRenderer;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import net.minecraft.entity.Entity;
import net.minecraft.entity.monster.EntityMagmaCube;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.passive.EntityAnimal;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityChest;
import net.minecraft.tileentity.TileEntityEnderChest;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.BlockPos;
import net.minecraft.util.Vec3;

import java.awt.Color;

public class HUD {

	public Minecraft mc = Minecraft.getMinecraft();

	private void drawLineWithGL(Vec3 blockA, Vec3 blockB) {
		int d = Math.round((float) blockA.distanceTo(blockB) + 0.2f);
		GL11.glColor3f(0F, 1F, 0F);
		float oz = (blockA.xCoord - blockB.xCoord == 0 ? 0 : -1f / 16f);
		float ox = (blockA.zCoord - blockB.zCoord == 0 ? 0 : 1f / 16f);
		GL11.glBegin(GL11.GL_LINE_STRIP);

		// you will want to modify these offsets.
		//GL11.glVertex3d(blockA.xCoord + 0.5, blockA.yCoord - 0.01, blockA.zCoord + 0.5);
		//GL11.glVertex3d(blockB.xCoord + 0.5, blockB.yCoord - 0.01, blockB.zCoord + 0.5);

		GL11.glVertex3d(blockA.xCoord, blockA.yCoord, blockA.zCoord);
		GL11.glVertex3d(blockB.xCoord, blockB.yCoord, blockB.zCoord);
		
		GL11.glEnd();
	}


	public static void drawTracerLine(double x, double y, double z, float red, float green, float blue, float alpha,
			float lineWdith) {
		GL11.glPushMatrix();
		GL11.glEnable(GL11.GL_BLEND);
		GL11.glEnable(GL11.GL_LINE_SMOOTH);
		GL11.glDisable(GL11.GL_DEPTH_TEST);
//		GL11.glDisable(GL11.GL_LIGHTING);
		GL11.glDisable(GL11.GL_TEXTURE_2D);
		GL11.glBlendFunc(770, 771);
		GL11.glEnable(GL11.GL_BLEND);
		GL11.glLineWidth(lineWdith);
		GL11.glColor4f(red, green, blue, alpha);
		GL11.glBegin(2);
		GL11.glVertex3d(0.0D, 0.0D + Minecraft.getMinecraft().thePlayer.getEyeHeight() - 0.2, 0.0D);
		GL11.glVertex3d(x, y, z);
		GL11.glEnd();
		GL11.glDisable(GL11.GL_BLEND);
		GL11.glEnable(GL11.GL_TEXTURE_2D);
		GL11.glEnable(GL11.GL_DEPTH_TEST);
		GL11.glDisable(GL11.GL_LINE_SMOOTH);
		GL11.glDisable(GL11.GL_BLEND);
//		GL11.glEnable(GL11.GL_LIGHTING);
		GL11.glPopMatrix();
	}

	public static void filledBox(AxisAlignedBB bb, int color, boolean shouldColor) {
		float var11 = (float) (color >> 24 & 255) / 255.0f;
		float var6 = (float) (color >> 16 & 255) / 255.0f;
		float var7 = (float) (color >> 8 & 255) / 255.0f;
		float var8 = (float) (color & 255) / 255.0f;
		Tessellator tessellator = Tessellator.getInstance();
		WorldRenderer worldRenderer = tessellator.getWorldRenderer();
		
		
		
		if (shouldColor) {
			GlStateManager.color((float) var6, (float) var7, (float) var8, (float) var11);
		}
		worldRenderer.begin(7, DefaultVertexFormats.POSITION);
		worldRenderer.pos(bb.minX, bb.minY, bb.minZ).endVertex();
		worldRenderer.pos(bb.minX, bb.maxY, bb.minZ).endVertex();
		worldRenderer.pos(bb.maxX, bb.minY, bb.minZ).endVertex();
		worldRenderer.pos(bb.maxX, bb.maxY, bb.minZ).endVertex();
		worldRenderer.pos(bb.maxX, bb.minY, bb.maxZ).endVertex();
		worldRenderer.pos(bb.maxX, bb.maxY, bb.maxZ).endVertex();
		worldRenderer.pos(bb.minX, bb.minY, bb.maxZ).endVertex();
		worldRenderer.pos(bb.minX, bb.maxY, bb.maxZ).endVertex();
		tessellator.draw();
		worldRenderer.begin(7, DefaultVertexFormats.POSITION);
		worldRenderer.pos(bb.maxX, bb.maxY, bb.minZ).endVertex();
		worldRenderer.pos(bb.maxX, bb.minY, bb.minZ).endVertex();
		worldRenderer.pos(bb.minX, bb.maxY, bb.minZ).endVertex();
		worldRenderer.pos(bb.minX, bb.minY, bb.minZ).endVertex();
		worldRenderer.pos(bb.minX, bb.maxY, bb.maxZ).endVertex();
		worldRenderer.pos(bb.minX, bb.minY, bb.maxZ).endVertex();
		worldRenderer.pos(bb.maxX, bb.maxY, bb.maxZ).endVertex();
		worldRenderer.pos(bb.maxX, bb.minY, bb.maxZ).endVertex();
		tessellator.draw();
		worldRenderer.begin(7, DefaultVertexFormats.POSITION);
		worldRenderer.pos(bb.minX, bb.maxY, bb.minZ).endVertex();
		worldRenderer.pos(bb.maxX, bb.maxY, bb.minZ).endVertex();
		worldRenderer.pos(bb.maxX, bb.maxY, bb.maxZ).endVertex();
		worldRenderer.pos(bb.minX, bb.maxY, bb.maxZ).endVertex();
		worldRenderer.pos(bb.minX, bb.maxY, bb.minZ).endVertex();
		worldRenderer.pos(bb.minX, bb.maxY, bb.maxZ).endVertex();
		worldRenderer.pos(bb.maxX, bb.maxY, bb.maxZ).endVertex();
		worldRenderer.pos(bb.maxX, bb.maxY, bb.minZ).endVertex();
		tessellator.draw();
		worldRenderer.begin(7, DefaultVertexFormats.POSITION);
		worldRenderer.pos(bb.minX, bb.minY, bb.minZ).endVertex();
		worldRenderer.pos(bb.maxX, bb.minY, bb.minZ).endVertex();
		worldRenderer.pos(bb.maxX, bb.minY, bb.maxZ).endVertex();
		worldRenderer.pos(bb.minX, bb.minY, bb.maxZ).endVertex();
		worldRenderer.pos(bb.minX, bb.minY, bb.minZ).endVertex();
		worldRenderer.pos(bb.minX, bb.minY, bb.maxZ).endVertex();
		worldRenderer.pos(bb.maxX, bb.minY, bb.maxZ).endVertex();
		worldRenderer.pos(bb.maxX, bb.minY, bb.minZ).endVertex();
		tessellator.draw();
		worldRenderer.begin(7, DefaultVertexFormats.POSITION);
		worldRenderer.pos(bb.minX, bb.minY, bb.minZ).endVertex();
		worldRenderer.pos(bb.minX, bb.maxY, bb.minZ).endVertex();
		worldRenderer.pos(bb.minX, bb.minY, bb.maxZ).endVertex();
		worldRenderer.pos(bb.minX, bb.maxY, bb.maxZ).endVertex();
		worldRenderer.pos(bb.maxX, bb.minY, bb.maxZ).endVertex();
		worldRenderer.pos(bb.maxX, bb.maxY, bb.maxZ).endVertex();
		worldRenderer.pos(bb.maxX, bb.minY, bb.minZ).endVertex();
		worldRenderer.pos(bb.maxX, bb.maxY, bb.minZ).endVertex();
		tessellator.draw();
		worldRenderer.begin(7, DefaultVertexFormats.POSITION);
		worldRenderer.pos(bb.minX, bb.maxY, bb.maxZ).endVertex();
		worldRenderer.pos(bb.minX, bb.minY, bb.maxZ).endVertex();
		worldRenderer.pos(bb.minX, bb.maxY, bb.minZ).endVertex();
		worldRenderer.pos(bb.minX, bb.minY, bb.minZ).endVertex();
		worldRenderer.pos(bb.maxX, bb.maxY, bb.minZ).endVertex();
		worldRenderer.pos(bb.maxX, bb.minY, bb.minZ).endVertex();
		worldRenderer.pos(bb.maxX, bb.maxY, bb.maxZ).endVertex();
		worldRenderer.pos(bb.maxX, bb.minY, bb.maxZ).endVertex();
		tessellator.draw();

	}

	public static void drawOutlinedBoundingBox(AxisAlignedBB bb, int color) {
		float[] color1;
		float red = (color >> 16 & 0xFF) / 255.0F;
		float blue = (color >> 8 & 0xFF) / 255.0F;
		float green = (color & 0xFF) / 255.0F;
		float alpha = (color >> 24 & 0xFF) / 255.0F;
		color1 = new float[] { red, blue, green, alpha };

		GL11.glLineWidth(1.0F);
		GL11.glColor4f(color1[0], color1[1], color1[2], 0.8F);
		RenderGlobal.func_181561_a(bb);
		GlStateManager.disableDepth();
		GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
		GL11.glPopMatrix();

	}

	private void drawEsp() {
		final double x1 = 1;
		final double y1 = 1;
		final double z1 = 1;

		AxisAlignedBB box = new AxisAlignedBB(x1, y1, z1, x1 + 1.0, y1 + 1.0, z1 + 1.0);

		filledBox(box, new Color(1, 1, 1).getRGB() & 0x19FFFFFF, true);
		drawOutlinedBoundingBox(box, new Color(1, 1, 1).getRGB());
	}
	
	public static void blockESPBox(BlockPos blockPos) {
		
		double x =
				blockPos.getX()
					- Minecraft.getMinecraft().getRenderManager().renderPosX;
		double y =
				blockPos.getY()
					- Minecraft.getMinecraft().getRenderManager().renderPosY;
		double z =
				blockPos.getZ()
					- Minecraft.getMinecraft().getRenderManager().renderPosZ;
		
		//GL11.glBlendFunc(770, 771);
		//GL11.glEnable(GL11.GL_BLEND);
		GL11.glLineWidth(1.0F);
		GL11.glColor4d(0, 0, 1, 1.0F);
		GL11.glDisable(GL11.GL_TEXTURE_2D);
		GL11.glDisable(GL11.GL_DEPTH_TEST);
		GL11.glDepthMask(false);
		
		//Box

		RenderGlobal.func_181561_a(new AxisAlignedBB(x, y, z, x + 1.0, y + 1.0, z + 1.0));
		//RenderGlobal.func_181563_a(new AxisAlignedBB(x, y, z, x + 1.0, y + 1.0, z + 1.0),0,255,255,255);
		
		//RenderGlobal.func_181561_a(new AxisAlignedBB(blockPos.getX(), blockPos.getY(), blockPos.getZ(), blockPos.getX() + 10.0, blockPos.getY() + 10.0, blockPos.getZ() + 10.0));
		
		//RenderGlobal.func_181563_a(new AxisAlignedBB(x, y, z, x + 10.0, y + 10.0, z + 10.0), 0, 255, 0, 255);
		
		GL11.glEnable(GL11.GL_TEXTURE_2D);
		GL11.glEnable(GL11.GL_DEPTH_TEST);
		GL11.glDepthMask(true);
		//GL11.glDisable(GL11.GL_BLEND);
		
		
		
	}
	public static void entityESPBox(Entity entity, int mode) {
		//GL11.glBlendFunc(770, 771);
		//GL11.glEnable(GL11.GL_BLEND);
		GL11.glLineWidth(2.0F);
		GL11.glDisable(GL11.GL_TEXTURE_2D);
		GL11.glDisable(GL11.GL_DEPTH_TEST);
		GL11.glDepthMask(false);
		if(mode == 0) //Enemy
			GL11.glColor4d(
					1 - Minecraft.getMinecraft().thePlayer.getDistanceSqToEntity(entity) / 40,
					 Minecraft.getMinecraft().thePlayer.getDistanceSqToEntity(entity) / 40,
					0, 0.5F);
					
		
		else if(mode == 1)//friend
			GL11.glColor4d(0, 0, 1, 0.5F);
		else if(mode == 2)//Other
			GL11.glColor4d(1, 1, 0, 0.5F);
		else if(mode == 3)// Target
			GL11.glColor4d(1, 0, 0, 0.5F);
		else if(mode == 4)//Team
			GL11.glColor4d(1, 1, 1, 0.5F);
		Minecraft.getMinecraft().getRenderManager();
		RenderGlobal.func_181561_a(
				new AxisAlignedBB(
						entity.boundingBox.minX
							-0.05
							- entity.posX
							+ (entity.posX - Minecraft.getMinecraft().getRenderManager().renderPosX),
						entity.boundingBox.minY
							-0.05
							- entity.posY
							+ (entity.posY - Minecraft.getMinecraft().getRenderManager().renderPosY),
						entity.boundingBox.minZ
							-0.05
							- entity.posZ
							+ (entity.posZ - Minecraft.getMinecraft().getRenderManager().renderPosZ),
						entity.boundingBox.maxX
							+0.05
							- entity.posX
							+ (entity.posX - Minecraft.getMinecraft().getRenderManager().renderPosX),
						entity.boundingBox.maxY
							+0.1
							- entity.posY
							+ (entity.posY - Minecraft.getMinecraft().getRenderManager().renderPosY),
						entity.boundingBox.maxZ
							+0.05
							- entity.posZ
							+ (entity.posZ - Minecraft.getMinecraft().getRenderManager().renderPosZ)));
		
		GL11.glEnable(GL11.GL_TEXTURE_2D);
		GL11.glEnable(GL11.GL_DEPTH_TEST);
		GL11.glDepthMask(true);
		//GL11.glDisable(GL11.GL_BLEND);
					
					
		
		
		
	}

	public static void drawLine(AxisAlignedBB blockA, AxisAlignedBB blockB)
    {
		
		GL11.glBlendFunc(770, 771);
		GL11.glEnable(GL11.GL_BLEND);
		GL11.glLineWidth(1.0F);
		GL11.glColor4d(0, 0, 1, 0.15F);
		GL11.glDisable(GL11.GL_TEXTURE_2D);
		GL11.glDisable(GL11.GL_DEPTH_TEST);
		GL11.glDepthMask(false);
		
		
		GL11.glColor4d(0, 0, 1, 0.5F);
		Tessellator tessellator = Tessellator.getInstance();
        WorldRenderer worldrenderer = tessellator.getWorldRenderer();
        worldrenderer.begin(3, DefaultVertexFormats.POSITION);
        worldrenderer.pos(blockA.minX, blockA.minY, blockA.minZ).endVertex();
        worldrenderer.pos(blockB.maxX, blockB.maxY, blockB.maxZ).endVertex();
        tessellator.draw();
        
		
		GL11.glEnable(GL11.GL_TEXTURE_2D);
		GL11.glEnable(GL11.GL_DEPTH_TEST);
		GL11.glDepthMask(true);
		GL11.glDisable(GL11.GL_BLEND);
		
        
    }
	
	

	public void draw() {
		ScaledResolution scaledResolution = new ScaledResolution(mc);

		//mc.fontRendererObj.drawString("Hello0", 0, 0, -1);
		
		// mc.getRenderManager().setRenderOutlines(true);

		//drawEsp();
		
		//blockESPBox2();
		
		
		for(Object o: mc.theWorld.loadedEntityList) {
			if(o instanceof EntityAnimal) {
				entityESPBox((Entity)o, 0);
				
			}			
		}
		
		for(Object o: mc.theWorld.loadedEntityList) {
			if(o instanceof EntityMob) {
				entityESPBox((Entity)o, 0);
				
			}			
		}
		
		
		for(Object o: mc.theWorld.loadedEntityList) {
			//if(o instanceof EntityMagmaCube) {
				entityESPBox((Entity)o, 0);
				
			//}			
		}
		
		for(Object o: mc.theWorld.loadedEntityList) {
			if(o instanceof EntityPlayer) {
				entityESPBox((Entity)o, 4);
			}		
		}
		
		
//		for(Object o: mc.theWorld.) {
//			if(o instanceof EntityAnimal) {
//				entityESPBox((Entity)o, 0);
//				
//			}			
//		}
		
		for(Object o: mc.theWorld.loadedTileEntityList) {

				blockESPBox(((TileEntity)o).getPos());
				
				
				
		}
		
		
		for(Object o: mc.theWorld.loadedTileEntityList) {
			if(o instanceof TileEntityChest) {
				blockESPBox(((TileEntityChest)o).getPos());
				
				
				//System.out.println(((TileEntityChest)o).getPos());
				
				//drawOutlinedBlockESP(Minecraft.getMinecraft().getRenderManager().renderPosX,Minecraft.getMinecraft().getRenderManager().renderPosY,Minecraft.getMinecraft().getRenderManager().renderPosZ,1, 0, 0, 0.15F,2.0F);
				//drawOutlinedBlockESP(((TileEntityChest)o).getPos().getX(), ((TileEntityChest)o).getPos().getY(), ((TileEntityChest)o).getPos().getZ(), 0, 1, 0, 0.15F,2.0F);
				
				//System.out.println(Minecraft.getMinecraft().getRenderManager().renderPosX);
				//System.out.println(Minecraft.getMinecraft().getRenderManager().renderPosY);
				//System.out.println(Minecraft.getMinecraft().getRenderManager().renderPosZ);
			}
		}
		
		double x = 1 - Minecraft.getMinecraft().getRenderManager().renderPosX;
		double y = 1 - Minecraft.getMinecraft().getRenderManager().renderPosY;
		double z = 1 - Minecraft.getMinecraft().getRenderManager().renderPosZ;
		
		double xx = 5 - Minecraft.getMinecraft().getRenderManager().renderPosX;
		double yy = 5 - Minecraft.getMinecraft().getRenderManager().renderPosY;
		double zz = 5 - Minecraft.getMinecraft().getRenderManager().renderPosZ;
		
		drawLine(new AxisAlignedBB(x, y, z, x + 1.0, y + 1.0, z + 1.0), new AxisAlignedBB(xx, yy, zz, xx + 1.0, yy + 1.0, zz + 1.0));
		
		XRay xray = new XRay();
		xray.glowXRAY();
		
		// drawTracerLine(1.0D,1.0D,1.0D,255.0F,255.0F,255.0F,255.0F,10.0F);

		// drawOutlinedBlockESP(1.0D,1,1,1,1,1,255,1);

	}
}
