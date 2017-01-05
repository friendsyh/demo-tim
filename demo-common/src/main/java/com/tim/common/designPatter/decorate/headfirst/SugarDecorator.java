package com.tim.common.designPatter.decorate.headfirst;

/**
 * Created by tim.syh on 2016/7/10.
 */
public class SugarDecorator extends ComdimentDecorator{

    private final String DES = "sugar";

    private final float PRICE = 1.0f;

    protected Beverage beverage;

    public SugarDecorator(Beverage beverage){
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
