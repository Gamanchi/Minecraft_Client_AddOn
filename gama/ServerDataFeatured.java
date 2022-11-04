package gama;

import net.minecraft.client.multiplayer.ServerData;
import net.minecraft.util.ResourceLocation;

public class ServerDataFeatured extends ServerData{

	public static final ResourceLocation STAR_ICON = new ResourceLocation("gama/star.png");
	
	public ServerDataFeatured(String serverName, String serverIp) {
		super(serverName, serverIp, false);
	}
}
