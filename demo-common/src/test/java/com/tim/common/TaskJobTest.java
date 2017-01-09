package com.tim.common;

import java.util.Timer;
import java.util.TimerTask;

/**
 * 任务调度测试
 * java中的定时任务，隔多久会自己调用一次
 * 模拟测试异步方法，像js中的setTimeout(function(){},5000)一样的方法
 * Created by tim.syh on 2017/1/9.
 */
public class TaskJobTest {

    public static void main(String[] args) {
        Timer timer = new Timer();
        //每隔5S时间执行一次方法
        timer.schedule(new MyTask(), 0, 5000);
    }

    static class MyTask extends TimerTask {
        @Override
        public void run() {
            System.out.println("this is my job");
        }
    }
}
