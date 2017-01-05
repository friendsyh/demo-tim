package com.tim.common.test.classLoader;

public class ClassTest {
	public static void main(String[] args) {
		Point point = new Point(1, 5);
		System.out.println(point.toString());
		
		Point point2 = new Point(1, 5);
		System.out.println(point.equals(point2));
		
	}
}
