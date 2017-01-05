package com.tim.common.designPatter.decorate.headfirst;

/**
 * Created by tim.syh on 2016/7/10.
 */
public class Cafe extends Beverage {

    private float basicCost = 20;

    public Cafe(){
        description = "Cafe";
    }

    public float cost(){
        return basicCost;
    }
}
