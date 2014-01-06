package me.Totenfluch.CoreClasses;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import me.Totenfluch.TServerClient.Client;
import me.Totenfluch.game.GameWindow;

public class LoginWindow extends JFrame{

	public static String E1 = "Error#1\nAccount is allready in Use!";
	// Account already in use
	public static String E2 = "Error#2\nLogin Informations Wrong";
	// Tickboxes wrong
	public static String E3 = "Error#3\nLogin Informations Wrong";
	// Password
	public static String E4 = "Error#4\nLogin Informations Wrong";
	// code is wrong
	public static String E5 = "Error#5\nLogin Informations Wrong";
	// name is wrong
	public static String E6 = "Error#6\nNot enough Permissions for this Section";
	// not enough Permissions
	public static String E7 = "Error#7\nYou Account has been banned";
	// account banned
	public static String E8 = "Error#8\nAuthentificator needed";
	// Authentificator needed, not rly an error


	public static boolean isLoggingIn = true;
	private static final long serialVersionUID = 1L;
	static boolean getLoginFile = false;
	public static int ActiveUserID;
	public static JTextField TextField1;
	private JTextField TextField2;
	private JTextField TextField3;
	private JPasswordField PasswordField1;
	private JButton Jbutton1;
	private JLabel Label1;
	private JLabel ASCIIofTheDay;
	private JLabel ProgrammInfo;
	private JCheckBox CheckBox1;
	private JCheckBox CheckBox2;
	private JCheckBox CheckBox3;
	private JCheckBox CheckBox4;
	private JCheckBox CheckBox5;
	private JCheckBox CheckBox6;
	private JCheckBox CheckBox7;
	private JCheckBox CheckBox8;
	private JCheckBox CheckBox9;
	private JCheckBox CheckBox10;
	@SuppressWarnings("rawtypes")
	private JComboBox ComboBoxLoginChooser;
	private JLabel RememberMeLabel;
	public static JCheckBox RememberMeCheckBox;
	private JButton Register;
	public static String strue = "true";
	public static String sfalse = "false";
	public static int LoginIDBuffer = -1 ;

	/*
	 * Flags:
	 * a -> Account Banned
	 * b -> Account flagged for Authentificator
	 * c -> Account temporarly disabled
	 * d -> Special notice on login
	 * 
	 * 
	 * 
	 * 
	 * 
	 */

	public static int verificationcode = OtherStuff.randInt(1, 9);

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public LoginWindow(){
		super("Login process");

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(300, 300);
		setLocationRelativeTo(null);
		setResizable(false);

		setLayout(new BorderLayout());
		JLabel background=new JLabel(ResourceLoader.Iconload("/Dragon.jpg"));
		background.setSize(300, 300);
		add(background);
		background.setLayout(new FlowLayout());


		Label1 = new JLabel("Enter your Informations to login!");
		Label1.setForeground(Color.white);
		Label1.setFont(new Font("Serif", Font.BOLD, 20));
		background.add(Label1);

		ASCIIofTheDay = new JLabel("Session ID : " + OtherStuff.randInt(10000000, 99999999) + verificationcode + OtherStuff.randInt(10, 99) + "");
		ASCIIofTheDay.setForeground(Color.magenta);
		Label1.setFont(new Font("Serif", Font.BOLD, 20));
		background.add(ASCIIofTheDay);


		TextField1 = new JTextField("UserID", 25);
		TextField1.addKeyListener(new KeyAdapterNumbersOnly());
		background.add(TextField1);

		TextField2 = new JTextField("Username", 25);
		background.add(TextField2);

		TextField3 = new JTextField("Verification Code", 25);
		TextField3.addKeyListener(new KeyAdapterNumbersOnly());
		background.add(TextField3);

		PasswordField1 = new JPasswordField("Password", 25);
		background.add(PasswordField1);

		CheckBox1 = new JCheckBox();
		CheckBox1.setBackground(Color.BLACK);
		background.add(CheckBox1);

		CheckBox2 = new JCheckBox();
		CheckBox2.setBackground(Color.BLACK);
		background.add(CheckBox2);

		CheckBox3 = new JCheckBox();
		CheckBox3.setBackground(Color.BLACK);
		background.add(CheckBox3);

		CheckBox4 = new JCheckBox();
		CheckBox4.setBackground(Color.BLACK);
		background.add(CheckBox4);

		CheckBox5 = new JCheckBox();
		CheckBox5.setBackground(Color.BLACK);
		background.add(CheckBox5);

		CheckBox6 = new JCheckBox();
		CheckBox6.setBackground(Color.BLACK);
		background.add(CheckBox6);

		CheckBox7 = new JCheckBox();
		CheckBox7.setBackground(Color.BLACK);
		background.add(CheckBox7);

		CheckBox8 = new JCheckBox();
		CheckBox8.setBackground(Color.BLACK);
		background.add(CheckBox8);

		CheckBox9 = new JCheckBox();
		CheckBox9.setBackground(Color.BLACK);
		background.add(CheckBox9);

		CheckBox10 = new JCheckBox();
		CheckBox10.setBackground(Color.BLACK);
		background.add(CheckBox10);

		String[] options = {"Console", "Calculator", "Game", "Advanced_Calculator", "Crypter" };
		ComboBoxLoginChooser = new JComboBox(options);
		background.add(ComboBoxLoginChooser);

		Jbutton1 = new JButton("Login");
		background.add(Jbutton1);

		RememberMeLabel = new JLabel("Remeber me");
		RememberMeLabel.setForeground(Color.white);
		RememberMeLabel.setFont(new Font("Serif", Font.BOLD, 15));
		background.add(RememberMeLabel);

		RememberMeCheckBox = new JCheckBox();
		RememberMeCheckBox.setBackground(Color.BLACK);
		background.add(RememberMeCheckBox);

		Register = new JButton(" -Register Beta Account- ");
		Register.setEnabled(false);
		background.add(Register);

		ProgrammInfo = new JLabel("You are running TFrame on Version " + Main.Version + " © Totenfluch");
		ProgrammInfo.setForeground(Color.white);
		ProgrammInfo.setFont(new Font("Serif", Font.BOLD, 10));
		background.add(ProgrammInfo);

		thehandler handler = new thehandler();
		TextField1.addActionListener(handler);
		TextField2.addActionListener(handler);
		TextField3.addActionListener(handler);
		PasswordField1.addActionListener(handler);
		Jbutton1.addActionListener(handler);
		RememberMeCheckBox.addActionListener(handler);

		TextField1.addKeyListener(new KeyListener(){

			@Override public void keyPressed(KeyEvent arg0) {}
			@Override public void keyReleased(KeyEvent arg0) {}
			@Override
			public void keyTyped(KeyEvent arg0) {
				String check = "UserID";
				if(TextField1.getText().equals(check)){
					TextField1.setText("");
				}
			}

		});
		TextField2.addKeyListener(new KeyListener(){

			@Override public void keyPressed(KeyEvent arg0) {}
			@Override public void keyReleased(KeyEvent arg0) {}
			@Override
			public void keyTyped(KeyEvent arg0) {
				String check = "Username";
				if(TextField2.getText().equals(check)){
					TextField2.setText("");
				}
			}

		});
		TextField3.addKeyListener(new KeyListener(){

			@Override public void keyPressed(KeyEvent arg0) {}
			@Override public void keyReleased(KeyEvent arg0) {}
			@Override
			public void keyTyped(KeyEvent arg0) {
				String check = "Verification Code";
				if(TextField3.getText().equals(check)){
					TextField3.setText("");
				}
			}

		});
		PasswordField1.addKeyListener(new KeyListener(){

			@Override public void keyPressed(KeyEvent arg0) {}
			@Override public void keyReleased(KeyEvent arg0) {}
			@Override
			public void keyTyped(KeyEvent arg0) {
				String check = "Password";
				if(String.valueOf(PasswordField1.getPassword()).equals(check)){
					PasswordField1.setText("");
				}
			}

		});
		TextField1.addMouseListener(new MouseAdapter(){
			@Override
			public void mouseClicked(MouseEvent e){
				String check = "UserID";
				if(TextField1.getText().equals(check)){
					TextField1.setText("");
				}
			}

			public void mouseEntered(MouseEvent arg0) {
				String check = "UserID";
				if(TextField1.getText().equals(check)){
					TextField1.setText("");
				}

			}

			public void mouseExited(MouseEvent arg0) {
				String check = "";
				if(TextField1.getText().equals(check)){
					TextField1.setText("UserID");
				}
			}
		});
		TextField2.addMouseListener(new MouseAdapter(){
			@Override
			public void mouseClicked(MouseEvent e){
				String check = "Username";
				if(TextField2.getText().equals(check)){
					TextField2.setText("");
				}
			}

			public void mouseEntered(MouseEvent arg0) {
				String check = "Username";
				if(TextField2.getText().equals(check)){
					TextField2.setText("");
				}

			}

			public void mouseExited(MouseEvent arg0) {
				String check = "";
				if(TextField2.getText().equals(check)){
					TextField2.setText("Username");
				}
			}
		});
		TextField3.addMouseListener(new MouseAdapter(){
			@Override
			public void mouseClicked(MouseEvent e){
				String check = "Verification Code";
				if(TextField3.getText().equals(check)){
					TextField3.setText("");
				}
			}

			public void mouseEntered(MouseEvent arg0) {
				String check = "Verification Code";
				if(TextField3.getText().equals(check)){
					TextField3.setText("");
				}

			}

			public void mouseExited(MouseEvent arg0) {
				String check = "";
				if(TextField3.getText().equals(check)){
					TextField3.setText("Verification Code");
				}
			}
		});
		PasswordField1.addMouseListener(new MouseAdapter(){
			@Override
			public void mouseClicked(MouseEvent e){
				String check = "Password";
				if((String.valueOf(PasswordField1.getPassword()).equals(check))){
					PasswordField1.setText("");
				}
			}

			public void mouseEntered(MouseEvent arg0) {
				String check = "Password";
				if((String.valueOf(PasswordField1.getPassword()).equals(check))){
					PasswordField1.setText("");
				}

			}

			public void mouseExited(MouseEvent arg0) {
				String check = "";
				if((String.valueOf(PasswordField1.getPassword()).equals(check))){
					PasswordField1.setText("Password");
				}
			}
		});
	}

	private class thehandler implements ActionListener{

		public void actionPerformed(ActionEvent event) {

			// Override Login Start
			if(event.getSource() == TextField1 && Main.DevBuild == true){
				OtherStuff.LoginID[0] = "0";
				LoginWindow.isLoggingIn = false;
				ConsoleWindow.ExecuteWindowActive = true;
				ConsoleWindow.TextArea1.append(OtherStuff.TheNormalTime() + " (override Login)\n");
			}
			// Override Login End

			if(event.getSource() == Jbutton1){
				String sTextfield1 = TextField1.getText();
				String sTextfield2 = TextField2.getText();
				String sTextfield3 = TextField3.getText();
				int LoginCodeInput = -1;
				int verificationcopdeInput = 0;
				if (sTextfield3.matches("[0-9]+") && sTextfield1.matches("[0-9]+")){
					LoginCodeInput = Integer.parseInt(sTextfield1);
					LoginIDBuffer = LoginCodeInput;
					verificationcopdeInput = Integer.parseInt(sTextfield3);
				}else{
					sTextfield3 = "1";
					sTextfield1 = "1";
					JOptionPane.showMessageDialog(null, "Your LoginID/Verification Code needs to be a Number!");
					TextField1.setText("UserID");
					TextField3.setText("Verification Code");
				}
				if(LoginCodeInput > 9999){
					JOptionPane.showMessageDialog(null, "Your LoginID can't be that high!");
					LoginCodeInput = -1;
				}
				char[] sPasswordfield = PasswordField1.getPassword();

				String checkboxes = "";
				if(CheckBox1.isSelected() == true){
					checkboxes+= 1;
				}
				if(CheckBox2.isSelected() == true){
					checkboxes+= 2;
				}
				if(CheckBox3.isSelected() == true){
					checkboxes+= 3;
				}
				if(CheckBox4.isSelected() == true){
					checkboxes+= 4;
				}
				if(CheckBox5.isSelected() == true){
					checkboxes+= 5;
				}
				if(CheckBox6.isSelected() == true){
					checkboxes+= 6;
				}
				if(CheckBox7.isSelected() == true){
					checkboxes+= 7;
				}
				if(CheckBox8.isSelected() == true){
					checkboxes+= 8;
				}
				if(CheckBox9.isSelected() == true){
					checkboxes+= 9;
				}
				if(CheckBox10.isSelected() == true){
					checkboxes+= 10;
				}

				Client.processMessage("/login " + LoginCodeInput + " " + sTextfield2.toString() + " " + verificationcopdeInput + " " + verificationcode + " " + String.valueOf(sPasswordfield) + " " + checkboxes + " " + ComboBoxLoginChooser.getSelectedItem());
				while(Client.waitingforreply == true){try{Thread.sleep(50);}catch(InterruptedException e){e.printStackTrace();}}
				if(OtherStuff.LatestServerReply().equals("true")){

					if(ComboBoxLoginChooser.getSelectedItem().equals("Console") && Integer.parseInt(OtherStuff.LoginPermissions[LoginCodeInput]) >= 1000){
						ActiveUserID = Integer.parseInt(TextField1.getText());
						if(RememberMeCheckBox.isSelected()){
							RememberMeClass.RememberMeSave(RememberMeCheckBox.isSelected(), LoginCodeInput, sTextfield2.toString(), verificationcopdeInput, String.valueOf(sPasswordfield), checkboxes, ComboBoxLoginChooser.getSelectedItem().toString());
						}else{
							RememberMeClass.RememberMeLogout();
						}
						JOptionPane.showMessageDialog(null, "Welcome back, " + OtherStuff.LoginName[ActiveUserID]+ " !\n");
						ConsoleWindow.TextArea1.append(OtherStuff.TheNormalTime() + " You logged in as" + OtherStuff.LoginName[ActiveUserID]+ "!\n");
						ConsoleWindow.TextArea1.append(OtherStuff.TheNormalTime() + " Your Permissions Level is at " + OtherStuff.LoginPermissions[ActiveUserID]+ " / 1000 !\n");
						ConsoleWindow.ExecuteWindowActive = true ;
						LoginWindow.isLoggingIn = false;

					}

					isLoggingIn = false;
				}else if(OtherStuff.LatestServerReply().equals("Authentificator needed")){
					JOptionPane.showMessageDialog(null, "Your Account has been flagged for the use of an Authentificator!");
					ConsoleWindow.ExecuteWindowActive = false;
					CalculatorWindow.CalculatorWindowActive = false;
					GameWindow.GameWindowActive = false;
					LoginWindow.isLoggingIn = false;
					AuthentificatorInWindow.AuthentificatorWindowActive = true;

				}else{

					if(Main.DevBuild == false){
						JOptionPane.showMessageDialog(null, "Unable to Login. " + "(" + OtherStuff.LatestServerReply() + ")");
					}
				}

				TextField1.setText("UserID");
				TextField2.setText("Username");
				TextField3.setText("Verification Code");
				PasswordField1.setText("Password");
				CheckBox1.setSelected(false);
				CheckBox2.setSelected(false);
				CheckBox3.setSelected(false);
				CheckBox4.setSelected(false);
				CheckBox5.setSelected(false);
				CheckBox6.setSelected(false);
				CheckBox7.setSelected(false);
				CheckBox8.setSelected(false);
				CheckBox9.setSelected(false);
				CheckBox10.setSelected(false);
			}
			
		}

	}

}


