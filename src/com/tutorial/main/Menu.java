package com.tutorial.main;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;

import com.tutorial.main.Gamee.STATE;

public class Menu extends MouseAdapter {
	
	private Handler handler;
	private HUD hud;
	private Random r = new Random();
	
	public Menu ( Handler handler , HUD hud){
		this.hud= hud;
		this.handler = handler;
	}
	
	public void mousePressed(MouseEvent e){
		int mx = e.getX();
		int my = e.getY();
		 
		
	if (Gamee.gameState == STATE.Menu){
		//play button
		if (mouseOver(mx, my, 210, 150, 200, 64)){
			AudioPlayer.getSound("sound").play();	
			Gamee.gameState = STATE.Select;
			return; 			// return ne i� yapar
		}
		
		//options button
		if(mouseOver(mx, my, 210, 250, 200, 64)){
			AudioPlayer.getSound("sound").play();	
			Gamee.gameState = STATE.Options;
		}
		
		//quit button
		if (mouseOver(mx, my, 210, 350, 200, 64) ){
			AudioPlayer.getSound("sound").play();	
			System.exit(1);
		}
	}
	
	if (Gamee.gameState == STATE.Select){
		//normal button
		if (mouseOver(mx, my, 210, 150, 200, 64)){
			AudioPlayer.getSound("sound").play();	
			Gamee.gameState = STATE.Game;			
			handler.addObject(new Player(Gamee.WIDTH/2-32,Gamee.HEIGHT/2-32, ID.Player , handler));
			handler.addObject(new BasicEnemy(r.nextInt(Gamee.WIDTH - 60), r.nextInt(Gamee.HEIGHT - 50), ID.BasicEnemy, handler));
			
			Gamee.diff = 0;
		}
		
		//hard button
		if(mouseOver(mx, my, 210, 250, 200, 64)){
			AudioPlayer.getSound("sound").play();		
			Gamee.gameState = STATE.Game;			
			handler.addObject(new Player(Gamee.WIDTH/2-32,Gamee.HEIGHT/2-32, ID.Player , handler));
			handler.addObject(new HardEnemy(r.nextInt(Gamee.WIDTH - 60), r.nextInt(Gamee.HEIGHT - 50), ID.BasicEnemy, handler));
			
			Gamee.diff = 1;
		}
		
		//back button
		if (mouseOver(mx, my, 210, 350, 200, 64) ){
			Gamee.gameState = STATE.Menu;
			AudioPlayer.getSound("sound").play();	
			return;
		}
	}
	if (Gamee.gameState == STATE.Options){
		
		//back button for options
		if(Gamee.gameState == STATE.Options){
			if(mouseOver(mx, my, 210, 350, 200, 64))
				Gamee.gameState = STATE.Menu;
				AudioPlayer.getSound("sound").play();	
				return;
				
		}
	}
	if(Gamee.gameState == STATE.End){
		if(mouseOver(mx, my, 210, 350, 200, 64))
			Gamee.gameState = STATE.Menu;
			hud.setLevel(1);
			hud.setScore(0);
			AudioPlayer.getSound("sound").play();
			return;
		}
	
	
		
		
	}
	public void mouseRelease(MouseEvent e){
		
	}
	
	private boolean mouseOver(int mx, int my, int x, int y ,int width ,int height){ // button borders calculated
		if(mx > x && mx < x + width){
			if (my > y && my < y + height){
				return true;
			}else return false;
		}else return false; 
	}
	
	public void tick(){
		
	}
	
	public void render(Graphics g){
		if (Gamee.gameState == STATE.Menu){
			g.setColor(Color.white);
			
			Font ftn = new Font("arial",1,50);
			Font ftn2 = new Font("arial",1,30);
			
			g.setFont(ftn);
			g.drawString("Menu", 240, 100);  // title
			
			g.setFont(ftn2);
			g.drawRect(210, 150, 200, 64);
			g.drawString("Play", 275, 190);
			
			g.drawRect(210, 250, 200, 64);
			g.drawString("Options", 275, 290);
			
			g.drawRect(210, 350, 200, 64);
			g.drawString("Quit", 275, 390);
		}else if (Gamee.gameState == STATE.Options){
			g.setColor(Color.white);
			
			Font ftn = new Font("arial",1,50);
			Font ftn2 = new Font("arial",1,30);
			
			g.setFont(ftn);
			g.drawString("Options", 240, 100);  // title
			
			g.setFont(ftn2);
			g.drawRect(210, 350, 200, 64);
			g.drawString("Back", 275, 390);
		}else if (Gamee.gameState == STATE.End){
			g.setColor(Color.white);
			
			Font ftn = new Font("arial",1,50);
			Font ftn2 = new Font("arial",1,30);
			Font ftn3 = new Font ("arial",1,20);
			
			g.setFont(ftn);
			g.drawString("GAME OVER", 180, 100);  // title
			
			g.setFont(ftn3);
			g.drawString("you lost with a score of: " + hud.getScore(), 175, 200);
			g.setFont(ftn2);
			g.drawRect(210, 350, 200, 64);
			g.drawString("Try Again", 245, 390);
		}else if (Gamee.gameState == STATE.Select){
			g.setColor(Color.white);
			
			Font ftn = new Font("arial",1,50);
			Font ftn2 = new Font("arial",1,30);
			
			g.setFont(ftn);
			g.drawString("Select Difficulty", 125, 100);  // title
			
			g.setFont(ftn2);
			g.drawRect(210, 150, 200, 64);
			g.drawString("Normal", 275, 190);
			
			g.drawRect(210, 250, 200, 64);
			g.drawString("Hard", 275, 290);
			
			g.drawRect(210, 350, 200, 64);
			g.drawString("Back", 275, 390);
		}
	}

}
