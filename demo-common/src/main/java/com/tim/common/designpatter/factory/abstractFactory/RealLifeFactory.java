package com.tim.common.designpatter.factory.abstractFactory;

import com.tim.common.designpatter.factory.factoryMethod.Bike;
import com.tim.common.designpatter.factory.factoryMethod.Vehicle;

/**
 * Created by Administrator on 2017/10/1.
 */
public class RealLifeFactory extends AbstractFactory {
    @Override
    Vehicle createVehicle() {
        return new Bike();
    }

    @Override
    Wepon createWepon() {
        return new Knife();
    }
}
