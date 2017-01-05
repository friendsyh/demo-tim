package com.tim.common.test.Integer;

import java.lang.reflect.Field;

public class TestInteger {
	public static void main(String[] args) {
		Integer i1 = 1198;
		Integer i2 = 1198;
		int i3 = 1198;
		System.out.println(i1 == i2);
		System.out.println(i1 == i3);
		
		Class clazz = int.class;
		System.out.println(clazz.isPrimitive());
	}
}
