package model;

import java.awt.Image;

import com.nguyenbalinh.gui.Constants;
import com.nguyenbalinh.gui.MoveAble;

public class Ball extends Object2D implements MoveAble, Constants {

	int ADD = 3;
	int REDUCE = -3;
	int ADD_X = REDUCE;
	int ADD_Y = REDUCE;
	boolean isDied = false;

	public Ball(int x, int y, Image img, int w, int h, int imgId) {
		super(x, y, img, w, h, imgId);
	}

	@Override
	public void move(int xFragment, int yFragment, int wFragment, Object2D[][] items) {
		checkInteractBrickUp(items);
		checkInteractBrickDown(items);
		checkInteractBrickRight(items);
		checkInteractBrickLeft(items);
		getLocation(xFragment, yFragment, wFragment, items);
		x += ADD_X;
		y += ADD_Y;

	}

	private void getLocation(int xFragment, int yFrangment, int wFragment, Object2D[][] items) {
		if (x > 0 && x > WIDTH_GUI - SIZE_ITEM - 2 * ADD +5) {

			ADD_X = REDUCE;
		}
		if (x <= 0) {
			ADD_X = ADD;
		}
		if (y + SIZE_ITEM == HEIGHT_GUI - SIZE_ITEM +1 && x + SIZE_ITEM > xFragment && x < xFragment + SIZE_ITEM * 4) {
			ADD_Y = REDUCE;
			if (x < xFragment + SIZE_ITEM * 4 && x > xFragment + (wFragment / 2)) {
				ADD_X = ADD;
			}
			if (x - SIZE_ITEM >= xFragment && x + SIZE_ITEM + SIZE_ITEM / 2 < xFragment + wFragment / 2) {
				ADD_X = REDUCE;
			}
		}
		if (y <= 0) {
			ADD_Y = ADD;
		}
		if (y > HEIGHT_GUI - SIZE_ITEM) {
			isDied = true;
			ADD_X = ADD_Y = 0;
		}

	}

	private void checkInteractBrickUp(Object2D[][] items) {
		int i = y / SIZE_ITEM;
		int jStart = x / SIZE_ITEM;
		int jEnd = (x + w) / SIZE_ITEM;
		for (int index = jStart; index < jEnd; index++) {
			if (items[i][index] != null && items[i][index].imgId != ImgUtils.FRAGMENT_ID) {
				items[i][index] = null;
				ADD_Y = ADD;
				break;
			}
		}

	}

	private void checkInteractBrickDown(Object2D[][] items) {
		int i = (y + SIZE_ITEM) / SIZE_ITEM;
		int jStart = x / SIZE_ITEM;
		int jEnd = (x + w) / SIZE_ITEM;
		for (int index = jStart; index < jEnd; index++) {
			try {
				if (items[i][index] != null && items[i][index].imgId != ImgUtils.FRAGMENT_ID) {
					items[i][index] = null;
					ADD_Y = REDUCE;
					break;
				}
			} catch (Exception ex) {

			}
		}

	}

	private void checkInteractBrickRight(Object2D[][] items) {
		int iStart = y / SIZE_ITEM;
		int iEnd = (y+SIZE_ITEM)/SIZE_ITEM;
		int j = (x + SIZE_ITEM) / SIZE_ITEM;
		for (int index = iStart; index < iEnd; index++) {
			try {
				if (items[index][j] != null && items[index][j].imgId != ImgUtils.FRAGMENT_ID) {
					items[index][j] = null;
					ADD_X = REDUCE;
					break;
				}
			} catch (Exception ex) {

			}
		}
	}

	private void checkInteractBrickLeft(Object2D[][] items) {
		int iStart = y / SIZE_ITEM;
		int iEnd = (y+SIZE_ITEM)/SIZE_ITEM;
		int j = x / SIZE_ITEM;
		for (int index = iStart; index < iEnd; index++) {
			try {
				if (items[index][j] != null && items[index][j].imgId != ImgUtils.FRAGMENT_ID) {
					items[index][j] = null;
					ADD_X = ADD;
					break;
				}
			} catch (Exception ex) {

			}
		}
	}

	public boolean isDied() {
		return isDied;
	}

	public void setDied(boolean isDied) {
		this.isDied = isDied;
	}

}
