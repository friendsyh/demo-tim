package com.tim.common.datastruct;

import com.tim.common.pojo.InitTestData;

import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * Created by tim.syh on 2017/1/8.
 */
public class MapTest extends InitTestData {

    private static final Logger logger = LoggerFactory.getLogger(MapTest.class);

    @Before
    public void init(){
        initObject();
    }

    @Test
    public void nullTest() throws Exception {
        testMap = new HashMap<>();
        System.out.println(testMap.get("aaa"));  //空的map里面用任意的key获取的是null

        testMap.put("null-1",null);
        testMap.put("null-2",null);
        System.out.println(testMap.size()); //size的值为2
        if(null == testMap || testMap.size() < 1){
            System.out.println("is NULL");
        }

//        testMap.get("aaa") = null;  //编译报错。java容器里面的值是引用，不能复制了
    }

    @Test
    public void loggerTest() throws Exception {
        logger.info("rlt:{}", testMap);
    }

    @Test
    public void testInput() throws Exception {
        Map<String, String> hashMap = new HashMap<>();
        //map的key值相同的时候会出现覆盖的情况
        hashMap.put("tim", "suyanghua");
        hashMap.put("tim", "liaowanying");
        System.out.println(hashMap.get("tim"));
    }

    @Test
    public void traverse() throws Exception {
        //Map personMap = new HashMap<int, Person>();
        testMap = new HashMap<String, Object>();
        String[] stringArray = {"abc","def"};
        testMap.put("objectType", perosn);
        testMap.put("StringType", testString);
        testMap.put("stringArray",stringArray);
        System.out.println(testMap);
        //基本遍历
        System.out.println("foreach by keySet----------------");
        for(String key : testMap.keySet()) {
            System.out.println(key + " =" + testMap.get(key));
        }

        //利用Entry来遍历map
        System.out.println("foreach by entrySet----------------");
        for(Map.Entry<String, Object> entry : testMap.entrySet()){
            System.out.println(entry.getKey() + ":" + entry.getValue());
        }

        //用lamda表达式进行遍历
        System.out.println("lamda forEach----------------");
        testMap.forEach((k,v) -> System.out.println(k + ":" + v));
    }

    @Test
    public void testTreeMap() throws Exception {
        //默认treeMap是按照key从小到大的顺序
//        Map<Long, String> treeMap = new TreeMap<>();
        //新建的treeMap是按照key从大到小的顺序
        Map<Integer, String> treeMap = new TreeMap<>((v1, v2) -> v2 - v1);
        //map的key值相同的时候会出现覆盖的情况
        treeMap.put(32, "suyanghua");
        treeMap.put(18, "liaowanying");
        treeMap.put(2, "susu");
        treeMap.put(90, "yeye");
        treeMap.put(185214, "yeye");

        //打印的时候发现时按照年龄进行从小到大排序好的
        System.out.println(treeMap);
        //打印的时候发现时按照年龄进行从小到大排序好的
        for(Map.Entry<Integer, String> entry : treeMap.entrySet()) {
            System.out.println(entry.getKey() + ":" + entry.getValue());
        }

        //会自动把18转成一个对象
        System.out.println(treeMap.get(18));
        System.out.println(treeMap.get(185214));
    }
}
