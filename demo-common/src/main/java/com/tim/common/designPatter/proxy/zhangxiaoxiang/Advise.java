package com.tim.common.designPatter.proxy.zhangxiaoxiang;

import java.lang.reflect.Method;

/**
 * AOP的业务逻辑接口
 * @author Administrator
 *
 */
public interface Advise {
	public void beforeMethod(Method method);
	public void afterMethod(Method method);
}
