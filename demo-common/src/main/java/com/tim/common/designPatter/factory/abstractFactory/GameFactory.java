package com.tim.common.designPatter.factory.abstractFactory;

import com.tim.common.designPatter.factory.factoryMethod.Car;
import com.tim.common.designPatter.factory.factoryMethod.Vehicle;

/**
 * Created by Administrator on 2017/10/1.
 */
public class GameFactory extends AbstractFactory {
    @Override
    Vehicle createVehicle() {
        return new Car();
    }

    @Override
    Wepon createWepon() {
        return new Gun();
    }
}
