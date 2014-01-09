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
	private JTextField BetaKey;
	private JButton Create;
	private JTextArea TOS;
	
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
		
		BetaKey = new JTextField("Beta Invitation Key", 30);
		background.add(BetaKey);
		
		TOS = new JTextArea("You are not allowed to edit the Programm\nYou are not allowed to cheat the program in any way\nI Accept that my Account can be closed anytime\nNo Racism, harrasment in the IRC\nI admit to give all my money to Totenfluch\nI admit to buy a expensive washing machine\nI hope this Text Ends now.\nIt does now!", 8, 30);
		TOS.setEditable(false);
		background.add(TOS);
		
		Create = new JButton("                   Create Account and Accept TOS                  ");
		background.add(Create);	
		
	}
	
}
