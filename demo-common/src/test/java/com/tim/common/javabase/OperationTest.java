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

    /**
     * 异或运算。相同返回为false，不同返回为true，是一种特殊的or。or为true的两种情况:1.两个都为true 2:只有一个为true。xor是第二种情况
     * 1.任何值和0做XOR运算，得到都是自己
     * 2.自己和自己做XOR，得到都是0。自己和自己做XOR，再和自己做XOR，得到都是1。加密text ^ key = cipherText，解密cipherText ^ key = text
     * 3.数据备份。x ^ y = z。以后，无论是文件 x 或文件 y 损坏，只要不是两个原始文件同时损坏，就能根据另一个文件和备份文件，进行还原。x ^ z = y
     * 0^0=0 1^1=0
     * 0^1=1 1^0=1
     */
    @Test
    public void testXOr() {
        System.out.println("1^0=：" + (1 ^ 0));

        System.out.println(5 ^ 8 ^ 20 ^ 51 ^ 5 ^ 8 ^ 20); //得到51。两组{5,8,20},额外多了一个51
        System.out.println(5 ^ 8 ^ 5 ^ 20 ^ 5 ^ 8 ^ 20); //得到5。两组{5,8,20},额外多了一个5
    }
}
