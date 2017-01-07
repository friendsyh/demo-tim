package com.tim.common.utils;

import com.google.common.collect.Lists;
import com.google.gson.reflect.TypeToken;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;

import com.tim.common.domain.Point;
import com.tim.common.domain.Student;
import com.tim.common.domain.Teacher;
import com.tim.common.utils.JacksonUtils;

import com.tim.common.domain.CategoryNotStdDO;
import com.tim.common.domain.test.FeatureDO;
import com.tim.common.domain.test.FeatureResultDO;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.*;

public class JacksonUtilsTest {

    private Student student;
    private String studentJsonStr;

    private List<Student> studentList;
    private String studentListJsonStr;

    private Teacher teacher;
    private String teacherJsonStr;

    @Before
    public void init(){
        student = new Student("tim", 28, "No.2 school");
        studentJsonStr = GsonUtils.objectToString(student);
        Student student1 = new Student("lily", 20, "zhuzhou No.1 shcool");

        studentList = Lists.newArrayList();
        studentList.add(student);
        studentList.add(student1);
        studentListJsonStr = GsonUtils.objectToString(studentList);

        teacher = new Teacher("teacher",50,"No.2 school", studentList, new Point(10,20));
        teacherJsonStr = GsonUtils.objectToString(teacher);
    }

    @Test
    public void testJsonNode() throws Exception {
        JsonNode jsonNode11 = JacksonUtils.stringToObject(studentListJsonStr);
        if(jsonNode11.isArray()){
            System.out.println(jsonNode11.size());
        }
        JsonNode jsonNode12 = JacksonUtils.stringToObject(teacherJsonStr);

        JsonNode jsonNode21 = jsonNode12.get("students");
        if(jsonNode21.isArray()){
            System.out.println(jsonNode11.size());
        }
        System.out.println(jsonNode12.get("age"));
    }

    @Test
    public void testBasic() throws Exception {
        Student newStudent = JacksonUtils.stringToObject(studentJsonStr, Student.class);

        List<Student> newStudentList = JacksonUtils.stringToObject(studentListJsonStr, new TypeReference<List<Student>>() {});

        Teacher newTeacher = JacksonUtils.stringToObject(teacherJsonStr, Teacher.class);
    }

}
