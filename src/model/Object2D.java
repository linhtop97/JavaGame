package model;

import java.awt.Graphics2D;
import java.awt.Image;

public class Object2D {
	protected int x, y;
	protected Image img;
	protected int w;
	protected int h;
	protected int imgId;

	public Object2D(int x, int y, Image img, int w, int h, int imgId) {
		this.x = x;
		this.y = y;
		this.img = img;
		this.w = w;
		this.h = h;
		this.imgId = imgId;
	}

	public void draw(Graphics2D g2d) {
		g2d.drawImage(img, x, y, w, h, null);
	}
	

	public int getW() {
		return w;
	}

	public void setW(int w) {
		this.w = w;
	}

	public int getH() {
		return h;
	}

	public void setH(int h) {
		this.h = h;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}
	
	
}
