package com.tim.common.designPatter.factory.factoryMethod;

import com.tim.common.designPatter.factory.simplefactory.Pizza;
import com.tim.common.designPatter.factory.simplefactory.SimplePizzaFactory;

/**
 * 通过工厂去创建对象
 * 只需要修改Factory 类就行了。
 * Created by tim.syh on 2016/8/30.
 */
public class TestMain {

	public static void main(String[] args) {
//		VehicleFactory vehicleFactory = new CarFactory();
		VehicleFactory vehicleFactory = new BikeFactory();

		Vehicle vehicle = vehicleFactory.createVehicle();
		vehicle.run();
	}
}
