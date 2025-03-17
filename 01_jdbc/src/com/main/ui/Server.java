package com.main.ui;

import java.awt.BorderLayout;
import java.awt.TextField;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Server extends JFrame implements KeyListener{
	
	private ServerSocket server;
	private Socket serSocket;
	DataOutputStream dos;
	DataInputStream dis;
	
	JTextArea area;
	JTextField text;
	
	Server(){
		
		
		area = new JTextArea();
		text = new JTextField();
		this.getContentPane().add(area);
		this.getContentPane().add(text, BorderLayout.SOUTH);
		
		text.addKeyListener(this);
   
		
		this.setTitle("Server");
		this.setName("Server");
		this.setVisible(true);
		this.setSize(500,800);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		try {
			server = new ServerSocket(2222);
			System.out.println("Server: server started....");
			serSocket = server.accept();
			System.out.println("Server: client accepted the call");
			
			dos = new DataOutputStream(serSocket.getOutputStream());
			dis = new DataInputStream(serSocket.getInputStream());
			
		} catch (IOException e) {
		   System.out.println("server down");
		}
	}
	
	
	public static void main(String[] args) {
		try {
			new Server().chat();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		};
	}


	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void keyReleased(KeyEvent e) {
		if(e.getKeyCode() == 10) {
			String msgByServer = text.getText();
			System.out.println(msgByServer);
			text.setText("");
			area.append("Server: "+ msgByServer+"\n");
			try {
				dos.writeUTF(msgByServer);
			} catch (IOException e1) {
			}
		}
		
	}
	
	public void chat() throws Exception {
		while(true) {
			String msgFromClient = dis.readUTF();
			area.append("\t\t\tclient: "+msgFromClient+"\n");
		}
	}

}
