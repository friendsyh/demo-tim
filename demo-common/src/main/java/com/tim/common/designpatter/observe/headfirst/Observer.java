package com.tim.common.designpatter.observe.headfirst;

/**
 * 观察者对象接口
 * @author tim.syh
 *
 */
public interface Observer {

	/**
	 * 所有观察者必须实现该方法，当主题对象状态改变时，会调用观察者的此方法
	 * @param temperature 温度
	 * @param humidity 湿度
	 * @param pressure 压力
	 */
	public void update(float temperature, float humidity, float pressure);
}
