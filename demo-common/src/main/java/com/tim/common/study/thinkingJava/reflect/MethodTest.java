package com.tim.common.study.thinkingJava.reflect;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;

public class MethodTest {

	/**
	 * @param args
	 * @throws ClassNotFoundException 
	 * @throws NoSuchMethodException 
	 * @throws SecurityException 
	 * @throws InvocationTargetException 
	 * @throws IllegalAccessException 
	 * @throws IllegalArgumentException 
	 * 直接调用了TestArg里面的main方法
	 */
	public static void main(String[] args) throws SecurityException, NoSuchMethodException, ClassNotFoundException, IllegalArgumentException, IllegalAccessException, InvocationTargetException {
		System.out.println("This is MethodTest : " + Arrays.toString(args));
		String className = args[0];
		Method method = Class.forName(className).getMethod("main", String[].class);
		//null 表示为静态方法。
		method.invoke(null, (Object)(new String[]{"abc","def","hig"}));
	}

}

class TestArg{
	
	public static void main(String[] args) {
		System.out.println("this is TestArg : " + Arrays.toString(args));
	}
}
