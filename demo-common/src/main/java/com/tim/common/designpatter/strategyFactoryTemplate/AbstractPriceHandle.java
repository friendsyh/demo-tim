package com.tim.common.designpatter.strategyFactoryTemplate;

import java.math.BigDecimal;

/**
 * 公共的东西getPrice()就是一个模板方法。这里面使用了模板模式
 * 不同的部分calPrice()单独抽取出来。
 *
 * Created by friendsyh on 2020/10/12.
 */
public abstract class AbstractPriceHandle implements PriceHandle {
    @Override
    public BigDecimal getPrice(BigDecimal price) {
        if(price.compareTo(new BigDecimal("0")) >= 0) {
            return calPrice(price).setScale(2);
        }

        return new BigDecimal("0").setScale(2);
    }

    public BigDecimal calPrice(BigDecimal price) {
        return price;
    }
}
