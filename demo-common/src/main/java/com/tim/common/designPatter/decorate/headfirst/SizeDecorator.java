package com.tim.common.designPatter.decorate.headfirst;

/**
 * Created by tim.syh on 2016/7/10.
 */
public class SizeDecorator extends ComdimentDecorator{

    protected Beverage beverage;

    private String size;

    public SizeDecorator(Beverage beverage) {
        this.beverage = beverage;
    }

    public SizeDecorator(Beverage beverage, String size) {
        this.beverage = beverage;
        this.size = size;
    }

    @Override
    public String getDescription() {
        return beverage.description + "," ;
    }

    @Override
    public float cost() {
        float cost = beverage.cost();
        if(getSize().equals(Size.S.getSize())){
            cost = cost + Size.S.getPrice();
        }
        if(getSize().equals(Size.M.getSize())){
            cost = cost + Size.M.getPrice();
        }
        if(getSize().equals(Size.L.getSize())){
            cost = cost + Size.L.getPrice();
        }
        return cost;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }
}
