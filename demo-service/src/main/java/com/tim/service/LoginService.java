package com.tim.service;

import com.tim.common.pojo.ResultDO;

/**
 * 登录服务
 * Created by tim.syh on 2017/5/22.
 */
public interface LoginService {

    ResultDO<Boolean> validate(Object object);

    boolean validate(String userName, String password);
}
