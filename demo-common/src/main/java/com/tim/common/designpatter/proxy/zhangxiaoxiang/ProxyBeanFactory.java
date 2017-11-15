package com.tim.common.designpatter.proxy.zhangxiaoxiang;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;


/**
 * 通过配置创建 代理实体对象
 * @author Administrator
 *
 */
public class ProxyBeanFactory {
	
	private Object target; 
	private Advise advise;
	
	/**
	 * 得到代理类
	 * @return
	 */
	public Object getProxy(){
		Object proxy = Proxy.newProxyInstance(
			target.getClass().getClassLoader(), 
			target.getClass().getInterfaces(), 
			new InvocationHandler(){
				
				@Override
				public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
//					System.out.println(method.getName() + ": 这是是在方法执行之前");
					advise.beforeMethod(method);
					Object retVal = method.invoke(target, args);
					advise.afterMethod(method);
//					System.out.println(method.getName() + ": 这是是在方法执行之后");
					return retVal;
				}
			}
			);
		return proxy;
	}

	public Object getTarget() {
		return target;
	}

	public void setTarget(Object target) {
		this.target = target;
	}

	public Advise getAdvise() {
		return advise;
	}

	public void setAdvise(Advise advise) {
		this.advise = advise;
	}
	
	
}
