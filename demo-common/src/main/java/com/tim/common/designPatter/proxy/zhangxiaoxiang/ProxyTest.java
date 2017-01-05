package com.tim.common.designPatter.proxy.zhangxiaoxiang;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.Collection;


public class ProxyTest {

	public static void main(String[] args) throws Exception {
		//第一种新建代理
		Class clazzProxy = Proxy.getProxyClass(Collection.class.getClassLoader(), Collection.class);
//		System.out.println(clazzProxy.getName());
		Constructor constructor = clazzProxy.getConstructor(InvocationHandler.class);
		class MyInvocationHandler implements InvocationHandler{

			@Override
			public Object invoke(Object proxy, Method method, Object[] args)
					throws Throwable {
				return null;
			}
			
		}
		Collection proxy1 = (Collection)constructor.newInstance(new MyInvocationHandler());
		proxy1.clear();
		
		//第二种新建代理
		Collection proxy2 = (Collection)constructor.newInstance(new InvocationHandler(){
			
			@Override
			public Object invoke(Object proxy, Method method, Object[] args)
					throws Throwable {
				return null;
			}
		});
		
		//第三种新建代理
		Collection proxy3 = (Collection)Proxy.newProxyInstance(
				Collection.class.getClassLoader(), 
				new Class[]{Collection.class}, 
				new InvocationHandler(){
					ArrayList<String> target = new ArrayList<String>();
					@Override
					public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
						System.out.println(method.getName() + ": 这是是在方法执行之前.时间：" + System.currentTimeMillis());
						Object retVal = method.invoke(target, args);
						System.out.println(method.getName() + ": 这是是在方法执行之后.时间：" + System.currentTimeMillis());
						return retVal;
					}
				}
				);
//		proxy3.add("suyanghua");
//		proxy3.add("liaowanying");
//		proxy3.add("subendong");
		
		final ArrayList target = new ArrayList();
		Collection proxy4 = (Collection)getProxy(target, new LogAdvise());
		proxy4.add("suyanghua");
		proxy4.add("liaowanying");
		proxy4.add("subendong");
		proxy4.size();
		

	}
	
	/**
	 * 得到代理类
	 * @param target
	 * @return
	 */
	private static Object getProxy(final Object target, final Advise advise){
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

}
