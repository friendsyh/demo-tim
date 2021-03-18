package com.tim.common.javabase;

import org.junit.Test;

/**
 * java操作符测试。java里面5/2=2，因为其实就是一个右移操作。如果最后一位是1会直接丢掉。所以会是2不是3.
 * Created by tim.syh on 2017/1/9.
 */
public class OperationTest {

    @Test
    public void testMove() {
        int number = 20;
        System.out.println("原二进制位：" + Integer.toBinaryString(number)); //原二进制位：10100
        System.out.println("右移>>之后的二进制位：" + Integer.toBinaryString(number >> 1));  //右移>>之后的二进制位：1010,相当于/2
        System.out.println("左移>>之后的二进制位：" + Integer.toBinaryString(number << 1)); //左移>>之后的二进制位：101000,相当于*2

        int number1 = 21;
        System.out.println("原二进制位：" + Integer.toBinaryString(number1)); //原二进制位：10101
        System.out.println("右移>>之后的二进制位：" + Integer.toBinaryString(number1 >> 1));  //右移>>之后的二进制位：1010,相当于/2。这里等于10，右移之后把原来的最右边的1也丢掉了。
        System.out.println("左移>>之后的二进制位：" + Integer.toBinaryString(number1 << 1)); //左移>>之后的二进制位：101010,相当于*2
    }
}
