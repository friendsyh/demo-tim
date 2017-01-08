package com.tim.common.utils;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * 网络工具类测试
 * Created by tim.syh on 2017/1/7.
 */
public class NetUtilsTest {
    @Test
    public void getIP() throws Exception {
        System.out.println(NetUtils.getIP());
    }

    @Test
    public void getHostName() throws Exception {
        System.out.println(NetUtils.getHostName());
    }

}