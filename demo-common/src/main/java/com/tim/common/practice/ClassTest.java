package com.tim.common.practice;

/**
 * 路径问题
 * Created by tim.syh on 2017/1/9.
 */
public class ClassTest {

    public static void main(String[] args) throws Exception {
        Class<?> stringClass = String.class;
        Class<?> longClass = Long.class;
        Class<?> doubleClass = Double.class;

        System.out.println(stringClass.toString());
        System.out.println(longClass.toString());
        System.out.println(doubleClass.toString());

    }
}
