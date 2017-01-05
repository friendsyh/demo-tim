package com.tim.common.designPatter.strategy;

/**
 * 普通鸭子
 * Created by tim.syh on 2016/8/25.
 */
public class DuckCommon extends Duck{

	public DuckCommon(){
		this.flyBehavior = new FlyWithWings();
		this.quackBehavior = new Quack();
	}

	@Override
	public void dispaly() {
		System.out.println("common duck");
	}
}
