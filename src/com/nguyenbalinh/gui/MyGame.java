package com.nguyenbalinh.gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.RandomAccessFile;
import java.util.Random;

import javax.crypto.SecretKeyFactorySpi;
import javax.swing.JButton;
import javax.swing.JPanel;

public class MyGame extends JPanel implements Constants, KeyListener, ActionListener {
	private GameManager gameManager;
	private boolean isLeft;
	private boolean isRight;
	private boolean check =false;
	
	public MyGame() {
		setSize(WIDTH_GUI, HEIGHT_GUI);
		setBackground(Color.BLACK);
		Random rd = new Random();
		switch (rd.nextInt(4)) {
		case 0:
			gameManager = new GameManager("map1");
			break;
		case 1:
			gameManager = new GameManager("map2");
			break;
		case 2:
			gameManager = new GameManager("map3");
			break;
		case 3:
			gameManager = new GameManager("map4");
			break;

		default:
			break;
		}
		addKeyListener(this);
		setFocusable(true);
		requestFocus();
		initThread();
		threadBall();
		threadCheckDieAndRepaint();
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D) g;
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		gameManager.drawAll(g2d);
		g2d.setColor(Color.WHITE);
		Font font = new Font("Tahoma", Font.BOLD, 30);
		g2d.setFont(font);	
		JButton btnRePlay = new JButton();
		btnRePlay.setText("Replay");
		btnRePlay.setSize(160,50);
		btnRePlay.setBackground(Color.WHITE);
		btnRePlay.setLocation(WIDTH_GUI/2 -80, HEIGHT_GUI/2 + 30);
		btnRePlay.setActionCommand("btnReplay");//set ID cho button.
		btnRePlay.addActionListener(this);
		if(check) {
			g2d.drawString("GAME OVER", WIDTH_GUI/2 -100, HEIGHT_GUI/2);
			add(btnRePlay);
		
		}
	}

	@Override
	public void keyPressed(KeyEvent e) {
		int keyCode = e.getKeyCode();
		switch (keyCode) {
		case KeyEvent.VK_LEFT:
			isLeft = true;
			break;
		case KeyEvent.VK_RIGHT:
			isRight = true;
			break;
		default:
			break;
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		int keyCode = e.getKeyCode();
		switch (keyCode) {
		case KeyEvent.VK_LEFT:
			isLeft = false;
			break;
		case KeyEvent.VK_RIGHT:
			isRight = false;
			break;
		default:
			break;
		}
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub

	}

	private void threadBall() {
		Runnable runnable = new Runnable() {

			@Override
			public void run() {
				while (true) {
					try {
						Thread.sleep(10);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					moveMyBall();
					if(checkDied()) {
						return;
					}
				}
			}

		};

		Thread thread = new Thread(runnable);
		thread.start();
	}
	private void threadCheckDieAndRepaint() {
		Runnable runnable = new Runnable() {

			@Override
			public void run() {
				while (true) {
					if(checkDied()) {
						check = true;
						return;
					}
					repaint();
				}
			}

		};

		Thread thread = new Thread(runnable);
		thread.start();
	}

	private boolean checkDied() {
		return gameManager.checkDied();

	}

	private void moveMyBall() {
		gameManager.moveBall();
	}

	private void initThread() {
		Runnable runnable = new Runnable() {
			@Override
			public void run() {
				while (true) {
					try {
						Thread.sleep(10);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					moveFragment();
					repaint();
					if(checkDied()) {
						return;
					}
				}
			}
		};
		Thread thread = new Thread(runnable);
		thread.start();
	}

	private void moveFragment() {
		if (isLeft) {
			gameManager.moveFragment(ORI_LEFT);
			return;
		}
		if (isRight) {
			gameManager.moveFragment(ORI_RIGHT);
			return;
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		switch (e.getActionCommand()) {
		case "btnReplay":	
			Replay();
			break;
		default:
			break;
		}
		
	}

	private void Replay() {
		System.exit(0);
	}
}
