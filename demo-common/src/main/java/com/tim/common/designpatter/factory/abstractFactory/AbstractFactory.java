package com.tim.common.designpatter.factory.abstractFactory;

import com.tim.common.designpatter.factory.factoryMethod.Vehicle;

/**
 * Created by Administrator on 2017/10/1.
 */
public abstract class AbstractFactory {

    abstract Vehicle createVehicle();

    abstract Wepon createWepon();
}
