package com.tim.common;

import com.tim.common.pojo.InitTestData;

import org.junit.Before;
import org.junit.Test;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.UUID;

/**
 * 字符串相关测试
 * Created by tim.syh on 2017/1/8.
 */
public class UrlDecodeTest extends InitTestData {

    @Before
    public void init() {
        initObject();
    }

    @Test
    public void testUrlDecode() {
        try {
            System.out.println(URLDecoder.decode("我们all is 好孩子", "UTF-8"));
            System.out.println(URLDecoder.decode("tetete11什么66789@#￥*（&*）*%", "UTF-8"));
            System.out.println(URLDecoder.decode("%25E6%2588%2591%25E4%25BB%25AC", "UTF-8"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
