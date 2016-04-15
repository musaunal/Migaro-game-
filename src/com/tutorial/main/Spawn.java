package com.tutorial.main;

import java.util.Random;

public class Spawn {

	private Handler handler;
	private HUD hud;
	private Random r = new Random();
	private Image image;
	
	private int scoreKeep ;
	
	public Spawn (Handler handler,HUD hud ,Image image){
		this.handler = handler;
		this.hud = hud;
		this.image = image;
	}
	
	public void tick(){
		scoreKeep++;
		
		if (scoreKeep >= 50){
			scoreKeep = 0;
			hud.setLevel(hud.getLevel() + 1);
			
			if (Gamee.diff == 0){
				if (hud.getLevel() == 2){
					handler.addObject(new BasicEnemy(r.nextInt(Gamee.WIDTH - 60), r.nextInt(Gamee.HEIGHT - 50), ID.BasicEnemy, handler));
				}else if (hud.getLevel() == 3){
					handler.addObject(new BasicEnemy(r.nextInt(Gamee.WIDTH - 60), r.nextInt(Gamee.HEIGHT - 50), ID.BasicEnemy, handler));
				}else if (hud.getLevel() == 4){
					handler.addObject(new FastEnemy(r.nextInt(Gamee.WIDTH - 60), r.nextInt(Gamee.HEIGHT - 50), ID.FastEnemy, handler));
				}else if (hud.getLevel() == 5){
					handler.addObject(new SmartEnemy(r.nextInt(Gamee.WIDTH - 60), r.nextInt(Gamee.HEIGHT - 50), ID.SmartEnemy, handler ));
				}else if (hud.getLevel() == 6){
					handler.addObject(new FastEnemy(r.nextInt(Gamee.WIDTH - 60), r.nextInt(Gamee.HEIGHT - 50), ID.FastEnemy, handler));
				}else if (hud.getLevel() == 7){
					handler.addObject(new SmartEnemy(r.nextInt(Gamee.WIDTH - 60), r.nextInt(Gamee.HEIGHT - 50), ID.SmartEnemy, handler ));
				}else if (hud.getLevel() == 10){
					handler.clearEnemys();
					AudioPlayer.getSound("boss").play();
					handler.addObject(new EnemyBoss((Gamee.WIDTH/2)-48 , -120 , ID.EnemyBoss, handler ,image));
				}
			}else if (Gamee.diff == 1){
				if (hud.getLevel() == 2){
					handler.addObject(new HardEnemy(r.nextInt(Gamee.WIDTH - 60), r.nextInt(Gamee.HEIGHT - 50), ID.BasicEnemy, handler));
				}else if (hud.getLevel() == 3){
					handler.addObject(new HardEnemy(r.nextInt(Gamee.WIDTH - 60), r.nextInt(Gamee.HEIGHT - 50), ID.BasicEnemy, handler));
				}else if (hud.getLevel() == 4){
					handler.addObject(new FastEnemy(r.nextInt(Gamee.WIDTH - 60), r.nextInt(Gamee.HEIGHT - 50), ID.FastEnemy, handler));
				}else if (hud.getLevel() == 5){
					handler.addObject(new SmartEnemy(r.nextInt(Gamee.WIDTH - 60), r.nextInt(Gamee.HEIGHT - 50), ID.SmartEnemy, handler));
				}else if (hud.getLevel() == 6){
					handler.addObject(new HardEnemy(r.nextInt(Gamee.WIDTH - 60), r.nextInt(Gamee.HEIGHT - 50), ID.FastEnemy, handler));
				}else if (hud.getLevel() == 7){
					handler.addObject(new HardEnemy(r.nextInt(Gamee.WIDTH - 60), r.nextInt(Gamee.HEIGHT - 50), ID.SmartEnemy, handler));
				}else if (hud.getLevel() == 10){
					handler.clearEnemys();
					AudioPlayer.getSound("boss").play();
					handler.addObject(new EnemyBoss((Gamee.WIDTH/2)-48 , -120 , ID.EnemyBoss, handler ,image));
				}else if (hud.getLevel() == 15){
					handler.addObject(new EnemyBoss2((Gamee.WIDTH/2)-48 , 600 , ID.EnemyBoss2, handler ,image));
				}
			}
			
		}
	}
}
