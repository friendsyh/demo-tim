package com.tim.common.domain;

import com.tim.common.pojo.BaseDO;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class User extends BaseDO {
    private String userId;
    private String password;
    private String note;

    public User(){

    }

    public User(String userId) {
        super();
        this.userId = userId;
    }


}
