package com.tim.common.datastructandalgori;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by friendsyh on 2020/9/2.
 */
public class TestHashMap {
    public static void main(String[] args) {
        Map<String, Long> map1 = new HashMap<>();
        System.out.println(map1.get("123"));  //空的map里面获取到的是null

        map1.put("aaa", 5L);
        map1.put("bbb", 4L);
//        map1.get("aaa") = null;  //编译报错。java容器里面的值是引用，不能复制了


    }
}
