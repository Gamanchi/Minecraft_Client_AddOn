package gama;

import gama.combat.EventMotion;
import gama.combat.KA;
import gama.events.Event;
import gama.gui.HUD;

public class Client {

	public static String name = "Gama";
	public static String Version = "1";
	
	private static final Client INSTANCE = new Client();
	public static final Client getInstance() {
		return INSTANCE;
	}
	
	public static HUD hud = new HUD();
	
	public static void onEvent(Event e) {
		//System.out.println("asdasdasdasd");
		
		KA f = new KA();
		f.onEvent(e);
		
		Fly s = new Fly();
		s.onEvent(e);
	}
	
	public static int key;//34
	public static boolean toggled;
	
	public static void onEnable() {}
	public static void onDisable() {}
	
	public static void toggle(boolean bool) {
		bool = !bool;		
	}
	
	public static int getKey() {
		return key;
	}
	
	
	
//	public static void onKey(int k) {
//		if(getKey() == k){
//			toggle();
//		}
//	}
	
//	private static int keys = 33;
//	public static boolean toggleds;
//	
//
//	
//	public static void toggles() {
//		toggleds = !toggleds;
//
//	}
//	
//	public static int getKeys() {
//		return keys;
//	}
//	
//	public static void onKeys(int k) {
//		if(getKeys() == k){
//			toggles();
//		}
//	}
	
	
	public static void startup() {
//		KA f = new KA();
//		f.onEvent(e);
	}
}
