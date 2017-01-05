package com.tim.common.designPatter.singleton.threadSafe;

/**
 * 单例模式，私有构造器，在类的内部调用
 * Created by tim.syh on 2016/8/14.
 */
public class SingletonCommon {

    private static SingletonCommon singleton;

    //私有的构造器，保证外部不能new对象，那么该对象始终只有一份
    private SingletonCommon(){}

    /**
     * 如果静态对象为空，那么new，否则就使用这一份对象。
     * 记得需要加上同步的关键词，多线程的时候有可能会创建多个实例对象。
     * @return
     */
    public static synchronized SingletonCommon getInstance(){
        if(singleton == null){
            singleton = new SingletonCommon();
        }
        return singleton;
    }
}
