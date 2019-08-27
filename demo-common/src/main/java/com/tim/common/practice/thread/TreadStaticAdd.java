package com.tim.common.practice.thread;

/**
 * 最简单的thread测试类
 */
public class TreadStaticAdd {

    private long count = 0;

    private void add10K() {
        int idx = 0;
        while (idx < 10000) {
            count++;
        }
    }

    public static void main(String[] args) throws Exception {
        TreadStaticAdd treadStaticAdd = new TreadStaticAdd();
        Thread t1 = new Thread(()->{treadStaticAdd.add10K();});
        Thread t2 = new Thread(()->{ treadStaticAdd.add10K();});

        t1.start();
        t2.start();

        System.out.println("count=" + treadStaticAdd.count);
    }

}
