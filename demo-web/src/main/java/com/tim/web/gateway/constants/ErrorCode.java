package com.tim.web.gateway.constants;

/**
 * @user: mengsong.caims
 * @date: 17/2/4
 */
public enum ErrorCode {

    PARAMETER_IS_MANDATORY("B:0001","Parameter %s is mandatory"),
    INVALID_VERSION("B:0002", "Invalid Version"),
    TIMESTAMP_HAS_EXPIRED("B:0003", "Timestamp has expired"),
    INVALID_TIMESTAMP_FORMAT("B:0004", "Invalid Timestamp format"),
    INVALID_REQUEST_FORMAT("B:0005","Invalid Request Format"),
    UNEXPECTED_INTERNAL_ERROR("B:0006","Unexpected internal error"),
    SIGNATURE_MISMATCHING("B:0007","Signature mismatching"),
    INVALID_ACTION("B:0008","Invalid Action"),
    ACCESS_DENIED("B:0009","Access Denied"),
    INSECURE_CHANNEL("B:0010","Insecure Channel"),
    REQUEST_TOO_BIG("B:0011","Request too Big"),
    INVALID_APP_KEY("B:0012", "Invalid App Key"),
    TOO_MANY_REQUEST("B:0429","Too many requests"),
    INTERNAL_APPLICATION_ERROR("B:1000","Internal Application Error"),
    INTERNAL_HSF_TIMEOUT_ERROR("1000","Request Time Out Error"),
    EMPTY_REQUEST("30","Empty Request"),
    INVALID_SERVICE_NAME("2008","Invalid Service Name")
    ;

    String errorCode;
    String errorMsg;

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }

    ErrorCode(String errorCode, String errorMsg){
        this.errorCode = errorCode;
        this.errorMsg = errorMsg;
    }

}
