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
	private Image image;

	
	public Menu ( Handler handler , HUD hud , Image image){
		this.hud= hud;
		this.handler = handler;
		this.image = image;
	}
	
	public void mousePressed(MouseEvent e){
		int mx = e.getX();
		int my = e.getY();
		 
		
	if (Gamee.gameState == STATE.Menu){
		
		
		//play button
		if (mouseOver(mx, my, 210, 150, 200, 64)){
			AudioPlayer.getSound("sound").play();	
			Gamee.gameState = STATE.Select;
			return; 			// return ne iþ yapar
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
			handler.addObject(new Player(Gamee.WIDTH/2-32,Gamee.HEIGHT/2-32, ID.Player , handler ,image));
			handler.addObject(new BasicEnemy(r.nextInt(Gamee.WIDTH - 60), r.nextInt(Gamee.HEIGHT - 50), ID.BasicEnemy, handler));
			
			Gamee.diff = 0;
		}
		
		//hard button
		if(mouseOver(mx, my, 210, 250, 200, 64)){
			AudioPlayer.getSound("sound").play();		
			Gamee.gameState = STATE.Game;			
			handler.addObject(new Player(Gamee.WIDTH/2-32,Gamee.HEIGHT/2-32, ID.Player , handler ,image));
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
		if(mouseOver(mx, my, 210, 350, 200, 64)){
			Gamee.gameState = STATE.Menu;
			AudioPlayer.getSound("sound").play();	
			return;
		}
		
		//	choose button creaper
		if (mouseOver(mx, my, 75 , 125 ,32 ,32 )){
			AudioPlayer.getSound("sound").play();
			Player.character = image.creaper;
			return;
		}
		
		//choose button soldier
		if (mouseOver(mx, my, 175 , 125 ,32 ,32 )){
			AudioPlayer.getSound("sound").play();
			Player.character = image.soldier;
			return;
		}
		
		//choose button ýronman
		if (mouseOver(mx, my, 270 ,125 ,32 ,32 )){
			AudioPlayer.getSound("sound").play();
			Player.character = image.ýronman;
			return;
		}
		
		//choose button payday
		if (mouseOver(mx, my, 385 , 125 ,32 ,32 )){
			AudioPlayer.getSound("sound").play();
			Player.character = image.payday;
			return;
		}
		
		//choose button skull
		if (mouseOver(mx, my, 500 , 125 ,32 ,32 )){
			AudioPlayer.getSound("sound").play();
			Player.character = image.skull;
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
			
			image.getImage("img/back.png");
			g.drawImage(image.img, 0, 0, null);
			
			g.setColor(Color.WHITE);
			
			Font ftn = new Font("arial",1,50);
			Font ftn2 = new Font("arial",1,30);
			
			g.setFont(ftn);
			//g.drawString("Menu", 240, 100);  // title
			
			g.setFont(ftn2);
			g.drawRect(210, 150, 200, 64);
			g.drawString("Play", 275, 190);
			
			g.drawRect(210, 250, 200, 64);
			g.drawString("Options", 253, 290);
			
			g.drawRect(210, 350, 200, 64);
			g.drawString("Quit", 275, 390);
		}else if (Gamee.gameState == STATE.Options){
			
			image.getImage("img/back.png");    //background picture
			g.drawImage(image.img, 0, 0, null);
			
			g.setColor(Color.WHITE);
			
			Font ftn = new Font("arial",1,50);
			Font ftn2 = new Font("arial",1,30);
			
			g.setFont(ftn);
			g.drawString("Choose your character", 40, 75);  // title
			
			g.setFont(ftn2);
			g.drawRect(210, 350, 200, 64);
			g.drawString("Back", 275, 390);
			
			image.getImage(image.creaper);
			g.drawImage(image.img , 75 , 125 ,null);
			
			image.getImage(image.soldier);
			g.drawImage(image.img , 175 , 125 ,null);
			
			image.getImage(image.ýronman);
			g.drawImage(image.img , 270 , 125 ,null);
			
			image.getImage(image.payday);
			g.drawImage(image.img , 385 , 125 ,null);
			
			image.getImage(image.skull);
			g.drawImage(image.img , 500 , 125 ,null);

			
		}else if (Gamee.gameState == STATE.End){
			
			image.getImage("img/back.png");
			g.drawImage(image.img, 0, 0, null);
			
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
			
			image.getImage("img/back.png");
			g.drawImage(image.img, 0, 0, null);
			
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
