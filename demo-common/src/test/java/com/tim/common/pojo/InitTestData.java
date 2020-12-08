package com.tim.common.pojo;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

import com.tim.common.domain.Person;
import com.tim.common.domain.Point;
import com.tim.common.domain.Student;
import com.tim.common.domain.Teacher;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import lombok.Data;

/**
 * 初始化测试数据,所有测试用例需要初始化数据使用
 * Created by tim.syh on 2017/1/7.
 */
@Data
public class InitTestData {
    protected String testString;
    protected String testJsonString;

    protected byte testByte;
    protected Byte testByteObj;

    protected boolean testBoolean;
    protected Boolean testBooleanObject;

    protected int testInt;
    protected Integer testInteger;

    protected double testDouble;
    protected Double testDoubleObject;

    protected long testLong;
    protected Long testLongObject;

    protected Date testUtilDate;
    protected java.sql.Date testSqlDate;

    protected String[] testStringArray;
    protected List<String> testStringList;
    protected List<Student> testStudentList;
    protected Map<String, Object> testMap;

    protected Person perosn;
    protected Student student;
    protected Point point;
    /** 符合对象，里面有List的student，也有student对象，也有point对象 */
    protected Teacher teacher;
    protected ResultDO<Point> resultDO;

    public void initObject(){
        testString = "this is a test string";

        testMap = Maps.newHashMap();
        testMap.put("nullKey", null);
        testMap.put("emptyObjKey", new Object());
        testMap.put("stringKey", "value1");
        testMap.put("objKey", perosn);
        testMap.put("listObjKey", testStudentList);

        testStringList = new ArrayList<>();
        testStringList.add("suyanghua");
        testStringList.add("lily");
        testStringList.add("susu");
        testStringList.add("rongrong");
        testStringList.add("biaobiao");

        perosn = new Person("tim-苏那个世界", 25);
        point = new Point(2,3);

        testStudentList = Lists.newArrayList();
        student = new Student("tim", 28, "湖南师范大学");
        Student student1 = new Student("susu", 5, "清华大学");
        Student student2 = new Student("lily", 22, "湖南师范大学");
        Student student3 = new Student("rongrong", 25, "大连海事大学");
        Student student4 = new Student("biaobiao", 25, "湖南理工大学");
        Student student5 = new Student("高晓松", 90, "清华大学");
        testStudentList.add(student);
        testStudentList.add(student1);
        testStudentList.add(student2);
        testStudentList.add(student3);
        testStudentList.add(student4);
        testStudentList.add(student5);

        teacher = new Teacher("董新汉院长", 50, "湖南师范大学", testStudentList, point);

        resultDO = ResultDO.successResult(point);

        System.out.println("***************************************************");
        System.out.println("**********init test data success!!!!!!!!!*********");
        System.out.println("***************************************************");
    }
}
