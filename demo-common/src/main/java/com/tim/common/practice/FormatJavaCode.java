package com.tim.common.practice;

import lombok.Getter;
import lombok.Setter;

/**
 * 标准的java 代码
 * Created by tim.syh on 2017/1/19.
 */
public class FormatJavaCode {

    /** 用户名称 */
    @Setter
    @Getter
    private String userName;

    public static void main(String args[]) {
        // 缩进4个空格
        String say = "hello";
        // 运算符的左右必须有一个空格
        int flag = 0;
        // 关键词if与括号之间必须有一个空格，括号内f与左括号，1与右括号不需要空格
        if (flag == 0) {
            System.out.println(say);
        }

        // 左大括号前加空格且不换行；左大括号后换行
        if (flag == 1) {
            System.out.println("world");
            // 右大括号前换行，右大括号后有else，不用换行
        } else {
            System.out.println("ok");
            // 右大括号做为结束，必须换行
        }
    }
}
