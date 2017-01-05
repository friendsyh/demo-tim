package com.tim.common.domain;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

/**
 * Created by tim.syh on 2016/11/4.
 */
public class Result {
    @Setter
    @Getter
    private String name;
    @Setter
    @Getter
    private Date lastModifiedDate;

    public static void main(String[] args) {
        Result result = new Result();
        System.out.println(result.getLastModifiedDate());
    }
}
