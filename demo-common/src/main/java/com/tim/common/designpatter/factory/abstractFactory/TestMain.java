package com.tim.common.designpatter.factory.abstractFactory;

import com.tim.common.designpatter.factory.factoryMethod.Vehicle;

/**
 * Created by tim.syh on 2016/8/30.
 */
public class TestMain {

	public static void main(String[] args) {

//	    AbstractFactory abstractFactory = new GameFactory();
	    AbstractFactory abstractFactory = new RealLifeFactory();

	    Vehicle vehicle = abstractFactory.createVehicle();
	    Wepon wepon = abstractFactory.createWepon();

	    vehicle.run();
	    wepon.shoot();
	}
}
