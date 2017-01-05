package com.tim.common.test.classLoader;

import java.lang.reflect.Field;

public class ReflectTest {
	public static void main(String[] args) {
		Point point = new Point(1, 2);
		point.getClass();
		
		Field[] fields = Point.class.getDeclaredFields();
	}
}
