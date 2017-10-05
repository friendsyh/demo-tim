package com.tim.common.designPatter.factory.abstractFactory;

import com.tim.common.designPatter.factory.factoryMethod.BikeFactory;
import com.tim.common.designPatter.factory.factoryMethod.Vehicle;
import com.tim.common.designPatter.factory.factoryMethod.VehicleFactory;

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
