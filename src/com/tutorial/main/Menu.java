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
	private IO ýo = new IO();
	public static int temp;

	
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
			if (mouseOver(mx, my, 558, 200, 250, 80)){
				AudioPlayer.getSound("sound").play();	
				Gamee.gameState = STATE.Select;
				return; 			// return ne iþ yapar
			}
			
			//options button
			if(mouseOver(mx, my, 558, 344, 250, 80)){
				AudioPlayer.getSound("sound").play();	
				Gamee.gameState = STATE.Options;
			}
			
			//quit button
			if (mouseOver(mx, my, 558, 488, 250, 80) ){
				AudioPlayer.getSound("sound").play();	
				System.exit(1);
			}
		}
		
		if (Gamee.gameState == STATE.Select){
			//normal button
			if (mouseOver(mx, my, 558, 200, 250, 80)){
				AudioPlayer.getSound("sound").play();	
				Gamee.gameState = STATE.Game;			
				handler.addObject(new Player(Gamee.WIDTH/2-32,Gamee.HEIGHT/2-32, ID.Player , handler ,image ,ýo));
				handler.addObject(new BasicEnemy(r.nextInt(Gamee.WIDTH - 60), r.nextInt(Gamee.HEIGHT - 50), ID.BasicEnemy, handler));
				
				Gamee.diff = 0;
			}
			
			//hard button
			if(mouseOver(mx, my, 558, 344, 250, 80)){
				AudioPlayer.getSound("sound").play();		
				Gamee.gameState = STATE.Game;			
				handler.addObject(new Player(Gamee.WIDTH/2-32,Gamee.HEIGHT/2-32, ID.Player , handler ,image , ýo));
				handler.addObject(new HardEnemy(r.nextInt(Gamee.WIDTH - 60), r.nextInt(Gamee.HEIGHT - 50), ID.BasicEnemy, handler));
				
				Gamee.diff = 1;
			}
			
			//back button
			if (mouseOver(mx, my, 558, 488, 250, 80) ){
				Gamee.gameState = STATE.Menu;
				AudioPlayer.getSound("sound").play();	
				return;
			}
		}
		if (Gamee.gameState == STATE.Options){
			
			//back button for options
			if(mouseOver(mx, my, 1040, 635, 250, 80)){
				Gamee.gameState = STATE.Menu;
				AudioPlayer.getSound("sound").play();	
				return;
			}
			//skill button 
			if (mouseOver(mx, my, 70, 635, 250, 80)){
				Gamee.gameState = STATE.Character;
				AudioPlayer.getSound("sound").play();
				return;
			}
			
			//	choose button creaper
			if (mouseOver(mx, my, 470 , 150 ,64 ,64 )){
				AudioPlayer.getSound("sound").play();
				Player.character = image.creaper;
				return;
			}
			
			//choose button soldier
			if (mouseOver(mx, my, 570 , 150 , 64 , 64 )){
				AudioPlayer.getSound("sound").play();
				Player.character = image.soldier;
				return;
			}
			
			//choose button ýronman
			if (mouseOver(mx, my, 670 , 150  , 64 , 64 )){
				AudioPlayer.getSound("sound").play();
				Player.character = image.ýronman;
				return;
			}
			
			//choose button payday
			if (mouseOver(mx, my, 770 , 150 , 64 , 64 )){
				AudioPlayer.getSound("sound").play();
				Player.character = image.payday;
				return;
			}
			
			//choose button skull
			if (mouseOver(mx, my, 870 , 150 , 64 , 64 )){
				AudioPlayer.getSound("sound").play();
				Player.character = image.skull;
				return;
			}
				
				
		}
		if(Gamee.gameState == STATE.End){
			if(mouseOver(mx, my, 578, 548, 250, 80)){
				Gamee.gameState = STATE.Menu;
				hud.setLevel(1);
				hud.setScore(0);
				AudioPlayer.getSound("sound").play();
				}
			ýo.read("Save/highScore.txt" );
			int x = Integer.valueOf(ýo.temp);
			if (hud.getScore() >= x){
				ýo.write("Save/highScore.txt");
			}
			return;
			}
		
		if (Gamee.gameState == STATE.Character) {
			if (mouseOver(mx, my, 1040, 635, 250, 80)){
				Gamee.gameState = STATE.Options;
				AudioPlayer.getSound("sound").play();
			}
			
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
			Font ftn2 = new Font("arial",1,40);
			
			g.setFont(ftn);
			//g.drawString("Menu", 240, 100);  // title
			
			g.setFont(ftn2);
			g.drawRect(558, 200, 250, 80);
			g.drawString("Play", 645, 251);
			
			g.drawRect(558, 344, 250, 80);
			g.drawString("Options", 615, 395);
			
			g.drawRect(558, 488, 250, 80);
			g.drawString("Quit", 645, 539);
		} 
		if (Gamee.gameState == STATE.Options){
			
			image.getImage("img/back.png");    //background picture
			g.drawImage(image.img, 0, 0, null);
			
			g.setColor(Color.WHITE);
			
			Font ftn = new Font("arial",1,60);
			Font ftn2 = new Font("arial",1,40);
			Font ftn3 = new Font("arial",1,25);
			
			g.setFont(ftn);
			g.drawString("Choose your character", 370, 100);  // title
			
			g.setFont(ftn3);
			g.drawString("Fordward = W", 70, 300);
			g.drawString("Back = S", 70, 350);
			g.drawString("Right = D", 70, 400);
			g.drawString("Left = A", 70, 450);
			g.drawString("Speed = SPACE", 300, 300);
			g.drawString("Pasue = P", 300, 350);
			g.drawString("Quit = ESC", 300, 400);
			
			g.drawString("Screen Size = 1366 / 768", 850, 300);
			g.drawString("Sounds = ON", 850, 350);
			g.drawString("Volume  = 100", 850, 400);
			
			g.setFont(ftn2);
			g.drawRect(1040, 635, 250, 80);
			g.drawString("Back", 1115, 690);
			
			g.drawRect(70, 635, 250, 80);
			g.drawString("Skills", 140, 690);
			
			image.getImage(image.creaper);
			g.drawImage(image.img , 470 , 150 ,null);
			
			image.getImage(image.soldier);
			g.drawImage(image.img , 570 , 150 ,null);
			
			image.getImage(image.ýronman);
			g.drawImage(image.img , 670 , 150 ,null);
			
			image.getImage(image.payday);
			g.drawImage(image.img , 770 , 150 ,null);
			
			image.getImage(image.skull);
			g.drawImage(image.img , 870 , 150 ,null);

			
		}
		if (Gamee.gameState == STATE.End){
			
			image.getImage("img/back.png");
			g.drawImage(image.img, 0, 0, null);
			
			g.setColor(Color.white);
			
			Font ftn = new Font("arial",1,70);
			Font ftn2 = new Font("arial",1,40);
			Font ftn3 = new Font ("arial",1,35);
			
			g.setFont(ftn);
			g.drawString("GAME OVER", 500, 100);  // title
			
			g.setFont(ftn3);
			temp = hud.getScore();
			g.drawString("you lost with a score of: " + hud.getScore(), 100, 250);
			ýo.read("Save/highScore.txt");
			g.drawString("your last highest Score is : " + ýo.temp , 100, 340);
			g.setFont(ftn2);
			g.drawRect(578, 548, 250, 80);
			g.drawString("Try Again", 620, 600);
		}
		if (Gamee.gameState == STATE.Character){
			
			image.getImage("img/back.png");
			g.drawImage(image.img, 0, 0, null);
			
			g.setColor(Color.white);
			
			Font ftn = new Font("arial",1,60);
			Font ftn2 = new Font("arial",1,40);
			Font ftn3 = new Font("arial",1,20);
			
			g.setFont(ftn);
			g.drawString("Character", 550, 100);
			
			g.setFont(ftn3);
			g.drawString("Character Name =", 70, 200);
			ýo.read("Save/characterName.txt");
			g.drawString(ýo.temp, 250, 200);
			
			g.drawString("Speed =", 70, 400);
			ýo.read("Save/speed.txt");
			g.drawString(ýo.temp, 170, 400 );
			
			g.drawString("health =", 70, 250);
			ýo.read("Save/health.txt");
			g.drawString(ýo.temp, 170, 250 );
			
			g.drawString("Power =", 70, 350);
			ýo.read("Save/power.txt");
			g.drawString(ýo.temp, 170, 350 );
			
			g.drawString("Mana =", 70, 300);
			ýo.read("Save/mana.txt");
			g.drawString(ýo.temp, 170, 300 );
			
			g.setFont(ftn2);
			g.drawRect(1040, 635, 250, 80);
			g.drawString("Back", 1115, 690);
		}
		if (Gamee.gameState == STATE.Select){
			
			image.getImage("img/back.png");
			g.drawImage(image.img, 0, 0, null);
			
			g.setColor(Color.white);
			
			Font ftn = new Font("arial",1,50);
			Font ftn2 = new Font("arial",1,40);
			
			g.setFont(ftn);
			g.drawString("Select Difficulty", 125, 100);  // title
			
			g.setFont(ftn2);
			g.drawRect(558, 200, 250, 80);
			g.drawString("Normal", 620, 250);
			
			g.drawRect(558, 344, 250, 80);
			g.drawString("Hard", 640, 394);
			
			g.drawRect(558, 488, 250, 80);
			g.drawString("Back", 640, 540);
		}
	}	

}
