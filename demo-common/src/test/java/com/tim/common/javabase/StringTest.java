package com.tim.common.javabase;

import com.tim.common.domain.Student;
import com.tim.common.pojo.InitTestData;

import org.apache.commons.lang3.StringUtils;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
    public void testStringAppend() throws Exception {
        String ss1 = "user_info.t0.name.user_info";
        String[] array = ss1.split("\\.");
        List<String> list = Arrays.asList(array);
        Set<String> set = new HashSet<>(list);

        System.out.println(StringUtils.join(array, ","));
        System.out.println(StringUtils.join(list, ","));
        System.out.println(StringUtils.join(set, ","));
        System.out.println(ss1.substring(0, ss1.indexOf(".")));
        System.out.println(ss1.substring(ss1.lastIndexOf(".") + 1));
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

        String sss = "file:/opt/seiois/mls-server/python/run.py";
        if(sss.startsWith("file")){
            System.out.println(sss.split(":")[1]);
        } else{
            System.out.println(sss);
        }

        String ss1 = "user_info.t0.name";
        System.out.println(ss1.substring(ss1.indexOf(".") + 1));
        System.out.println(ss1.substring(ss1.lastIndexOf(".") + 1));
        System.out.println(ss1.substring(0, ss1.indexOf(".")));

        String ss2 = "/tmp/yuxiang/order_processed_100w.csv";
        System.out.println(ss2.substring(ss2.lastIndexOf("/") + 1, ss2.indexOf(".")));
//        System.out.println(ss2.substring(ss2.lastIndexOf("/")));
    }

    @Test
    public void getYinHao() throws Exception {
        String str="SPARK_EXECUTOR_CORES=\"4\" #Number of cores for the workers (Default: 1).";
        Pattern p = Pattern.compile("\"(.*?)\"");
        Matcher m = p.matcher(str);
        if(m.find()){
            System.out.println(m.group().trim().replace("\"","")+"");
        }
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
        String string = null;
//        System.out.println(string.isEmpty());  //会报空指针异常呢
        System.out.println(StringUtils.isEmpty(string));
        System.out.println(StringUtils.join(testStringList, "&&"));
        System.out.println(String.join("&&", testStringList));
    }

    @Test
    public void testSplit() throws Exception {
        String string = "运营商,移动;话费面值,500元";
//        int first = StringUtils.indexOf(string, "面值");
//        int second = StringUtils.indexOf(string, "元");
//        String result = StringUtils.substring(string, first + 3, second);
        System.out.println(string.substring(string.indexOf("面值") + 3, string.indexOf("元")));

        String esPath = "hdfs://vm16:8020/tmp/rulefind/135/partition/part-00001";
        String index = esPath.substring(esPath.lastIndexOf("part-") + 5, esPath.length());
        System.out.println(index);
    }

    @Test
    public void testReplace() throws Exception {
        String string = "editor 's notes";
        System.out.println(string.replace("'", "''"));
    }

    @Test
    public void testReg() throws Exception {
        String columnType = "varchar";
        if ("STRING".equals(columnType.toUpperCase())
                || "VARCHAR".equals(columnType.toUpperCase())
                || "TEXT".equals(columnType.toUpperCase())
                || columnType.matches("^varchar\\([1-9][0-9]*\\)")    //varchar(n)
                || columnType.matches("^char\\([1-9][0-9]*\\)")){
            System.out.println("OK");
        } else {
            System.out.println("ERROR");
        }
    }

    /**
     * 测试数据库类型表达式
     */
    @Test
    public void test() {
        Assert.assertEquals("String", setType("varchar"));
        Assert.assertEquals("String", setType("varchar(20)"));
        Assert.assertEquals("String", setType("varchar(500)"));
        Assert.assertEquals("String", setType("VARCHAR"));
        Assert.assertEquals("String", setType("VARCHAR(20)"));
        Assert.assertEquals("String", setType("VARCHAR(500)"));
        Assert.assertEquals("String", setType("Varchar(500)"));
    }

    public static String setType(String columnType) {
        if ("STRING".equals(columnType.toUpperCase())
                || "VARCHAR".equals(columnType.toUpperCase())
                || "CHAR".equals(columnType.toUpperCase())
                || "TEXT".equals(columnType.toUpperCase())
                || columnType.toLowerCase().matches("^varchar\\([1-9][0-9]*\\)")    //varchar(n)
                || columnType.toLowerCase().matches("^char\\([1-9][0-9]*\\)")){
            return "String";
        } else if ("DOUBLE".equals(columnType.toUpperCase())
                || "FLOAT".equals(columnType.toUpperCase())
                || "DECIMAL".equals(columnType.toUpperCase())
                || columnType.toLowerCase().matches("^float[48]")) {      //float4 float8
            return "Decimal";
        } else if ("INTEGER".equals(columnType.toUpperCase())
                || "INT".equals(columnType.toUpperCase())
                || "TINYINT".equals(columnType.toUpperCase())
                || "SMALLINT".equals(columnType.toUpperCase())
                || "MEDIUMINT".equals(columnType.toUpperCase())
                || "BIGINT".equals(columnType.toUpperCase())
                || columnType.toLowerCase().matches("^int[248]")             //int2 int4 int8
                || columnType.toLowerCase().matches("^serial[248]")) {      //serial2 serial4 serial8
            return "Long";
        } else {
            return "String";
        }
    }
}
