package com.java.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class MyServer {

	public static void main(String[] args) throws IOException {
		ServerSocket s = new ServerSocket(2000);
		while(true) {
			System.out.println("wait for client....");
			Socket client = s.accept();
			System.out.println("received from " + client.getInetAddress().getHostName() + ":" + client.getPort());
			new Thread(new ServerThread(client)).start();
		}
	}
}
