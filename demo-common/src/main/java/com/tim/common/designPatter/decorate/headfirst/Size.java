package com.tim.common.designPatter.decorate.headfirst;

/**
 * Created by tim.syh on 2016/7/10.
 */
public enum Size {
    S("S", 1.0f), M("M", 2.0f), L("L", 3.0f);

    private final String size;

    private final float price;

    Size(String size, float price){
        this.size = size;
        this.price = price;
    }

    public String getSize(){
        return size;
    }

    public float getPrice(){
        return price;
    }

    public static void main(String[] args) {
        System.out.println();
    }
}
