package model;

import java.awt.Image;

import javax.swing.ImageIcon;

public class ImgUtils {
	public static final int FRAGMENT_ID = 1;
	public static final int BLUE_ID = 2;
	public static final int RED_ID = 3;
	public static final int VIOLET_ID = 4;
	public static final int YELLOW_ID = 5;
	public static final int GREEN_ID = 6;
	public static final int PINK_ID = 7;
	public static final int BALL_ID = 8;

	public static Image getImgFromValue(int value) {
		switch (value) {
		case FRAGMENT_ID:
			Image img = new ImageIcon(ImgUtils.class.getResource("/imgs/fragment.png")).getImage();
			return img;
		case BLUE_ID:
			img = new ImageIcon(ImgUtils.class.getResource("/imgs/blue.png")).getImage();
			return img;
		case RED_ID:
			img = new ImageIcon(ImgUtils.class.getResource("/imgs/red.png")).getImage();
			return img;
		case VIOLET_ID:
			img = new ImageIcon(ImgUtils.class.getResource("/imgs/violet.png")).getImage();
			return img;
		case YELLOW_ID:
			img = new ImageIcon(ImgUtils.class.getResource("/imgs/yellow.png")).getImage();
			return img;
		case GREEN_ID:
			img = new ImageIcon(ImgUtils.class.getResource("/imgs/green.png")).getImage();
			return img;
		case PINK_ID:
			img = new ImageIcon(ImgUtils.class.getResource("/imgs/pink.png")).getImage();
			return img;
		case BALL_ID:
			img = new ImageIcon(ImgUtils.class.getResource("/imgs/ball.png")).getImage();
			return img;
		default:
			return null;

		}
	}
}
