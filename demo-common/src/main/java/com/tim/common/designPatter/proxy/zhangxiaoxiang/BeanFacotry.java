package com.tim.common.designPatter.proxy.zhangxiaoxiang;

import java.util.Properties;

/**
 * 通过配置创建实体对象
 * @author Administrator
 *
 */
public class BeanFacotry {
	
	private Properties properties;
	
	public Object getBean(String name) throws Exception{
		String className = (String)properties.getProperty(name);
		Object bean = null;
		try {
			Class clazz = Class.forName(className);
			bean = clazz.newInstance();
		} catch (Exception e) {
			e.printStackTrace();
		}
		if(bean instanceof ProxyBeanFactory){
			ProxyBeanFactory proxyBeanFactory = (ProxyBeanFactory)bean;
			Object target = Class.forName(properties.getProperty(name + ".target")).newInstance();
			Advise advise = (Advise)(Class.forName(properties.getProperty(name + ".advise"))).newInstance();
			proxyBeanFactory.setAdvise(advise);
			proxyBeanFactory.setTarget(target);
			
			Object proxy = ((ProxyBeanFactory) bean).getProxy();
			return proxy;
		}
		return bean;
	}

	public Properties getProperties() {
		return properties;
	}

	public void setProperties(Properties properties) {
		this.properties = properties;
	}

}
