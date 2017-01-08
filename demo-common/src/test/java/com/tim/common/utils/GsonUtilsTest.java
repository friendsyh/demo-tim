package com.tim.common.utils;

import com.google.gson.reflect.TypeToken;

import com.tim.common.InitTestData;
import com.tim.common.domain.Student;
import com.tim.common.domain.Teacher;

import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GsonUtilsTest extends InitTestData {
    private String studentJsonStr;
    private String studentListJsonStr;
    private String teacherJsonStr;

    @Before
    public void init(){
        initObject();
        studentJsonStr = GsonUtils.objectToString(getStudent());
        studentListJsonStr = GsonUtils.objectToString(getTestStudentList());
        teacherJsonStr = GsonUtils.objectToString(getTeacher());
    }

    @Test
    public void testNullObj() throws Exception {

        //如果对象为null，返回的就是null
        System.out.println(GsonUtils.objectToString(null));
        System.out.println(GsonUtils.stringToObject(null, Map.class));

        //如果value对象为new Object(),序列化返回{}
        //如果value对象为null，默认情况不序列化这个key-value；但是可以在Gson new的时候配置这个参数
        Map<String, Object> testMap = new HashMap<String, Object>();
        testMap.put("item", new Object()); //{"item":{}}
        testMap.put("testnull", null);  //默认的情况下，value为null，直接不序列化这个对象
        System.out.println(GsonUtils.objectToString(testMap));
    }

    @Test
    public void testBasic() throws Exception {
        String testJsonString = "{\"success\":true;\"errorCode\":100;\"module\":\"this is a module\"}";
        Map object = GsonUtils.stringToObject(testJsonString, Map.class);
        Student newStudent = GsonUtils.stringToObject(studentJsonStr, Student.class);
        List<Student> newStudentList = GsonUtils.stringToObject(studentListJsonStr, new TypeToken<List<Student>>(){});
        Teacher newTeacher = GsonUtils.stringToObject(teacherJsonStr, Teacher.class);
    }
}
