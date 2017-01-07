package com.tim.common.utils;

import java.util.Arrays;

/**
 * Base16公共类，现在都使用Base64进行编码了
 * 主要用来保存二进制的内容传输，比如加密后的数据呀，图片呀等二进制数据，需要进行字符串传输。
 * @author tim.syh
 *
 */
public class Base16Utils {
	
	/** 
     * 把16进制字符串转换成字节数组
     * 比如4E25 返回的是[78, 37]
     * @param hex 
     * @return 
     */  
    public static byte[] hexStringToByte(String hex) {  
        int len = (hex.length() / 2);  
        byte[] result = new byte[len];  
        char[] achar = hex.toCharArray();  
        for (int i = 0; i < len; i++) {  
            int pos = i * 2;  
            //toByte(achar[pos + 1] 是低四位
            //toByte(achar[pos]) << 4 是高四位，进行或运算，比如10110000|00001011=10111011就得到结果了
            result[i] = (byte) (toByte(achar[pos]) << 4 | toByte(achar[pos + 1]));  
        }  
        return result;
    }
    
    /**
     * 把单个字符转成字节，F返回15
     * 其实就是16进制转10进制
     * @param c
     * @return
     */
    private static byte toByte(char c) {  
        byte b = (byte) "0123456789ABCDEF".indexOf(c);  
        return b;  
    } 
    
    /** 
     * 把字节数组转换成16进制字符串 
     * 比如[78, 37]返回的就是4E25
     * @param bArray 
     * @return 
     */  
    public static final String bytesToHexString(byte[] bArray) {  
        if(bArray == null ){  
            return "";  
        }  
        StringBuffer sb = new StringBuffer(bArray.length);  
        String sTemp;  
        for (int i = 0; i < bArray.length; i++) {  
            sTemp = Integer.toHexString(0xFF & bArray[i]);  
            if (sTemp.length() < 2){
            	sb.append(0);
            }  
            sb.append(sTemp.toUpperCase());  
        }  
        return sb.toString();  
    }
    
    public static void main(String[] args) {
		System.out.println("abcdefg".indexOf('c'));  //返回结果为2
		System.out.println("*****************change to hex start******************");
		byte[] bytes = hexStringToByte("4E25F");
		System.out.println(Arrays.toString(hexStringToByte("4E25")));
		for(int i = 0;i < bytes.length;i++){
			System.out.println(bytes[i] + "---" + Integer.toBinaryString(bytes[i]));
		}
		System.out.println("*****************change to hex end********************");
		System.out.println(Integer.valueOf("4E25",16).toString());
	}
    
}
