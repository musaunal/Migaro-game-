package com.tutorial.main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;

public class Player extends GameObject {
	
	
	Random r = new Random();
	Handler handler ;
	Trail trail ;
	
	public Player(int x, int y, ID id, Handler handler) { // we defined to prenferences of player
		super(x, y, id);
		this.handler = handler;
	}
	
	public Rectangle getBounds(){
		return new Rectangle((int)x, (int)y, 32, 32);
	}
	
	public void tick() {
		x += velX;
		y += velY;
	
		x = Gamee.clamp(x, 0, Gamee.WIDTH - 39);
		y = Gamee.clamp(y, 0, Gamee.HEIGHT - 60);
	
		handler.addObject(new Trail(x, y, ID.Trail, Color.WHITE, 32, 32, 0.05f , handler));
		
		collision();
	}
	
	public void collision (){
		
		
		
		for (int i=0 ; i < handler.object.size(); i++){
			
			GameObject tempObject = handler.object.get(i);
			// tempobject is now enemy
			if (tempObject.getId() == ID.BasicEnemy  || tempObject.getId() == ID.FastEnemy ||tempObject.getId()== ID.SmartEnemy ){
				if (getBounds().intersects(tempObject.getBounds())){
					//collision code
					
					if (Gamee.diff == 0)
						HUD.HEALTH -= 2 ;
					else if (Gamee.diff == 1)
						HUD.HEALTH -= 3;
					
					
					
				}	
			}else if (tempObject.getId() == ID.EnemyBossBullet){
				if (getBounds().intersects(tempObject.getBounds())){
					HUD.HEALTH -= 1 ;
				}
			}
			
			
		}
	}

	public void render(Graphics g) {
		
		g.setColor(Color.WHITE);
		g.fillRect((int)x, (int)y, 32, 32);
	}

}
