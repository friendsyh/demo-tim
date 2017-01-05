package com.tim.common.datastruct;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Set;

import com.tim.common.domain.Person;


public class TestMap {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//Map 的key还只能是String类型的，其他类型的还不行
		//Map personMap = new HashMap<int, Person>();
		String[] strings = {"abc","def"};
		HashMap<String, Object> testMap = new HashMap<String, Object>();
		Person p = new Person("tim",23);
		testMap.put("objectType", p);
		testMap.put("StringType", "hello world");
		testMap.put("stringArray",strings[1]);
		
		for(String key : testMap.keySet()) {
			System.out.println(key + " =" + testMap.get(key));
		}
		System.out.println(testMap.get("stringArray"));
		HashMap<String, String> hashMap = new HashMap<String, String>();
		//map的key值相同的时候会出现覆盖的情况
		hashMap.put("tim", "suyanghua");
		hashMap.put("tim", "liaowanying");
		System.out.println(hashMap.get("tim"));
		
		HashMap<String, Person> personsHashMap = new HashMap<String, Person>();
		personsHashMap.put("tim", p);
		System.out.println(personsHashMap.get("tim"));
		
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		Random random = new Random(47);
		for(int i = 0 ;i < 1000;i++){
			int key = random.nextInt(20);
			map.put(key, map.get(key) == null ? 0 : map.get(key) + 1);
		}
		System.out.println(map);
		System.out.println("foreach map begin----------------");
		for(int key : map.keySet()){
			System.out.println(map.get(key));
		}
		
		//利用泛型来遍历map
		Set<Map.Entry<Integer, Integer>> set = map.entrySet();
		for(Map.Entry<Integer, Integer> entry : set){
			System.out.println(entry.getKey() + ":" + entry.getValue());
		}
	}

}
