package com.tim.common;

import com.tim.common.domain.ManyPropertiesObject;
import com.tim.common.domain.Person;

import org.junit.Before;
import org.junit.Test;

import java.util.Date;

/**
 * 测试对象使用
 * Created by tim.syh on 2017/1/7.
 */
public class ObjectTest extends InitTestData {

    @Before
    public void init(){
        initObject();
    }

    @Test
    public void testInstanceOf() throws Exception {
        //字符串类型都是true
        System.out.println(testString instanceof String);
        System.out.println(testString instanceof Object);
    }

    @Test
    public void TestObjectInit(){
        /**初始化object的结果总结：基本类型有默认值，所有对象对象都为null，注意String是对象类型
         * 1.String : null
         * 2.char : 第一个unicode编码字符0
         * 3.byte : 0
         * 4.Byte : null
         * 5.boolean : fasle
         * 6.Boolean : null
         * 7.int : 0
         * 8.Integer : null
         * 9.double : 0.0
         * 10.Double : null
         * 11.对象都是null
         * 注意：long 和 int类似，float 和double类型
         */
        ManyPropertiesObject object = new ManyPropertiesObject();

        // new 一个Date对象为 今天的日期
        testUtilDate = new Date();
        testSqlDate = new java.sql.Date(testUtilDate.getTime()); //普通date转sql date

//        testIntObject = new Integer();  //报错,初始化Integer需要指定
    }

    @Test
    public void testChangeFunctionValue() throws Exception {
        //string的值不会修改，person的值会修改
        changeBasic(testString);
        changeObj(perosn);
    }

    public static void changeBasic(String string){
        string = "BBB";
    }

    public static void changeObj(Person person){
        person.setName("浅行");
    }
}
