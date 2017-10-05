package com.tim.common.designPatter.factory.abstractFactory;

import com.tim.common.designPatter.factory.factoryMethod.Vehicle;

/**
 * Created by Administrator on 2017/10/1.
 */
public abstract class AbstractFactory {

    abstract Vehicle createVehicle();

    abstract Wepon createWepon();
}
