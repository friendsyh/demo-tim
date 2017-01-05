package com.tim.common.pojo;

import lombok.Getter;
import lombok.Setter;

/**
 *
 * Created by tim.syh on 2016/12/26.
 */
public class ResultDO<T> extends BaseDO {

    @Setter
    @Getter
    private boolean success;

    @Setter
    @Getter
    private T model;

    @Setter
    @Getter
    private String errorMsg;

    @Setter
    @Getter
    String errorCode;

    public ResultDO(T t) {
        this.model = t;
        this.setSuccess(true);
    }

    public ResultDO() {

    }

    public boolean isFail() {
        return !isSuccess();
    }


    public static <T> ResultDO<T> successResult(T t) {
        return new ResultDO<>(t);
    }

    public static <T> ResultDO<T> failureResult() {
        ResultDO<T> resultDO = new ResultDO<>();
        resultDO.setSuccess(false);
        return resultDO;
    }

    public static <T> ResultDO<T> failureResult(String errorStr) {
        ResultDO<T> resultDO = new ResultDO<>();
        resultDO.setSuccess(false);
        resultDO.setErrorMsg(errorStr);
        return resultDO;
    }
}
