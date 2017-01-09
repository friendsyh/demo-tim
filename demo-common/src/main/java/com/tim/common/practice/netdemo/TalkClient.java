package com.tim.common.practice.netdemo;

import java.io.*;
import java.net.*;


public class TalkClient {

	public static void main(String args[]) {
		try {
			@SuppressWarnings("resource")
			Socket socket = new Socket("127.0.0.1", 4700);
			BufferedReader sin = new BufferedReader(new InputStreamReader(System.in));
			PrintWriter os = new PrintWriter(socket.getOutputStream());
			BufferedReader is = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			//从键盘读入字符流
			String input = sin.readLine();
			System.out.println("message from keyboard: " + input);
			while (!input.equals("bye")) {
				//通过socket输出到服务端
				os.println(input);
				//从服务端返回的数据
				input = is.readLine();
				System.out.println("get the server message: " + input);
			}
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}