package com.tim.common.myutils;


/**
 * 字节字符等处理公共类
 * @author tim.syh
 *
 */
public class ByteUtil {
    
    public static void main(String[] args) {
    	//二进制的数
        int BinaryNumber = 0b11101110;
        System.out.println("*******************二进制的数:" + BinaryNumber);
        System.out.println("二转十："+ BinaryNumber);
        System.out.println("二转八："+ Integer.toOctalString(BinaryNumber));
        System.out.println("二转十六："+ Integer.toHexString(BinaryNumber));
        System.out.println("二字符串转十："+ Integer.valueOf("11101110",2));
    	
        //八进制的数
        int octalNumber = 017;
        System.out.println("*******************八进制的数:" + octalNumber);
        System.out.println("八转二："+ Integer.toBinaryString(octalNumber));
        System.out.println("八转十："+ octalNumber);
        System.out.println("八转十六："+ Integer.toHexString(octalNumber));
        System.out.println("八字符串转十："+ Integer.valueOf("17",8));
        
    	//十进制的数
    	int decNumber = 120;
    	System.out.println("*******************十进制的数:" + decNumber);
    	System.out.println("十转二："+ Integer.toBinaryString(decNumber));
        System.out.println("十转八："+ Integer.toOctalString(decNumber));
        System.out.println("十转十六："+ Integer.toHexString(decNumber));
    	
    	//十六进制的数
        int hexNumber = 0xABCDEF;
        System.out.println("*******************十六进制的数:" + hexNumber);
        
    	System.out.println("十六转二："+ Integer.toBinaryString(hexNumber));
        System.out.println("十六转八："+ Integer.toOctalString(hexNumber));
        System.out.println("十六转十："+ hexNumber);
        System.out.println("十六转十六：" + Integer.toHexString(hexNumber));
        System.out.println("十六字符串转十："+ Integer.valueOf("ABCDEF",16));
	}
    
}
