package me.Totenfluch.CoreClasses;
import java.awt.*;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class ConnectingWindow extends JFrame{
	private static final long serialVersionUID = 1L;
	public static boolean connectionwindowactive = true;
	JLabel connecting;
	public static JLabel reconnecting;
	ImageIcon image = new ImageIcon("blub");
	
	public ConnectingWindow(){
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(300, 450);
		setLocationRelativeTo(null);
		setResizable(false);
		setVisible(true);
		
		setLayout(new FlowLayout());

		setLayout(new BorderLayout());
		JLabel background=new JLabel(ResourceLoader.Iconload("/connecting.gif"));
		background.setSize(300, 250);
		add(background);
		background.setLayout(new FlowLayout());

		super.setTitle("Client");
		connecting = new JLabel("Connecting to Server...");
		background.add(connecting);
		
		reconnecting = new JLabel("");
		background.add(reconnecting);

	}


}
