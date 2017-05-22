package service.impl;

import com.tim.common.pojo.ResultDO;

import service.LoginService;

/**
 * 登录服务实现
 * Created by tim.syh on 2017/5/22.
 */
public class LoginServiceImpl implements LoginService {

    @Override
    public ResultDO<Boolean> validate(Object object) {
        return ResultDO.successResult();
    }

    @Override
    public boolean validate(String userName, String password) {
        return false;
    }
}
