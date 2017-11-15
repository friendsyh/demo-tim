package com.tim.common.designpatter.factory.abstractFactory;

/**
 * Created by Administrator on 2017/10/1.
 */
public class Knife implements Wepon {
    @Override
    public void shoot() {
        System.out.println("刀--shooting");
    }
}
