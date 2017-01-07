package com.tim.common.utils;

import org.apache.commons.lang3.StringUtils;

import java.io.IOException;
import java.net.InetAddress;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Random;
import java.util.UUID;


/**
 * UUID generate
 * @author tim.syh
 * @since 20160613
 */
public class UniqIDUtils {
    private static char[] digits = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f' };
    private static UniqIDUtils me = new UniqIDUtils();
    private String hostAddr;
    private Random random = new SecureRandom();
    private MessageDigest mHasher;
    private UniqTimer timer = new UniqTimer();


    private UniqIDUtils() {
        try {
            InetAddress addr = InetAddress.getLocalHost();

            hostAddr = addr.getHostAddress();
        }
        catch (IOException e) {
            hostAddr = String.valueOf(System.currentTimeMillis());
        }

        if (StringUtils.isBlank(hostAddr) || "127.0.0.1".equals(hostAddr)) {
            hostAddr = String.valueOf(System.currentTimeMillis());
        }

        try {
            mHasher = MessageDigest.getInstance("MD5");
        }
        catch (NoSuchAlgorithmException nex) {
            mHasher = null;
        }
    }


    public static UniqIDUtils getInstance() {
        return me;
    }


    public String getHostAddr() {
        return hostAddr;
    }


    private String getUniqID() {
        StringBuffer sb = new StringBuffer();
        long t = timer.getCurrentTime();

        sb.append(t);

        sb.append("-");

        sb.append(random.nextInt(89999) + 10000);

        sb.append("-");
        sb.append(hostAddr);

        sb.append("-");
        sb.append(Thread.currentThread().hashCode());
        sb.append("-");
        sb.append(UUID.randomUUID());

        return sb.toString();
    }


    public String generateUUID() {
        return hash(getUniqID());
    }


    public synchronized String hash(String str) {
        byte[] bt = mHasher.digest(str.getBytes());
        int l = bt.length;

        char[] out = new char[l << 1];

        for (int i = 0, j = 0; i < l; i++) {
            out[j++] = digits[(0xF0 & bt[i]) >>> 4];
            out[j++] = digits[0x0F & bt[i]];
        }

        return new String(out);
    }


    public String XOR2(String str32) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str32.length(); i++) {
            sb.append(str32.charAt(i) ^ 2);
        }
        return sb.toString();
    }

    private class UniqTimer {
        private long lastTime = System.nanoTime();


        public synchronized long getCurrentTime() {
            long currTime = System.nanoTime();
            lastTime = Math.max(lastTime, currTime);
            return lastTime;
        }
    }

    public static void main(String[] args) {
        System.out.println(UniqIDUtils.getInstance().generateUUID());
    }
}
