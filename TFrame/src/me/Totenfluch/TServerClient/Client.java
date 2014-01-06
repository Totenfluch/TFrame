package me.Totenfluch.TServerClient;

import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.net.*;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import me.Totenfluch.classpackage.ConnectingWindow;
import me.Totenfluch.classpackage.DataCrypter;
import me.Totenfluch.classpackage.Main;

public class Client extends JFrame implements Runnable
{
	private static final long serialVersionUID = 1L;
	// Components for the visual display of the chat windows
	public static boolean IsConnectedToServer = false;
	private static TextField tf = new TextField("Input", 80);
	private TextArea ta = new TextArea("Text from other users will appear here\n\n", 30, 120);
	private static TextField ComputerName = new TextField(Main.ComputerName, 20);
	public static String LatestServerReply = "";
	public static boolean waitingforreply = false;

	static String format;
	// The socket connecting us to the server
	public static Socket socket;
	// The streams we communicate to the server; these come
	// from the socket
	private static DataOutputStream dout;
	private DataInputStream din;
	// Constructor
	public Client( String host, int port ) {
		setSize(900, 600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setExtendedState(1);

		setLayout( new FlowLayout() );
		add(tf);
		add(ComputerName);
		add(ta);
		ComputerName.setEditable(false);
		// We want to receive messages when someone types a line
		// and hits return, using an anonymous class as
		// a callback
		tf.addActionListener( new ActionListener() {
			public void actionPerformed( ActionEvent e ) {
				processMessage( e.getActionCommand() );
			}
		} );
		// Connect to the server
		try {
			// Initiate the connection
			socket = new Socket( host, port );
			// We got a connection! Tell the world
			System.out.println( "connected to "+socket );
			// Let's grab the streams and create DataInput/Output streams
			// from them
			din = new DataInputStream( socket.getInputStream() );
			dout = new DataOutputStream( socket.getOutputStream() );
			// Start a background thread for receiving messages
			IsConnectedToServer = true;
			GetServerMessages.reconnecting = false;
			ConnectingWindow.connectionwindowactive = false;
			new Thread( this ).start();
		}catch( IOException ie ){ 

			try {
				Thread.sleep(100);
			} catch (InterruptedException e1) {
				e1.printStackTrace();
			}

			JOptionPane.showMessageDialog(null, "Couldn't connect to the Master Server. Shutting down."); 
			System.exit(0);
		}
	}


	// Gets called when the user types something
	public static void processMessage( String message ) {
		if(IsConnectedToServer == true){
			try {
				// Send it to the server
				format = DataCrypter.encrypt2((ComputerName.getText() +" " + message));
				dout.writeUTF( format );
				// Clear out text input field
				tf.setText( "" );
				waitingforreply = true;
			} catch( Exception ie ) { ie.printStackTrace(); System.out.println( ie ); }
		}
	}
	// Background thread runs this: show messages from other window
	public void run() {
		try {
			// Receive messages one-by-one, forever
			while (true) {
				// Get the next message
				String message = DataCrypter.decrypt2(din.readUTF());
				LatestServerReply = message;
				// Print it to our text window
				GetServerMessages.CheckServerMessages(message);
				ta.append( message+"\n" );
				waitingforreply = false;
			}
		} catch( Exception ie ) { ie.printStackTrace(); System.out.println( ie); IsConnectedToServer = false; }
	}
}