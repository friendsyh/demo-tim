package com.tim.common.datastruct;

import com.tim.common.domain.Person;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.ListIterator;
import java.util.Set;


public class TestArrayList {
	public static void main(String[] args) {
		List<String> list = new ArrayList<String>();
		list.add("tim");
		list.add("lily");
		list.add("lily");
		list.add("lily");
		list.add("gril");
		list.add("baby");
		list.add("baby");
		list.add("baby1");
		list.add("baby2");
        //打印list方法一
        System.out.println(list);
        //打印list方法二
        ListIterator<String> iterator = list.listIterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next() + "-------" + iterator.previousIndex() + "--------" + iterator.nextIndex());;
        }

        removeDuplicate(list);

		//list clear清除集合里面所有的元素，对象不会置空,只是清空里面的内容
		list.clear();
		list.add("baby3");

		//arrayList转为数组，list接口没有这个方法。并且toArray一定要传入参数。
        System.out.println("list to array get array begin.----------------------");
		String[] array =(String[]) list.toArray(new String[list.size()]);

		System.out.println("array toString() begin-----------------");
		System.out.println(Arrays.toString(array));
		
		System.out.println("array to list get list begin-------------");
		List<String> myList = Arrays.asList(array);

		//移除List里面的一个元素。
		List<Person> persons = new ArrayList<Person>();
		Person p1 = new Person("tim", 22);
		Person p2 = new Person("lily", 18);
		Person p3 = new Person("arong", 16);
		persons.add(p1);
		persons.add(p2);
		persons.add(p3);
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
     * 去重
     * @param srcList
     */
	private static void removeDuplicate(List<String> srcList){
        System.out.println("before removeDuplicate:" + srcList);
        Set<String> set = new HashSet<String>(srcList);
        srcList = new ArrayList<String>(set);
        System.out.println("after removeDuplicate:" + srcList);
    }
}
