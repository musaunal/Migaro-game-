package com.tutorial.main;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import com.tutorial.main.Gamee.STATE;

public class KeyInput extends KeyAdapter{

	private Handler handler;
	private boolean[] keyDown = new boolean[4];
	private boolean mana=false ;
	private IO �o;
	public int speed;
	
	public KeyInput(Handler handler , IO �o){
		this.handler = handler;
		this.�o = �o;
		
		resetSpeed();
		
		for (int i=0; i<4; i++){
			keyDown[i]=false;
		}
	}
	
	public void resetSpeed(){
		�o.read("Save/speed.txt");
		speed = Integer.valueOf(�o.temp);
	}
	
	public void keyPressed(KeyEvent e){
		int key = e.getKeyCode();
		
		for (int i=0; i< handler.object.size(); i++){
			GameObject tempObject = handler.object.get(i);
			
			if(tempObject.getId() == ID.Player){
				//key events for player 1 
				
				if(key == KeyEvent.VK_SPACE && HUD.mana != 0 )mana = true;
				if(key == KeyEvent.VK_W){
					keyDown[0]=true; 
					if (mana && HUD.mana!=0) {tempObject.setVelY(-2*speed); HUD.mana-=2; }
					else  tempObject.setVelY(-1*speed);
				}
				if(key == KeyEvent.VK_A){
					keyDown[1]=true;
					if(mana && HUD.mana!=0) { tempObject.setVelX(-2*speed); HUD.mana-=2; }
					else tempObject.setVelX(-1*speed);
				}
				if(key == KeyEvent.VK_S){
					keyDown[2]=true; 
					if(mana && HUD.mana!=0){ tempObject.setVelY(2*speed); HUD.mana-=2; }
					else  tempObject.setVelY(speed);
				}
				if(key == KeyEvent.VK_D){ 
					keyDown[3]=true;
					if(mana && HUD.mana!=0){ tempObject.setVelX(2*speed); HUD.mana-=2; }
					else tempObject.setVelX(speed);
				}
			}
		}
	}
	
	public void keyReleased(KeyEvent e){
		int key = e.getKeyCode();
		
		for (int i=0; i< handler.object.size(); i++){
			GameObject tempObject = handler.object.get(i);
			
			if(tempObject.getId() == ID.Player){
				//key events for Player 1 
				
				if(key == KeyEvent.VK_SPACE){resetSpeed(); mana=false;}
				if(key == KeyEvent.VK_W)keyDown[0]= false ;
				if(key == KeyEvent.VK_A)keyDown[1]= false ;
				if(key == KeyEvent.VK_S)keyDown[2]= false ;
				if(key == KeyEvent.VK_D)keyDown[3]= false ;
				
				//vertical movement 
				if( !keyDown[0] && !keyDown[2]) tempObject.setVelY(0);
				//horizonal movement
				if( !keyDown[1] && !keyDown[3]) tempObject.setVelX(0);	
			}
		}
		
		if(key == KeyEvent.VK_P) {
			if (Gamee.gameState == STATE.Game){
				if(Gamee.paused == false)
					Gamee.paused = true ;
				else Gamee.paused=false;
			}
		}
		
		if(key == KeyEvent.VK_ESCAPE){
			System.exit(1);
		}

	}
	
}
