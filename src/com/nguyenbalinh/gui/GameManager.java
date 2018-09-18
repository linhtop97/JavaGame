package com.nguyenbalinh.gui;

import java.awt.Graphics2D;
import java.awt.Image;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

import model.Ball;
import model.Fragment;
import model.Object2D;

public class GameManager implements Constants {
	private Object2D arrItem[][];
	private Fragment fragment;
	private Ball ball;
	public GameManager(String map) {
		initBall();
		initFragment(map);
		initMap(map);
		
	}

	private void initBall() {
		int x = WIDTH_GUI/2 - 15;
		int y = HEIGHT_GUI - SIZE_ITEM;
		 Image img = model.ImgUtils.getImgFromValue(8);
	     ball = new Ball(x, y, img, SIZE_ITEM, SIZE_ITEM, 1);
	}
	private void initFragment(String map) {
		 int x;
	        switch (map){
	            case "map1":
	                x = 6 * SIZE_ITEM;
	                break;
	            default:
	                x = 6 * SIZE_ITEM;
	                break;
	        }
	        int y = 25 * SIZE_ITEM -2;
	        Image img = model.ImgUtils.getImgFromValue(1);
	        fragment = new Fragment(x, y, img, SIZE_ITEM * 4, SIZE_ITEM, 1);
	}

	private void initMap(String map) {
		arrItem = new Object2D[ROWS][COLUMNS];
		try {

			URL url = getClass().getResource("/maps/" + map + ".txt");
			BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream()));

			for (int i = 0; i < ROWS; i++) {
				String line = in.readLine();
				int y = i * SIZE_ITEM;
				for (int j = 0; j < line.length(); j++) {
					int value = line.charAt(j) - '0';
					if (value == 0) {
						continue;
					}
					if (value == 1) {
						continue;
					}
					int x = j * SIZE_ITEM;
					Image img = model.ImgUtils.getImgFromValue(value);
					Object2D object2D = new Object2D(x, y, img, SIZE_ITEM, SIZE_ITEM, value);
					arrItem[i][j] = object2D;
				}
			}
			in.close();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void drawAll(Graphics2D g2d) {
		ball.draw(g2d);
		//draw Fragment
		fragment.draw(g2d);
		// draw item
		for (int i = 0; i < ROWS; i++) {
			for (int j = 0; j < COLUMNS; j++) {
				if (arrItem[i][j] == null) {
					continue;
				}
				arrItem[i][j].draw(g2d);
			}
		}
	}

	public void moveFragment(int ori) {
		fragment.move(ori);
	}

	public void moveBall() {
		ball.move(fragment.getX(), fragment.getY(), fragment.getW(), arrItem);
		
	}
	public boolean checkDied() {
		return ball.isDied();
	}
}
