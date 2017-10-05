package com.tim.common.practice;

import com.tim.common.domain.Person;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Comparable<Person> 接口是用来定义比较对象的。定义在一个类里面，默认使用。
 * Compaertor<Person> 是比较器。用来自己定义比较策略。
 * Created by tim.syh on 2017/10/1.
 */
public class CompareTest {

    public static void main(String[] args) {

        List<Person> personList = new ArrayList<Person>();
        personList.add(new Person("tim", 28));
        personList.add(new Person("lily", 25));
        personList.add(new Person("baba", 53));

        System.out.println("originList:" + personList);

        //默认会使用Person类里面的方法
        Collections.sort(personList);
        System.out.println("default List:" + personList);

        //自己定义一个比较器。并且实现比较器的实现方法
        personList.sort(new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                return o1.getAge() - o2.getAge();
            }
        });

        System.out.println("age sort List:" + personList);
    }

}
