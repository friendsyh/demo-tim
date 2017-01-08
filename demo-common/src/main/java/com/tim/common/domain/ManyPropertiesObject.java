package com.tim.common.domain;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * Created by tim.syh on 2016/11/4.
 */
@Data
public class ManyPropertiesObject {
    private String name;
    private char testChar;

    private byte testByte;
    private Byte testByteObj;

    private boolean hasDone;
    private Boolean hasFinished;

    private int age;
    private Integer ageInteger;

    private double price;
    private Double priceObject;

    private long id;
    private Long idLongObject;

    private String[] stringArrays;

    private Date lastModifiedDate;
    private List<String> stringList;
    private Map<String, Object> map;

}
