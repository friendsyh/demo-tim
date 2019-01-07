package com.tim.common.practice;

import com.tim.common.domain.Person;

/**
 * 测试一个类的实例化过程
 * Created by tim.syh on 2017/2/13.
 */
public class InitialObject {
    /** 静态变量 */
    public static String staticField = "静态变量";

    /** 变量 */
    public String field = "变量";

    /** 静态初始化块 */
    static {
        System.out.println(staticField);
        System.out.println("静态初始化块");
    }

    /** 初始化块 */ {
        System.out.println(field);
        System.out.println("初始化块");
    }

    /** 构造器 */
    public InitialObject() {
        System.out.println("构造器");
    }

    /**
     *普通方法中可以使用静态变量，相当于一个全局变量
     */
    public void objectFunction(){
        System.out.println("普通方法调用：中使用变量field：" + field);
        staticField = "静态变量已经变化了";
    }

    /**
     * 静态方法中不能使用普通变量，因为普通变量还没new出来对象呢。
     */
    public static void staticFunction(){
        System.out.println("静态方法调用:");
//        this.field = "abc";
    }

    public static void main(String[] args) {
        //执行自己的类
        new InitialObject().objectFunction();

        //执行其他地方的类，需要连接进来
        Person person = new Person("tim", 50);
        System.out.println(person.getName());
    }
}
