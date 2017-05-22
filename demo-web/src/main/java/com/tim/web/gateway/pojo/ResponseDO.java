package com.tim.web.gateway.pojo;

import com.alibaba.fastjson.annotation.JSONField;
import com.thoughtworks.xstream.annotations.XStreamAlias;


public class ResponseDO {

    public HeadDO getHead() {
        return head;
    }

    public void setHead(HeadDO head) {
        this.head = head;
    }

    public Object getBody() {
        return body;
    }

    public void setBody(Object body) {
        this.body = body;
    }

    public ResponseDO(){}

    public ResponseDO(HeadDO head, Object body){
        this.head = head;
        this.body = body;
    }
    @XStreamAlias("Head")
    @JSONField(name = "Head")
    HeadDO head;

    @XStreamAlias("Body")
    @JSONField(name = "Body")
    Object body;

}
