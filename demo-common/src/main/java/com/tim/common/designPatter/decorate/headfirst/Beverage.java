package com.tim.common.designPatter.decorate.headfirst;

/**
 *饮料基类
 * Created by tim.syh on 2016/7/10.
 */
public abstract class Beverage {

    public String description = "Unknow beverage";

    public String getDescription(){
        return description;
    }

    public abstract float cost();
}
