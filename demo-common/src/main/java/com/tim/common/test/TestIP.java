package com.tim.common.test;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class TestIP {

    /**
     * @param args
     */
    public static void main(String[] args) {

        String IP = null;
        String host = null;
        try {
            InetAddress ia = InetAddress.getLocalHost();
            host = ia.getHostName();//获取计算机名字
            IP = ia.getHostAddress();//获取IP
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
        System.out.println(host);
        System.out.println(IP);
    }

}
