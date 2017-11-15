package com.tim.web.gateway.handle;

import com.tim.common.pojo.ResultDO;
import com.tim.common.utils.DateUtils;
import com.tim.web.gateway.constants.ErrorCode;
import com.tim.web.gateway.constants.GatewayConstant;
import com.tim.web.gateway.pojo.ErrorHeadDO;
import com.tim.web.gateway.pojo.GatewayRequest;
import com.tim.web.gateway.pojo.ParamsDO;
import com.tim.web.gateway.pojo.RequestDO;
import com.tim.web.gateway.utils.ResultUtil;
import com.tim.web.gateway.utils.SecurityUtil;

import java.util.Date;
import java.util.TreeMap;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;
import com.tim.service.LoginService;

@Slf4j
@Component("gatewayRequestHandler")
public class GatewayRequestHandler extends AbstractRequestHandler<GatewayRequest> {

    //4 hours失效
    private final static long expiredTimeSeconds = 14400000;

    @Resource
    private LoginService loginService;

    @Override
    protected ResultDO validateParaments(GatewayRequest requestDO) {

        if (requestDO.getBody() instanceof String) {
            String xmlBody = (String) requestDO.getBody();
            if (StringUtils.isNotEmpty(xmlBody) && (xmlBody.contains("<!DOCTYPE") || xmlBody.contains("<!ENTITY"))) {
                //防止XXE攻击
                return ResultDO.failureResult(ErrorCode.INSECURE_CHANNEL.getErrorCode(), ErrorCode.INSECURE_CHANNEL.getErrorMsg());
            }
        }

        if (requestDO.getVersion() == null || !GatewayConstant.V1.equals(requestDO.getVersion())) {
            return ResultDO.failureResult(ErrorCode.PARAMETER_IS_MANDATORY.getErrorCode(),
                    String.format(ErrorCode.PARAMETER_IS_MANDATORY.getErrorMsg(), GatewayConstant.VERSION));
        }

        if (requestDO.getAction() == null) {
            return ResultDO.failureResult(ErrorCode.PARAMETER_IS_MANDATORY.getErrorCode(),
                    String.format(ErrorCode.PARAMETER_IS_MANDATORY.getErrorMsg(), GatewayConstant.ACTION));
        }

        if (requestDO.getSignature() == null) {
            return ResultDO.failureResult(ErrorCode.PARAMETER_IS_MANDATORY.getErrorCode(),
                    String.format(ErrorCode.PARAMETER_IS_MANDATORY.getErrorMsg(), GatewayConstant.SIGNATURE));
        }

        if (requestDO.getTimestamp() == null) {
            return ResultDO.failureResult(ErrorCode.PARAMETER_IS_MANDATORY.getErrorCode(),
                    String.format(ErrorCode.PARAMETER_IS_MANDATORY.getErrorMsg(), GatewayConstant.TIMESTAMP));
        }

        if (StringUtils.isBlank(requestDO.getAppKey())) {
            return ResultDO.failureResult(ErrorCode.PARAMETER_IS_MANDATORY.getErrorCode(),
                    String.format(ErrorCode.PARAMETER_IS_MANDATORY.getErrorMsg(), GatewayConstant.APP_KEY));
        }

        return checkTimestamp(requestDO.getTimestamp());
    }

    @Override
    protected ResultDO auth(GatewayRequest requestDO) {
        Long userId = requestDO.getUserId();
        try {
            String appSecret = getAppSecret(requestDO.getAppKey());
            if (StringUtils.isNotBlank(appSecret)) {
                return auth(requestDO, appSecret);
            } else {
                logger.warn("user is not existed:" + userId);
                return ResultDO.failureResult(ErrorCode.INVALID_APP_KEY.getErrorCode(), ErrorCode.INVALID_APP_KEY.getErrorMsg());
            }
        } catch (Exception e) {
            logger.error("user email:" + userId + e.getMessage());
            return ResultDO.failureResult(ErrorCode.INTERNAL_APPLICATION_ERROR.getErrorCode(),
                    ErrorCode.INTERNAL_APPLICATION_ERROR.getErrorMsg());
        }
    }

    @Override
    protected ResultDO checkAcl(GatewayRequest requestDO) {
        //权限校验, 暂时不加
        return ResultDO.successResult(true);
    }

    @Override
    protected ParamsDO map(GatewayRequest requestDO) {
        ParamsDO paramsDO = new ParamsDO();
        paramsDO.setTimestamp(requestDO.getTimestamp());
        paramsDO.setAction(requestDO.getAction());
        paramsDO.setFormat(requestDO.getFormat());

        if (StringUtils.isNotBlank(requestDO.getUserName())) {
            paramsDO.setUserId(requestDO.getUserId());
            paramsDO.setUserName(requestDO.getUserName());
        }

        paramsDO.setVersion(requestDO.getVersion());
        paramsDO.setParams(requestDO.getExtParam());
        return paramsDO;
    }

    @Override
    protected String render(GatewayRequest requestDO, ResultDO resultDO) {
        ErrorHeadDO errorHeadDO = new ErrorHeadDO();
        if (!resultDO.isSuccess()) {
            String errorMsg = resultDO.getErrorMsg();
            String errorCode = resultDO.getErrorCode();
            errorHeadDO.setRequestAction(requestDO.getAction());
            errorHeadDO.setErrorCode(errorCode);
            errorHeadDO.setErrorMessage("E" + errorCode + ":" + errorMsg);
        }

        return ResultUtil.convert(errorHeadDO, resultDO.getModel(), requestDO.getFormat());
    }

    public ResultDO auth(RequestDO requestDO, String appSecret) {
        ResultDO resultDO = new ResultDO();
        TreeMap<String, String> treeMap = new TreeMap<>(requestDO.getRequestParam());
        String signatureFromRequest = treeMap.get(GatewayConstant.SIGNATURE); //get signature for preparing

        //Generate signature to prepare with the signature from request
        treeMap.remove(GatewayConstant.SIGNATURE);
        String queryString = SecurityUtil.toQueryString(treeMap);
        if (StringUtils.isEmpty(appSecret)) {
            resultDO.setSuccess(false);
            resultDO.setErrorCode(ErrorCode.ACCESS_DENIED.getErrorCode());
            resultDO.setErrorMsg(ErrorCode.ACCESS_DENIED.getErrorMsg());
            return resultDO;
        }

        final String signature = SecurityUtil.sign(queryString, appSecret);
        if (!signature.equals(signatureFromRequest)) {
            logger.warn("request url----" + requestDO.getRequestUrl());
            logger.warn("queryString:apikey----" + queryString + ":" + appSecret);
            resultDO.setSuccess(false);
            resultDO.setErrorCode(ErrorCode.SIGNATURE_MISMATCHING.getErrorCode());
            resultDO.setErrorMsg(ErrorCode.SIGNATURE_MISMATCHING.getErrorMsg());
        } else {
            resultDO.setSuccess(true);
        }

        return resultDO;
    }

    @Override
    public ResultDO invokeAction(GatewayRequest requestDO) {
        log.warn("invokeAction request param: " + requestDO.toString());
        Object body = requestDO.getBody();
        // 可以返射或泛化处理
        if (StringUtils.equals(requestDO.getAction(), "login")) {
            return loginService.validate(body);
        } else if (StringUtils.equals(requestDO.getAction(), "decreaseProductPool")) {
            return loginService.validate(body);
        }
        return ResultDO.failureResult(ErrorCode.INVALID_ACTION.getErrorCode(), ErrorCode.INVALID_ACTION.getErrorMsg());
    }

    /**
     * TODO，从配置文件读取定义的appKey,先默认都设置为10000
     * @param appKey
     * @return
     */
    private String getAppSecret(String appKey) {
        return "10000";
    }

    /**
     * 检查传入的时间和当前服务器时间是否吻合,时间在expiredTimeSeconds毫秒内的均算吻合
     * @return
     */
    public static ResultDO checkTimestamp(String timestamp) {
        ResultDO resultDO = new ResultDO();
        try {
            Date date = null;
            if (StringUtils.isNotBlank(timestamp)) {
                date = DateUtils.convertLong2Date(timestamp);
            } else {
                resultDO.setSuccess(false);
                resultDO.setErrorCode(ErrorCode.INVALID_TIMESTAMP_FORMAT.getErrorCode());
                resultDO.setErrorMsg(ErrorCode.INVALID_TIMESTAMP_FORMAT.getErrorMsg());
                return resultDO;
            }

            boolean isOK = (Math.abs(date.getTime() - (new Date()).getTime()) < expiredTimeSeconds);
            if (!isOK) {
                resultDO.setSuccess(false);
                resultDO.setErrorCode(ErrorCode.TIMESTAMP_HAS_EXPIRED.getErrorCode());
                resultDO.setErrorMsg(ErrorCode.TIMESTAMP_HAS_EXPIRED.getErrorMsg());
            }
        } catch (Exception e) {
            resultDO.setSuccess(false);
            resultDO.setErrorCode(ErrorCode.INVALID_TIMESTAMP_FORMAT.getErrorCode());
            resultDO.setErrorMsg(ErrorCode.INVALID_TIMESTAMP_FORMAT.getErrorMsg());
        }
        return resultDO;
    }
}
