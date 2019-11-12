package com.tim.common.datastructandalgori;

import java.util.LinkedList;

/**
 * Created by friendsyh on 2019/11/6.
 */
public class LinkedListTest {

    public static void main(String[] args) {
        LinkedList<Integer> linkedList = new LinkedList<>();
        linkedList.add(1);
        linkedList.add(2);
        linkedList.add(3);
        linkedList.remove(2); //remove index参数标识下标，是从0开始计算的。
        System.out.println(linkedList);
    }
}
