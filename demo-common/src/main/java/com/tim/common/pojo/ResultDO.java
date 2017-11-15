package com.tim.common.pojo;

import lombok.Getter;
import lombok.Setter;

/**
 *
 * Created by tim.syh on 2016/12/26.
 */
public class ResultDO<T> extends BaseDO {
    private static final long serialVersionUID = -5714633840048608311L;

    @Setter
    @Getter
    private boolean success = true;

    @Setter
    @Getter
    private T model;

    @Setter
    @Getter
    private String errorMsg;

    @Setter
    @Getter
    private String errorCode;

    public ResultDO(T t) {
        this.model = t;
    }

    public ResultDO() {

    }

    public boolean isFail() {
        return !isSuccess();
    }

    public static <T> ResultDO<T> successResult(T t) {
        return new ResultDO<>(t);
    }

    public static <T> ResultDO<T> successResult() {
        return new ResultDO<>();
    }

    public static <T> ResultDO<T> failureResult() {
        ResultDO<T> resultDO = new ResultDO<>();
        resultDO.setSuccess(false);
        return resultDO;
    }

    public static <T> ResultDO<T> failureResult(T t) {
        ResultDO<T> result = new ResultDO<>();
        result.setSuccess(false);
        result.setModel(t);
        return result;
    }

    public static <T> ResultDO<T> failureResult(T t, String msg) {
        ResultDO<T> result = new ResultDO<>();
        result.setSuccess(false);
        result.setModel(t);
        result.setErrorMsg(msg);
        return result;
    }

    public static <T> ResultDO<T> build(boolean success, String msg, T model) {
        ResultDO<T> result = new ResultDO<>();
        result.setSuccess(success);
        result.setErrorMsg(msg);
        result.setModel(model);
        return result;
    }

    public static <T> ResultDO<T> failureResult(String errorStr) {
        ResultDO<T> resultDO = new ResultDO<>();
        resultDO.setSuccess(false);
        resultDO.setErrorMsg(errorStr);
        return resultDO;
    }

    public static <T> ResultDO<T> failureResult(String errorCode, String errorMsg) {
        ResultDO<T> resultDO = new ResultDO<>();
        resultDO.setSuccess(false);
        resultDO.setErrorMsg(errorMsg);
        resultDO.setErrorCode(errorCode);
        return resultDO;
    }

    public static <T, U> ResultDO<T> failureResult(ResultDO<U> source) {
        return ResultDO.failureResult(source.getErrorCode(), source.getErrorMsg());
    }

    public static <T, U> ResultDO<T> failureResult(ResultDO<U> source, T model) {
        ResultDO<T> result = new ResultDO<>();
        result.setSuccess(false);
        result.setModel(model);
        result.setErrorMsg(source.getErrorMsg());
        result.setErrorCode(source.getErrorCode());
        return result;
    }

    public void appendMsg(String msg) {
        if(msg == null) {
            return;
        }
        if(errorMsg == null) {
            errorMsg = "";
        } else {
            errorMsg += "/";
        }

        errorMsg += msg;
    }
}
