package com.tutorial.main;

import java.awt.Color;
import java.awt.Graphics;

public class HUD extends IO {

	public static float HEALTH;
	public static double mana;
	private float greenValue = 255;
	
	private int score = 0;
	private int level = 1;
	
	public HUD(){
		
		build();
		
	}
	
	public void build(){
		read("Save/health.txt");
		float x = Integer.valueOf(temp);
		HEALTH = x;
		
		read("Save/mana.txt");
		int y = Integer.valueOf(temp);
		mana = y;
	}
	
	public void tick (){
		
		HEALTH = Gamee.clamp(HEALTH,0,250);
		greenValue = HEALTH*5/2;
		greenValue = Gamee.clamp(greenValue, 0, 255);
		score++;
	}
	public void render (Graphics g){
		g.setColor(Color.GRAY);
		g.fillRect(15, 15, (int)HEALTH *2, 32);
		g.setColor(new Color(75, (int)greenValue, 0));
		g.fillRect(15, 15, (int)HEALTH * 2, 32);
		
		g.setColor(Color.blue);
		g.fillRect(15, 100, (int)mana*2, 32);
		
		g.setColor(Color.WHITE);
		g.drawRect(15, 15,(int)HEALTH * 2, 32);

		g.drawString("Score " + score, 15, 64);
		g.drawString("Level " + level, 15, 80);
	}
	public void setScore (int score){
		this.score = score;
	}
	public int getScore (){
		return score;
	}
	public void setLevel (int level){
		this.level = level;
	}
	public int getLevel (){
		return level;
	}
}
