package com.nguyenbalinh.gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import javax.swing.JPanel;

public class BottomLayout extends JPanel implements Constants {
	private int score = 1;

	public BottomLayout() {
		setSize(WIDTH_GUI, HEIGHT_GUI / 9);
		setBackground(Color.LIGHT_GRAY);
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D) g;
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		g2d.setColor(Color.BLACK);
		Font font = new Font("Tahoma", Font.ITALIC, 20);
		g2d.setFont(font);
		g2d.drawString("Level:", WIDTH_GUI / 2 - 50, HEIGHT_GUI + 40);
		g2d.drawString(String.valueOf(score), WIDTH_GUI / 2 + 10, HEIGHT_GUI + 40);
	}

	private void addScore() {
		score++;
	}

	private void threadAddScore() {
		Runnable runnable = new Runnable() {

			@Override
			public void run() {

			}
		};
		Thread th = new Thread(runnable);
		th.start();
	}
}
