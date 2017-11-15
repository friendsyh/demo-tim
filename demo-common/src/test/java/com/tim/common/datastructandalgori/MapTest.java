package com.tim.common.datastructandalgori;

import com.tim.common.pojo.InitTestData;

import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Created by tim.syh on 2017/1/8.
 */
public class MapTest extends InitTestData {

    @Before
    public void init(){
        initObject();
    }

    @Test
    public void nullTest() throws Exception {
        testMap = new HashMap<String, Object>();
//		HashMap<String, Object> map = null;
        testMap.put("null-1",null);
        testMap.put("null-2",null);
        System.out.println(testMap.size());
        if(null == testMap || testMap.size() < 1){
            System.out.println("is NULL");
        }
        Object o = testMap.get("null-1");
    }

    @Test
    public void testInput() throws Exception {
        HashMap<String, String> hashMap = new HashMap<String, String>();
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
        System.out.println("foreach map begin----------------");
        for(String key : testMap.keySet()) {
            System.out.println(key + " =" + testMap.get(key));
        }

        //利用泛型来遍历map
        Set<Map.Entry<String, Object>> set = testMap.entrySet();
        for(Map.Entry<String, Object> entry : set){
            System.out.println(entry.getKey() + ":" + entry.getValue());
        }
    }
}
