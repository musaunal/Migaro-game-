package com.tutorial.main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;

public class EnemyBossBullet extends GameObject {
	
	private Trail trail;
	private Player player;
	private Handler handler ;
	Random r = new Random();
	
	public EnemyBossBullet(int x, int y, ID id, Handler handler ,int speed) {
		super(x, y, id);
		this.handler = handler;
		this.trail = trail;
		
		velX = (r.nextInt(5 - -5) + -5);
		velY = speed;
		
		}
	
	public Rectangle getBounds(){
		return new Rectangle((int)x, (int)y, 16, 16);
	}

	public void tick() {
	x += velX ;
	y += velY ;
	
	
	if (y >= Game.HEIGHT) handler.removeObject(this);
	
	handler.addObject(new Trail(x, y, ID.Trail, Color.ORANGE, 16, 16, 0.05f , handler));
	
	}


	public void render(Graphics g) {
		g.setColor(Color.ORANGE);
		g.fillRect((int)x,(int) y, 16, 16);
		
	
		
	}

}
