package com.main;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class MyServer {
	
	private ServerSocket server;
	private Socket serSocket;
	DataOutputStream dos;
	DataInputStream dis;
	DataInputStream disForConsole;
	
	public MyServer() {
		try {
			server = new ServerSocket(2222);
			System.out.println("Server: server started....");
			serSocket = server.accept();
			System.out.println("Server: client accepted the call");
			
			dos = new DataOutputStream(serSocket.getOutputStream());
			dis = new DataInputStream(serSocket.getInputStream());
			disForConsole = new DataInputStream(System.in);
			
		} catch (IOException e) {
		   System.out.println("server down");
		}
	}
	
	public void chat() throws Exception {
		while(true) {
			String msgFromClient = dis.readUTF();
			System.out.println("client:  "+msgFromClient);
			
			String msgByServer = disForConsole.readLine();
			dos.writeUTF(msgByServer);
			
		}
	}
	
	
	public static void main(String[] args) {
		try {
			new MyServer().chat();
		} catch (Exception e) {

		};
	}

}
