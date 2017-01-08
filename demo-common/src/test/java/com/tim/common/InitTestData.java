package com.tim.common;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

import com.tim.common.domain.Person;
import com.tim.common.domain.Point;
import com.tim.common.domain.Student;
import com.tim.common.domain.Teacher;

import java.util.List;
import java.util.Map;

import lombok.Data;

/**
 * 初始化测试数据,所有测试用例需要初始化数据使用
 * Created by tim.syh on 2017/1/7.
 */
@Data
public class InitTestData {
    private int testInt;
    private Integer testInteger;

    private boolean testBoolean;
    private Boolean testBooleanObj;

    private String testString;
    private String jsonString;

    private Person perosn;
    private Student student;
    private Point point;
    /** 符合对象，里面有List的student，也有student对象，也有point对象 */
    private Teacher teacher;

    private List<Student> studentList;
    private Map<String, Object> testMap;

    public void initObject(){
        perosn = new Person("tim-苏那个世界", 25);
        point = new Point(2,3);

        studentList = Lists.newArrayList();
        student = new Student("tim-苏那个世界", 28, "湖南师范大学");
        Student student2 = new Student("lily-小怪兽", 22, "湖南师范大学");
        studentList.add(student);
        studentList.add(student2);
        teacher = new Teacher("董新汉院长", 50, "湖南师范大学", studentList, point);

        testMap = Maps.newHashMap();
        testMap.put("nullKey", null);
        testMap.put("emptyObjKey", new Object());
        testMap.put("stringKey", "value1");
        testMap.put("objKey", perosn);
        testMap.put("listObjKey", studentList);
    }
}
