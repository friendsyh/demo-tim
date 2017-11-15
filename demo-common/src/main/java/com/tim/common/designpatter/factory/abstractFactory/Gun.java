package com.tim.common.designpatter.factory.abstractFactory;

/**
 * Created by Administrator on 2017/10/1.
 */
public class Gun implements Wepon {
    @Override
    public void shoot() {
        System.out.println("枪--shooting");
    }
}
