package com.tim.common.practice.exception;

/**
 * Created by tim.syh on 2017/3/18.
 */
public class ExceptionPrint {
    public static void main(String[] args) {
        exceptionStr();
    }

    private static void exceptionStr(){
        try {
            Object object = null;
            object.toString();
        } catch (Exception e) {
            System.out.println("###" + e.toString()); // java.lang.NullPointerException
            System.out.println("###" + e.getMessage()); //null
            System.out.println("###" + e.getLocalizedMessage()); //null
            e.printStackTrace(); //打印出堆栈
        }
    }
}
