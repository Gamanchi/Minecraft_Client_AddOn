package gama.combat;

import java.util.Comparator;
import java.util.List;
import java.util.Locale.Category;
import java.util.stream.Collectors;

import org.lwjgl.input.Keyboard;

import gama.events.Event;
import gama.gama.Timer;
import gama.Client;
import gama.combat.EventMotion;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.entity.Entity;
//import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.network.play.client.C02PacketUseEntity;
import net.minecraft.network.play.client.C02PacketUseEntity.Action;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.KeyAdapter;

public class KA {

	public Minecraft mc = Minecraft.getMinecraft();
	public Timer timer = new Timer();

	public static boolean killAuraBool = false;
	
	public static void onKey(int k) {	
		if(34 == k){
			//Client.toggle(killAuraBool);
			killAuraBool = !killAuraBool;		
		}
	}

	public void onEvent(Event e) {
		if (e instanceof EventMotion) {
			if (e.isPre()) {

				EventMotion event = (EventMotion) e;

				List<Entity> targets = mc.theWorld.loadedEntityList.stream().filter(EntityLivingBase.class::isInstance)
						.collect(Collectors.toList());

				targets = targets.stream()
						.filter(entity -> entity.getDistanceToEntity(mc.thePlayer) < 5 && entity != mc.thePlayer)
						.collect(Collectors.toList());

				targets.sort(Comparator
						.comparingDouble(entity -> ((EntityLivingBase) entity).getDistanceToEntity(mc.thePlayer)));

				if (!targets.isEmpty()) {
					Entity target = targets.get(0);

					event.setYaw(getRotations(target)[0]);
					event.setPitch(getRotations(target)[1]);

					// mc.thePlayer.rotationYaw = (getRotations(target)[0]);
					// mc.thePlayer.rotationPitch = (getRotations(target)[1]);

//					if(timer.hasTimeElapsed(1000 / 10, true)) {
//						mc.thePlayer.swingItem();
//						mc.thePlayer.sendQueue.addToSendQueue(new C02PacketUseEntity(target, Action.ATTACK));
//					}

					// EntityPlayerSP f = (EntityPlayerSP)target;
					// System.out.println(f.getHealth());

					
					
					
					
					
					if(killAuraBool) {
						if (timer.hasTimeElapsed(1000 / 10, true)) {
							mc.playerController.attackEntity(mc.thePlayer, target);
							mc.thePlayer.swingItem();
						}
					}
				}
			}
		}
	}

	public float[] getRotations(Entity e) {
		double deltaX = e.posX + (e.posX - e.lastTickPosX) - mc.thePlayer.posX,
				deltaY = e.posY - 3.5 + e.getEyeHeight() - mc.thePlayer.posY + mc.thePlayer.getEyeHeight(),
				deltaZ = e.posZ + (e.posZ - e.lastTickPosZ) - mc.thePlayer.posZ,
				distance = Math.sqrt(Math.pow(deltaX, 2) + Math.pow(deltaZ, 2));

		float yaw = (float) Math.toDegrees(-Math.atan(deltaX / deltaZ)),
				pitch = (float) -Math.toDegrees(Math.atan(deltaY / distance));

		if (deltaX < 0 && deltaZ < 0) {
			yaw = (float) (90 + Math.toDegrees(Math.atan(deltaZ / deltaX)));

		} else if (deltaX > 0 && deltaZ < 0) {
			yaw = (float) (-90 + Math.toDegrees(Math.atan(deltaZ / deltaX)));
		}
		return new float[] { yaw, pitch };
	}
}
