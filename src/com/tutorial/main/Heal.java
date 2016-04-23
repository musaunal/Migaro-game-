package com.tutorial.main;

import java.awt.Graphics2D;
import java.awt.Rectangle;

public class Heal extends GameObject {
	
	private Image img;
	
	public Heal(int x, int y, ID id , Image img) {
		super(x, y, id);
		
		this.img = img;
		
		velX = 0;
		velY = 0;
		
		}
	
	public Rectangle getBounds(){
		return new Rectangle((int)x, (int)y, 32, 32);
	}

	public void tick() {
	
	}


	public void render(Graphics2D g) {
		
		img.getImage(img.heal);
		g.drawImage(img.img, (int)x, (int)y, null);
		
	}

}
