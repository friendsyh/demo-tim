package com.tim.common.practice.netdemo;

import java.io.*;
import java.net.*;


public class Client1 {

	public static void main(String args[]) throws UnknownHostException, IOException {
		Socket socket = new Socket("127.0.0.1", 4700);
		PrintWriter os = new PrintWriter(socket.getOutputStream());
		os.write("abcd");
		os.close();
		socket.close();
	}
}