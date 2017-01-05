package com.tim.common.study.dianshang.class1.protocol;

/**
 * 
 * 模拟请求实体类
 * @author 苏阳华
 * @since 2015-3-1
 *
 */
public class Request {

	/** 请求内容 */
	private String requestContent;
	
	/** 请求长度  */
	private int requestLength;
	
	/** 协议编码 */
	private byte encode;

	public String getRequestContent() {
		return requestContent;
	}

	public void setRequestContent(String requestContent) {
		this.requestContent = requestContent;
	}

	public int getRequestLength() {
		return requestLength;
	}

	public void setRequestLength(int requestLength) {
		this.requestLength = requestLength;
	}

	public byte getEncode() {
		return encode;
	}

	public void setEncode(byte encode) {
		this.encode = encode;
	}
	
	
}
