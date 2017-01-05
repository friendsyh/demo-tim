package com.tim.common.domain;

import java.util.List;

import lombok.Data;

/**
 * 教师类，一个教师多个学生
 * Created by tim.syh on 2016/12/23.
 */
@Data
public class Teacher extends Person{

    private String schoolName;

    private List<Student> students;

    private Point point;

    public Teacher(){}

    public Teacher(String name, int age, String schoolName, List<Student> students, Point point) {
        super(name, age);
        this.schoolName = schoolName;
        this.students = students;
        this.point = point;
    }
}


