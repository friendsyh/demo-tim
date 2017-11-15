package com.tim.common.designpatter.decorate.basic;

/**
 * Created by tim.syh on 2016/7/10.
 */
public class Tea extends Beverage {

    private float basicCost = 5;

    public Tea(){
        description = "Tea";
    }

    @Override
    public float cost(){
        return basicCost + super.cost();
    }
}
