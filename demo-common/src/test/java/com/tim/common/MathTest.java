package com.tim.common;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * 数学相关测试
 * Created by tim.syh on 2017/1/8.
 */
public class MathTest extends InitTestData {

    @Before
    public void init() {
        initObject();
    }

    @Test
    public void testOperation() throws Exception {
        //除法，5/2=2   5.0/2=2.5
        Assert.assertEquals(2.5, (5.0 / 2), 0);
        Assert.assertEquals(2, (5 / 2), 0);

        //向上取整,比如2.2返回3.0; 2.0返回2.0
        Assert.assertEquals(3.0, Math.ceil(2.2), 0);
        Assert.assertEquals(2.0, Math.ceil(2.0), 0);
    }

    @Test
    public void getRandomDouble() throws Exception {
        double a = 5;
        for (int i = 0; i < 100; i++) {
            System.out.println(getRandom(1.15, 2.65));
        }
    }

    @Before
    public void getRandomInt() throws Exception {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        Random random = new Random(47);
        for(int i = 0 ;i < 1000;i++){
            int key = random.nextInt(20);
            map.put(key, map.get(key) == null ? 0 : map.get(key) + 1);
        }
        System.out.println(map);
    }

    private double getRandom(double min, double max) {
        return Math.random() * (max - min) + min;
    }
}
