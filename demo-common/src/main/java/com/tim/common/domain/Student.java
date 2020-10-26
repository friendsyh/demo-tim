package com.tim.common.domain;

import lombok.Data;
import lombok.ToString;

/**
 * 学生类
 * Created by tim.syh on 2016/12/23.
 */
@Data
public class Student extends Person {

    private String schoolName;

    public Student(String name, int age, String schoolName) {
        super(name, age);
        this.schoolName = schoolName;
    }

    @Override
    public String toString() {
        return getName();
    }
}
