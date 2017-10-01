package com.tim.common.datastructAndAlgori;

import com.tim.common.pojo.InitTestData;
import com.tim.common.domain.Person;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.ListIterator;
import java.util.Set;

/**
 * Created by tim.syh on 2017/1/8.
 */
public class ListTest extends InitTestData {

    @Before
    public void init(){
        initObject();
        testStringList = new ArrayList<String>();
        testStringList.add("tim");
        testStringList.add("lily");
        testStringList.add("lily");
        testStringList.add("lily");
        testStringList.add("gril");
        testStringList.add("baby");
        testStringList.add("baby");
        testStringList.add("baby1");
        testStringList.add("baby2");
    }

    @Test
    public void traverse() throws Exception {
        //打印list方法一
        System.out.println(testStringList);
        //打印list方法二
        ListIterator<String> iterator = testStringList.listIterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next() + "-------" + iterator.previousIndex() + "--------" + iterator.nextIndex());;
        }

        //list clear清除集合里面所有的元素，对象不会置空,只是清空里面的内容
        testStringList.clear();
    }

    @Test
    public void convertArray() throws Exception {
        //arrayList转为数组，list接口没有这个方法。并且toArray一定要传入参数。
        System.out.println("list to array get array begin.----------------------");
        String[] array =(String[]) testStringList.toArray(new String[testStringList.size()]);

        System.out.println("array toString() begin-----------------");
        System.out.println(Arrays.toString(array));

        System.out.println("array to list get list begin-------------");
        List<String> myList = Arrays.asList(array);
    }

    /**
     * 移除一个元素
     * @throws Exception
     */
    @Test
    public void removeElemet() throws Exception {
        //移除List里面的一个元素。
        List<Person> persons = new ArrayList<Person>();
        Person p1 = new Person("tim", 22);
        Person p2 = new Person("lily", 18);
        Person p3 = new Person("arong", 16);
        persons.add(p1);
        persons.add(p2);
        persons.add(p3);
        //这种方式走不通
//		for(Person person : persons){
//			if(person.getName().equals("lily")){
//				persons.remove(person);
//			}
//		}
        for(int i = persons.size() - 1; i >= 0;i--){
            Person person = persons.get(i);
            if(person.getName().equals("lily")){
                persons.remove(person);
            }
        }

        System.out.println(persons.size());
    }

    /**
     * List 去重
     */
    @Test
    public void removeDuplicate(){
        System.out.println("before removeDuplicate:" + testStringList);
        Set<String> set = new HashSet<String>(testStringList);
        testStringList = new ArrayList<String>(set);
        System.out.println("after removeDuplicate:" + testStringList);
    }
}
