package com.tim.common;

import com.tim.common.domain.Person;

import org.junit.Test;

/**
 * 测试是值传递还是引用传递
 * Created by tim.syh on 2017/1/8.
 */
public class FunctionTest {

    @Test
    public void testChangeFunctionValue() throws Exception {
        int org = 10;
        changeInt(org);
        System.out.println("int change =" + org);   //值还是10，不会变化

        Person person = new Person("tim",27);
        changeObj(person);
        System.out.println(person.toString()); //看情况的。如果方法里面new了对象那么不会修改person，如果没有new对象那么会修改person对象.

        String string = "abc";
        changeStr(string);
        System.out.println("string change = " + string); //结果还是abc，因为string s = "mm"，相当于执行String s = new String("mm");
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
     * 字符串和对象一样理解，但是s = "mm"，相当于s = new String("mm");因此导致s和string共同指向的对象打断，s指向了新对象。但是string还是指向abc。
     * @param s
     */
    private static void changeStr(String s) {
        s = "mm";
    }
}
