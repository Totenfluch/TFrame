package me.Totenfluch.classpackage;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;


public class AuthentificatorInWindow extends JFrame{

	private static final long serialVersionUID = 1L;
	public static boolean AuthentificatorWindowActive = false;
	public static int SecretKey = 216578691;
	public static double SecretKey2 = 16484;
	public static double ValidKey;
	private JLabel Info;
	private JTextField input;
	private JButton login;

	public AuthentificatorInWindow(){
		setSize(300, 150);
		setVisible(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setResizable(false);
		
		setLayout(new BorderLayout());
		JLabel background=new JLabel(ResourceLoader.Iconload("/Dragon.jpg"));
		background.setSize(300, 150);
		add(background);
		background.setLayout(new FlowLayout());


		Info = new JLabel("Put the Code in here please");
		Info.setForeground(Color.white);
		background.add(Info);

		input = new JTextField(20);
		background.add(input);

		login = new JButton("Login");
		background.add(login);

		thehandler handler = new thehandler();
		input.addActionListener(handler);
		login.addActionListener(handler);

	}


	private class thehandler implements ActionListener{

		public void actionPerformed(ActionEvent event) {
			if(event.getSource() == login){
				if(Double.parseDouble(input.getText()) == ValidKey ){
					AuthentificatorWindowActive = false;
					ConsoleWindow.ExecuteWindowActive = true;
					JOptionPane.showMessageDialog(null, "Welcome back, " + OtherStuff.LoginName[LoginWindow.LoginIDBuffer]+ " !\n");
					ConsoleWindow.TextArea1.append(OtherStuff.TheNormalTime() + " You logged in as" + OtherStuff.LoginName[LoginWindow.LoginIDBuffer]+ "!\n");
					ConsoleWindow.TextArea1.append(OtherStuff.TheNormalTime() + " Your Permissions Level is at " + OtherStuff.LoginPermissions[LoginWindow.LoginIDBuffer]+ " / 1000 !\n");
				}else{
					JOptionPane.showMessageDialog(null, "Your Authentificator Code seems to be wrong. Try again!");
				}
			}
		}
	}

}


