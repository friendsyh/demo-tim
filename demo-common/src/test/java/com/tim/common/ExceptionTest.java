package com.tim.common;

import org.junit.Before;
import org.junit.Test;

/**
 * Created by tim.syh on 2017/1/8.
 */
public class ExceptionTest extends InitTestData {

    @Before
    public void init(){
        initObject();
    }

    @Test
    public void testFlow() throws Exception {
        testMap = null;
//		try {
        testMap.put("1", 2);
//		} catch (Exception e) {
//			System.out.println("出现空指针异常了!");
//		}
        System.out.println("出现空指针异常，还是执行了。");
    }

    @Test
    public void testFlowArray() throws Exception{
        try {
            showTest();
            System.out.println("111111111");
        } catch (Exception e) {
            //IndexOutOfBound Exception showTest()方法里面已经catch了，这里就不会catch了
            e.printStackTrace();
            System.out.println("this is catch the exception again!!");
        }
        System.out.println("but this will go on!");
    }

    private void showTest() throws Exception{
        //数组的三中定义方式
        int[] a = new int[]{1,2,3,4};
//		int[] b = new int[4];
//		int[] c = {1,2,3,4};

        try {
            System.out.println(a[0]);
            System.out.println(a[4]);
            //后面的就不会执行了!!!!!!!!!!!
            System.out.println(a[1]);
        } catch (Exception e) {
            System.out.println(a[2]);
            e.printStackTrace();
            System.out.println(a[3]);
        }
        System.out.println("then still go on excute!!");
    }
}
