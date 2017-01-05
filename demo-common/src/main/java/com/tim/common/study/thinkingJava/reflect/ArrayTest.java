package com.tim.common.study.thinkingJava.reflect;

import java.lang.reflect.Array;
import java.util.Arrays;

public class ArrayTest {

	/**
	 * 用泛型解决打印任何类型的数组
	 * @param <T>
	 * @param t
	 */
	public static <T> void printArray(T[] t){
		for (T t2 : t) {
			System.out.println(t2);
		}
	}
	
	public static void printArrayByReflect(Object obj) {
		//obj.getClass() == Arrays.class;
		if(obj.getClass().isArray()){
			int length = Array.getLength(obj);
			for(int i =0 ;i < length;i++){
				System.out.println(Array.get(obj, i));
			}
		}else{
			System.out.println(obj);
		}
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		printArray(new String[]{"abc","de"});
		printArray(new Integer[]{1,2});
		
		printArrayByReflect(new String[]{"abc","de"});
	}

}
