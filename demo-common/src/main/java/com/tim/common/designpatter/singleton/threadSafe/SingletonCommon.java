package com.tim.common.designpatter.singleton.threadSafe;

/**
 * 单例模式，私有构造器，在类的内部调用
 * Created by tim.syh on 2016/8/14.
 */
public class SingletonCommon {

    private volatile static SingletonCommon singleton;

    //私有的构造器，保证外部不能new对象，那么该对象始终只有一份
    private SingletonCommon(){}

    /**
     * 如果静态对象为空，那么new，否则就使用这一份对象。这种模式下singleton对象都没必要定义为volatile类型了，反正已经锁住了
     * 记得需要加上同步的关键词，多线程的时候有可能会创建多个实例对象。
     * 但是这种方式太影响效率。
     * @return
     */
    public static synchronized SingletonCommon getInstanceNotPrefect(){
        if(singleton == null){
            singleton = new SingletonCommon();
        }
        return singleton;
    }

    /**
     * 完美的形式，双重检测锁。
     * 注意双重检测锁也需要把singleton对象定义为volatile。主要是为了防止执行new SingletonCommon()语句的时候指令重排。
     * 1.分配内存空间
     * 2.初始化对象
     * 3.设置singleton指针指向刚初始化的对象
     * 如果按照1->2->3的顺序是没问题的。
     * 但是如果是按照1->3->2的顺序。可能执行到3的时候出现并发线程，检测到singleton也已经不为空了，也会出现线程安全问题。
     *
     * @return
     */
    public static SingletonCommon getInstance(){
        if(singleton == null){   //Single Checked
            synchronized (SingletonCommon.class){
                if(singleton == null){  //Double Checked,如果A线程在这个new 对象执行5S卡死，
                    // B线程也恰好执行到第一个判断也是为空，然后也执行到了这里，等A线程执行完之后返回一个实例之后B线程也会返回一个实例。
                    //所以这个地方需要二次检验。
                    singleton = new SingletonCommon();
                }
            }
        }
        return singleton;
    }
}
