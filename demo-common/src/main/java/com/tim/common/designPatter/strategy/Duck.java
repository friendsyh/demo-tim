package com.tim.common.designPatter.strategy;

/**
 * 鸭子的类
 * Created by tim.syh on 2016/8/25.
 */
public abstract class Duck {

	FlyBehavior flyBehavior;

	QuackBehavior quackBehavior;

//	public Duck(){};

	public void swim(){
		System.out.println("All duck can swimming");
	}

	public abstract void dispaly();

	public void performFly(){
		flyBehavior.fly();
	}

	public void perfomQuack(){
		quackBehavior.quack();
	}
}
