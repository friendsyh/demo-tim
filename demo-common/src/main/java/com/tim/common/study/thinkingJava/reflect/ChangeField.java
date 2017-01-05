package com.tim.common.study.thinkingJava.reflect;

import java.lang.reflect.Field;

import com.tim.common.domain.Point;


public class ChangeField {

	//把对象的所有string类型的成员变量中的字符'a' 改成字符'b'
	public static void changeField(Object obj) throws Exception {
		Field[] fields = obj.getClass().getFields();
		for (Field field : fields) {
			if(field.getType() == String.class){
				String oldStr = (String) field.get(obj);
				String newStr = oldStr.replace('a', 'b');
				field.set(obj, newStr);
			}
		}
	}
	
	/**
	 * @param args
	 * @throws Exception 
	 */
	public static void main(String[] args) throws Exception {
		Point point1 = new Point();
		point1.setPosition("abababababab");
		point1.setColor("black");
		point1.setSize("a big am pig");
		System.out.println(point1.toString());
		
		changeField(point1);
		System.out.println("after chagne the field.------------------------");
		System.out.println(point1.toString());
		
		
	}
}
