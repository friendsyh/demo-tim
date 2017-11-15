package com.tim.common.designpatter.factory.simplefactory;

/**
 * Created by tim.syh on 2016/8/30.
 */
public class CheesePizza implements Pizza{

	public CheesePizza(){
		System.out.println("CheesePizza");
	}

	@Override
	public void prepare() {
		System.out.println("准备工作");
	}

	@Override
	public void bake() {
		System.out.println("烘烤");
	}

	@Override
	public void pack() {
		System.out.println("包装");
	}
}
