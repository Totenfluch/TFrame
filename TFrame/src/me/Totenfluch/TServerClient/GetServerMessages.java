package me.Totenfluch.TServerClient;

import java.io.IOException;

import javax.swing.JOptionPane;

import me.Totenfluch.classpackage.ConsoleWindow;
import me.Totenfluch.classpackage.OtherStuff;

public class GetServerMessages{
	public static String newestreply = null;
	public static boolean reconnecting = false;

	public static void CheckServerMessages(String message){
		
		newestreply = OtherStuff.LatestServerReply();

		if(newestreply.startsWith("YouGotkickednr")){
			OtherStuff.CloseAllWindows();
			JOptionPane.showMessageDialog(null, "Kicked by Server");
			System.exit(0);
		}

		else if(message.startsWith("YouGotkicked")){
			String [] kickreason = message.split(" ");
			OtherStuff.CloseAllWindows();
			if(kickreason.length == 1){
				JOptionPane.showMessageDialog(null, "Kicked by Server");
			}else if(kickreason.length == 2){
				JOptionPane.showMessageDialog(null, "Kicked by Server. Reason: " + kickreason[1]);
			}else{
				JOptionPane.showMessageDialog(null, "Kicked by Server");
			}
			System.exit(0);
		}
		
		else if(message.startsWith("ServerIsShuttingDown")){
			try {
				Client.socket.close();
			} catch (IOException e){
				e.printStackTrace();
			}
			reconnecting = true;
		}
		
		else if(message.startsWith("broadcast")){
			if(ConsoleWindow.ircon == true){
				String [] broadcaststring = message.split(" ");
				ConsoleWindow.TextArea1.append(OtherStuff.TheNormalTime() + broadcaststring[1].replace("_", " ").replace("broadcast", "").toString() + "\n");
				ConsoleWindow.TextArea1.setCaretPosition(ConsoleWindow.TextArea1.getDocument().getLength());
			}
		}
		
		else if(message.contains("You are connected to the TFrame Server")){
			reconnecting = false;
			Client.IsConnectedToServer = true;
		}
	}
}
