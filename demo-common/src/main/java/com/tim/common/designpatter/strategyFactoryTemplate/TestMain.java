package com.tim.common.designpatter.strategyFactoryTemplate;

import java.math.BigDecimal;

/**
 * 这个例子很实在。融合了单例模式，工厂模式，策略模式，模板模式4个设计模式。还融合了注解，反射等内容。可以好好研究
 *
 * Created by friendsyh on 2020/10/12.
 */
public class TestMain {

    public static void main(String[] args) {
        BigDecimal price = new BigDecimal("100");

        PriceHandle priceHandle = PriceHandleFactory.getInstance().getPriceHandle("superVip");
        System.out.println("price=" + priceHandle.getPrice(price));
    }
}
