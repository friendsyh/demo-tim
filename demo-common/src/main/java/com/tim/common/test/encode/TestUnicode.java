package com.tim.common.test.encode;

public class TestUnicode {
	public static void main(String[] args) {
		String string = "中国abc";
		System.out.println(chinaToUnicode(string));
		System.out.println("\u4e2d\u56fdabc");
		System.out.println("\u8ff7");
	}
	
	/** 
     * 把中文转成Unicode码 
     * @param str 
     * @return 
     */  
    public static String chinaToUnicode(String str){  
        String result="";  
        for (int i = 0; i < str.length(); i++){  
            int chr1 = (char) str.charAt(i);  
            if(chr1>=19968&&chr1<=171941){//汉字范围 \u4e00-\u9fa5 (中文)  
                result+="\\u" + Integer.toHexString(chr1);  
            }else{  
                result+=str.charAt(i);  
            }  
        }  
        return result;  
    }  
}
