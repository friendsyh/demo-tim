package com.tim.web.controller;

import com.tim.common.pojo.ResultDO;
import com.tim.common.utils.GsonUtils;
import com.tim.web.gateway.handle.GatewayRequestHandler;
import com.tim.web.gateway.pojo.GatewayRequest;
import com.tim.web.gateway.pojo.GatewayResponse;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import lombok.extern.slf4j.Slf4j;

/**
 * 自建网管gateway
 * @user: tim.syh
 */
@Slf4j
@Controller
public class GatewayController {

    @Resource
    private GatewayRequestHandler gatewayRequestHandler;

    //@ResponseBody
    @RequestMapping(value = "/gateway", method = {RequestMethod.POST, RequestMethod.GET})
    public ResponseEntity<String> gateway(HttpServletRequest request) {
        try {
            GatewayRequest gatewayRequest = new GatewayRequest(request);
            ResultDO result = gatewayRequestHandler.invoke(gatewayRequest);
            return new ResponseEntity<>(GsonUtils.objectToString(parseResponse(result)), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("SYSTEM EXCEPTION", HttpStatus.OK);
        }
    }

    private GatewayResponse parseResponse(ResultDO resultDO) {
        GatewayResponse gatewayResponse = new GatewayResponse();
        gatewayResponse.setSuccess(resultDO.isSuccess());
        gatewayResponse.setTimeStamp(System.currentTimeMillis() + "");
        gatewayResponse.setErrorCode(resultDO.getErrorCode());
        gatewayResponse.setErrorMsg(resultDO.getErrorMsg());
        gatewayResponse.setData(resultDO.getModel());

        return gatewayResponse;
    }

}
