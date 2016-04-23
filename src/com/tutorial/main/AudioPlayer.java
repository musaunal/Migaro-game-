package com.tutorial.main;

import java.util.HashMap;
import java.util.Map;

import org.newdawn.slick.Music;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.Sound;

public class AudioPlayer {

	public static Map<String, Sound> soundMap = new HashMap<String, Sound>();
	public static Map<String, Music> musicMap = new HashMap<String, Music>();
	
	public static void load() {
		
		try {
			soundMap.put("sound", new Sound("res/click4.ogg"));	
			soundMap.put("end" , new Sound("res/end.ogg"));
			soundMap.put("boss", new Sound("res/boss.ogg"));
			soundMap.put("basýc", new Sound("res/basic.ogg"));
			soundMap.put("fast", new Sound("res/fast.ogg"));
			soundMap.put("smart", new Sound("res/smart.ogg"));
			soundMap.put("heal", new Sound("res/heal.ogg"));
			musicMap.put("music", new Music("res/background.ogg"));
		} catch (SlickException e) {
			e.printStackTrace();
		}	
	}
	
	public static Music getMusic(String key){
		return musicMap.get(key);
	}
	
	public static Sound getSound(String key){
		return soundMap.get(key);
	}

}
