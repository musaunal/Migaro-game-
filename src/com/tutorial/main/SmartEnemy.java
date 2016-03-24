package com.tutorial.main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class SmartEnemy extends GameObject {
	
	//private Trail trail;
	private GameObject player;
	private Handler handler ;
	
	public SmartEnemy(float x, float y, ID id, Handler handler) {
		super(x, y, id);
		this.handler = handler;
		//this.trail = trail;
		
		for (int i=0; i<handler.object.size(); i++ ){
			if( handler.object.get(i).getId() == ID.Player ) player = handler.object.get(i);	
		}	
	}
	
	public Rectangle getBounds(){
		return new Rectangle((int)x, (int)y, 16, 16);
	}

	public void tick() {
	x += velX ;
	y += velY ;
	
	float diffX = x - player.getX() - 8;
	float diffY = y - player.getY() - 8;
	// distance is a simple hipotenüs
	float distance = (float) Math.sqrt((x-player.getX())*(x-player.getX()) + (y-player.getY())*(y-player.getY()));
	
	velX = ((-1/distance) * diffX );
	velY = ((-1/distance) * diffY );
	
	//if(y <= 0 || y >= Game.HEIGHT - 48) velY *= -1 ;
	//if(x <= 0 || x >= Game.WIDTH - 16) velX *= -1 ;
	
	
	handler.addObject(new Trail(x, y, ID.Trail, Color.GREEN, 16, 16, 0.05f , handler));
	
	}


	public void render(Graphics g) {
		g.setColor(Color.GREEN);
		g.fillRect((int)x,(int) y, 16, 16);
		
	
		
	}

}
