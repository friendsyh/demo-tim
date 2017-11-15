package com.tim.common.designpatter.factory.factoryMethod;

/**
 * Created by Administrator on 2017/10/1.
 */
public class CarFactory extends VehicleFactory {

    @Override
    Vehicle createVehicle() {
        return new Car();
    }
}
