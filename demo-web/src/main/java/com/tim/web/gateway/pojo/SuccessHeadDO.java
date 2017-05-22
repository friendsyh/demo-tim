package com.tim.web.gateway.pojo;

import com.alibaba.fastjson.annotation.JSONField;
import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 * @user: tim.syh
 * @date: 17/2/4
 */
public class SuccessHeadDO implements HeadDO{

    @XStreamAlias("RequestAction")
    @JSONField(name = "RequestAction")
    String requestAction;

    @XStreamAlias("RequestId")
    @JSONField(name = "RequestId")
    String requestId;

    @XStreamAlias("ResponseType")
    @JSONField(name = "ResponseType")
    String responseType;

    @XStreamAlias("Timestamp")
    @JSONField(name = "Timestamp")
    String timestamp;

    public String getRequestAction() {
        return requestAction;
    }

    public void setRequestAction(String requestAction) {
        this.requestAction = requestAction;
    }

    public String getRequestId() {
        return requestId;
    }

    public void setRequestId(String requestId) {
        this.requestId = requestId;
    }

    public String getResponseType() {
        return responseType;
    }

    public void setResponseType(String responseType) {
        this.responseType = responseType;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

}