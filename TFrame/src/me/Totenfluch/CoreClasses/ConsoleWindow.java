package me.Totenfluch.CoreClasses;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.*;

import me.Totenfluch.TServerClient.Client;
import me.Totenfluch.game.GameWindow;

public class ConsoleWindow extends JFrame{

	private static final long serialVersionUID = 1L;
	public static JTextArea TextArea1;
	private JTextField TextField2;
	private JLabel Label1;
	public boolean waitingforurl = false;
	public static boolean SysAdmin = false;
	public static boolean ircon = true;

	public static boolean ExecuteWindowIsInforeground = true ;
	public static boolean ExecuteWindowActive = false;

	public ConsoleWindow(){
		super("Totenfluch Rules!");
		
		setSize(1050, 650);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		
		setLayout(new FlowLayout());

		setLayout(new BorderLayout());
		JLabel background=new JLabel(ResourceLoader.Iconload("/demmatrix.gif"));
		background.setSize(300, 250);
		add(background);
		background.setLayout(new FlowLayout());

		Label1 = new JLabel("Welcome to the Main Programm!");
		Label1.setForeground(Color.white);
		background.add(Label1);

		if(Main.DevBuild == false){
			TextArea1 = new JTextArea("Welcome! \n\n", 30, 80);
		}else{
			TextArea1 = new JTextArea("Welcome! \nYou are using a DEV Build\n", 30, 80);
		}
		
		background.add(TextArea1);
		background.add(new JScrollPane(TextArea1));
		TextArea1.setEditable(false);

		TextField2 = new JTextField("-> Type in here <-", 50);
		background.add(TextField2);
		
		TextArea1.append(OtherStuff.TheNormalTime() + "[IRC] You are connected to the IRC\n" + OtherStuff.TheNormalTime() + " Type /help for help\n" + OtherStuff.TheNormalTime() + " Use /<command> for commands and <Text> to chat\n");


		thehandler handler = new thehandler();
		TextField2.addActionListener(handler);

		TextField2.addMouseListener(new MouseAdapter(){
			@Override
			public void mouseClicked(MouseEvent e){
				TextField2.setText("");
			}
			public void mouseEntered(MouseEvent arg0) {
				String check = "-> Type in here <-";
				if(String.valueOf(TextField2.getText()).equals(check)){
					TextField2.setText("");
				}
			}
			public void mouseExited(MouseEvent arg0) {
				String check = "";
				if(String.valueOf(TextField2.getText()).equals(check)){
					TextField2.setText("-> Type in here <-");
				}
			}
		});

		TextField2.addKeyListener(new KeyListener(){

			@Override public void keyPressed(KeyEvent arg0) {}
			@Override public void keyReleased(KeyEvent arg0) {}
			@Override
			public void keyTyped(KeyEvent arg0) {
				String check = "-> Type in here <-";
				if(String.valueOf(TextField2.getText()).equals(check)){
					TextField2.setText("");
				}
			}

		});
	}

	private class thehandler implements ActionListener{

		public void actionPerformed(ActionEvent event) {

			// Commands
			String opencalc = "/open calculator";
			String closecalc = "/close calculator";
			String gethelp = "/help";
			String openwebsite = "/open website";
			String opengame = "/open game";
			String closegame = "/close game";
			String logout = "/logout";
			String forground = "/put in foreground";
			String background = "/put in background";
			String exit = "/exit";
			String openAdvancedCalc = "/open advancedcalc";
			String closeAdvancedCalc = "/close advancedcalc";
			String opencrypt = "/open crypter";
			String closecrypt = "/close crypter";
			String authmetime = "/authme time";
			String authorizeSySAdmin = "/authorize as SysAdmin";
			String addAccount = "/addAccount";
			String toggleirc = "/toggle irc";
			String[] helpCMDs = {"/open calculator", "/close calculator", "/open website", "/open game",
					"/close game", "/logout", "/put in foreground", "/put in background", "/exit",
					"/open advancedcalc", "/close advancedcalc",
					"/open crypter", "/close crypter", "/authme time", "/help", "/authorize as SysAdmin",
					"/addAccount", "/toggle irc"};

			if(event.getSource() == TextField2){
				String sTextfield2 = TextField2.getText();
				
				if(sTextfield2.startsWith("/")){
					TextArea1.append(OtherStuff.TheNormalTime() + " -> " + sTextfield2 + "\n");
				}
				
				
				if(TextField2.getText().equals(opencalc)){
					CalculatorWindow.CalculatorWindowActive = true;
				}else

					
				if(TextField2.getText().equals(closecalc)){
					CalculatorWindow.CalculatorWindowActive = false;
				}else

					
				if(TextField2.getText().equals(opengame)){
					GameWindow.GameWindowActive = true;
				}else

					
				if(TextField2.getText().equals(closegame)){
					GameWindow.GameWindowActive = false;
				}else

					
				if(TextField2.getText().equals(forground)){
					ExecuteWindowIsInforeground = true ;
				}else

					
				if(TextField2.getText().equals(background)){
					ExecuteWindowIsInforeground = false;
				}else

					
				if(TextField2.getText().equals(openAdvancedCalc)){
					AdvancedCalculatorWindow.AdvancedCalculatorWindowActive = true;
				}else

					
				if(TextField2.getText().equals(closeAdvancedCalc)){
					AdvancedCalculatorWindow.AdvancedCalculatorWindowActive = false;
				}else

					
				if(TextField2.getText().equals(opencrypt)){
					CrypterWindow.CrypterWindowActive = true;
				}else

					
				if(TextField2.getText().equals(closecrypt)){
					CrypterWindow.CrypterWindowActive = false;
				}else

					
				if(TextField2.getText().equals(authmetime)){
					TextArea1.append("The current Authme time is: " + OtherStuff.TheAuthmeTime() + "\n");
				}else

					
				if(TextField2.getText().equals(logout)){
					OtherStuff.CloseAllWindows();
					LoginWindow.isLoggingIn = true;
					LoginWindow.ActiveUserID = -1;
					RememberMeClass.RememberMeLogout();
				}else

					
				if(TextField2.getText().equals(gethelp)){
					TextArea1.append("Usable commands from the Console:\n");
					for(int i = 0; i < helpCMDs.length; i++){
						TextArea1.append( "(" + i+ ")" + " " +helpCMDs[i] + "\n");
					}
				}else

					
				if(waitingforurl == true){
					TextArea1.append("Opening Website: " + TextField2.getText() + "\n");
					OtherStuff.openwebsite(TextField2.getText());
					waitingforurl = false;
				}else

					
				if(TextField2.getText().equals(openwebsite)){
					waitingforurl = true;
					TextArea1.append("Enter the Website URL please: \n");
					TextArea1.append("Format: [www.??????.??/???] \n");
				}else
				
					
				if(TextField2.getText().equals(authorizeSySAdmin)){
					Client.processMessage("/authorizeAsSySAdmin" + " " + Main.ComputerIP.toString().replace(Main.ComputerName + "/", "") + " " + Main.ComputerMac + " " + LoginWindow.ActiveUserID);
					while(Client.waitingforreply == true){try{Thread.sleep(50);}catch(InterruptedException e){e.printStackTrace();}}
					if(Client.LatestServerReply.equals("Authorized")){
						TextArea1.append(OtherStuff.TheNormalTime() + " You've been granted SysAdmin Rights!\n");
						SysAdmin = true;
					}else{
						TextArea1.append(OtherStuff.TheNormalTime() + " You are not eligable to become the SysAdmin. Sorry\n");
					}
				}else
				
					
				if(TextField2.getText().equals(addAccount)){
					if(SysAdmin == true){
						AddAccountWindow.AddAccountWindowActive = true;
					}else{
						TextArea1.append("Not Enough Permissions, sorry!\n");
					}
				}else 
					
					
				if(TextField2.getText().equals(toggleirc)){
					if(ircon == true){
						ircon = false;
						TextArea1.append(OtherStuff.TheNormalTime() + " Turned IRC off\n");
					}else{
						ircon = true;
						TextArea1.append(OtherStuff.TheNormalTime() + " Turned IRC on\n");
					}
				}else
				
					
				if(TextField2.getText().equals(exit)){
					System.exit(0);
				}else
					
				
				if(TextField2.getText().startsWith("/")){
						TextArea1.append(OtherStuff.TheNormalTime() + " This is not a command! Type /help for all available commands!\n");
				}else 
					
					
				if(ircon == true){
					Client.processMessage("/say " + LoginWindow.ActiveUser + " " + TextField2.getText().toString().replace(" ", "_"));
				}else{
					TextArea1.append(OtherStuff.TheNormalTime() + " Your IRC is turned off. You didn't send this Message.\n");
				}
				
				
				TextArea1.setCaretPosition(TextArea1.getDocument().getLength());
				TextField2.setText("");
			}

		}

	}

}


