package gama;

import gama.combat.EventMotion;
import gama.events.Event;
import gama.events.listeners.EventUpdate;
import net.minecraft.client.Minecraft;

public class Fly {
	
	public Minecraft mc = Minecraft.getMinecraft();
	
public static boolean flyBool = false;
	
	public static void onKey(int k) {	
		if(33 == k){
			//Client.toggle(killAuraBool);
			flyBool = !flyBool;	
		}
	}
	
	public void onEvent(Event e) {
		if (e instanceof EventUpdate) {
			if(e.isPre()) {
				if(flyBool) {
					mc.thePlayer.capabilities.isFlying = true;
					mc.thePlayer.capabilities.allowFlying = true;
				}else {
					mc.thePlayer.capabilities.isFlying = false;
					mc.thePlayer.capabilities.allowFlying = false;
				}
			}
		}
	}
}
