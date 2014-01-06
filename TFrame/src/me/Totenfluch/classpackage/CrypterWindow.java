package me.Totenfluch.classpackage;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class CrypterWindow extends JFrame{
	private static final long serialVersionUID = 1L;
	public static boolean CrypterWindowActive = false;
	private JTextField Input;
	private JTextField Encrypted;
	private JTextField Decrypted;
	private JButton CryptButton;


	public CrypterWindow(){
		setTitle("Crypter Window");
		setSize(300, 150);
		setVisible(false);
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setLocationRelativeTo(null);
		setResizable(false);
		
		setLayout(new BorderLayout());
		JLabel background=new JLabel(ResourceLoader.Iconload("/Dragon.jpg"));
		background.setSize(300, 150);
		add(background);
		background.setLayout(new FlowLayout());


		Input = new JTextField("Input in here", 20);
		background.add(Input);

		Encrypted = new JTextField("Encrypted Text in here", 20);
		Encrypted.setEditable(false);
		Encrypted.setForeground(Color.GREEN);
		background.add(Encrypted);

		Decrypted = new JTextField("Decrypted Text in here",20);
		Decrypted.setEditable(false);
		Encrypted.setForeground(Color.RED);
		background.add(Decrypted);

		CryptButton = new JButton("Crypt");
		background.add(CryptButton);

		thehandler handler = new thehandler();
		Input.addActionListener(handler);
		Encrypted.addActionListener(handler);
		Decrypted.addActionListener(handler);
		CryptButton.addActionListener(handler);

	}


	private class thehandler implements ActionListener{

		public void actionPerformed(ActionEvent event) {
			if(event.getSource() == CryptButton){
				String input = Input.getText();
				Encrypted.setText(DataCrypter.encrypt(input));
				Decrypted.setText(DataCrypter.decrypt3(input));
			}

		}
	}

}
