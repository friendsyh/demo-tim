package com.tim.common.designPatter.proxy.zhangxiaoxiang;

import com.tim.common.test.classLoader.Point;
import com.tim.common.utils.PropertiesUtil;

public class AopTest {
	
	public static void main(String[] args) throws Exception {
		BeanFacotry beanFacotry = new BeanFacotry();
		PropertiesUtil propertiesUtil = new PropertiesUtil("/config.properties");
		beanFacotry.setProperties(propertiesUtil.getPropertie());
		
		Point bean = (Point)beanFacotry.getBean("xxx");
//		System.out.println(bean.getClass().getName());
//		bean.setX(3);
//		bean.setY(4);
		bean.addAll();
		
//		Class clazz = Class.forName("Point");
//		Point point = (Point)clazz.newInstance();
//		System.out.println(point.getClass().getName());
	}
}
