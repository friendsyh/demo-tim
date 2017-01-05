package com.tim.common.pojo;

import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * Created by tim.syh on 2016/12/26.
 */
public class BaseDO {
    private static final long serialVersionUID = 963271684707264144L;

    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }
}
