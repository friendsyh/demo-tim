package com.tim.common.practice.netdemo;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.ServerSocket;
import java.net.Socket;


public class Server1 {

	/**
	 * @param args
	 * @throws IOException 
	 */
	@SuppressWarnings("resource")
	public static void main(String[] args) throws IOException {
		ServerSocket serverSocket = new ServerSocket(4700);
		Socket socket = serverSocket.accept();
		System.out.println("server start ……");
		
		//缓冲字符流就直接能够得到string
//		BufferedReader is = new BufferedReader(new InputStreamReader(socket.getInputStream()));
//		String input = is.readLine();
		
		//普通字符流，每次读取的都是一个字符。
		Reader reader = new InputStreamReader(socket.getInputStream());
		char[] chars = new char[3];
		System.out.println(reader.read(chars));
		System.out.println(chars);
		System.out.println("server get message: " + reader.read());
//		is.close();
		socket.close();
	}
}
