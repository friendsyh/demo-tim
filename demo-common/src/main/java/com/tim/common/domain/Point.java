package com.tim.common.domain;

import com.tim.common.pojo.BaseDO;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Point extends BaseDO {
    private int x;
    private int y;
}
