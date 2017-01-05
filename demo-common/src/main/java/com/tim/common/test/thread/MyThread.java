package com.tim.common.test.thread;

/**
 * 多个线程共享一个静态变量，会让静态变量一直变化下去
 */
public class MyThread extends Thread {

	public static int index = 0;
	
	@Override
	public void run() {
		for (int i = 0; i < 10; i++) {
			System.out.println(getName() + ":" + index++);
		}
	}
	
	public static void main(String[] args) {
		new MyThread().start();
		new MyThread().start();
		new MyThread().start();
	}

}
