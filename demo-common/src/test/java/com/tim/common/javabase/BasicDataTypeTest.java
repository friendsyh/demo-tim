package com.tim.common.javabase;

import org.junit.Test;

import java.math.BigDecimal;

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

        Integer i41 = 5;
        System.out.println(i41 + "");

        System.out.println(Integer.MAX_VALUE);
        System.out.println(Integer.MIN_VALUE);
        System.out.println(Long.MAX_VALUE);
        System.out.println(Long.MIN_VALUE);

        int number = 17;
        System.out.println("number++ % 5 = " + number++ % 5);  //结果为2,计算完毕之后再会++操作变成18
    }

    @Test
    public void testFloat() throws Exception {
//        float f1 = 1.1; //错误的写法,必须要添加f
        float f2 = 1.1f; //这个必须要添加f,如果不添加f,就默认是double类型了，会丢失精度
        double d = 1.1; //这个可以不用加d
    }

    @Test
    public void testDouble() throws Exception {
        Double d1 = 1.0d;
        Double d2 = 0.9d;
        Double d3 = 0.1d;
        Double d4 = 0.2d;
        Double d5 = 0.5d;

        System.out.println("十进制：d1=" + d1 + ",d2=" + d2 + ",d3=" + d3);  //d1=1.0,d2=0.9,d3=0.1
        System.out.println("二进制：d1=" + Double.doubleToLongBits(d1) + ",d2=" + Double.doubleToLongBits(d2) + ",d3=" + Double.doubleToLongBits(d3));
        System.out.println(d1 - d2); //1.0-0.9=0.09999999999999998, 因为十进制的0.9转成二进制本身是一个无限循环的东西。所以计算出来的也是一个无限循环的东西。
        System.out.println(d1 - d4); //1.0-0.8=0.2
    }

    @Test
    public void testBigDecimal() throws Exception {
        //保留2位有效数字
        System.out.println(BigDecimal.valueOf((float) 2 / 64).setScale(2, BigDecimal.ROUND_UP).doubleValue());

        //测试被除数为0的情况。抛出NumberFormatException异常
        System.out.println(BigDecimal.valueOf((float) 15l / 0l).setScale(2, BigDecimal.ROUND_UP).doubleValue());
    }

    @Test
    public void testChar() throws Exception {
        char c = '你';
        char[] charArray = "abcdfwleg".toCharArray();
    }
}
