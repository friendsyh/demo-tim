package com.tim.common.test;

import java.util.HashMap;
import java.util.Map;

/**
 * map 里面是可以存放多个null对象的.
 */
public class TestNull {

	public static void main(String[] args) {
		Map<String, Object> map = new HashMap<String, Object>();
//		HashMap<String, Object> map = null;
		System.out.println(map.size());
        map.put("null-1",null);
        map.put("null-2",null);
		if(null == map || map.size() < 1){
			System.out.println("is NULL");
		}
		Object o = map.get("null-1");
		
		map = null;
//		try {
			map.put("1", 2);
//		} catch (Exception e) {
//			System.out.println("出现空指针异常了!");
//		}
		System.out.println("出现空指针异常，还是执行了。");
	}

}
