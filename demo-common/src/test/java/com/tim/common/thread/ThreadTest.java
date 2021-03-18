package com.tim.common.thread;

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
                sleep(1000);
//                wait(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
	}


    /**
     * 结果如下
     * 1.线程的执行不一定先start就先执行。
     * 2.因为index是共享的，所以会有缓存导致的错误的。比如第六行结果，按理来说结果应该是5的，但是编程了3，说明用了缓存。
     * 3.得到的总数是24，而不是30，和第二点结果一样。会丢失几个值。发现循环1000000次，也只是丢失了6次，最终结果是2999994.有点奇怪。
     *
     * Thread-0:0--RUNNABLE
     * Thread-2:2--RUNNABLE
     * Thread-1:1--RUNNABLE
     * Thread-1:3--RUNNABLE
     * Thread-2:4--RUNNABLE
     * Thread-0:3--RUNNABLE
     * @param args
     */
	public static void main(String[] args) {
		new ThreadTest().start();
		new ThreadTest().start();
		new ThreadTest().start();
	}

}
