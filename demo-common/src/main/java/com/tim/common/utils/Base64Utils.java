package com.tim.common.utils;

import org.apache.commons.codec.binary.Base64;

/**
 * 
 * Base64 的公共类
 * @author tim.syh
 *
 */
public class Base64Utils {

	/**
     * Base64 字符串转字节数组的时候。因为Base64字符不是标准字符，把+转成-，把/转成_，因此需要转换回来
     * 标准Base64最后两个字符是+和/,但是这个两个字符在URL中有特殊意义，因此url safe的是吧+转换成-，把/转换成_。现在解码需要置换回来。
     * @param param
     * @return
     */
    public static byte[] decodeUrlSafe(String param) {
    	if(param == null){
    		return null;
    	}
    	try {
    		String result = param.replace("-", "+").replace("_", "/");
    		if(result.length() % 4 == 2){
    			result += "=="; 
    		}
    		if(result.length() % 4 == 3){
    			result += "="; 
    		}
    		return Base64.decodeBase64(result.getBytes());
		} catch (Exception e) {
			e.printStackTrace();
		}
        return null;
    }
    
    /**
     * 字符串反Base64成字节数组
     * @param param
     * @return
     */
    public static byte[] base64StringToByte(String param){
    	if(param == null){
    		return null;
    	}
    	try {
    		return Base64.decodeBase64(param.getBytes());
		} catch (Exception e) {
			e.printStackTrace();
		}
        return null;
    }
    
    /**
     * 字节数组Base64成字符串
     * @return
     */
    public static String base64ByteToString(byte[] bytes){
    	if(bytes == null || bytes.length < 1){
    		return null;
    	}
    	try {
			return Base64.encodeBase64String(bytes);
		} catch (Exception e) {
			e.printStackTrace();
		}
    	return null;
    }
}
