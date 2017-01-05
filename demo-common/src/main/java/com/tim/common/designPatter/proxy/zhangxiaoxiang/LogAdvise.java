package com.tim.common.designPatter.proxy.zhangxiaoxiang;

import java.lang.reflect.Method;

public class LogAdvise implements Advise{

	@Override
	public void beforeMethod(Method method) {
		System.out.println(method.getName() + "方法开始时的时间：" + System.currentTimeMillis());
	}

	@Override
	public void afterMethod(Method method) {
		System.out.println(method.getName() + "方法结束时的时间：" + System.currentTimeMillis());
	}

}
