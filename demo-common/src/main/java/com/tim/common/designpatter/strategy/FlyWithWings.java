package com.tim.common.designpatter.strategy;

/**
 * Created by tim.syh on 2016/8/25.
 */
public class FlyWithWings implements FlyBehavior {
	@Override
	public void fly() {
		System.out.println("fly in the sky");
	}
}
