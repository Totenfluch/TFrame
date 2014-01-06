/*
 * 
 * 
 * 
 * 
 * 
 * Copyright @ Totenfluch
 * aka. Christian Ziegler
 * 
 * 
 * 
 * 
 * 
 */


package me.Totenfluch.classpackage;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.UnknownHostException;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import me.Totenfluch.TServerClient.Client;
import me.Totenfluch.TServerClient.GetServerMessages;
import me.Totenfluch.game.GameWindow;

public class Main {

	public static int Version = 11;
	public static int AllowedVersion;
	public static String ComputerName;
	public static InetAddress ComputerIP = null;
	public static String ComputerMac = "ERRORID";
	public static boolean DevBuild = false;

	public static void main(String[] args){

		/*OtherStuff.GetVersion();
		if(AllowedVersion == -1){
			JOptionPane.showMessageDialog(null, "Shutting down. \n(1) You are not connected to the Internet \n(2) You are Trying to cheat the Programm. \n(3) The Administrator messed something up.");
			System.exit(1);
		}else if(Version != AllowedVersion){
			JOptionPane.showMessageDialog(null, "Invalid Program Version!");
			System.exit(1);
		}*/

		boolean checkconditions = true;
		java.net.URL imageURL = Main.class.getResource("/GlobeIcon.png");
		ImageIcon img = null;
		if (imageURL != null) {
			img = new ImageIcon(imageURL);
		}

		try {
			ComputerIP = InetAddress.getLocalHost();
		} catch (UnknownHostException e1) {
			e1.printStackTrace();
		}
		ComputerMac = OtherStuff.getMacAdress();
		ComputerName = ComputerIP.getHostName();

		ConnectingWindow connectframe = new ConnectingWindow();
		connectframe.setIconImage(img.getImage());
		connectframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		LoginWindow loginframe = new LoginWindow();
		loginframe.setIconImage(img.getImage());
		loginframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		ConsoleWindow executeframe = new ConsoleWindow();
		executeframe.setIconImage(img.getImage());
		executeframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		CalculatorWindow CalculatorFrame = new CalculatorWindow();
		CalculatorFrame.setIconImage(img.getImage());
		CalculatorFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		GameWindow GameFrame = new GameWindow();
		GameFrame.setIconImage(img.getImage());
		GameFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		AdvancedCalculatorWindow AdvancedCalculatorFrame = new AdvancedCalculatorWindow();
		AdvancedCalculatorFrame.setIconImage(img.getImage());
		AdvancedCalculatorFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		CrypterWindow CrypterFrame = new CrypterWindow();
		CrypterFrame.setIconImage(img.getImage());
		CrypterFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		AuthentificatorInWindow AuthentificatorInFrame = new AuthentificatorInWindow();
		AuthentificatorInFrame.setIconImage(img.getImage());
		AuthentificatorInFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		AddAccountWindow AddAccountFrame = new AddAccountWindow();
		AddAccountFrame.setIconImage(img.getImage());
		AddAccountFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


		CalculatorFrame.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent event) {
				CalculatorWindow.CalculatorWindowActive = false;
				ConsoleWindow.TextArea1.append("You closed the Calculator Window: Shutting it down.\n");
				if(ConsoleWindow.ExecuteWindowActive == false){
					System.exit(1);
				}
			}
		});

		GameFrame.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent event) {
				GameWindow.GameWindowActive = false;
				ConsoleWindow.TextArea1.append("You closed the Game Window: Shutting it down.\n");
				if(ConsoleWindow.ExecuteWindowActive == false){
					System.exit(1);
				}
			}
		});

		AdvancedCalculatorFrame.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent event) {
				AdvancedCalculatorWindow.AdvancedCalculatorWindowActive = false;
				ConsoleWindow.TextArea1.append("You closed the AdvancedCalculator Window: Shutting it down.\n");
				if(ConsoleWindow.ExecuteWindowActive == false){
					System.exit(1);
				}
			}
		});

		CrypterFrame.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent event) {
				CrypterWindow.CrypterWindowActive = false;
				ConsoleWindow.TextArea1.append("You closed the Crypter Window: Shutting it down.\n");
				if(ConsoleWindow.ExecuteWindowActive == false){
					System.exit(1);
				}
			}
		});

		AuthentificatorInFrame.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent event) {
				AuthentificatorInWindow.AuthentificatorWindowActive = false;
				ConsoleWindow.TextArea1.append("You closed the Authentificator Window: Shutting it down.\n");
				if(ConsoleWindow.ExecuteWindowActive == false){
					System.exit(1);
				}
			}
		});

		Runtime.getRuntime().addShutdownHook(new Thread() {
			public void run() {
				if(LoginWindow.isLoggingIn == false){
					Client.processMessage("/logout " + OtherStuff.LoginID[LoginWindow.ActiveUserID] + " " + OtherStuff.LoginName[LoginWindow.ActiveUserID]);
					try {
						Thread.sleep(50);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					System.exit(0);
				}
			}
		});


		// Updating

		if(LoginWindow.getLoginFile == false){
			OtherStuff.GetLoginCredicals();
			LoginWindow.getLoginFile = true;
		}

		String host = "188.194.13.44";
		int port = Integer.parseInt("9987");
		final Client chatframe = new Client(host, port);

		if(DevBuild == true){
			chatframe.setVisible(true);
		}else{
			chatframe.setVisible(false);
		}
		chatframe.setIconImage(img.getImage());

		/*chatframe.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent event) {
				System.exit(1);
			}
			public void windowDeiconified(WindowEvent e){
				chatframe.setExtendedState(1);
			}
		});*/

		Client.processMessage("/getversion");
		while(Client.waitingforreply == true){try{Thread.sleep(50);}catch(InterruptedException e){e.printStackTrace();}}

		if(!OtherStuff.LatestServerReply().equals(String.valueOf(Version))){
			JOptionPane.showMessageDialog(null, "-> Your Programm is not up to date or the Server was not up in Time. <-\n-> Your are using Version " +
					Version +"\n-> The Allowed Version is " + OtherStuff.LatestServerReply() +
					"\n-> If both Numbers are the same, It's the Server - Ignore this Message and Press OK\n Download the newest Version here:\nhttps://dl.dropboxusercontent.com/u/88851086/TFrame.jar");
			if(!OtherStuff.LatestServerReply().equals(String.valueOf(Version))){
				OtherStuff.openwebsite("https://dl.dropboxusercontent.com/u/88851086/TFrame.jar");
				System.exit(1);
			}
		}

		Client.processMessage("/getLoadedAccounts");
		while(Client.waitingforreply == true){try{Thread.sleep(50);}catch(InterruptedException e){e.printStackTrace();}}
		AddAccountWindow.LoadedAccounts = Integer.valueOf(OtherStuff.LatestServerReply());
		AddAccountWindow.inID.setText(String.valueOf(AddAccountWindow.LoadedAccounts));

		String autologin = "";
		String sendme = null;
		try {
			sendme = RememberMeClass.RememberMeLogin();
		} catch (Exception e1) {
			e1.printStackTrace();
			sendme = "nop";
		}
		if(!autologin.equals("nop")){
			Client.processMessage(sendme);
			while(Client.waitingforreply == true){try{Thread.sleep(50);}catch(InterruptedException e){e.printStackTrace();}}
			if(OtherStuff.LatestServerReply().equals("true")){
				JOptionPane.showMessageDialog(null, "Welcome back, " + OtherStuff.LoginName[LoginWindow.ActiveUserID]+ " !\n");
				ConsoleWindow.TextArea1.append(OtherStuff.TheNormalTime() + " You Auto-logged in as" + OtherStuff.LoginName[LoginWindow.ActiveUserID]+ "!\n");
				ConsoleWindow.TextArea1.append(OtherStuff.TheNormalTime() + " Type: /logout to cancel your Auto-login\n"); 
				ConsoleWindow.TextArea1.append(OtherStuff.TheNormalTime() + " Your Permissions Level is at " + OtherStuff.LoginPermissions[LoginWindow.ActiveUserID]+ " / 1000 !\n");
				ConsoleWindow.ExecuteWindowActive = true ;
				LoginWindow.isLoggingIn = false;
			}
		}

		int checkconditionsamount = 595;
		while(checkconditions == true){
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}


			if((ConnectingWindow.connectionwindowactive == true && connectframe.isVisible() == false) || GetServerMessages.reconnecting == true){
				connectframe.setVisible(true);
			}else if(ConnectingWindow.connectionwindowactive == false && connectframe.isVisible() == true && Client.IsConnectedToServer == true){
				connectframe.setVisible(false);
			}

			if(LoginWindow.isLoggingIn == true && loginframe.isVisible() == false && ConnectingWindow.connectionwindowactive == false && Client.IsConnectedToServer == true){
				loginframe.setVisible(true);
			}else if(LoginWindow.isLoggingIn == false && loginframe.isVisible() == true && ConnectingWindow.connectionwindowactive == false){
				loginframe.setVisible(false);
			}

			if(ConsoleWindow.ExecuteWindowActive == true && executeframe.isVisible() == false){
				executeframe.setVisible(true);
			}else if(ConsoleWindow.ExecuteWindowActive == false && executeframe.isVisible() == true){
				executeframe.setVisible(false);
			}

			if(CalculatorWindow.CalculatorWindowActive == true && CalculatorFrame.isVisible() == false){
				CalculatorFrame.setVisible(true);
			}else if(CalculatorWindow.CalculatorWindowActive == false && CalculatorFrame.isVisible() == true){
				CalculatorFrame.setVisible(false);
			}

			if(GameWindow.GameWindowActive == true && GameFrame.isVisible() == false){
				GameFrame.setVisible(true);
			}else if(GameWindow.GameWindowActive == false && GameFrame.isVisible() == true){
				GameFrame.setVisible(false);
			}

			if(AdvancedCalculatorWindow.AdvancedCalculatorWindowActive == true && AdvancedCalculatorFrame.isVisible() == false){
				AdvancedCalculatorFrame.setVisible(true);
			}else if(AdvancedCalculatorWindow.AdvancedCalculatorWindowActive == false && AdvancedCalculatorFrame.isVisible() == true){
				AdvancedCalculatorFrame.setVisible(false);
			}

			if(CrypterWindow.CrypterWindowActive == true && CrypterFrame.isVisible() == false){
				CrypterFrame.setVisible(true);
			}else if(CrypterWindow.CrypterWindowActive == false && CrypterFrame.isVisible() == true){
				CrypterFrame.setVisible(false);
			}

			if(AuthentificatorInWindow.AuthentificatorWindowActive == true && AuthentificatorInFrame.isVisible() == false){
				AuthentificatorInFrame.setVisible(true);
			}else if(AuthentificatorInWindow.AuthentificatorWindowActive == false && AuthentificatorInFrame.isVisible() == true){
				AuthentificatorInFrame.setVisible(false);
			}

			if(AddAccountWindow.AddAccountWindowActive == true && AddAccountFrame.isVisible() == false){
				AddAccountFrame.setVisible(true);
			}else if(AddAccountWindow.AddAccountWindowActive == false && AddAccountFrame.isVisible() == true){
				AddAccountFrame.setVisible(false);
			}

			if(ConsoleWindow.ExecuteWindowIsInforeground == true && executeframe.isAlwaysOnTop() == false){
				executeframe.setAlwaysOnTop(true);
			}else if(ConsoleWindow.ExecuteWindowIsInforeground == false && executeframe.isAlwaysOnTop() == true){
				executeframe.setAlwaysOnTop(false);
			}

			if(GetServerMessages.reconnecting == true && Client.IsConnectedToServer == false){
				chatframe.setVisible(false);
				chatframe.dispose();
				chatframe.removeAll();

				final Client chatframe2 = new Client(host, port);
				chatframe2.setSize(900, 600);
				chatframe2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				chatframe2.setExtendedState(1);
				chatframe2.setVisible(true);
				chatframe2.setIconImage(img.getImage());

				ConnectingWindow.reconnecting.setText("Server Connection lost: Reconnecting...");
				if(Client.IsConnectedToServer == false){
					ConnectingWindow.connectionwindowactive = true;
				}else{
					ConnectingWindow.connectionwindowactive = false;
					LoginWindow.isLoggingIn = true;
				}

				OtherStuff.CloseAllWindows();
				System.out.println("Reconnecting started!");
			}



			int x = OtherStuff.intTheAuthmeTime();

			double firstposy =  Math.pow(x, 2) + x*AuthentificatorInWindow.SecretKey;
			int firstposxy = (int) Math.abs(Math.floor(firstposy/100));

			double secoundposy = Math.pow(x, 3) + x*AuthentificatorInWindow.SecretKey2;
			int secoundposxy = (int) Math.abs(Math.floor(secoundposy/100));

			String validkey = String.valueOf(firstposxy) + String.valueOf(secoundposxy);
			AuthentificatorInWindow.ValidKey = Double.parseDouble(validkey);

			checkconditionsamount++;
			if(checkconditionsamount >= 600){

				try {
					String line;
					Process p = Runtime.getRuntime().exec
							(System.getenv("windir") +"\\system32\\"+"tasklist.exe");
					BufferedReader input =
							new BufferedReader(new InputStreamReader(p.getInputStream()));
					while ((line = input.readLine()) != null) {
						if(line.contains("cheatengine")){
							Client.processMessage("/IamUsingCheatEngine");
							Thread.sleep(100);
							System.exit(0);
						}
					}
					input.close();
				} catch (Exception err) {
					err.printStackTrace();
				}

				Client.processMessage("/getversion");
				while(Client.waitingforreply == true){try{Thread.sleep(50);}catch(InterruptedException e){e.printStackTrace();}}

				if(!OtherStuff.LatestServerReply().equals(String.valueOf(Version))){
					JOptionPane.showMessageDialog(null, "-> Your Programm is not up to date or the Server was not up in Time. <-\n-> Your are using Version " +
							Version +"\n-> The Allowed Version is " + OtherStuff.LatestServerReply() +
							"\n-> If both Numbers are the same, It's the Server - Ignore this Message and Press OK\n Download the newest Version here:\nhttps://dl.dropboxusercontent.com/u/88851086/TFrame.jar");
					if(!OtherStuff.LatestServerReply().equals(String.valueOf(Version))){
						OtherStuff.openwebsite("https://dl.dropboxusercontent.com/u/88851086/TFrame.jar");
						System.exit(1);
					}
				}

				checkconditionsamount = 0;
			}
		}
	}

}
