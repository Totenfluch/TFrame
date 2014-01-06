package me.Totenfluch.classpackage;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;



public class RememberMeClass {
	public static String[] RememberMeCredicals = new String[7];

	public static void RememberMeSave(boolean state, int ID, String Username, int Code, String Password, String Ticks, String Destination){
		Code = Code/LoginWindow.verificationcode;
		String gameFolderPath, gameFilePath;
		gameFolderPath = System.getenv().get("APPDATA") + "\\TFrame";
		gameFilePath = gameFolderPath + "\\RememberMe.txt";
		
		File gameFolder = new File(gameFolderPath);
		if (!gameFolder.exists()) {
		    // Folder doesn't exist. Create it
		    if (gameFolder.mkdir()) {
		        // Folder created
		        File gameFile = new File(gameFilePath);
		        if (!gameFile.exists()) {
		            // File doesn't exists, create it
		            try {
		                if (gameFile.createNewFile()) {
		                    // mGameFile created in %APPDATA%\myGame !
		                }
		                else {
		                    // Error
		                }
		            } catch (IOException ex) {
		                // Handle exceptions here
		            }
		        }
		        else {
		            // File exists
		        }
		    }
		    else {
		        // Error
		    }
		}
		else {
		    // Folder exists
		}
		
	    File file = new File(gameFilePath);    
	    PrintWriter writer = null;
	    try {
	        writer = new PrintWriter(new FileWriter(file, true));
	        writer.println(DataCrypter.encrypt3(String.valueOf(state)));
	        writer.println(DataCrypter.encrypt3(String.valueOf(ID)));
	        writer.println(DataCrypter.encrypt3(Username));
	        writer.println(DataCrypter.encrypt3(String.valueOf(Code)));
	        writer.println(DataCrypter.encrypt3(Password));
	        writer.println(DataCrypter.encrypt3(Ticks));
	        writer.println(DataCrypter.encrypt3(Destination));
	    } catch (IOException e) {
	        throw new RuntimeException(e);
	    } finally {
	        writer.close();
	    }
		
	}
	
	public static void RememberMeLogout(){
		String Filepath = System.getenv().get("APPDATA") + "\\TFrame\\RememberMe.txt";
		File file = new File(Filepath);
		file.delete();
	}
	
	public static String RememberMeLogin() throws Exception{
		String Filepath = System.getenv().get("APPDATA") + "\\TFrame\\RememberMe.txt";
		File file = new File(Filepath);
		if(file.exists()){
			BufferedReader br = new BufferedReader(new FileReader(Filepath));
		    try {
		        StringBuilder sb = new StringBuilder();
		        String line = br.readLine();
		        int i = 0;
		        while (line != null) {
		            RememberMeCredicals[i] = DataCrypter.decrypt3(line);
		            line = br.readLine();
		            i++;
		        }
		        i = 0;
		        String everything = sb.toString();
		        System.out.println(everything);
		        String logmein = "/login " + RememberMeCredicals[1] + " " + RememberMeCredicals[2] + " "  + Integer.valueOf(RememberMeCredicals[3])*LoginWindow.verificationcode + " " +
		        				LoginWindow.verificationcode + " " + RememberMeCredicals[4] + " " + RememberMeCredicals[5] + " " + RememberMeCredicals[6];
		        LoginWindow.ActiveUserID = Integer.valueOf(RememberMeCredicals[1]);
		        return logmein;
		    } finally {
		        br.close();
		    }
		}else{
			return "nop";
		}
	}
}
