package com.tutorial.main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;

public class EnemyBoss extends GameObject {
	
	private Handler handler ;
	Random r = new Random();
	
	private int timer = 50;
	
	public EnemyBoss(int x, int y, ID id, Handler handler) {
		super(x, y, id);
		this.handler = handler;
		
		velX = 0;
		velY = 2;
		
		}
	
	public Rectangle getBounds(){
		return new Rectangle((int)x, (int)y, 96, 96);
	}

	public void tick() {
	x += velX ;
	y += velY ;
	
	if(timer <= 0) { 
		velY = 0; 
		
		if(velX == 0) velX=2 ; 
		
		if (velX > 0)	velX += 0.005f;
		else if (velX < 0) velX -= 0.005f;
		
		velX = Gamee.clamp(velX, -10, 10);
		
		int spawn = r.nextInt(10);
		if (spawn == 0) handler.addObject(new EnemyBossBullet( (int)x+48 , (int)y+48, ID.EnemyBossBullet, handler, 5));
	}
	else timer--;
	
	if(x <= 0 || x >= Gamee.WIDTH - 96) velX *= -1 ;
	
	
	
	}


	public void render(Graphics g) {
		g.setColor(Color.RED);
		g.fillRect((int)x,(int) y, 96, 96);
		
	
		
	}

}
