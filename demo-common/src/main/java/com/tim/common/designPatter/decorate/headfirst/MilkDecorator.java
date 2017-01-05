package com.tim.common.designPatter.decorate.headfirst;

/**
 * Created by tim.syh on 2016/7/10.
 */
public class MilkDecorator extends ComdimentDecorator{

    private final String DES = "milk";

    private final float PRICE = 1.5f;

    protected Beverage beverage;

    public MilkDecorator(Beverage beverage){
        this.beverage = beverage;
    }

    @Override
    public String getDescription() {
        return beverage.getDescription() + DES;
    }

    @Override
    public float cost() {
        return beverage.cost() + PRICE;
    }
}
