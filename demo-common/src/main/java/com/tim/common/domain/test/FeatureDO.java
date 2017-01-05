package com.tim.common.domain.test;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by tim.syh on 2016/8/26.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class FeatureDO {

    private String user_name;

    private boolean is_allow;

    private Boolean isAllow;

    private String thanks_OK_that;
}
