package com.tim.common.designpatter.strategy;

/**
 * 策略模式，对行为进行了组合。如果new的是木头鸭子，那么就走向不会飞和不会叫的策略接口
 * 如果是普通鸭子，走向的是会飞和会叫的策略
 * 1.对于飞行这个行为，可以走不同的策略，比如不会飞，翅膀飞，骑火箭飞都可以，但是他们都实现了fly的接口。
 * 2.具体走哪个策略，其实是在new的时候决定了。比如new 木头鸭子，那么会选择走不会飞的策略。
 * Created by tim.syh on 2016/8/25.
 */
public class TestMain {

	public static void main(String[] args) {
		Duck duckWood = new DuckWood();
		duckWood.dispaly();
		duckWood.performFly();
		duckWood.perfomQuack();

		Duck commomWood = new DuckCommon();
		commomWood.dispaly();
		commomWood.performFly();
		commomWood.perfomQuack();
	}
}
