package com.tutorial.main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.util.Random;

public class Player extends GameObject {
	
	
	Random r = new Random();
	Handler handler ;
	Trail trail ;
	
	public Player(int x, int y, ID id, Handler handler) { // we defined to prenferences of player
		super(x, y, id);
		this.handler = handler;
		this.trail = trail;
	}
	
	public Rectangle getBounds(){
		return new Rectangle(x, y, 32, 32);
	}
	
	public void tick() {
		x += velX;
		y += velY;
	
		x = Game.clamp(x, 0, Game.WIDTH - 39);
		y = Game.clamp(y, 0, Game.HEIGHT - 60);
	
		handler.addObject(new Trail(x, y, ID.Trail, Color.WHITE, 32, 32, 0.05f , handler));
		
		collision();
	}
	
	public void collision (){
		
		
		
		for (int i=0 ; i < handler.object.size(); i++){
			
			GameObject tempObject = handler.object.get(i);
			if (tempObject.getId() == ID.BasicEnemy  || tempObject.getId() == ID.FastEnemy ){ // tempobject is now basic enemy
				if (getBounds().intersects(tempObject.getBounds())){
					//collision code
					
					HUD.HEALTH -= 2 ;
					
					
					
				}	
			}
			
			
		}
	}

	public void render(Graphics g) {
		
		g.setColor(Color.WHITE);
		g.fillRect(x, y, 32, 32);
	}

}
