package com.main;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

import javax.swing.JFrame;

public class Client{
	Socket clientSocket;
	DataOutputStream dos;
	DataInputStream dis, consoleDis;
	
	
	public Client(){
		try {
			clientSocket = new Socket(InetAddress.getLocalHost(), 2222);
			System.out.println("client: accept the server call....");
			
			dos = new DataOutputStream(clientSocket.getOutputStream());
			dis = new DataInputStream(clientSocket.getInputStream());
			
			
			consoleDis = new DataInputStream(System.in); //read data from console
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	public void chat() throws Exception {
		while(true) {
			//client has written on the console, read data from console
			String messageByClient = consoleDis.readLine();
			dos.writeUTF(messageByClient);
			String msgFromServer = dis.readUTF();
			System.out.println("\t\t\tserver: "+msgFromServer);
			
		}
	}
	
	public static void main(String[] args) {
		
		try {
			new Client().chat();
		} catch (Exception e) {
		};
		
	}

}
