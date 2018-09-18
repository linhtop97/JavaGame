package com.nguyenbalinh.gui;

import javax.swing.BoxLayout;
import javax.swing.JFrame;

public class GUI extends JFrame implements Constants{

	private BoxLayout boxLayout;
	private BottomLayout bottomLayout;
	private MyGame myGame;

	public GUI() {
		setTitle("My Game");
		setSize(WIDTH_GUI+5, HEIGHT_GUI+ HEIGHT_GUI/9);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);
		setLocationRelativeTo(null);
		boxLayout = new BoxLayout(this, BoxLayout.Y_AXIS);
		myGame = new MyGame();
		add(myGame);
		myGame.setFocusable(true);
		myGame.requestFocus();
		bottomLayout = new BottomLayout();
		add(bottomLayout);
		
	}
}
