package com.tim.common.designpatter.factory.simplefactory;

/**
 * Created by tim.syh on 2016/8/30.
 */
public class SimplePizzaFactory {

	public static Pizza createPizza(String type){
		Pizza pizzz = null;

		if(type.equals("cheese")){
			pizzz = new CheesePizza();
		} else if(type.equals("salt")){
			pizzz = new SaltPizza();
		}

		return pizzz;
	}
}
