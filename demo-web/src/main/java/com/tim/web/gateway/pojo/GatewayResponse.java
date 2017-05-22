package com.tim.web.gateway.pojo;

import com.tim.common.pojo.BaseDO;

import lombok.Getter;
import lombok.Setter;

/**
 * @user: mengsong.caims
 * @date: 17/2/7
 */
@Getter
@Setter
public class GatewayResponse<T> extends BaseDO {
    private static final long serialVersionUID = -3239475774776714920L;
    private boolean success;
    private T data;
    private String errorCode;
    private String errorMsg;
    private String timeStamp;

    public static GatewayResponse error(String errorCode, String errorMsg) {
        GatewayResponse gatewayResponse = new GatewayResponse();
        gatewayResponse.setSuccess(false);
        gatewayResponse.setErrorCode(errorCode);
        gatewayResponse.setErrorMsg(errorMsg);
        return gatewayResponse;
    }
}
