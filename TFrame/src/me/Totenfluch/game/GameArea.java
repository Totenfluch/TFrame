package me.Totenfluch.game;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import javax.swing.JPanel;
import javax.swing.Timer;

import me.Totenfluch.CoreClasses.ResourceLoader;

public class GameArea extends JPanel implements ActionListener{
	private static final long serialVersionUID = 1L;
	public static int scoreamount = 0;
	public static int moveamount = 0;
	public static int collisiondetectionamount = 0;

	Image playerback, playerfront, playerleft, playerright, playerleftdown, playerleftup, playerrightdown, playerrightup;

	private Timer timer;
	//private GameCraft craft;

	public GameArea(){
		addKeyListener(new TAdapter());
		setFocusable(true);
		setDoubleBuffered(true);


		new GameCraft();

		timer = new Timer(5, this);
		timer.start();
	}

	public void LoadImages(){
		playerback = ResourceLoader.ImageLoad(("/playerback.png"));
		playerfront = ResourceLoader.ImageLoad(("/playerfront.png"));
		playerright = ResourceLoader.ImageLoad(("/playerright.png"));
		playerleft = ResourceLoader.ImageLoad(("/playerleft.png"));
	}

	@SuppressWarnings("rawtypes")
	public void paint(Graphics g) {
		super.paint(g);

		Graphics2D g2d = (Graphics2D)g;
		drawbackground(g);
		drawScore(g);

		if(GameCraft.direction == 3){
			g2d.drawImage(ResourceLoader.ImageLoad("/playerback.png"), GameCraft.getX(), GameCraft.getY(), this);
		}else if(GameCraft.direction == 0){
			g2d.drawImage(ResourceLoader.ImageLoad("/playerfront.png"), GameCraft.getX(), GameCraft.getY(), this);
		}else if(GameCraft.direction == 1){
			g2d.drawImage(ResourceLoader.ImageLoad("/playerleft.png"), GameCraft.getX(), GameCraft.getY(), this);
		}else if(GameCraft.direction == 2){
			g2d.drawImage(ResourceLoader.ImageLoad("/playerright.png"), GameCraft.getX(), GameCraft.getY(), this);
		}else{
			g2d.drawImage(ResourceLoader.ImageLoad("/playerfront.png"), GameCraft.getX(), GameCraft.getY(), this);
		}

		////////////
		// Bullet //
		////////////

		ArrayList ms = GameCraft.getBulletDOWN();

		for (int i = 0; i < ms.size(); i++ ) {
			BulletDOWN m = (BulletDOWN) ms.get(i);
			g2d.drawImage(m.getImage(), m.getX(), m.getY(), this);
		}

		ArrayList msUP = GameCraft.getBulletUP();

		for (int i = 0; i < msUP.size(); i++ ) {
			BulletUP m = (BulletUP) msUP.get(i);
			g2d.drawImage(m.getImage(), m.getX(), m.getY(), this);
		}

		ArrayList msLEFT = GameCraft.getBulletLEFT();

		for (int i = 0; i < msLEFT.size(); i++ ) {
			BulletLEFT m = (BulletLEFT) msLEFT.get(i);
			g2d.drawImage(m.getImage(), m.getX(), m.getY(), this);
		}

		ArrayList msRIGHT = GameCraft.getBulletRIGHT();

		for (int i = 0; i < msRIGHT.size(); i++ ) {
			BulletRIGHT m = (BulletRIGHT) msRIGHT.get(i);
			g2d.drawImage(m.getImage(), m.getX(), m.getY(), this);
		}

		ArrayList msEnemys = GameCraft.getEnemys();

		for (int i = 0; i < msEnemys.size(); i++ ) {
			Enemys m = (Enemys) msEnemys.get(i);
			g2d.drawImage(m.getImage(), m.getX(), m.getY(), this);
		}

		////////////
		// Bullet //
		////////////

		Toolkit.getDefaultToolkit().sync();
		g.dispose();
	}

	public void drawbackground (Graphics g){
		g.drawImage(ResourceLoader.ImageLoad("/SampleMap1.png"), 0, 0, this);
	}

	public void drawScore (Graphics g){
		g.drawString("Score: "+ scoreamount, 750, 100);
	}


	private class TAdapter extends KeyAdapter {

		public void keyReleased(KeyEvent e) {
			GameCraft.keyReleased(e);
		}

		public void keyPressed(KeyEvent e) {
			GameCraft.keyPressed(e);
		}
	}

	@SuppressWarnings("rawtypes")
	public void actionPerformed(ActionEvent e) {
		////////////
		// Bullet //
		////////////
		ArrayList msDOWN = GameCraft.getBulletDOWN();
		for (int i = 0; i < msDOWN.size(); i++) {
			BulletDOWN m = (BulletDOWN) msDOWN.get(i);
			if (m.isVisible()) 
				m.moveDOWN();
			else msDOWN.remove(i);
		}

		ArrayList msUP = GameCraft.getBulletUP();
		for (int i = 0; i < msUP.size(); i++) {
			BulletUP m = (BulletUP) msUP.get(i);
			if (m.isVisible()) 
				m.moveUP();
			else msUP.remove(i);
		}

		ArrayList msLEFT = GameCraft.getBulletLEFT();
		for (int i = 0; i < msLEFT.size(); i++) {
			BulletLEFT m = (BulletLEFT) msLEFT.get(i);
			if (m.isVisible()) 
				m.moveLEFT();
			else msLEFT.remove(i);
		}

		ArrayList msRIGHT = GameCraft.getBulletRIGHT();
		for (int i = 0; i < msRIGHT.size(); i++) {
			BulletRIGHT m = (BulletRIGHT) msRIGHT.get(i);
			if (m.isVisible()) 
				m.moveRIGHT();
			else msRIGHT.remove(i);
		}
		
		ArrayList msEnemys = GameCraft.getEnemys();
		if(moveamount >= 150){
			for (int i = 0; i < msEnemys.size(); i++) {
				Enemys m = (Enemys) msEnemys.get(i);
				if (m.isVisible()){
					m.moveMe();
				}else{ 
					msEnemys.remove(i);
				}
			}
			moveamount = 0;
		}
		moveamount++;
		
		
		
		for(int a = 0; a < msDOWN.size(); a++){
			for(int b = 0; b < msEnemys.size(); b++){
				BulletDOWN bdown = (BulletDOWN) msDOWN.get(a);
				Enemys enemy = (Enemys) msEnemys.get(b);
				int xbul = bdown.getX();
				int ybul = bdown.getY();
				int xenemy = enemy.getX();
				int yenemy = enemy.getY();
				
				if((xbul - xenemy < 20 && xbul - xenemy > -20) && ( ybul - yenemy < 20 && xbul - yenemy > -20)){
					enemy.visible = false;
					scoreamount++;
					//GameCraft.SpawnEnemys();
				}
			}
		}
		
		for(int a = 0; a < msRIGHT.size(); a++){
			for(int b = 0; b < msEnemys.size(); b++){
				BulletRIGHT bright = (BulletRIGHT) msRIGHT.get(a);
				Enemys enemy = (Enemys) msEnemys.get(b);
				int xbul = bright.getX();
				int ybul = bright.getY();
				int xenemy = enemy.getX();
				int yenemy = enemy.getY();
				
				if((xbul - xenemy < 20 && xbul - xenemy > -20) && ( ybul - yenemy < 20 && xbul - yenemy > -20)){
					enemy.visible = false;
					scoreamount++;
					//GameCraft.SpawnEnemys();
				}
			}
		}
		
		for(int a = 0; a < msLEFT.size(); a++){
			for(int b = 0; b < msEnemys.size(); b++){
				BulletLEFT bleft = (BulletLEFT) msLEFT.get(a);
				Enemys enemy = (Enemys) msEnemys.get(b);
				int xbul = bleft.getX();
				int ybul = bleft.getY();
				int xenemy = enemy.getX();
				int yenemy = enemy.getY();
				
				if((xbul - xenemy < 20 && xbul - xenemy > -20) && ( ybul - yenemy < 20 && xbul - yenemy > -20)){
					enemy.visible = false;
					scoreamount++;
					//GameCraft.SpawnEnemys();
				}
			}
		}

		for(int a = 0; a < msUP.size(); a++){
			for(int b = 0; b < msEnemys.size(); b++){
				BulletUP bup = (BulletUP) msUP.get(a);
				Enemys enemy = (Enemys) msEnemys.get(b);
				int xbul = bup.getX();
				int ybul = bup.getY();
				int xenemy = enemy.getX();
				int yenemy = enemy.getY();
				
				if((xbul - xenemy < 20 && xbul - xenemy > -20) && ( ybul - yenemy < 20 && xbul - yenemy > -20)){
					enemy.visible = false;
					scoreamount++;
					//GameCraft.SpawnEnemys();
				}
			}
		}
		
		/*
		Enemy 500 500
		Bullet 510 510
		510 < 500 && 480 < 500 || 500 > 510 && 500 > 480
		500 > 320 && 500 > 380
		
		*/
		
		////////////
		// Bullet //
		////////////
		GameCraft.move();
		repaint();  
	}
}

