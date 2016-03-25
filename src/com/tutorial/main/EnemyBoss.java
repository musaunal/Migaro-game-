package com.tutorial.main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;

public class EnemyBoss extends GameObject {
	
	private Trail trail;
	private Player player;
	private Handler handler ;
	Random r = new Random();
	
	private int timer = 90;
	
	public EnemyBoss(int x, int y, ID id, Handler handler) {
		super(x, y, id);
		this.handler = handler;
		this.trail = trail;
		
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
		
		velX = Game.clamp(velX, -10, 10);
		
		int spawn = r.nextInt(10);
		if (spawn == 0) handler.addObject(new EnemyBossBullet( (int)x+48 , (int)y+48, ID.BasicEnemy, handler));
	}
	else timer--;
	
	//if(y <= 0 || y >= Game.HEIGHT - 48) velY *= -1 ;  		// window collision
	if(x <= 0 || x >= Game.WIDTH - 96) velX *= -1 ;
	
	
	//handler.addObject(new Trail(x, y, ID.Trail, Color.RED, 96, 96, 0.05f , handler));
	
	}


	public void render(Graphics g) {
		g.setColor(Color.RED);
		g.fillRect((int)x,(int) y, 96, 96);
		
	
		
	}

}
