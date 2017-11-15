package com.tim.common.designpatter.strategy;

/**
 * 木头鸭子，既不会叫也不会飞
 * Created by tim.syh on 2016/8/25.
 */
public class DuckWood extends Duck{

	public DuckWood(){
		this.flyBehavior = new FlyNoWay();
		this.quackBehavior = new QuackMute();
	}

	@Override
	public void dispaly() {
		System.out.println("wood duck,I can not fly and quack,but I can swimming");
	}
}
