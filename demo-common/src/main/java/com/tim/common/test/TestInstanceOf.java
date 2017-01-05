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
        Map<String,Object> result = convertPojo2TopMap(person,config);
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

	private static <T> Map<String,Object> convertPojo2TopMap(T object, Map<String, String> diamondConfig) throws Exception{
		Map<String,Object> result = new HashMap<String, Object>();
		if(object == null){
			return result;
		}
		Class cls = object.getClass();
		Field[] fields = cls.getDeclaredFields();
		for(int i = 0; i < fields.length; i++){
			Field field = fields[i];
			field.setAccessible(true);
			for(String key : diamondConfig.keySet()){
				//处理features,写死的方式
				if("features".equals(key)){
					break;
				}
				//处理度量衡
				if("taosirDO".equals(key)){
					break;
				}
				//处理材质
				if("materialDO".equals(key)){

				}
				if(field.getName().equals(key)){
					result.put(diamondConfig.get(key), field.get(object));
					break;
				}
			}
		}
		return result;
	}

}
