package com.tim.common.designpatter.factory.factoryMethod;

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
