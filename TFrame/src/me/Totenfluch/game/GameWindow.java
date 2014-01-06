package me.Totenfluch.game;



import javax.swing.JFrame;


public class GameWindow extends JFrame {

	private static final long serialVersionUID = 1L;
	public static boolean GameWindowActive = false;

	public GameWindow() {
		
	    add(new GameArea());
	    
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1600, 900);
        setLocationRelativeTo(null);
        setTitle("Forest Survival");
        setResizable(false);
    }
}
