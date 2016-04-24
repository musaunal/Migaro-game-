package com.tutorial.main;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import com.tutorial.main.Gamee.STATE;

public class KeyInput extends KeyAdapter{

	private Handler handler;
	private boolean[] keyDown = new boolean[4];
	private IO ýo;
	public int speed;
	
	public KeyInput(Handler handler , IO ýo){
		this.handler = handler;
		this.ýo = ýo;
		
		resetSpeed();
		
		for (int i=0; i<4; i++){
			keyDown[i]=false;
		}
	}
	
	public void resetSpeed(){
		ýo.read("Save/speed.txt");
		speed = Integer.valueOf(ýo.temp);
	}
	
	public void keyPressed(KeyEvent e){
		int key = e.getKeyCode();
		
		for (int i=0; i< handler.object.size(); i++){
			GameObject tempObject = handler.object.get(i);
			
			if(tempObject.getId() == ID.Player){
				//key events for player 1 
				
				if(key == KeyEvent.VK_SPACE && HUD.mana != 0 ){speed =10; HUD.mana--; };
				if(key == KeyEvent.VK_W){ tempObject.setVelY(-1*speed); keyDown[0]=true; }
				if(key == KeyEvent.VK_A){ tempObject.setVelX(-1*speed); keyDown[1]=true; }
				if(key == KeyEvent.VK_S){ tempObject.setVelY(speed); keyDown[2]=true; }
				if(key == KeyEvent.VK_D){ tempObject.setVelX(speed); keyDown[3]=true; }
			}
		}
	}
	
	public void keyReleased(KeyEvent e){
		int key = e.getKeyCode();
		
		for (int i=0; i< handler.object.size(); i++){
			GameObject tempObject = handler.object.get(i);
			
			if(tempObject.getId() == ID.Player){
				//key events for Player 1 
				
				if(key == KeyEvent.VK_SPACE){resetSpeed();}
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
