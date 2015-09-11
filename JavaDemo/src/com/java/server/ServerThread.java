package com.java.server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class ServerThread implements Runnable{

	private Socket s;
	private BufferedReader bd;
	public ServerThread(Socket s) throws IOException {
		this.s = s;
		bd = new BufferedReader(new InputStreamReader(this.s.getInputStream(),"gbk"));;
	}

	@Override
	public void run() {
		String content = null;
		try {
			while((content = bd.readLine()) != null) {
				System.out.println("from client msg : " + content);
				s.getOutputStream().write(content.getBytes("gbk"));
			}
			System.out.println("end");
		} catch (IOException e) {
			System.out.println("error");
		}
	}
}
