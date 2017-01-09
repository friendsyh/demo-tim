package com.tim.common.practice.netdemo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;


public class TalkServer {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		@SuppressWarnings("resource")
		ServerSocket serverSocket = new ServerSocket(4700);
		Socket socket = null;
		socket = serverSocket.accept();
		BufferedReader sin = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter os = new PrintWriter(socket.getOutputStream());
		BufferedReader is = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		String input;
		while(true) {
			input = is.readLine();
			System.out.println("server get message: " + input);
			String replay = sin.readLine();
			os.println(replay);
			System.out.println("server put message: "+ replay);
			
			if("bye".equals(input)) {
				break;
			}
		}
		is.close();
		os.close();
		sin.close();
		socket.close();
	}
}
