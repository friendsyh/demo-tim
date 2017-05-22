package com.tim.web.gateway.utils;

import com.alibaba.fastjson.JSON;
import com.thoughtworks.xstream.XStream;
import com.tim.web.gateway.pojo.ErrorHeadDO;
import com.tim.web.gateway.pojo.HeadDO;
import com.tim.web.gateway.pojo.ResponseDO;
import com.tim.web.gateway.pojo.SuccessHeadDO;

import java.util.HashMap;


public class ResultUtil {

    public static final String XML_HEADER = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>";

    /**
     * JavaBean转换成xml或者json
     * @param body
     * @return
     */
    public static String convert(HeadDO headDO, Object body, String format) {
        if(format!= null && format.toUpperCase().equals("JSON")){
            ResponseDO responseDO = new ResponseDO(headDO, body);
            HashMap hashMap = new HashMap();
            if(headDO instanceof ErrorHeadDO){
                hashMap.put("ErrorResponse", responseDO);
            }
            if(headDO instanceof SuccessHeadDO){
                hashMap.put("SuccessResponse", responseDO);
            }
            return JSON.toJSONString(hashMap);
        }else{  //默认为XML
            XStream xStream = new XStream();
            xStream.setMode(XStream.NO_REFERENCES);
            xStream.aliasSystemAttribute(null, "class");
            //启用Annotation
            xStream.autodetectAnnotations(true);
            if(headDO instanceof ErrorHeadDO){
                xStream.alias("ErrorResponse", ResponseDO.class);
            }
            if(headDO instanceof SuccessHeadDO){
                xStream.alias("SuccessResponse", ResponseDO.class);
            }
            ResponseDO responseDO = new ResponseDO(headDO,body);
            String xml = XML_HEADER + xStream.toXML(responseDO);
            xStream = null;
            return xml;
        }
    }


}
