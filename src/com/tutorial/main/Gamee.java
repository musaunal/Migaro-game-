package com.tutorial.main;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferStrategy;
import java.util.Random;

public class Gamee extends Canvas implements Runnable{
	private static final long serialVersionUID = 1550691097823471818L;
	public static final int WIDTH = 640 , HEIGHT = WIDTH/12*9 ;
	
	private Thread thread;
	private boolean running = false;
	
	public static boolean paused = false;
	public static int diff = 0;
	
	// 0 = normal
	// 1 = hard
	
	private Handler handler;
	private Random r ;
	private HUD hud ;
	private Spawn spawner;
	private Menu menu;
	private Image image;
	//private IO io;
	
	public enum STATE {
		Menu,
		Options,
		Select,
		Game,
		End
	};
	
	
	public static STATE gameState = STATE.Menu;       // why this STATE was can used as a class
	
	public Gamee(){
		handler = new Handler();
		r = new Random();
		hud = new HUD() ;
		image = new Image();
		menu = new Menu(handler, hud ,image);
		//io = new IO();
	
		AudioPlayer.load();
		AudioPlayer.getMusic("music").loop();
		
		new Window(WIDTH ,HEIGHT ,"let's build a game :D" ,this);
		
		spawner = new Spawn(handler ,hud , image);
		
		this.addKeyListener(new KeyInput(handler));
		this.addMouseListener(menu);
		
		if(gameState == STATE.Game){
			handler.addObject(new Player(r.nextInt(WIDTH), r.nextInt(HEIGHT), ID.Player , handler , image));
			handler.addObject(new BasicEnemy(r.nextInt(WIDTH - 60), r.nextInt(HEIGHT - 50), ID.BasicEnemy, handler));
		}
	}
	public synchronized void start(){
	thread = new Thread(this);
	thread.start();
	running = true;
	}
	
	public synchronized void stop(){
		try{
			thread.join();
			running = false;
		}catch(Exception e){
			 e.printStackTrace();
		}
	}
	
	public void run(){    /// this code calculate FPS of game
		
		this.requestFocus();
		long lastTime = System.nanoTime();
		double amountOfTicks = 60.0;
		double ns = 1000000000 / amountOfTicks;
		double delta = 0;
		long timer = System.currentTimeMillis();
		while (running){
			long now = System.nanoTime();
			delta += (now - lastTime) / ns ;
			lastTime = now;
			while (delta >= 1){
				tick();
				delta--;
			}
			if (running)
				render();
			if (System.currentTimeMillis() - timer > 1000){
				timer += 1000;
			}
		}
		stop();
	}
	
	private void tick(){
		/*try {								//arrange your cpu usage
		    Thread.sleep(5);                 //1000 milliseconds is one second. 
		} catch(InterruptedException ex) {
		    Thread.currentThread().interrupt();
		}*/
		
		if (gameState == STATE.Game){
		
			if (!paused){
				
				hud.tick();
				spawner.tick();
				handler.tick();
				
				if (HUD.HEALTH <= 0){
					HUD.HEALTH=100;
					AudioPlayer.getSound("end").play();
					gameState = STATE.End;
					handler.clearEnemys();
				}
			}
			
		}else if (gameState == STATE.Menu || gameState == STATE.End || gameState == STATE.Select){
			
			try {								//arrange your cpu usage
			    Thread.sleep(10);                 //1000 milliseconds is one second. 
			} catch(InterruptedException ex) {
			    Thread.currentThread().interrupt();
			}
			
			menu.tick();
			handler.tick();
		}
		
	}
	private void render(){  // rearrange our background preferences
		BufferStrategy bs = this.getBufferStrategy();
		if (bs == null){
			this.createBufferStrategy(3);
			return;
		}
		Graphics2D g = (Graphics2D) bs.getDrawGraphics();
		
		g.setColor(Color.black);
		g.fillRect(0, 0, WIDTH, HEIGHT);
		
		handler.render(g);
		
		if (paused){
			g.drawString("PAUSED", WIDTH/2, HEIGHT/2);
		}
		
		if (gameState == STATE.Game){
			hud.render(g);
		}else if (gameState == STATE.Menu || gameState == STATE.Options || gameState == STATE.End || gameState == STATE.Select){
			menu.render(g);
		}
		
		g.dispose();
		bs.show();
		System.gc();
	}
	
	public static float clamp(float var ,float min ,float  max){
		if (var >= max)
			return var = max ;
		else if (var <= min )
			return var = min ;
		else  
			return var ;
	}
	
	public static void main (String []args){
		new Gamee();	
	}
	
}
