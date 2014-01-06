package me.Totenfluch.classpackage;

import java.awt.Desktop;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.URI;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Random;

import me.Totenfluch.TServerClient.Client;
import me.Totenfluch.game.GameWindow;




public class OtherStuff {
	public static String[] LoginID = new String[9999];
	public static String[] LoginName = new String[9999];
	public static String[] LoginCode = new String[9999];
	public static String[] LoginPassword = new String[9999];
	public static String[] LoginPermissions = new String[9999];
	public static String[] LoginFlags = new String[9999];



	public static void openwebsite(String url){
		try {
			Desktop dt = Desktop.getDesktop();
			URI uri = new URI(url);
			dt.browse(uri.resolve(uri));

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static String LatestServerReply(){
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		String reply = Client.LatestServerReply;
		return reply;
	}

	public static String TheNormalTime(){
		Calendar cal = Calendar.getInstance();
		cal.getTime();
		SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
		String time = sdf.format(cal.getTime());
		String closebracket = "[";
		String openbracket = "]";
		String currenttime = closebracket + time + openbracket ;
		return currenttime;
	}

	public static String TheAuthmeTime(){
		Calendar cal = Calendar.getInstance();
		cal.getTime();
		SimpleDateFormat sdf = new SimpleDateFormat("HHmm");
		String time = sdf.format(cal.getTime());
		return time;
	}

	public static int intTheAuthmeTime(){
		Calendar cal = Calendar.getInstance();
		cal.getTime();
		SimpleDateFormat sdf = new SimpleDateFormat("HHmm");
		String time = sdf.format(cal.getTime());
		return Integer.parseInt(time);
	}

	public static int Authmetimer(){
		Calendar cal = Calendar.getInstance();
		cal.getTime();
		SimpleDateFormat sdf = new SimpleDateFormat("ss");
		String time = sdf.format(cal.getTime());
		int intime = Integer.parseInt(time);
		return intime;
	}
	
	public static void CloseAllWindows(){
		AdvancedCalculatorWindow.AdvancedCalculatorWindowActive = false;
		AuthentificatorInWindow.AuthentificatorWindowActive = false;
		CalculatorWindow.CalculatorWindowActive = false;
		ConsoleWindow.ExecuteWindowActive = false;
		CrypterWindow.CrypterWindowActive = false;
		LoginWindow.isLoggingIn = false;
		GameWindow.GameWindowActive = false;
	}
	
	
	public static String getMacAdress(){
		String ComputerMac = null;
		try{
			InetAddress ComputerIP = InetAddress.getLocalHost();
			NetworkInterface network = NetworkInterface.getByInetAddress(ComputerIP);
			byte[] mac = network.getHardwareAddress();
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < mac.length; i++) {
				sb.append(String.format("%02X%s", mac[i], (i < mac.length - 1) ? "-" : ""));		
			}
			ComputerMac = sb.toString();

		}catch ( Exception e){
			e.printStackTrace();
		}
		return ComputerMac;
	}
	
	public static void GetLoginCredicals(){
		for(int i=0; i<9999; i++){
			LoginID[i] = "";
			LoginName[i] = "";
			LoginCode[i] = "";
			LoginPassword[i] = "";
			LoginPermissions[i] = "";
			LoginFlags[i] = "";
		}

		try{

			/*decrypted*/ //URL oracle = new URL("https://dl.dropboxusercontent.com/u/88851086/asidfas89djvrt34j7985vj7234j7k2j3745j723jk745jk78234757k82v347k582xdk7458vc237l858192k874c51l235k1vc27837l81l5c1235.txt");
			/*encrypted */URL oracle = new URL("https://dl.dropboxusercontent.com/u/88851086/JFrameencryptedDatabase.txt");
			BufferedReader in = new BufferedReader(
					new InputStreamReader(oracle.openStream()));

			String inputLine;
			int is = 0;
			int charge = 0;
			while ((inputLine = in.readLine()) != null){
				if(charge == 0){
					LoginID[is] = DataCrypter.decrypt(inputLine);
					charge++;
				}else if(charge == 1){
					LoginName[is] = DataCrypter.decrypt(inputLine);
					charge++;
				}else if(charge == 2){
					LoginCode[is] = DataCrypter.decrypt(inputLine);
					charge++;
				}else if(charge == 3){
					LoginPassword[is] = DataCrypter.decrypt(inputLine);
					charge++;
				}else if(charge == 4){
					LoginPermissions[is] = DataCrypter.decrypt(inputLine);
					charge++;
				}else if(charge == 5){
					LoginFlags[is] = DataCrypter.decrypt(inputLine);
					charge = 0;
					is++;
				}                         
			}
			in.close();
		} catch (IOException e) {
			System.exit(1);
		}

	}

	public static void GetVersion(){
		try{
			URL oracle = new URL("https://dl.dropboxusercontent.com/u/88851086/Jframe%20Version.txt");
			BufferedReader in = new BufferedReader(
					new InputStreamReader(oracle.openStream()));

			String inputLine;
			while ((inputLine = in.readLine()) != null){
				Main.AllowedVersion = Integer.parseInt(inputLine);                  
			}
			in.close();
		} catch (IOException e) {
			Main.AllowedVersion = -1;
		}

	}

	public static int randInt(int min, int max) {
		Random rand = new Random();
		int randomNum = rand.nextInt((max - min) + 1) + min;

		return randomNum;
	}

}