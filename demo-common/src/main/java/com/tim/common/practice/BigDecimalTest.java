package com.tim.common.practice;

import java.math.BigDecimal;

/**
 * Created by tim.syh on 2017/2/27.
 */
public class BigDecimalTest {
    public static void main(String[] args) throws Exception {
        BigDecimal number1 = new BigDecimal(2.0).setScale(1);
        BigDecimal number2 = new BigDecimal(2.00).setScale(5);

        System.out.println(number1.equals(number2));
        System.out.println(number1.compareTo(number2));
    }

}
