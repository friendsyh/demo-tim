package com.tim.web.gateway.pojo;

import com.tim.web.gateway.constants.Constants;

import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.builder.ToStringBuilder;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.io.InputStream;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

public class RequestDO {

    private String action;
    private String requestUrl = null;
    private String requestMethod = null;
    protected Map<String, String> requestParam = null;
    private Object body = null;
    private String remoteAddr;

    public RequestDO(HttpServletRequest request) {
        InputStream is = null;
        Object body = null;
        try {
            if (Constants.POST.equalsIgnoreCase(request.getMethod())) {
                is = request.getInputStream();
                if (is != null) {
                    if (ServletFileUpload.isMultipartContent(request)) {
                        body = IOUtils.toByteArray(is);
                    } else {
                        body = IOUtils.toString(is, Constants.CHAR_UTF_8);
                    }
                }
            }
        } catch (IOException e) {
        }

        this.requestMethod = request.getMethod();
        String queryString = request.getQueryString();
        if (StringUtils.isNotBlank(queryString)) {
            queryString = "?".concat(queryString);
        } else {
            queryString = "";
        }
        this.setRequestUrl(request.getRequestURL().append(queryString).toString());
        this.initRequestParams(request);
        if (body != null) {
            this.setBody(body);
        }

        this.remoteAddr = getRemoteAddr(request);
    }


    protected void initRequestParams(HttpServletRequest request) {
        this.requestParam = new HashMap<>();
        Enumeration paramsNames = request.getParameterNames();
        while (paramsNames.hasMoreElements()) {
            String name = (String) paramsNames.nextElement();
            requestParam.put(name, request.getParameter(name));
        }
    }

    protected Map<String, String> getHeaders(HttpServletRequest request) {

        HashMap<String, String> headerMap = new HashMap<>();
        request.getHeaderNames();

        Enumeration headerNames = request.getHeaderNames();
        while (headerNames.hasMoreElements()) {
            String name = (String) headerNames.nextElement();
            headerMap.put(name, request.getHeader(name));
        }

        return headerMap;
    }

    public String getRemoteAddr() {
        return remoteAddr;
    }

    public void setRemoteAddr(String remoteAddr) {
        this.remoteAddr = remoteAddr;
    }

    public String getRequestUrl() {
        return requestUrl;
    }

    protected void setRequestUrl(String requestUrl) {
        this.requestUrl = requestUrl;
    }

    public Map<String, String> getRequestParam() {
        return requestParam;
    }

    private void setRequestParam(Map<String, String> allParam) {
        this.requestParam = allParam;
    }

    public String getRequestMethod() {
        return requestMethod;
    }

    public Object getBody() {
        return body;
    }

    public void setBody(Object body) {
        this.body = body;
    }

    protected static String getRemoteAddr(HttpServletRequest request) {
        if (request == null) return null;
        String remoteAddr = null;
        String forwardedFors = request.getHeader("X-Forwarded-For");
        if (isEffective(forwardedFors)) {
            if (forwardedFors.indexOf(",") > -1) {
                String[] array = forwardedFors.split(",");
                for (String element : array) {
                    if (isEffective(element)) {
                        remoteAddr = element;
                        break;
                    }
                }
            } else {
                remoteAddr = forwardedFors;
            }
        }
        if (!isEffective(remoteAddr)) {
            remoteAddr = request.getHeader("Proxy-Client-IP");
        }
        if (!isEffective(remoteAddr)) {
            remoteAddr = request.getHeader("WL-Proxy-Client-IP");
        }
        if (!isEffective(remoteAddr)) {
            remoteAddr = request.getHeader("X-Real-IP");
        }
        if (!isEffective(remoteAddr)) {
            remoteAddr = request.getRemoteAddr();
        }
        return remoteAddr;
    }

    private static boolean isEffective(final String remoteAddr) {
        boolean isEffective = false;
        if ((null != remoteAddr) && (!"".equals(remoteAddr.trim()))
                && (!"unknown".equalsIgnoreCase(remoteAddr.trim()))) {
            isEffective = true;
        }
        return isEffective;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }
}
