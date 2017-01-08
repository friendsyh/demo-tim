package com.tim.common.test;

import com.tim.common.domain.Person;
import com.tim.common.domain.ResultSet;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by tim.syh on 2016/6/29.
 */
public class TestInstanceOf {
    public static void main(String[] args) throws Exception{
		String sss = "my name is OK";
        System.out.println(sss instanceof String);
        System.out.println(sss instanceof Object);

        String number = "AAA";
        changeA(number);
        System.out.println(number);

        Person person = new Person("tim",21);
        changeObj(person);
        System.out.println(person.getName());

		Map<String,String> config = new HashMap<String, String>();
		config.put("name","n_a_m_e");
		config.put("age","Age");
        System.out.println(config instanceof Map);
    }

    public static void changeA(String a){
        a = "BBB";
    }

    public static void changeObj(Person person){
        person.setName("浅行");
    }

	public static void testObject() throws Exception{
		Person person1 = new Person("tim",21);
		Person person2 = new Person("tim",21);

		ResultSet resultSet = new ResultSet();
		resultSet.addResult(person1);
		resultSet.addResult(person2);

//		Person[] allPerson = (Person[]) resultSet.getResults(); //这样子实现不行，抛异常了不知道为啥。
		Object[] allPerson = resultSet.getResults();
		System.out.println(allPerson.length);
		for (int i = 0; i < allPerson.length; i++) {
			System.out.println(allPerson[i] instanceof Person);
			Person p = (Person) allPerson[i];
			System.out.println(p.getName());
		}
	}

}
