package com.tim.common;

import com.google.common.collect.Lists;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.BeanUtils;

import java.util.List;

import com.tim.common.domain.Person;
import com.tim.common.domain.Point;
import com.tim.common.domain.Student;
import com.tim.common.domain.Teacher;
import com.tim.common.utils.GsonUtils;

/**
 * 测试BeanUtils类的深度拷贝。
 * 1.基本数据没问题。
 * 2.如果属性对象的某个类型是Object,没问题。
 * 3.如果属性对象是List类型，就有问题了。不是深度拷贝。
 * Created by tim.syh on 2016/12/23.
 */
public class BeanUtilsTest extends InitTestData {

    @Before
    public void init(){
        initObject();
    }

    @Test
    public void testCopyObject() {
        //能拷贝成功
        Person personCopy = new Person();
        BeanUtils.copyProperties(getPerosn(), personCopy);

        Teacher teacherCopy = new Teacher();
        BeanUtils.copyProperties(getTeacher(), teacherCopy);
        //teacher 的age不会改变
        teacherCopy.setAge(50000);
        //teacher 的point不会改变
        teacherCopy.setPoint(new Point(10000, 1000));
        //注意：：：：：teacher 的students[0] 会改变
        teacherCopy.getStudents().get(0).setSchoolName("yuzhou school");
    }
}
