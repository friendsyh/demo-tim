package com.tim.common.test.encode;

import java.io.UnsupportedEncodingException;
import java.util.Arrays;

public class TestEncode {

	public static void main(String[] args) throws UnsupportedEncodingException {
		
		byte[] b = "中国abc".getBytes(); //返回它的字节数组。
		System.out.println(Arrays.toString(b));//utf-8下[-28, -72, -83, -27, -101, -67, 97, 98, 99]
		byte[] bg = "中国abc".getBytes("GB2312"); //返回它的字节数组。
		System.out.println(Arrays.toString(bg));//GB2312下[-42, -48, -71, -6, 97, 98, 99]
		
		//"杈�" 是utf-8 下的"输7"，用GBK来读的时候就成了"杈�"，都恰好是4个字节。
		byte[] dd = "输7".getBytes("UTF-8");
		String str = new String(dd, "GBK");
		System.out.println(str); //输出"杈�"
		
		System.out.println(b.length); //返回的是9，因为默认是UTF-8，一个汉字三个字节
		System.out.println("中国abc".length()); //返回是5，返回的是字符的长度，总共5个字符。
		
		
		System.out.println("****************************");
		String msg = "中国abc";
		System.out.println(msg);
		int len = msg.getBytes().length;// 按操作系统默认编码来编码,因为该文件的编码方式为utf-8，所以返回为9
		System.out.println(len);
		try {
			len = msg.getBytes("GB2312").length;// 输7
			System.out.println("GB2312: " + len);
			len = msg.getBytes("GBK").length;// 输出7
			System.out.println("GBK: " + len);
			len = msg.getBytes("GB18030").length;// 输出7,// 2*2+3,一个汉字占2字节,一个英文字母一个字节
			System.out.println("GB18030: " + len);
			len = msg.getBytes("UTF-8").length;// 输出9,// 2*3+3=9,一个汉字占3字节,一个英文字母一个字节.
			System.out.println("UTF-8: " + len);
			len = msg.getBytes("UTF-16").length;// 输出12
			System.out.println("UTF-16: " + len);
			len = msg.getBytes("UTF-32").length;// 输出20
			System.out.println("UTF-32: " + len);
			len = msg.getBytes("Unicode").length;// 输出12
			System.out.println("Unicode: " + len);
		} catch (java.io.UnsupportedEncodingException e) {
			System.out.println(e.getMessage().toString());
		}
	}

}
