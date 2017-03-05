package com.tim.common.practice;

/**
 * 关键字测试
 * 1. final表示不可变的。修饰类表示不可继承，比如Integer，String等都是不可以被继承的。
 * Created by tim.syh on 2017/3/5.
 */
public class KeyWords {

    private final String testStr = "abc";

    public void testFinalField(){
//        testStr = new String("def");  //编译报错，因为final变量是不可以变化的
    }

    /**
     * final方法，子类不能对改方法进行重写。如果认为该方法已经确定，就可以定义父类的方法为final方法
     */
    public final void testFinalMethod(){
        return;
    }
}
