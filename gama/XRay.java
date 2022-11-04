package gama;

import java.util.ArrayList;

import com.google.common.collect.ImmutableMap;

import gama.gui.HUD;
import net.minecraft.block.Block;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntityChest;
import net.minecraft.util.BlockPos;
import net.minecraft.world.chunk.Chunk;
import net.minecraft.world.chunk.storage.ExtendedBlockStorage;

public class XRay {

	public static boolean enabled;
	private float oldGamma;
	public static ArrayList<Block> xrayBlocks = new ArrayList<Block>();

	public static boolean xRayBool = false;
	public Minecraft mc = Minecraft.getMinecraft();

//	public void glowXRAY() {
//		BlockPos playerBlockPos = mc.thePlayer.getPosition();
//		 System.out.println(playerBlockPos);
//		 for (int x = playerBlockPos.getX(); x < playerBlockPos.getX() + 50; x++) {
//			  
//			  BlockPos playerBlockPos_ = new BlockPos(x , playerBlockPos.getY(), playerBlockPos.getZ());
//			  
//			  //IBlockState curBlock = chunk.getBlockState(playerBlockPos_);
//			  
//			  IBlockState curBlock = mc.theWorld.getBlockState(playerBlockPos_);
//			  
//			  String blockName = curBlock.getBlock().getLocalizedName().toString();
//			  
//			  String ore = "Diamond Ore";			 			 
//			  
//			  if(blockName.equals(ore)) {
//				  
//				  HUD.blockESPBox(playerBlockPos_);
//			  }
//			  
//		 }
//		 
//	}
	
	public static boolean glowxRayBool = false;
	public static void onKeyglow(int k) {
		if (36 == k) {
			// Client.toggle(killAuraBool);
			glowxRayBool = !glowxRayBool;

		}
	}
	
	public static boolean fullBrightBool = false;
	public static void onKeyfullBright(int k) {
		if (37 == k) {
			System.out.println("ran");
			// Client.toggle(killAuraBool);
			fullBrightBool = !fullBrightBool;

			
			XRay x = new XRay();
			x.fullBright();
		}
	}

	public void glowXRAY() {
		BlockPos playerBlockPos = mc.thePlayer.getPosition();
		if(glowxRayBool) {
			for (int x = playerBlockPos.getX(); x < playerBlockPos.getX() + 50; x++) {

				for (int z = playerBlockPos.getZ(); z < playerBlockPos.getZ() + 50; z++) {

					for (int y = playerBlockPos.getY(); y < playerBlockPos.getY() + 50; y++) {

						BlockPos playerBlockPos_ = new BlockPos(x, y, z);

						// IBlockState curBlock = chunk.getBlockState(playerBlockPos_);

						IBlockState curBlock = mc.theWorld.getBlockState(playerBlockPos_);

						String blockName = curBlock.getBlock().getLocalizedName().toString();

						String ore = "Diamond Ore";

						if (blockName.equals(ore)) {

							HUD.blockESPBox(playerBlockPos_);

						}
					}
				}
			}
			//mc.theWorld.lis
			for (int x = playerBlockPos.getX(); x < playerBlockPos.getX() + 50; x++) {

				for (int z = playerBlockPos.getZ() - 50; z < playerBlockPos.getZ(); z++) {

					for (int y = playerBlockPos.getY(); y < playerBlockPos.getY() + 50; y++) {

						BlockPos playerBlockPos_ = new BlockPos(x, y, z);

						// IBlockState curBlock = chunk.getBlockState(playerBlockPos_);

						IBlockState curBlock = mc.theWorld.getBlockState(playerBlockPos_);

						String blockName = curBlock.getBlock().getLocalizedName().toString();

						String ore = "Diamond Ore";

						if (blockName.equals(ore)) {

							HUD.blockESPBox(playerBlockPos_);
						}
					}
				}
			}

			
			
			for (int x = playerBlockPos.getX(); x < playerBlockPos.getX() + 50; x++) {

				for (int z = playerBlockPos.getZ(); z < playerBlockPos.getZ() + 50; z++) {

					for (int y = playerBlockPos.getY(); y < playerBlockPos.getY() + 50; y++) {

						BlockPos playerBlockPos_ = new BlockPos(x, y, z);

						// IBlockState curBlock = chunk.getBlockState(playerBlockPos_);

						IBlockState curBlock = mc.theWorld.getBlockState(playerBlockPos_);

						String blockName = curBlock.getBlock().getLocalizedName().toString();

						String ore = "Diamond Ore";

						if (blockName.equals(ore)) {

							HUD.blockESPBox(playerBlockPos_);

						}
					}
				}
			}
			for (int x = playerBlockPos.getX() - 50; x < playerBlockPos.getX(); x++) {

				for (int z = playerBlockPos.getZ() - 50; z < playerBlockPos.getZ(); z++) {

					for (int y = playerBlockPos.getY(); y < playerBlockPos.getY() + 50; y++) {

						BlockPos playerBlockPos_ = new BlockPos(x, y, z);

						// IBlockState curBlock = chunk.getBlockState(playerBlockPos_);

						IBlockState curBlock = mc.theWorld.getBlockState(playerBlockPos_);

						String blockName = curBlock.getBlock().getLocalizedName().toString();

						String ore = "Diamond Ore";

						if (blockName.equals(ore)) {

							HUD.blockESPBox(playerBlockPos_);
						}
					}
				}
			}
			
			
			
			for (int x = playerBlockPos.getX(); x < playerBlockPos.getX() + 50; x++) {

				for (int z = playerBlockPos.getZ(); z < playerBlockPos.getZ() + 50; z++) {

					for (int y = playerBlockPos.getY() - 50; y < playerBlockPos.getY(); y++) {

						BlockPos playerBlockPos_ = new BlockPos(x, y, z);

						// IBlockState curBlock = chunk.getBlockState(playerBlockPos_);

						IBlockState curBlock = mc.theWorld.getBlockState(playerBlockPos_);

						String blockName = curBlock.getBlock().getLocalizedName().toString();

						String ore = "Diamond Ore";

						if (blockName.equals(ore)) {

							HUD.blockESPBox(playerBlockPos_);

						}
					}
				}
			}
			for (int x = playerBlockPos.getX(); x < playerBlockPos.getX() + 50; x++) {

				for (int z = playerBlockPos.getZ() - 50; z < playerBlockPos.getZ(); z++) {

					for (int y = playerBlockPos.getY() - 50; y < playerBlockPos.getY(); y++) {

						BlockPos playerBlockPos_ = new BlockPos(x, y, z);

						// IBlockState curBlock = chunk.getBlockState(playerBlockPos_);

						IBlockState curBlock = mc.theWorld.getBlockState(playerBlockPos_);

						String blockName = curBlock.getBlock().getLocalizedName().toString();

						String ore = "Diamond Ore";

						if (blockName.equals(ore)) {

							HUD.blockESPBox(playerBlockPos_);
						}
					}
				}
			}

			
			
			for (int x = playerBlockPos.getX(); x < playerBlockPos.getX() + 50; x++) {

				for (int z = playerBlockPos.getZ(); z < playerBlockPos.getZ() + 50; z++) {

					for (int y = playerBlockPos.getY() - 50; y < playerBlockPos.getY(); y++) {

						BlockPos playerBlockPos_ = new BlockPos(x, y, z);

						// IBlockState curBlock = chunk.getBlockState(playerBlockPos_);

						IBlockState curBlock = mc.theWorld.getBlockState(playerBlockPos_);

						String blockName = curBlock.getBlock().getLocalizedName().toString();

						String ore = "Diamond Ore";

						if (blockName.equals(ore)) {

							HUD.blockESPBox(playerBlockPos_);

						}
					}
				}
			}
			for (int x = playerBlockPos.getX() - 50; x < playerBlockPos.getX(); x++) {

				for (int z = playerBlockPos.getZ() - 50; z < playerBlockPos.getZ(); z++) {

					for (int y = playerBlockPos.getY() - 50; y < playerBlockPos.getY(); y++) {

						BlockPos playerBlockPos_ = new BlockPos(x, y, z);

						// IBlockState curBlock = chunk.getBlockState(playerBlockPos_);

						IBlockState curBlock = mc.theWorld.getBlockState(playerBlockPos_);

						String blockName = curBlock.getBlock().getLocalizedName().toString();

						String ore = "Diamond Ore";

						if (blockName.equals(ore)) {

							HUD.blockESPBox(playerBlockPos_);
						}
					}
				}
			}
		}
		
		
		
	}

	void fullBright() {
		if (fullBrightBool) {
			this.oldGamma = mc.gameSettings.gammaSetting;
			mc.gameSettings.gammaSetting = 10.0f;
			mc.gameSettings.ambientOcclusion = 0;
			mc.renderGlobal.loadRenderers();

		} else {
			mc.gameSettings.gammaSetting = this.oldGamma;
			mc.gameSettings.ambientOcclusion = 1;
			mc.renderGlobal.loadRenderers();
		}
	}
	
	void Xray() {
		if (xRayBool) {
			this.oldGamma = mc.gameSettings.gammaSetting;
			mc.gameSettings.gammaSetting = 10.0f;
			mc.gameSettings.ambientOcclusion = 0;
			mc.renderGlobal.loadRenderers();

		} else {
			mc.gameSettings.gammaSetting = this.oldGamma;
			mc.gameSettings.ambientOcclusion = 1;
			mc.renderGlobal.loadRenderers();
		}

//		 Block f = xrayBlocks.get(10);
//		 
//		 System.out.println(f.getBlockBoundsMinX());
//		 System.out.println(f.getBlockBoundsMinY());
//		 System.out.println(f.getBlockBoundsMinZ());
//		 
//		 System.out.println(f.getBlockBoundsMaxX());
//		 System.out.println(f.getBlockBoundsMaxY());
//		 System.out.println(f.getBlockBoundsMaxZ());
//		 
//		 System.out.println(xrayBlocks.size());

		BlockPos fasdas = new BlockPos(0, 0, 0);

		Chunk chunk = mc.theWorld.getChunkFromBlockCoords(fasdas);
		IBlockState block = chunk.getBlockState(fasdas);

		// ImmutableMap<IProperty, Comparable> asdasd = block.getProperties();

		ExtendedBlockStorage[] stor = chunk.getBlockStorageArray();

		ExtendedBlockStorage d = stor[1];

//		 double dist = 0;
//		 EntityPlayer dists = mc.theWorld.getClosestPlayer(0, 0, 0, dist);	 
//		 Entity fasdasdasd = (Entity)dists;	 
//		 System.out.println(fasdasdasd.getName());

		

	}

	public static void onKey(int k) {
		if (35 == k) {
			// Client.toggle(killAuraBool);
			xRayBool = !xRayBool;

			XRay x = new XRay();
			x.Xray();
		}
	}

//	
//	public boolean shouldXrayBlock(Block blockid) {
//		if(this.xrayBlocks.contains(blockid)) {
//			return true;
//		}
//		return false;
//		
//	}

}
