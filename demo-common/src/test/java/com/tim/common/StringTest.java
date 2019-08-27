package com.tim.common;

import com.tim.common.pojo.InitTestData;

import org.junit.Before;
import org.junit.Test;

import java.util.UUID;

/**
 * 字符串相关测试
 * Created by tim.syh on 2017/1/8.
 */
public class StringTest extends InitTestData {

    @Before
    public void init() {
        initObject();
    }

    @Test
    public void testBasic() throws Exception {
        System.out.println(String.valueOf(null));
        System.out.println("".hashCode());

        String testString = "abc";
        System.out.println(testString + 5);
        System.out.println(testString.charAt(0));

        String ss = "123456";
        System.out.println(Long.parseLong(ss));
        System.out.println(UUID.randomUUID().toString());
    }

    @Test
    public void substringTest() throws Exception {
        String ss = "http://baidu.com?abc=123";
        System.out.println(ss.substring( 0,ss.indexOf("?"))); // http://baidu.com
        System.out.println(ss.substring(ss.indexOf("?"))); // ?abc=123
    }

    @Test
    public void equalsTest() throws Exception {
        String str1 = "aaa";
        String str2 = "aaa";
        String str3 = new String("aaa");
        System.out.println(str1 == str2);
        System.out.println(str1 == str3);
    }

    @Test
    public void testBasicFunction() throws Exception {
        System.out.println("'that','nice','thisThing'".contains("'this'"));

        String date = "20120607";
        String result = "(" + date.substring(0, 4) + "年" + date.substring(4, 6) + "月" + date.substring(6,8) + "日)";
        System.out.println(result);
        System.out.println(System.currentTimeMillis());
        System.out.println(date.substring(3,date.length()));
    }

    @Test
    public void testJsonString() throws Exception {
        testJsonString = "{\"success\":true;\"errorCode\":100;\"module\":\"this is a module\"}";
        System.out.println(testJsonString);
    }

    @Test
    public void testDeEncode() throws Exception {
        String string = "item.api.response.QueryItemListInfoRsp item.service.ItemService.queryItemListInfo(item.api.request.QueryItemListInfoReq) throws java.lang.Exception";
        string = string.replaceAll(".*Rsp ", "").replaceAll("\\(.*", "");
        System.out.println(string);

        System.out.println("转义开始测试：" + "abc\tde\refg");
        String test = "{\"TB2pbrIsXXXXXXUXXXXXXXXXXXX_!!0-taoxiaopu_sell.jpg\":{\"flag\":\"hr_interrupt\"}}";
        System.out.println("test=" + test);
        System.out.println("test=" + test.replace("\"hr_interrupt\"","\"interrupt\""));
    }

    @Test
    public void testInit() throws Exception {
        String string;
    }
}
