package com.tim.common.designpatter.strategy;

/**
 * Created by tim.syh on 2016/8/25.
 */
public class QuackMute implements QuackBehavior{
	@Override
	public void quack() {
		System.out.println("<<keep quit>>");
	}
}
