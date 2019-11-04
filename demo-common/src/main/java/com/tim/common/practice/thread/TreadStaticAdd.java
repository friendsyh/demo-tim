package com.tim.common.practice.thread;

/**
 * 最简单的thread测试类。
 * count是一个对象的一个属性。两个线程每个对其操作加1到1W。但是结果就是1W-2W之间的一个随机数。因为都是对缓存的数据进行修改。
 */
public class TreadStaticAdd {

    private long count = 0;

    private void add10K() {
        int idx = 0;
        while (idx++ < 10) {
            count++;
        }
    }

    public static void main(String[] args) throws Exception {


        TreadStaticAdd treadStaticAdd = new TreadStaticAdd();
        Thread t1 = new Thread(()->{ treadStaticAdd.add10K();});
        Thread t2 = new Thread(()->{ treadStaticAdd.add10K();});

        // 启动两个线程
        t1.start();
        t2.start();
//        System.out.println("count=" + treadStaticAdd.count);
        // 等待两个线程执行结束。先要等t1执行完之后才能执行t2
        t1.join();
//        System.out.println("count=" + treadStaticAdd.count);
        t2.join();

        System.out.println("count=" + treadStaticAdd.count);
    }

}
