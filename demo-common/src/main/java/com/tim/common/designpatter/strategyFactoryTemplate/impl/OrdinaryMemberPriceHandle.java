package com.tim.common.designpatter.strategyFactoryTemplate.impl;

import com.tim.common.designpatter.strategyFactoryTemplate.AbstractPriceHandle;
import com.tim.common.designpatter.strategyFactoryTemplate.MemberType;

import java.math.BigDecimal;

/**
 * Created by friendsyh on 2020/10/12.
 */
@MemberType(memberType = "ordinary")
public class OrdinaryMemberPriceHandle extends AbstractPriceHandle {

    public BigDecimal calPrice(BigDecimal price) {
        return price;

//        return super.calPrice(price); //直接返回父类的方法也是OK的，父类默认就是不打折扣
    }
}
