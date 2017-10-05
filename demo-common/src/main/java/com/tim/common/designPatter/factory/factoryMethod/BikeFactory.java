package com.tim.common.designPatter.factory.factoryMethod;

/**
 * Created by Administrator on 2017/10/1.
 */
public class BikeFactory extends VehicleFactory {

    @Override
    Vehicle createVehicle() {
        return new Bike();
    }
}
