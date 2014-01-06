package me.Totenfluch.CoreClasses;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import me.Totenfluch.TServerClient.Client;

public class AddAccountWindow extends JFrame{
	private static final long serialVersionUID = 1L;
	public static boolean AddAccountWindowActive = false;
	public static int LoadedAccounts = 0;
	
	public JLabel Headline;
	public static JTextField inID;
	public JTextField inCode;
	public JTextField inName;
	public JTextField inPassword;
	public JTextField inPermissions;
	public JTextField inFlags;
	public JButton sendinfos;
	
	public AddAccountWindow(){
		setSize(150, 235);
		setVisible(false);
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setLocationRelativeTo(null);
		setResizable(false);
		
		setLayout(new BorderLayout());
		JLabel background=new JLabel(ResourceLoader.Iconload("/addAccountBackground.jpg"));
		background.setSize(150, 235);
		add(background);
		background.setLayout(new FlowLayout());
		
		Headline = new JLabel("Informations here");
		Headline.setForeground(Color.GREEN);
		background.add(Headline);
		
		inID = new JTextField(String.valueOf(LoadedAccounts), 10);
		inID.setEditable(false);
		background.add(inID);
		
		inName = new JTextField("Account Name", 10);
		background.add(inName);
		
		inCode = new JTextField("Account Code", 10);
		background.add(inCode);
		
		inPassword = new JTextField("Account Password", 10);
		background.add(inPassword);
		
		inPermissions = new JTextField("Account Permissions", 10);
		background.add(inPermissions);
		
		inFlags = new JTextField("Account Flags", 10);
		background.add(inFlags);
		
		sendinfos = new JButton("Create");
		background.add(sendinfos);
		
		thehandler handler = new thehandler();
		sendinfos.addActionListener(handler);
		
		
		
		inID.addKeyListener(new KeyListener(){
			@Override public void keyPressed(KeyEvent arg0) {}
			@Override public void keyReleased(KeyEvent arg0) {}
			@Override
			public void keyTyped(KeyEvent arg0) {
				String check = "Account ID";
				if(inID.getText().equals(check)){
					inID.setText("");
				}
			}

		});
		inCode.addKeyListener(new KeyListener(){
			@Override public void keyPressed(KeyEvent arg0) {}
			@Override public void keyReleased(KeyEvent arg0) {}
			@Override
			public void keyTyped(KeyEvent arg0) {
				String check = "Account Code";
				if(inCode.getText().equals(check)){
					inCode.setText("");
				}
			}

		});
		inName.addKeyListener(new KeyListener(){
			@Override public void keyPressed(KeyEvent arg0) {}
			@Override public void keyReleased(KeyEvent arg0) {}
			@Override
			public void keyTyped(KeyEvent arg0) {
				String check = "Account Name";
				if(inName.getText().equals(check)){
					inName.setText("");
				}
			}

		});
		inPassword.addKeyListener(new KeyListener(){
			@Override public void keyPressed(KeyEvent arg0) {}
			@Override public void keyReleased(KeyEvent arg0) {}
			@Override
			public void keyTyped(KeyEvent arg0) {
				String check = "Account Password";
				if(inPassword.getText().equals(check)){
					inPassword.setText("");
				}
			}

		});
		inPermissions.addKeyListener(new KeyListener(){
			@Override public void keyPressed(KeyEvent arg0) {}
			@Override public void keyReleased(KeyEvent arg0) {}
			@Override
			public void keyTyped(KeyEvent arg0) {
				String check = "Account Permissions";
				if(inPermissions.getText().equals(check)){
					inPermissions.setText("");
				}
			}

		});
		inFlags.addKeyListener(new KeyListener(){
			@Override public void keyPressed(KeyEvent arg0) {}
			@Override public void keyReleased(KeyEvent arg0) {}
			@Override
			public void keyTyped(KeyEvent arg0) {
				String check = "Account Flags";
				if(inFlags.getText().equals(check)){
					inFlags.setText("");
				}
			}

		});
	}
	
	private class thehandler implements ActionListener{

		public void actionPerformed(ActionEvent event) {
			if(event.getSource() == sendinfos){
				//String iID = inID.getText();
				String iName = inName.getText();
				String iPassword = inPassword.getText();
				String iPermissions = inPermissions.getText();
				String iFlags = inFlags.getText();
				String iCode = inCode.getText();
				String SysAdmintrue = null;
				if(ConsoleWindow.SysAdmin == true){
					SysAdmintrue = "true";
				}else{
					SysAdmintrue = "false";
				}
				String sendme = "/addAccount " + SysAdmintrue + " " + iCode + " " + iName + " " + iPassword + " " + iPermissions + " " + iFlags;
				inName.setText("Account Name");
				inPassword.setText("Account Password");
				inPermissions.setText("Account Permissions");
				inFlags.setText("Account Flags");
				inCode.setText("Account Code");
				
				Object[] options = {"Yes, I am",
				"No, I'm not"};
				int n = JOptionPane.showOptionDialog(null,
						"Are You sure that\nyou want to create:\n\n ID: " + String.valueOf(LoadedAccounts)  + "\nName: " + iName + "\nCode: " + iCode + "\nPassword: "+ iPassword + "\nPermissions: "
						+ iPermissions + "\nFlags: " + iFlags + "\n\n",
						"Question",
						JOptionPane.YES_NO_OPTION,
						JOptionPane.QUESTION_MESSAGE,
						null,
						options,
						options[0]);
				
				if(n == 0){
					Client.processMessage(sendme);
					JOptionPane.showMessageDialog(null, "Account " + iName + " has been created!");
					LoadedAccounts++;
					inID.setText(String.valueOf(LoadedAccounts));
					AddAccountWindowActive = false;
				}else{
					JOptionPane.showMessageDialog(null, "Accont creation aborted!");
					LoadedAccounts--;
					inID.setText(String.valueOf(LoadedAccounts));
					AddAccountWindowActive = false;
				}
			}
		}
	}
	
	
}
