package me.Totenfluch.CoreClasses;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class RegisterAccountWindow extends JFrame{
	private static final long serialVersionUID = 1L;
	public static boolean RegisterAccountWindowActive = false;
	private JTextField Nickname;
	private JTextField SecurityCode;
	private JPasswordField Password;
	private JTextField Email;
	private JTextField FirstName;
	private JTextField LastName;
	private JTextField Birthday;
	private JButton Create;
	private JTextArea AGB;
	
	public RegisterAccountWindow(){
		setSize(425, 350);
		setTitle("Register Account");
		setResizable(false);
		
		setLayout(new BorderLayout());
		JLabel background=new JLabel(ResourceLoader.Iconload("/CreateAccountBackground.jpg"));
		background.setSize(300, 300);
		add(background);
		background.setLayout(new FlowLayout());
		
		Nickname = new JTextField("Nickname", 30);
		background.add(Nickname);
		
		SecurityCode = new JTextField("Security code 1-100", 30);
		background.add(SecurityCode);
		
		Password = new JPasswordField("password", 30);
		background.add(Password);
		
		Email = new JTextField("Email", 30);
		background.add(Email);
		
		FirstName = new JTextField("FirstName", 14);
		background.add(FirstName);
		
		LastName = new JTextField("LastName", 15);
		background.add(LastName);
		
		Birthday = new JTextField("BirthDay YYYY:MM:DD", 30);
		background.add(Birthday);
		
		AGB = new JTextArea("I haz All Rights I want\nYou no cheat Programm\nTotenfluch is cooler than me\nTotenfluch is a great Person\nI admit to give all my money to Totenfluch\nI admit to buy a expensive washing machine\nI hope this Text Ends now.\nIt does now!", 8, 30);
		AGB.setEditable(false);
		background.add(AGB);
		
		Create = new JButton("                   Create Account and Accept AGB                  ");
		background.add(Create);	
		
	}
	
}
