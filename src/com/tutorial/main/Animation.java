package com.tutorial.main;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

public class Animation {

	private BufferedImage img;
	private int frameWidth;
	private int frameHeight;
	private int numberOfFrames;
	
	private long frameTime;
	private long startingFrameTime;
	private long timeForNextFrame;
	
	private boolean loop;
	public boolean active;
	
	public int x;
	public int y;
	
	private int currentFrameNumber;
	private int startingXofFrameInImage;
	private int endingXofFrameInImage;
	
	private long showDelay;
	private long timeofAnimationCreation;
	
	
	public Animation (BufferedImage img, int frameWidth, int frameHeight ,int numberOfFrames ,long frameTime ,boolean loop ,int x ,int y , long showDelay){     
		
		this.img = img;
		this.frameHeight = frameHeight;
		this.frameWidth = frameWidth;
		this.numberOfFrames = numberOfFrames;
		this.frameTime = frameTime;
		this.loop = loop;
		
		this.x = x;
		this.y = y;
		
		this.showDelay = showDelay;
		
		
		timeofAnimationCreation = System.currentTimeMillis();
		
		startingXofFrameInImage = 0;
		endingXofFrameInImage = frameWidth;
		
		startingFrameTime = System.currentTimeMillis() + showDelay;
		timeForNextFrame = startingFrameTime + this.frameTime;
		currentFrameNumber = 0;
		active = true;
	}
	
	public void changesCoordinates(int x ,int y){
		this.x = x;
		this.y = y;
	}
	
	private void tick ()
	{
		
		if (timeForNextFrame <= System.currentTimeMillis())
		{
			currentFrameNumber++;
			
			if (currentFrameNumber >= numberOfFrames)
			{
				currentFrameNumber = 0;
				
				if(!loop)
					active = false;
			}
			
			
			startingXofFrameInImage = currentFrameNumber * frameWidth;
			endingXofFrameInImage = startingXofFrameInImage + frameWidth;
			
			
			startingFrameTime = System.currentTimeMillis();
			timeForNextFrame = startingFrameTime + frameTime;
		}
	}
	
	
	public void  render(Graphics2D g ){
		
		this.tick();
		
		if (this.timeofAnimationCreation + this.showDelay <= System.currentTimeMillis())
			g.drawImage(this.img, x, y, x + frameWidth, y + frameHeight, startingXofFrameInImage, 0, endingXofFrameInImage, frameHeight, null);
		
	}
}
