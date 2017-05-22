package com.tim.web.gateway.pojo;

import com.tim.web.gateway.constants.GatewayConstant;

import lombok.Getter;
import lombok.Setter;
import org.apache.commons.lang3.math.NumberUtils;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@Setter
@Getter
public class GatewayRequest extends RequestDO {

    private String requestId;
    private String format;
    private String timestamp;
    private Long userId;
    private String userName;
    private String userEmail;
    private String version;
    private String signature;
    private String appKey;
    private Map<String, String> extParam;

    public GatewayRequest(HttpServletRequest request) {

        super(request);

        Map<String, String> extParam = new HashMap<>();
        extParam.putAll(this.getRequestParam());
        this.setExtParam(extParam);

        if (extParam.containsKey(GatewayConstant.ACTION)) {
            this.setAction(extParam.get(GatewayConstant.ACTION));
            extParam.remove(GatewayConstant.ACTION);
        }

        if (extParam.containsKey(GatewayConstant.ACTION_V2)) {
            this.setAction(extParam.get(GatewayConstant.ACTION_V2));
            extParam.remove(GatewayConstant.ACTION_V2);
        }

        if (extParam.containsKey(GatewayConstant.FORMAT)) {
            this.setFormat(extParam.get(GatewayConstant.FORMAT));
            extParam.remove(GatewayConstant.FORMAT);
        }

        if (extParam.containsKey(GatewayConstant.FORMAT_V2)) {
            this.setFormat(extParam.get(GatewayConstant.FORMAT_V2));
            extParam.remove(GatewayConstant.FORMAT_V2);
        }

        if (extParam.containsKey(GatewayConstant.TIMESTAMP)) {
            this.setTimestamp(extParam.get(GatewayConstant.TIMESTAMP));
            extParam.remove(GatewayConstant.TIMESTAMP);
        }

        if (extParam.containsKey(GatewayConstant.TIMESTAMP_V2)) {
            this.setTimestamp(extParam.get(GatewayConstant.TIMESTAMP_V2));
            extParam.remove(GatewayConstant.TIMESTAMP_V2);
        }

        if (extParam.containsKey(GatewayConstant.VERSION)) {
            this.setVersion(extParam.get(GatewayConstant.VERSION));
            extParam.remove(GatewayConstant.VERSION);
        }

        if (extParam.containsKey(GatewayConstant.VERSION_V2)) {
            this.setVersion(extParam.get(GatewayConstant.VERSION_V2));
            extParam.remove(GatewayConstant.VERSION_V2);
        }

        if (extParam.containsKey(GatewayConstant.SIGNATURE)) {
            this.setSignature(extParam.get(GatewayConstant.SIGNATURE));
            extParam.remove(GatewayConstant.SIGNATURE);
        }

        if (extParam.containsKey(GatewayConstant.SIGNATURE_V2)) {
            this.setSignature(extParam.get(GatewayConstant.SIGNATURE_V2));
            extParam.remove(GatewayConstant.SIGNATURE_V2);
        }

        if (extParam.containsKey(GatewayConstant.APP_KEY)) {
            this.setAppKey(extParam.get(GatewayConstant.APP_KEY));
            extParam.remove(GatewayConstant.APP_KEY);
        }

        if (extParam.containsKey(GatewayConstant.USER_ID)) {
            this.setUserId(NumberUtils.toLong(extParam.get(GatewayConstant.USER_ID)));
            extParam.remove(GatewayConstant.USER_ID);
        }

        if (extParam.containsKey(GatewayConstant.USER_ID_V2)) {
            this.setUserEmail(extParam.get(GatewayConstant.USER_ID_V2));
            extParam.remove(GatewayConstant.USER_ID_V2);
        }
    }

    public void addExtParam(String key, String value) {
        if (this.extParam == null) {
            this.extParam = new HashMap<>();
        }
        this.extParam.put(key, value);
    }

}
