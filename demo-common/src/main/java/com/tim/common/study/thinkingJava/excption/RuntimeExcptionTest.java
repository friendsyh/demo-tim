package com.tim.common.study.thinkingJava.excption;

public class RuntimeExcptionTest {
	
	public static void f(){
		throw new RuntimeException("from f()");
	}

	//没有抛出异常。但是照样能够扑捉到。
	public static void g(){
		f();
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		g();
	}

}
