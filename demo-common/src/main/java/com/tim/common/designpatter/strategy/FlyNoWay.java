package com.tim.common.designpatter.strategy;

/**
 * Created by tim.syh on 2016/8/25.
 */
public class FlyNoWay implements FlyBehavior{
	@Override
	public void fly() {
		System.out.println("I can not fly...");
	}
}
