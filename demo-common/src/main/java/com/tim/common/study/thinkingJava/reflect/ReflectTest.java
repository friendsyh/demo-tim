package com.tim.common.study.thinkingJava.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class ReflectTest {

	public static void main(String[] args) throws Exception{

		//new String(new StringBuffer("abc"))
		Constructor constructor = Class.forName("java.lang.String").getConstructor(StringBuffer.class);
		String c = (String) constructor.newInstance(new StringBuffer("abc"));
		System.out.println(c);
	}

}
