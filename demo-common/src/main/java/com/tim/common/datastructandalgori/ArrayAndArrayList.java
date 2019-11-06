package com.tim.common.datastructandalgori;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

/**
 * Created by friendsyh on 2019/11/6.
 */
public class ArrayAndArrayList {

    public static void main(String[] args) {
        //数组初始化的形式
        int[] array1 = new int[10];
        int[] array2 = {10,20};
//        int[] array3 = new int[5]{10,20};   //错误的初始化方式

        //arrayList是线程不安全的。vector是线程安全的。比如size()方法，vector就是加了一个synchronized关键字。
        ArrayList<Integer> arrayList1 = new ArrayList<>();
        arrayList1.size();
        arrayList1.add(5);

        Vector<Integer> vector1 = new Vector<>();
        vector1.size();
    }
}
