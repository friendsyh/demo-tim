package com.tim.common.designpatter.observe.headfirst;

/**
 * 主题对象
 * @author tim.syh
 *
 */
public interface Subject {
	
	/**
	 * 一个新的观察者注册进来了
	 * @param o
	 */
	public void registerObserver(Observer o);
	
	/**
	 * 一个新的观察者被移走了
	 * @param o
	 */
	public void removeObserver(Observer o);
	
	/**
	 * 当主题对象状态修改时，这个方法被调用，用来通知所有的观察者
	 */
	public void notifyObsevers();
}
