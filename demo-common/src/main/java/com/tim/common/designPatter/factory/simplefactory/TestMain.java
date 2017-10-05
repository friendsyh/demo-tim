package com.tim.common.designPatter.factory.simplefactory;

import com.tim.common.designPatter.factory.simplefactory.SimplePizzaFactory;

/**
 * 通过工厂去创建对象
 * Created by tim.syh on 2016/8/30.
 */
public class TestMain {

	public static void main(String[] args) {
		Pizza pizza1 = SimplePizzaFactory.createPizza("cheese");
		pizza1.prepare();
		pizza1.bake();
		pizza1.pack();

		Pizza pizza2 = SimplePizzaFactory.createPizza("salt");
		pizza2.prepare();
		pizza2.bake();
		pizza2.pack();
	}
}
