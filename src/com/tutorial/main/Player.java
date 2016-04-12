package com.tutorial.main;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;

public class Player extends GameObject {
		
	Random r = new Random();
	private Handler handler ;
	private Image image ;
	public static String character = "img/skull.png";
	
	public Player(int x, int y, ID id, Handler handler ,Image image) { // we defined to prenferences of player
		super(x, y, id);
		this.handler = handler;
		this.image = image;
		
	}
	
	public Rectangle getBounds(){
		return new Rectangle((int)x, (int)y, 64, 64);
	}
	
	public void tick() {
		x += velX;
		y += velY;
	
		x = Gamee.clamp(x, 0, Gamee.WIDTH - 71);
		y = Gamee.clamp(y, 0, Gamee.HEIGHT - 92);
	
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
		
		
		image.getImage(character);
		//g.setColor(Color.WHITE);
		g.drawImage(image.img, (int)x, (int)y, null);
		//g.fillRect((int)x, (int)y, 32, 32);
	}

}
