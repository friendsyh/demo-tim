package com.tim.common.designpatter.strategyFactoryTemplate.impl;

import com.tim.common.designpatter.strategyFactoryTemplate.AbstractPriceHandle;
import com.tim.common.designpatter.strategyFactoryTemplate.MemberType;

import java.math.BigDecimal;

/**
 * Created by friendsyh on 2020/10/12.
 */
@MemberType(memberType = "vip")
public class VipMemberPriceHandle extends AbstractPriceHandle {

    public BigDecimal calPrice(BigDecimal price) {
        return price.multiply(new BigDecimal("0.8"));
    }
}
