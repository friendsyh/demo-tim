package com.tim.common.practice.exception;

import com.tim.common.domain.Person;
import com.tim.common.domain.Point;
import com.tim.common.domain.Student;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by tim.syh on 2017/3/18.
 * 必须要打印出堆栈的的记录方式才行
 *
 */
public class ExceptionPrint {

    private final Logger logger = LoggerFactory.getLogger(ExceptionPrint.class);

    public static void main(String[] args) {
//        exceptionStr();
        new ExceptionPrint().exceptionLogger();
    }

    private static void exceptionStr() {
        try {
            Object object = null;
            object.toString();
        } catch (Exception e) {
            System.out.println("###" + e.toString()); // java.lang.NullPointerException
            System.out.println("###" + e.getMessage()); //null
            System.out.println("###" + e.getLocalizedMessage()); //null
            e.printStackTrace(); //打印出堆栈
        }
    }

    private void exceptionLogger() {
        Person person = null;
        Point point = null;
        Student student = null;
        try {
            person = new Person("susu", 15);
            point = new Point(1,2);
            student = new Student("susu",25, "No.2 scholl");
            Object object = null;
            object.hashCode();
        } catch (Exception e) {
            logger.error(e.toString());
            //能够正常打印出堆栈。第一个符号使用perosn替代
            logger.error("####1111#####this is a exception test,person={},is error!s", person, e);
            //居然也能够正常打印出堆栈。第二个对象为空
            //2017-09-22 12:01:17,529 [ERROR] [demo-tim]| [ExceptionPrint] ####2222#####this is a exception test,person=Person(name=susu, age=15),student={}
            logger.error("####2222#####this is a exception test,person={},student={}", person, e);
            //居然也能够正常打印出堆栈。第二,第三个对象为空
            //2017-09-22 12:01:17,529 [ERROR] [demo-tim]| [ExceptionPrint] ####2222#####this is a exception test,person=Person(name=susu, age=15),student={},hello={}
            logger.error("####3333#####this is a exception test,person={},student={},hello={}", person, e);
            //常常使用的标准形式，能够正确打印出堆栈
            logger.error("####4444#####this is a exception test,person={},point={},student={}", person, point, student, e);

            //ponitX 设置为 Integer类型，打印正常
            logger.error("####5555#####this is a exception test,person={},pointx={}", person, new Integer(10));
        }
    }
}
