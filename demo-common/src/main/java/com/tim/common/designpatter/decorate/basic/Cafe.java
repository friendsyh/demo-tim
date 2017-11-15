package com.tim.common.designpatter.decorate.basic;

/**
 * Created by tim.syh on 2016/7/10.
 */
public class Cafe extends Beverage{

    private float basicCost = 20;

    public Cafe(){
        description = "Cafe";
    }

    @Override
    public float cost(){
        return basicCost + super.cost();
    }
}
