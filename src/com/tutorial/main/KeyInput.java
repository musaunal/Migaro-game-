package com.tutorial.main;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import com.tutorial.main.Game.STATE;

public class KeyInput extends KeyAdapter{

	private Handler handler;
	private boolean[] keyDown = new boolean[4];
	private Game game;
	
	public KeyInput(Handler handler, Game game){
		this.handler = handler;
		
		this.game = game;
		
		for (int i=0; i<4; i++){
			keyDown[i]=false;
		}
	}
	
	public void keyPressed(KeyEvent e){
		int key = e.getKeyCode();
		
		for (int i=0; i< handler.object.size(); i++){
			GameObject tempObject = handler.object.get(i);
			
			if(tempObject.getId() == ID.Player){
				//key events for player 1 
				
				if(key == KeyEvent.VK_W){ tempObject.setVelY(-5); keyDown[0]=true; }
				if(key == KeyEvent.VK_A){ tempObject.setVelX(-5); keyDown[1]=true; }
				if(key == KeyEvent.VK_S){ tempObject.setVelY(5); keyDown[2]=true; }
				if(key == KeyEvent.VK_D){ tempObject.setVelX(5); keyDown[3]=true; }
			}
		}
	}
	
	public void keyReleased(KeyEvent e){
		int key = e.getKeyCode();
		
		for (int i=0; i< handler.object.size(); i++){
			GameObject tempObject = handler.object.get(i);
			
			if(tempObject.getId() == ID.Player){
				//key events for Player 1 
				
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
			if (game.gameState == STATE.Game){
				if(Game.paused == false)
					Game.paused = true ;
				else Game.paused=false;
			}
		}
		
		if(key == KeyEvent.VK_ESCAPE){
			System.exit(1);
		}

	}
	
}
