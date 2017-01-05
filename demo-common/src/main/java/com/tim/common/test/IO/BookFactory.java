package com.tim.common.test.IO;

public class BookFactory{
		
	public static IBook getBookA() {
		IBook book = new BookA();
		return book;
	}
	
	public static IBook getBookB() {
		IBook book = new BookB();
		return book;
	}
	
}
