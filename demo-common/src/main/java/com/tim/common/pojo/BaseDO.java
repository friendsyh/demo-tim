package com.tim.common.pojo;

import org.apache.commons.lang3.builder.ToStringBuilder;

import java.io.Serializable;

/**
 * 所有类的基础DO
 * Created by tim.syh on 2016/12/26.
 */
public class BaseDO implements Serializable{
    private static final long serialVersionUID = 963271684707264144L;

    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }
}
