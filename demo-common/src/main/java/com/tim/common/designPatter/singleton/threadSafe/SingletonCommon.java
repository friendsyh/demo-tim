package com.tim.common.designPatter.singleton.threadSafe;

/**
 * 单例模式，私有构造器，在类的内部调用
 * Created by tim.syh on 2016/8/14.
 */
public class SingletonCommon {

    private volatile static SingletonCommon singleton;

    //私有的构造器，保证外部不能new对象，那么该对象始终只有一份
    private SingletonCommon(){}

    /**
     * 如果静态对象为空，那么new，否则就使用这一份对象。
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
