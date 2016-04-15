package com.tutorial.main;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;

public class Trail extends GameObject{
	
	
	private float alpha = 1;
	private double life;
	private Handler handler;
	private Color color;
	private int width , height;
	
	// life between 0.001 - 0.1 ;
	
	public Trail(float x, float y, ID id, Color color,int width, int height, double life, Handler handler) {
		super(x, y, id);
		this.color = color;
		this.handler = handler;
		this.height = height;
		this.width = width;
		this.life = life;
	}
	public void tick() {
		if (alpha > life){
			alpha -= life - 0.001f;
		}else handler.removeObject(this);

	}
	public void render(Graphics2D g) {
		Graphics2D g2d = (Graphics2D) g;
		g2d.setComposite(makeTranspatant(alpha));
		
		g.setColor(color);
		g.fillRect((int)x, (int)y, width, height);
		
		g2d.setComposite(makeTranspatant(1));
	}
	
	private AlphaComposite makeTranspatant(float alpha){
		int type = AlphaComposite.SRC_OVER;
		return(AlphaComposite.getInstance(type , alpha));
	}

	
	public Rectangle getBounds() {
		
		return null;
	}

	
	
}
