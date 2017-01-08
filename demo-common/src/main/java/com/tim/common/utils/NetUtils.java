package com.tim.common.utils;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * 网络工具类
 * Created by tim.syh on 2017/1/7.
 */
public class NetUtils {

    /**
     * 获取调用程序的机器IP
     * @return
     */
    public static String getIP() throws UnknownHostException {
        return InetAddress.getLocalHost().getHostAddress();
    }

    /**
     * 获取调用程序的主机名称
     * @return
     */
    public static String getHostName() throws UnknownHostException {
        return InetAddress.getLocalHost().getHostName();
    }
}
