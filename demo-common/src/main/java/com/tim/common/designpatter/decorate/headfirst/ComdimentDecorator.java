package com.tim.common.designpatter.decorate.headfirst;

/**
 * 调料装饰者
 * Created by tim.syh on 2016/7/10.
 */
abstract public class ComdimentDecorator extends Beverage{
    @Override
    public abstract String getDescription();
}
