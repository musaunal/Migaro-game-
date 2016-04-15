package com.tutorial.main;

import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.util.Random;

public class EnemyBossBullet extends GameObject {
	
	private Handler handler ;
	Random r = new Random();
	Image image = new Image();
	
	public EnemyBossBullet(int x, int y, ID id, Handler handler ,int speed ,Image image) {
		super(x, y, id);
		this.handler = handler;
		this.image = image;
		
		velX = (r.nextInt(5 - -5) + -5);
		velY = speed;
		
		}
	
	public Rectangle getBounds(){
		return new Rectangle((int)x, (int)y, 16, 16);
	}

	public void tick() {
	x += velX ;
	y += velY ;
	
	
	if (y >= Gamee.HEIGHT) handler.removeObject(this);
	
	//handler.addObject(new Trail(x, y, ID.Trail, Color.ORANGE, 16, 16, 0.05f , handler));
	
	}


	public void render(Graphics2D g) {
		//g.setColor(Color.ORANGE);
		image.getImage(image.bullet);
		g.drawImage(image.img, (int)x, (int)y, null);
		//g.fillRect((int)x,(int) y, 16, 16);
		
	
		
	}

}
