package com.tim.common.test;

import com.google.common.collect.Lists;

import org.springframework.beans.BeanUtils;

import java.util.List;

import com.tim.common.domain.Person;
import com.tim.common.domain.Point;
import com.tim.common.domain.Student;
import com.tim.common.domain.Teacher;

/**
 * 测试BeanUtils类的深度拷贝。
 * 1.基本数据没问题。
 * 2.如果属性对象的某个类型是Object,没问题。
 * 3.如果属性对象是List类型，就有问题了。不是深度拷贝。
 * Created by tim.syh on 2016/12/23.
 */
public class TestBeanUtils {

    public static void main(String[] args) {
        Person tim = new Person("tim", 25);
        Person timCopy = new Person();
        BeanUtils.copyProperties(tim, timCopy);

        List<Student> students = Lists.newArrayList();
        Student s1 = new Student("s1", 11, "No.2");
        Student s2 = new Student("s2", 12, "No.2");
        Student s3 = new Student("s3", 11, "No.2");
        students.add(s1);students.add(s2);students.add(s3);
        Point point = new Point(2,3);

        Teacher teacher = new Teacher("Mr Wang", 50, "No.2", students, point);
        Teacher teacherCopy = new Teacher();
        BeanUtils.copyProperties(teacher, teacherCopy);
        teacher.setAge(50000);
        teacher.setPoint(new Point(10000, 1000));
        teacher.getStudents().get(0).setSchoolName("yuzhou school");
    }
}
