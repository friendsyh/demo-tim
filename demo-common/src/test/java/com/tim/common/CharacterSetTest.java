package com.tim.common;

import com.tim.common.utils.Base16Utils;
import org.junit.Test;

import java.util.Arrays;

/**
 * 字符集和字符编码测试
 * Created by tim.syh on 2017/1/8.
 */
public class CharacterSetTest {

    @Test
    public void testEncodeDecode() throws Exception {
        byte[] b = "你好，中国".getBytes("GBK"); //返回它的字节数组。
        System.out.println(Arrays.toString(b));//GBK下[-60, -29, -70, -61, -93, -84, -42, -48, -71, -6]
        System.out.println(Base16Utils.bytesToHexString(b));//UTF-8下:C4E3 BAC3 A3AC D6D0 B9FA
        System.out.println("-----------------------------------------------------------------");

        byte[] b_utf8 = "严".getBytes("UTF-8"); //返回它的字节数组。
        System.out.println(Arrays.toString(b_utf8));//UTF-8下[-28, -72, -91]
        System.out.println(Base16Utils.bytesToHexString(b_utf8));//UTF-8下:E4B8A5
        System.out.println("-----------------------------------------------------------------");

        byte[] b_gb2312 = "严".getBytes("GB2312"); //返回它的字节数组。
        System.out.println(Arrays.toString(b_gb2312));//GB2312下[-47, -49]
        System.out.println(Base16Utils.bytesToHexString(b_gb2312));//GB2312下:D1CF
        System.out.println("-----------------------------------------------------------------");

        byte[] b1_utf8 = "y".getBytes("UTF-8"); //返回它的字节数组。
        System.out.println(Arrays.toString(b1_utf8));//UTF-8下[-28, -72, -91]
        System.out.println(Base16Utils.bytesToHexString(b1_utf8));//UTF-8下:E4B8A5
        System.out.println("-----------------------------------------------------------------");

        byte[] b1_gb2312 = "y".getBytes("GB2312"); //返回它的字节数组。
        System.out.println(Arrays.toString(b1_gb2312));//GB2312下[-47, -49]
        System.out.println(Base16Utils.bytesToHexString(b1_gb2312));//GB2312下:D1CF
        System.out.println("-----------------------------------------------------------------");
    }

    @Test
    public void encodeDecode() throws Exception {
        String string = "中国abc";
        System.out.println(chinaToUnicode(string));
        System.out.println("\u4e2d\u56fdabc");
        System.out.println("\u8ff7");
    }

    /**
     * 把中文转成Unicode码
     */
    public static String chinaToUnicode(String str) {
        String result = "";
        for (int i = 0; i < str.length(); i++) {
            int chr1 = (char) str.charAt(i);
            if (chr1 >= 19968 && chr1 <= 171941) {//汉字范围 \u4e00-\u9fa5 (中文)
                result += "\\u" + Integer.toHexString(chr1);
            } else {
                result += str.charAt(i);
            }
        }
        return result;
    }

    @Test
    public void testCharacterConvert() throws Exception {
        byte[] b = "中国abc".getBytes(); //返回它的字节数组。
        System.out.println(Arrays.toString(b));//utf-8下[-28, -72, -83, -27, -101, -67, 97, 98, 99]
        byte[] bg = "中国abc".getBytes("GB2312"); //返回它的字节数组。
        System.out.println(Arrays.toString(bg));//GB2312下[-42, -48, -71, -6, 97, 98, 99]

        //"杈�" 是utf-8 下的"输7"，用GBK来读的时候就成了"杈�"，都恰好是4个字节。
        byte[] dd = "输7".getBytes("UTF-8");
        String str = new String(dd, "GBK");
        System.out.println(str); //输出"杈�"

        System.out.println(b.length); //返回的是9，因为默认是UTF-8，一个汉字三个字节
        System.out.println("中国abc".length()); //返回是5，返回的是字符的长度，总共5个字符。


        System.out.println("****************************");
        String msg = "中国abc";
        System.out.println(msg);
        int len = msg.getBytes().length;// 按操作系统默认编码来编码,因为该文件的编码方式为utf-8，所以返回为9
        System.out.println(len);
        try {
            len = msg.getBytes("GB2312").length;// 输7
            System.out.println("GB2312: " + len);
            len = msg.getBytes("GBK").length;// 输出7
            System.out.println("GBK: " + len);
            len = msg.getBytes("GB18030").length;// 输出7,// 2*2+3,一个汉字占2字节,一个英文字母一个字节
            System.out.println("GB18030: " + len);
            len = msg.getBytes("UTF-8").length;// 输出9,// 2*3+3=9,一个汉字占3字节,一个英文字母一个字节.
            System.out.println("UTF-8: " + len);
            len = msg.getBytes("UTF-16").length;// 输出12
            System.out.println("UTF-16: " + len);
            len = msg.getBytes("UTF-32").length;// 输出20
            System.out.println("UTF-32: " + len);
            len = msg.getBytes("Unicode").length;// 输出12
            System.out.println("Unicode: " + len);
        } catch (java.io.UnsupportedEncodingException e) {
            System.out.println(e.getMessage().toString());
        }
    }
}
