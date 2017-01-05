package com.tim.common.test;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.StringReader;

public class TestIO {
	File file1 = new File("f:\\test\\testFile.txt");
	File file2 = new File("f:\\test");
	String s1, s2;

	public static void main(String[] args) throws IOException {
		TestIO test = new TestIO();
		test.createFile();
		System.out.println(test.getStdInput());
		//System.out.println(test.readFile("f:\\test\\tesxtFile.txt"));
		//test.putFile(test.readFile("f:\\test\\testFile.txt"), "f:\\test\\test.txt");
		//test.getCharFromString("you are a pig~~~");
	
	}
	
	public void createFile() {

		if (file2.isDirectory()) {
			System.out.println("文件夹已经存在");
		} else {
			file2.mkdir();
			System.out.println("创建文件夹成功");
		}

		if (!file1.exists()) {
			try {
				file1.createNewFile();
				System.out.println("创建文件成功");
			} catch (IOException e) {
				
				e.printStackTrace();
			}
		}
	}

	public String getStdInput() throws IOException {
		 BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		//Scanner bf = new Scanner(System.in);
		String s3 = "";
		String str = "";
		System.out.println("enter a line strings!!");
		while ((s3 = bf.readLine()) != null && s3.length() != 0) {
			str += "\r\n";
			str += bf.readLine();
		}
		return str;
	}

	/*---------------------------把str字符串读入到制定目录---------------------------------------------------*/
	public void putFile(String str, String path) throws IOException {

		File file = new File(path);
		if (!file.exists()) {
			try {
				file.createNewFile();
				System.out.println("本来没有文件夹，创建文件成功");
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		FileWriter file4 = new FileWriter(path);
		PrintWriter out = new PrintWriter(new BufferedWriter(file4));
		BufferedReader in = new BufferedReader(new StringReader(str));
		int lineCounter = 1;
		String string = "";
		while((string = in.readLine()) != null) {
			out.println(lineCounter++ + ":" + string);
		} 
		out.close();
		System.out.println("成功插入到文件中");
	}

	/*---------------------------从文件中逐行读入数据---------------------------------------------------*/
	public String readFile(String path) throws IOException {

		BufferedReader in = new BufferedReader(new FileReader(path));
		String str = "";
		String str1 = "";
		try {
			while ((str1 = in.readLine()) != null) {
				str += str1 + "\n";
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		in.close();
		return str;
	}
	
	/*---------------------------从字符串中把字符一个个找出---------------------------------------------------*/
	public void getCharFromString(String str) throws IOException {
		int c = 0;
		StringReader in = new StringReader(str);
		while((c = in.read()) != -1){
				System.out.print((char)c);
		}
	}

}
