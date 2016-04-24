package com.tutorial.main;

import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.imageio.ImageIO;

public class Player extends GameObject {
		
	Random r = new Random();
	private Handler handler ;
	private Image image ;
	private IO ýo;
	public static String character = "img/skull.png";
	private Animation anim;
	private BufferedImage img;
	private int offsetXanim = 70;
    private int offsetYanim = -23;

	
	public Player(int x, int y, ID id, Handler handler ,Image image ,IO ýo) { // we defined to prenferences of player
		super(x, y, id);
		this.handler = handler;
		this.image = image;
		this.ýo = ýo;
		
		loadContent();
	}
	
	public Rectangle getBounds(){
		return new Rectangle((int)x, (int)y, 32, 32);
	}
	
	public void tick() {
		x += velX;
		y += velY;
	
		x = Gamee.clamp(x, 0, Gamee.WIDTH - 39);
		y = Gamee.clamp(y, 0, Gamee.HEIGHT - 60);
	
		 anim.changesCoordinates( (int)x -160 + offsetXanim, (int)y-10 + offsetYanim);     
		
		collision();		
		
	}
	
	public void loadContent (){
		
		try{
			URL animImgUrl = this.getClass().getResource("img/playeranim.png");
	        img = ImageIO.read(animImgUrl);	
		}catch (IOException e) {
			Logger.getLogger(Player.class.getName()).log(Level.SEVERE, null, e);
		}
		
		anim = new Animation(img, 204, 34, 3, 20, true, (int)this.x + offsetXanim , (int)this.y + offsetYanim, 0);
	}

	public void collision (){		
		for (int i=0 ; i < handler.object.size(); i++){
			
			GameObject tempObject = handler.object.get(i);
			// tempobject is now enemy
			if (tempObject.getId() == ID.BasicEnemy  || tempObject.getId() == ID.FastEnemy ||tempObject.getId()== ID.SmartEnemy ){
				if (getBounds().intersects(tempObject.getBounds())){
					//collision code
					
					if(tempObject.getId() == ID.BasicEnemy){
					AudioPlayer.getSound("basýc").play();
					}
					
					if(tempObject.getId() == ID.FastEnemy)
						AudioPlayer.getSound("fast").play(1.00f,0.25f);
					
					if(tempObject.getId() == ID.SmartEnemy)
						AudioPlayer.getSound("smart").play(1.00f,0.5f);
					
					ýo.read("Save/armor.txt");
					float y = Integer.valueOf(ýo.temp)/10;
					
					if (Gamee.diff == 0)
						HUD.HEALTH -= 2 -y ;
					else if (Gamee.diff == 1)
						HUD.HEALTH -= 3 -y;
					
					
					
				}	
			}else if (tempObject.getId() == ID.EnemyBossBullet){
				if (getBounds().intersects(tempObject.getBounds())){
					AudioPlayer.getSound("basýc").play();
					HUD.HEALTH -= 1 ;
				}
			}else if (tempObject.getId() == ID.Heal){
				if (getBounds().intersects(tempObject.getBounds())){
					
					handler.removeObject(tempObject);
					HUD.HEALTH +=20;
					AudioPlayer.getSound("heal").play();
					
				}
			}
		}
	}

	public void render(Graphics2D g) {
		
		
		image.getImage(character);
		g.drawImage(image.img, (int)x, (int)y, null);
		anim.render(g);
	}

}
