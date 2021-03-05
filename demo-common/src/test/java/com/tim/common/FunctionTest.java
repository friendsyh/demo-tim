package com.tim.common;

import com.tim.common.domain.Person;

import org.junit.Test;

import java.math.BigDecimal;

/**
 * 测试是值传递还是引用传递。只有标准的对象类型（不包括字符串类型）传入会修改对象的值，其他函数内都改变不了外面的值。
 * Created by tim.syh on 2017/1/8.
 */
public class FunctionTest {

    @Test
    public void testChangeFunctionValue() throws Exception {
        int org = 10;
        changeInt(org);
        System.out.println("int change =" + org);   //值还是10，不会变化

        Integer org1 = 20;
        changeInteger(org1);
        System.out.println("Integer change =" + org1);   //值还是20，不会变化

        Person person = new Person("tim",27);
        changeObj(person);
        System.out.println(person.toString()); //看情况的。如果方法里面new了对象那么不会修改person，如果没有new对象那么会修改person对象.

        String string = "abc";
        changeStr(string);
        System.out.println("string change = " + string); //结果还是abc，因为string s = "mm"，相当于执行String s = new String("mm");

        BigDecimal value = new BigDecimal("20.5");
        changeBigDecmail(value);
        System.out.println("bigdecimal change = " + value); //结果还是abc，因为string s = "mm"，相当于执行String s = new String("mm");
    }

    /**
     * 值传递，不会修改org的值。
     * x的值变成10000了，但是函数体释放之后x变量就不存在了，但是org的值还是10
     * @param x
     */
    private static void changeInt(int x) {
        x = 10000;
    }

    /**
     * 值传递，不会修改org的值。
     * 不管里面有没有new对象，都不会改变原来的值
     * @param x
     */
    private static void changeInteger(Integer x) {
//        x = 10000; //因为这个x=10000和字符串一样，也是相当于x = new Integer(10000);创立一个新对象
        x = new Integer(10000); //函数外面不会改变
    }

    /**
     * 也是值传递。
     *
     * 如果是p = new Person("lily", 25);
     * 1.p和person都指向tim对象。2.p指向了new的lily对象，相当于p和person已经分离了 3.因此person对象的值还没没有改变
     *
     * 如果是p.setName("lily");
     * 1.p和person都指向tim对象。2.p和person的值都会修改掉。因此结果会修改。p和person对应的还是原始的那个person对象。
     * @param p
     */
    private static void changeObj(Person p) {
        p = new Person("lily", 25);
//        p.setName("lily");
    }

    /**
     * 字符串和对象一样理解，但是s = "mm"，相当于s = new String("mm");因此导致s和string共同指向的对象打断，s指向了新对象。但是原来的string还是指向abc。
     * @param s
     */
    private static void changeStr(String s) {
        s = "mm";
    }

    /**
     * 如果这样子传入字符串，append是有效的。因为外面的String和里面的s指向同一个对象
     * @param s
     */
    private static void changeStr1(StringBuffer s) {
        s.append("test");
    }

    /**
     *
     * @param number
     */
    private static void changeBigDecmail(BigDecimal number) {
//        number = new BigDecimal("10000"); //肯定不会改变函数外面的值
        number.add(new BigDecimal(10.5));  //也不会改变函数外面的值，因为源码是new了一个新对象，要返回外面的值，只能return。这个和StringBuffer不一样，StringBuffer是在原来对象追加
    }
}
