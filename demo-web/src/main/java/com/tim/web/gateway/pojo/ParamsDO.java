package com.tim.web.gateway.pojo;

import com.google.common.collect.Maps;
import java.io.Serializable;
import java.util.Map;

/**
 * @user: mengsong.caims
 * @date: 17/2/4
 */
public class ParamsDO implements Serializable {

    private static final long serialVersionUID = 851666131984941040L;
    private String action;
    private String format;
    private String timestamp;
    private Long userId;
    private String userName;
    private String version;

    Map<String, String> params = Maps.newHashMap();

    public ParamsDO() {
    }

    //默认为XML
    public boolean isXML() {
        return format == null || format.toUpperCase().equals("XML");
    }

    public boolean isJSON() {
        return format != null && format.toUpperCase().equals("JSON");
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public Map<String, String> getParams() {
        return params;
    }

    public void setParams(Map<String, String> params) {
        this.params = params;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}