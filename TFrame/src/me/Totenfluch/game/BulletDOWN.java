package me.Totenfluch.game;
import java.awt.Image;

import javax.swing.ImageIcon;

public class BulletDOWN {

	private int x, y;
	private Image image;
	boolean visible;

	private final int Bullet_SPEED = 5;

	public BulletDOWN(int x, int y) {
		if(GameCraft.specialweapon == true){
			ImageIcon ii =
					new ImageIcon(this.getClass().getResource("/chrome.png"));
			image = ii.getImage();
		}else if(GameCraft.direction == 0){
			ImageIcon ii =
					new ImageIcon(this.getClass().getResource("/bulletdown.png"));
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

	public void moveDOWN() {

			y += Bullet_SPEED;
			
		if (x > 1800 || x<1 || y>900 || y<1){
			//explode();
			visible = false;
			if(x > 1351 && y>396 && y<600){
				GameArea.scoreamount++;
			}
		}
	}


}