package com.tim.common.myutils;

import java.security.MessageDigest;

public class CrcUtil {
    private static final char[] HEX_DIGITS = {
            '0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
            'A', 'B', 'C', 'D', 'E', 'F'};

    public static String MD5(String paramString) throws Exception {
        MessageDigest messageDigest = MessageDigest.getInstance("MD5");
        byte[] arrayOfByte2 = new byte[messageDigest.getDigestLength()];
        messageDigest.reset();
        messageDigest.update(paramString.getBytes("UTF-8"));
        byte[] arrayOfByte1 = messageDigest.digest();
        StringBuffer stringBuffer = new StringBuffer(arrayOfByte1.length * 2);
        for (byte b = 0; b < arrayOfByte1.length; b++) {
            byte b1 = (byte) (arrayOfByte1[b] & 0xFF);
            if (b1 < 16)
                stringBuffer.append("0");
            stringBuffer.append(Integer.toHexString(b1));
        }
        return stringBuffer.toString().toString();
    }

    public static String MD5_32(String paramString) throws Exception {
        MessageDigest messageDigest = MessageDigest.getInstance("MD5");
        byte[] arrayOfByte = new byte[messageDigest.getDigestLength()];
        messageDigest.reset();
        messageDigest.update(paramString.getBytes("UTF-8"));
        return toHexString(messageDigest.digest());
    }

    public static String getCrc(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5) throws Exception {
        return MD5(paramString1 + paramString2 + paramString3 + paramString4 + paramString5);
    }

    public static String toHexString(byte[] paramArrayOfByte) {
        StringBuilder stringBuilder = new StringBuilder(paramArrayOfByte.length * 2);
        for (byte b = 0; b < paramArrayOfByte.length; b++) {
            stringBuilder.append(HEX_DIGITS[(paramArrayOfByte[b] & 0xF0) >>> 4]);
            stringBuilder.append(HEX_DIGITS[paramArrayOfByte[b] & 0xF]);
        }
        return stringBuilder.toString();
    }
}