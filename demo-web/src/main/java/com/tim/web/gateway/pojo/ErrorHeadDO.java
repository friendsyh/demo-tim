package com.tim.web.gateway.pojo;

import com.alibaba.fastjson.annotation.JSONField;
import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 * @user: tim.syh
 * @date: 17/2/4
 */
public class ErrorHeadDO implements HeadDO{

    @XStreamAlias("RequestAction")
    @JSONField(name = "RequestAction")
    String requestAction;

    @XStreamAlias("ErrorType")
    @JSONField(name = "ErrorType")
    String errorType;

    @XStreamAlias("ErrorCode")
    @JSONField(name = "ErrorCode")
    String errorCode;

    @XStreamAlias("ErrorMessage")
    @JSONField(name = "ErrorMessage")
    String errorMessage;

    public String getRequestAction() {
        return requestAction;
    }

    public void setRequestAction(String requestAction) {
        this.requestAction = requestAction;
    }

    public String getErrorType() {
        return errorType;
    }

    public void setErrorType(String errorType) {
        this.errorType = errorType;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

}