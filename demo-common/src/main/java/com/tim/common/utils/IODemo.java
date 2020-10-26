package com.tim.common.utils;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.Reader;
import java.io.StringReader;

public class IODemo {
	File file1 = new File("f:\\test\\testFile.txt");
	File file2 = new File("f:\\test");
	String s1, s2;

	public static void main(String[] args) throws IOException {
		IODemo test = new IODemo();
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
	public String readFileByLine(String path) throws IOException {
		StringBuffer content = new StringBuffer();
		try(BufferedReader in = new BufferedReader(new FileReader(path))) {
            String tempLine = "";
			while ((tempLine = in.readLine()) != null) {
                content.append(tempLine).append("\n");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return content.toString();
	}

    /*---------------------------从文件中逐行读入数据---------------------------------------------------*/
    public void readFileByChars(String path) throws IOException {
        File file = new File(path);
        Reader reader = null;
        try {
            System.out.println("以字符为单位读取文件内容，一次读一个字节：");
            // 一次读一个字符
            reader = new InputStreamReader(new FileInputStream(file));
            int tempchar;
            while ((tempchar = reader.read()) != -1) {
                // 对于windows下，\r\n这两个字符在一起时，表示一个换行。
                // 但如果这两个字符分开显示时，会换两次行。
                // 因此，屏蔽掉\r，或者屏蔽\n。否则，将会多出很多空行。
                if (((char) tempchar) != '\r') {
                    System.out.print((char) tempchar);
                }
            }
            reader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
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
