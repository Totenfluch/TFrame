package me.Totenfluch.game;
import java.awt.Image;

import javax.swing.ImageIcon;

public class BulletUP {

	private int x, y;
	private Image image;
	boolean visible;

	private final int Bullet_SPEED = 5;

	public BulletUP(int x, int y) {
		if(GameCraft.specialweapon == true){
			ImageIcon ii =
					new ImageIcon(this.getClass().getResource("/chrome.png"));
			image = ii.getImage();
		}else if(GameCraft.direction == 3){
			ImageIcon ii =
					new ImageIcon(this.getClass().getResource("/bulletup.png"));
			image = ii.getImage();
		}

		visible = true;
		this.x = x;
		this.y = y+20;

	}


	public Image getImage() {
		return image;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public boolean isVisible() {
		return visible;
	}

	public void moveUP() {

			y -= Bullet_SPEED;
			
		if (x > 1800 || x<1 || y>900 || y<1){
			//explode();
			visible = false;
			if(x > 1351 && y>396 && y<600){
				GameArea.scoreamount++;
			}
		}
	}


}