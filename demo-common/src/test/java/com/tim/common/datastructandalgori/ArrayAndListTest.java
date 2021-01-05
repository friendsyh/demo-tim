package com.tim.common.datastructandalgori;

import com.google.common.collect.Lists;

import com.tim.common.pojo.InitTestData;

import org.apache.commons.lang3.ArrayUtils;
import org.junit.Before;
import org.junit.Test;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by tim.syh on 2017/1/8.
 */
public class ArrayAndListTest extends InitTestData {

    @Before
    public void init(){
        initObject();
    }

    public void testArrayInit() throws Exception {
        //数组初始化的形式
        int[] array1 = new int[10];
        int[] array2 = {10,20};
        int[] array3 = new int[]{10,20};
//        int[] array3 = new int[5]{10,20};   //错误的初始化方式
    }

    /**
     * 总结来说Arrays类，最好不要使用这个类。
     * 1.Arrays.asList(array),array参数只能是对象类型，不能是基本类型
     * 2.Arrays.asList(array) 返回的ArrayList不是java的ArrayList，是一个内部类，不能进行add操作
     * 3.Arrays.asList(array)如果修改array对返回的List也有影响
     * @throws Exception
     */
    @Test
    public void array2List() throws Exception {
        int[] intArray = new int[]{1,3,4,5};
        List intList = Arrays.asList(intArray);
        System.out.println(intList.size()); //打印的Size=1呢。因为Arrays.asList 只能接受对象类型的元素。基本类型得元素会报错。

        Integer[] intergerArray = new Integer[]{1,3,4,5};
        List integerList = Arrays.asList(intergerArray);
        System.out.println(integerList.size()); //打印的Size=4,这个是正确的解
//        integerList.add(10); //这个add执行异常，因为Arrays.asList返回的ArrayList不是java自带的，而是一个内部类，没有add方法

        //最好的数组转List的方式如下：
        List<Integer> list1 = new ArrayList<>(Arrays.asList(intergerArray)); //但是这种方法也只能针对对象类型，基本元素数组会报错

        //通过stream流进行转换
        List<Integer> list2 = Arrays.stream(new int[]{1,3,4,5}).boxed().collect(Collectors.toList());
        List<String> stringList = Stream.of(new String[]{"lily","tom"}).collect(Collectors.toList());
    }

    /**
     * 用泛型解决打印任何类型的数组
     * @param <T>
     * @param t
     */
    public static <T> void printArray(T[] t){
        for (T t2 : t) {
            System.out.println(t2);
        }
    }

    /**
     * 用反射解决打印任何类型的数组
     */
    public static void printArrayByReflect(Object obj) {
        //obj.getClass() == Arrays.class;
        if(obj.getClass().isArray()){
            int length = Array.getLength(obj);
            for(int i =0 ;i < length;i++){
                System.out.println(Array.get(obj, i));
            }
        }else{
            System.out.println(obj);
        }
    }

}
