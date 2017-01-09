package com.tim.common;

import com.tim.common.domain.Point;
import com.tim.common.pojo.InitTestData;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * 反射和class相关相关测试
 * Created by tim.syh on 2017/1/8.
 */
public class ReflectTest extends InitTestData {

    @Before
    public void init() {
        initObject();
    }

    @Test
    public void getClassInfo() throws Exception {
        Point point = new Point(1, 2);
        Class clazz1 = point.getClass();
        Class clazz2 = Point.class;
        Class clazz3 = Class.forName("com.tim.common.domain.Point");

        System.out.println(clazz1 == clazz2); //true,同一个对象
        System.out.println(clazz1 == clazz3); //true,同一个对象
    }

    @Test
    public void testClassInfo() throws Exception {
        Point point = new Point(1, 2);

        Class clazz1 = point.getClass();  //这种方法虽然是根据对象获取，但是也是获取类的内容，和对象无关
        System.out.println(clazz1.isPrimitive()); //false 是否是基本数据类型
        System.out.println(clazz1.isArray()); //false
        System.out.println(clazz1.getName()); //com.tim.common.domain.Point
        System.out.println(clazz1.getClassLoader()); // sun.misc.Launcher$AppClassLoader@14dad5dc
        Field[] fields = clazz1.getDeclaredFields();  //两个Field
        Method[] methods = clazz1.getMethods(); //14个method
    }

}
