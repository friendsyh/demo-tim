package com.tim.common.designpatter.strategyFactoryTemplate;

import java.math.BigDecimal;

/**
 * Created by friendsyh on 2020/10/12.
 * 价格的策略类。定义接口
 */
public interface PriceHandle {

    /**
     * 获取实际的价格
     * @param price 原来的架构
     * @return
     */
    BigDecimal getPrice(BigDecimal price);
}
