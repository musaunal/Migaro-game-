package com.tutorial.main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;

public class BasicEnemy extends GameObject {
	
	private Handler handler ;
	
	public BasicEnemy(int x, int y, ID id, Handler handler) {
		super(x, y, id);
		this.handler = handler;
		
		velX = 5;
		velY = 5;
		
		}
	
	public Rectangle getBounds(){
		return new Rectangle((int)x, (int)y, 16, 16);
	}

	public void tick() {
	x += velX ;
	y += velY ;
	
	if(y <= 0 || y >= Gamee.HEIGHT - 48) velY *= -1 ;
	if(x <= 0 || x >= Gamee.WIDTH - 16) velX *= -1 ;
	
	
	handler.addObject(new Trail(x, y, ID.Trail, Color.RED, 16, 16, 0.05f , handler));
	
	}


	public void render(Graphics2D g) {
		g.setColor(Color.RED);
		g.fillRect((int)x,(int) y, 16, 16);
		
	
		
	}

}
