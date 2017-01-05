package com.tim.common.domain;

import lombok.Data;

/**
 * 学生类
 * Created by tim.syh on 2016/12/23.
 */
@Data
public class Student extends Person {

    private String schoolName;

    public Student(){
    }

    public Student(String name, int age, String schoolName) {
        super(name, age);
        this.schoolName = schoolName;
    }
}
