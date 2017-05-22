package com.tim.common;

/**
 * 线程测试
 * Created by tim.syh on 2017/1/9.
 */
public class ThreadTest extends Thread {

	public static int index = 0;
	
	@Override
	public void run() {
		for (int i = 0; i < 10; i++) {
			System.out.println(getName() + ":" + index++ + "--" + getState().toString());

            try {
//                sleep(1000);
                wait(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
	}
	
	public static void main(String[] args) {
		new ThreadTest().start();
		new ThreadTest().start();
		new ThreadTest().start();
	}

}
