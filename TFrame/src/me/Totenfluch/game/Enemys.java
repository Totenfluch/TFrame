package me.Totenfluch.game;
import java.awt.Image;

import javax.swing.ImageIcon;

import me.Totenfluch.CoreClasses.OtherStuff;

public class Enemys {

	private int x, y;
	private Image image;
	boolean visible;

	private final int Entity_Speed = 1;

	public Enemys(int x, int y) {

			ImageIcon ii =
					new ImageIcon(this.getClass().getResource("/gegner.png"));
			image = ii.getImage();

		visible = true;
		this.x = x;
		this.y = y;

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

	public void moveMe() {
			
			int dir = OtherStuff.randInt(1, 8);
			
			
			if(dir == 1){
				if(!(y>800)){
					for(int p=0; p<5; p++){
						y+= Entity_Speed;
					}
				}
			}else if(dir == 2){
				if(!(y<50)){
					for(int p=0; p<5; p++){
						y-= Entity_Speed;
					}
				}
			}else if(dir == 3){
				if(!(x>1700)){
					for(int p=0; p<5; p++){
						x+= Entity_Speed;
					}
				}
			}else if(dir == 4){
				if(!(x<50)){
					for(int p=0; p<5; p++){
						x-= Entity_Speed;
					}
				}
			}
			
			
			
		if (x > 1800 || x<1 || y>900 || y<1){
			//explode();
			visible = false;
			if(x > 1351 && y>396 && y<600){
				GameArea.scoreamount++;
			}
		}
	}


}