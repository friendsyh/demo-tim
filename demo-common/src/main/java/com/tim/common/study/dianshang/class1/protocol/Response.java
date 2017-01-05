package com.tim.common.study.dianshang.class1.protocol;

/**
 * 
 * 模拟返回实体类
 * @author 苏阳华
 * @since 2015-3-1
 *
 */
public class Response {

	/** 返回内容 */
	private String responseContent;
	
	/** 返回长度 */
	private int responseLength;
	
	/** 协议编码 */
	private byte encode;

	public String getResponseContent() {
		return responseContent;
	}

	public void setResponseContent(String responseContent) {
		this.responseContent = responseContent;
	}

	public int getResponseLength() {
		return responseLength;
	}

	public void setResponseLength(int responseLength) {
		this.responseLength = responseLength;
	}

	public byte getEncode() {
		return encode;
	}

	public void setEncode(byte encode) {
		this.encode = encode;
	}

	
}
