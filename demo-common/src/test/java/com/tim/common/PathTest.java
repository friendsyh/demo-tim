package com.tim.common;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * 路径相关测试
 * Created by tim.syh on 2017/1/8.
 */
public class PathTest extends InitTestData {

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

}
