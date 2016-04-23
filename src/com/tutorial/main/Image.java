package com.tutorial.main;

import java.util.logging.Level;
import java.util.logging.Logger;
import java.awt.image.BufferedImage;
import java.net.URL;

import javax.imageio.ImageIO;

public class Image {

	public BufferedImage img;
	
	public String soldier ="img/soldier.png";
	public String skull = "img/skull.png";
	public String payday = "img/payday.png";
	public String ýronman = "img/ýronman.png";
	public String creaper = "img/creaper.png";
	public String button = "img/button.png";
	public String bullet = "img/bullet.png";
	public String playerAnim ="img/playeranim.png";
	public String heal = "img/heal.png";
	
	
	public void getImage (String picture){
		
		try {
			URL image = this.getClass().getResource(picture);
			img = ImageIO.read(image);	
		} catch (Exception e) {
			Logger.getLogger(Image.class.getName()).log(Level.SEVERE, null, e);	
		}
		
	}

}
