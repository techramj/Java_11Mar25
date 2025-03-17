package com.main.ui;

import java.awt.BorderLayout;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Client  extends JFrame implements KeyListener{
	
	Socket clientSocket;
	DataOutputStream dos;
	DataInputStream dis, consoleDis;
	
	JTextArea area;
	JTextField text;
	
	
	public Client() {
		
		area = new JTextArea();
		text = new JTextField();
		this.getContentPane().add(area);
		this.getContentPane().add(text, BorderLayout.SOUTH);
		
		text.addKeyListener(this);;
   
		
		this.setTitle("Client");
		this.setName("Client");
		this.setVisible(true);
		this.setSize(500,800);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
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
		String msgFromServer = dis.readUTF();
		area.append("server: "+msgFromServer+"\n");
		}
	}
	
	
	public static void main(String[] args) {
		try {
			new Client().chat();
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
			String msgByClient = text.getText();
			System.out.println(msgByClient);
			text.setText("");
			area.append("Client: "+ msgByClient+"\n");
			try {
				dos.writeUTF(msgByClient);
			} catch (IOException e1) {
			}
		}
		
	}

}
