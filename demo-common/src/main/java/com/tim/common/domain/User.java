package com.tim.common.domain;

import lombok.Data;

@Data
public class User {
    private String userId;
    private String password;
    private String note;


    public User(String userId) {
        super();
        this.userId = userId;
    }
}
