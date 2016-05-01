package com.tutorial.main;

import java.awt.Canvas;
import java.awt.Dimension;
import java.awt.Frame;

import javax.swing.JFrame;

public class Window extends Canvas{
	private static final long serialVersionUID = -240840600533728354L;

	public Window(int width ,int height ,String title ,Gamee game){
		JFrame frame = new JFrame(title);
		
		frame.setUndecorated(true);
		frame.setExtendedState(Frame.MAXIMIZED_BOTH);

		frame.setMaximumSize(new Dimension(width , height));
		frame.setMinimumSize(new Dimension(width , height));
		
		//frame.setPreferredSize(new Dimension(width , height));
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.add(game);
		frame.setVisible(true);
		game.start();
	}
	
}
