package com.tim.common.datastruct;

import com.tim.common.domain.Student;
import com.tim.common.pojo.InitTestData;
import com.tim.common.domain.Person;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Set;
import java.util.Vector;
import java.util.stream.Collectors;

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
    public void testThreadSafe() {
        //arrayList是线程不安全的。vector是线程安全的。比如size()方法，vector就是加了一个synchronized关键字。
        Vector<Integer> vector1 = new Vector<>();
        vector1.size();
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
        System.out.println("list to array get array begin----------------------");
        String[] array =(String[]) testStringList.toArray(new String[testStringList.size()]);

        System.out.println("array toString() begin-----------------");
        System.out.println(Arrays.toString(array));

        System.out.println("array to list get list begin-------------");
        List<String> myList = Arrays.asList(array);
        //Arrays.asList()方法返回的List是不可以被修改的。因为返回的List并不是jdk中的List，而是一个内部类
//        myList.add("测试List是否可以修改");
    }

    /**
     * 使用foreach如果原来对象有add或者remove会抛出异常。使用迭代器模式(foreach语句)移除的时候会抛出异常。我们使用迭代器移除的过程
     * 1. hasNext()判断是否有下一个元素。这里是通过当前游标cursor == size来判断。
     * 2. next()方法的时候，会判断到在迭代周期内列表做过修改就会抛ConcurrentModificationException异常。
     * 解决方案：不能使用foreach就使用for语句啦。经过测试发现size<2的时候可以使用add和remove方法。
     * @throws Exception
     */
    @Test
    public void foreachElemetException() {
        ArrayList<Integer> integerArrayList = new ArrayList<>();
        integerArrayList.add(0);
        integerArrayList.add(1);
        integerArrayList.add(2);
        integerArrayList.add(3);
        System.out.println("old list:" + integerArrayList);
        //这样子就抛异常了。
        for(Integer integer : integerArrayList) {
            integerArrayList.add(5); //add也会抛出异常
//            integerArrayList.remove(5); //remove也会抛出异常
        }
        System.out.println("old list:" + integerArrayList);

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
        //【错误移除元素方法】有时候会抛异常，参见上面一个测试用例
        for(Person person : persons){
            if(person.getName().equals("tim")){
                persons.remove(person);
            }
        }

//        //【正确移除元素方法一】
//        for(int i = 0; i < persons.size(); i++){
//            Person person = persons.get(i);
//            if(person.getName().equals("tim")){
//                persons.remove(person);
//            }
//        }

//        //【正确移除元素方法二】
//        List<Person> newPersons = persons.stream().filter(person -> !person.getName().equals("tim")).collect(Collectors.toList());
//        System.out.println(newPersons);

        System.out.println(persons);
    }

    /**
     * List 去重。把List转成Set然后再转回来就行了
     */
    @Test
    public void removeDuplicate(){
        System.out.println("before removeDuplicate:" + testStringList);
        Set<String> set = new HashSet<>(testStringList);
        testStringList = new ArrayList<>(set);
        System.out.println("after removeDuplicate:" + testStringList);
    }

    @Test
    public void sortedLamda(){
        initObject();
        System.out.println("before sorted:" + testStudentList);
//        testStudentList.sort((s1, s2) -> s1.getAge().compareTo(s2.getAge())); //按照年龄从小到大排序
//        testStudentList.sort((s1, s2) -> s2.getAge().compareTo(s1.getAge())); //按照年龄从大到小排序

//        testStudentList.sort((s1, s2) -> Integer.compare(s1.getAge(), s2.getAge())); //按照年龄从小到大排序
        testStudentList.sort((s1, s2) -> Integer.compare(s2.getAge(), s1.getAge())); //按照年龄从大到小排序

//        Collections.sort(testStudentList, Comparator.comparing(Student::getAge)); //从小到达排序

        System.out.println("after sorted:" + testStudentList);
    }

    /**
     * list 转 map之后还会保持原来的顺序吗。
     * 顺序肯定会有变化，因为map是根据hash进行保存的
     */
    @Test
    public void list2MapSort() {
        Map<String, String> studentMap = new HashMap<>();
        for(Student student : testStudentList) {
            studentMap.put(student.getName(), student.toString());
        }

        Map<String, String> map1 = testStudentList.stream().collect(Collectors.toMap(Student::getName, Student::toString));
        Map<String, String> map2 = testStudentList.stream().collect(Collectors.toMap(s -> s.getName(), s -> s.toString()));

        System.out.println("OK");
    }

}
