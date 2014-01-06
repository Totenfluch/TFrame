package me.Totenfluch.game;

import java.awt.Image;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import me.Totenfluch.CoreClasses.OtherStuff;

public class GameCraft {


	private static int dx;
	private static int dy;
	private static int x;
	private static int y;
	private static Image image;
	
	public static boolean specialweapon = false;
	/*
	 * 0 = down
	 * 1 = left
	 * 2 = right
	 * 3 = up
	 */
	public static int direction = 0;
	////////////
	// Bullet //
	////////////
    @SuppressWarnings("rawtypes")
	private static ArrayList misslesDOWN;
    private final static int CRAFT_SIZE = 20;
    
	@SuppressWarnings("rawtypes")
	public GameCraft() {
		x = 800;
		y = 450;
		misslesDOWN = new ArrayList();
		missilesUP = new ArrayList();
		missilesLEFT = new ArrayList();
		missilesRIGHT = new ArrayList();
		MovingEntitys = new ArrayList();
	}
	
    @SuppressWarnings("rawtypes")
	public ArrayList getMisslesDOWN() {
        return misslesDOWN;
    }
    
    
	@SuppressWarnings("unchecked")
	public static void fireDOWN() {
	    misslesDOWN.add(new BulletDOWN(x + CRAFT_SIZE, y + CRAFT_SIZE/2));
	}
	
	@SuppressWarnings("rawtypes")
	public static ArrayList getBulletDOWN() {
	     return misslesDOWN;
	 }
	////////////
	// Bullet //
	////////////
	
    @SuppressWarnings("rawtypes")
	private static ArrayList missilesUP;
    private final static int CRAFT_SIZEUP = 20;
    

	
    @SuppressWarnings("rawtypes")
	public ArrayList getMissilesUP() {
        return missilesUP;
    }
    
    
	@SuppressWarnings("unchecked")
	public static void fireUP() {
		missilesUP.add(new BulletUP(x + CRAFT_SIZEUP, y + CRAFT_SIZEUP/2));
	}
	
	@SuppressWarnings("rawtypes")
	public static ArrayList getBulletUP() {
	     return missilesUP;
	 }
	
	///
	
    @SuppressWarnings("rawtypes")
	private static ArrayList missilesLEFT;
    private final static int CRAFT_SIZELEFT = 20;
    

	
    @SuppressWarnings("rawtypes")
	public ArrayList getMissilesLEFT() {
        return missilesLEFT;
    }
    
    
	@SuppressWarnings("unchecked")
	public static void fireLEFT() {
		missilesLEFT.add(new BulletLEFT(x + CRAFT_SIZELEFT, y + CRAFT_SIZELEFT/2));
	}
	
	@SuppressWarnings("rawtypes")
	public static ArrayList getBulletLEFT() {
	     return missilesLEFT;
	 }
	
	//
    
	
    @SuppressWarnings("rawtypes")
	private static ArrayList missilesRIGHT;
    private final static int CRAFT_SIZERIGHT = 20;
    

	
    @SuppressWarnings("rawtypes")
	public ArrayList getMissilesRIGHT() {
        return missilesRIGHT;
    }
    
    
	@SuppressWarnings("unchecked")
	public static void fireRIGHT() {
		missilesRIGHT.add(new BulletRIGHT(x + CRAFT_SIZERIGHT, y + CRAFT_SIZERIGHT/2));
	}
	
	@SuppressWarnings("rawtypes")
	public static ArrayList getBulletRIGHT() {
	     return missilesRIGHT;
	 }
	
	// Enemys
	@SuppressWarnings("rawtypes")
	private static ArrayList MovingEntitys;
    private final static int CRAFT_SIZEnemys = 20;
    

	
    @SuppressWarnings("rawtypes")
	public static ArrayList getEnemys() {
        return MovingEntitys;
    }
    
    
	@SuppressWarnings("unchecked")
	public static void SpawnEnemys() {
		MovingEntitys.add(new Enemys(OtherStuff.randInt(101, 1699) + CRAFT_SIZEnemys, OtherStuff.randInt(101, 799) + CRAFT_SIZEnemys/2));
	}
	
	@SuppressWarnings("rawtypes")
	public static ArrayList MovingEntitys() {
	     return MovingEntitys;
	 }
	

	
	//
	public static void move() {
		if(y<1){
			y = 1;
		}else if(y>800){
			y = 800;
		}
		else if(x<1){
			x = 1;
		}else if(x>1530){
			x = 1530;
		}else{
			x += dx;
			y += dy;
		}
		//System.out.println(x + " " + y);
	}

	public static int getX() {
		return x;
	}

	public static int getY() {
		return y;
	}

	public static Image getImage() {
		return image;
	}
	
	
	public static void keyPressed(KeyEvent e) {

		int key = e.getKeyCode();

		if (key == KeyEvent.VK_LEFT) {
			dx = -1;
			direction = 1;
		}

		if (key == KeyEvent.VK_RIGHT) {
			dx = 1;
			direction = 2;
		}

		if (key == KeyEvent.VK_UP) {
			dy = -1;
			direction = 3;
		}

		if (key == KeyEvent.VK_DOWN) {
			dy = 1;
			direction = 0;
		}
		
		if (key == KeyEvent.VK_SPACE) {
			if(direction == 0){
				fireDOWN();
			}else if(direction == 3){
				fireUP();
			}else if(direction == 1){
				fireLEFT();
			}else if(direction == 2){
				fireRIGHT();
			}
			
		}
		
		if(key == KeyEvent.VK_ALT && specialweapon == true){
			specialweapon = false;
		}else if(key == KeyEvent.VK_ALT){
			specialweapon = true;
		}
		
		if(key == KeyEvent.VK_ENTER){
			SpawnEnemys();
		}
	}

	public static void keyReleased(KeyEvent e) {
		int key = e.getKeyCode();

		if (key == KeyEvent.VK_LEFT) {
			dx = 0;
		}

		if (key == KeyEvent.VK_RIGHT) {
			dx = 0;
		}

		if (key == KeyEvent.VK_UP) {
			dy = 0;
		}

		if (key == KeyEvent.VK_DOWN) {
			dy = 0;
		}
		
	}
}

