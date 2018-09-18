package model;

import java.awt.Image;

import com.nguyenbalinh.gui.Constants;
import com.nguyenbalinh.gui.MoveAble;

public class Fragment extends Object2D implements Constants {

	public Fragment(int x, int y, Image img, int w, int h, int imgId) {
		super(x, y, img, w, h, imgId);
	}

	public void move(int ori) {
		switch (ori) {
		case ORI_LEFT:
			if (x >= 6) {
				x = x - 6;
			}
			break;
		case ORI_RIGHT:
			if (x <= WIDTH_GUI - 12 - w) {
				x = x + 6;
			}
			break;
		default:
			break;
		}
	}

}
