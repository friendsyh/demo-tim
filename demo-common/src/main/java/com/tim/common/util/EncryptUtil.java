package com.tim.common.util;

import java.io.UnsupportedEncodingException;
import java.security.GeneralSecurityException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class EncryptUtil {

	/**
	 * SHA-1加密算法
	 * 
	 * @param data
	 *            需要加密的明文
	 * @return 加密后的密文
	 * @throws GeneralSecurityException
	 * @throws NoSuchAlgorithmException
	 */
	public static String encryptSHA(String data) {
		try {
			MessageDigest sha = MessageDigest.getInstance("SHA-1");
			sha.update(data.getBytes());
			return bytes2Hex(sha.digest());
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * MD5加密算法
	 * 
	 * @param data
	 *            需要加密的明文
	 * @return 加密后的密文
	 * @throws UnsupportedEncodingException 
	 * @throws GeneralSecurityException
	 * @throws NoSuchAlgorithmException
	 */
	public static String encryptMD5(String data) {
		try {
			MessageDigest md5 = MessageDigest.getInstance("MD5");
			md5.update(data.getBytes("utf8"));
			return bytes2Hex(md5.digest());
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
			return null;
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return data;
	}

	/**
	 * 把密文字节数组转换成十六进制的字符串形式
	 * 
	 * */
	private static String bytes2Hex(byte[] bytes) {
		StringBuilder hexString = new StringBuilder();
		String temp = null;
		for (int i = 0; i < bytes.length; i++) {
//			byte b = bytes[i];
//			//是否为负数，默认不是负数
//			boolean negative = false;
//			if(b < 0){
//				negative = true;
//			}
//			
//			int inte = Math.abs(b);
//			if(negative) inte = inte | 0x80;
			temp = (Integer.toHexString(bytes[i] & 0xFF));
			if (temp.length() == 1) {
				hexString.append(0);
			}
			hexString.append(temp);
		}
		return hexString.toString();
	}
	
	/**
	 * 
	 * 生成6位数字随机码
	 * */
	synchronized public static String randomCode() {
		return String.valueOf((int)((Math.random() * 9 + 1) * 100000));
	}
	
	public static void main(String[] args) {
		System.out.println("MD5=" + encryptMD5("globalsellerplatform@thesaurus1482910027243#ok*") + (System.currentTimeMillis()/1000));
	}
	
}
