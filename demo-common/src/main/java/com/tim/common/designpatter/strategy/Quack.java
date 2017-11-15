package com.tim.common.designpatter.strategy;

/**
 * Created by tim.syh on 2016/8/25.
 */
public class Quack implements QuackBehavior{
	@Override
	public void quack() {
		System.out.println("qu qu qu qu");
	}
}
