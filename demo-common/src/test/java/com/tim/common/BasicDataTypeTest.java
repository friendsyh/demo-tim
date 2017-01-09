package com.tim.common;

import org.junit.Test;

/**
 * 基本数据类型测试
 * Created by tim.syh on 2017/1/9.
 */
public class BasicDataTypeTest {

    @Test
    public void testInteger() throws Exception {
        Integer i11 = 127;
        Integer i12 = 127;
        System.out.println(i11 == i12); //true,低于127的时候两个对象是同一个对象

        Integer i21 = 128;
        Integer i22 = 128;
        System.out.println(i21 == i22); //false，超过127的时候两个对象不同一个对象

        int i31 = 128;
        System.out.println(i31 == i21); //true

        System.out.println(int.class.isPrimitive()); //true,是一个基本数据类型
        System.out.println(Integer.class.isPrimitive()); //false,不是一个基本数据类型
    }
}
