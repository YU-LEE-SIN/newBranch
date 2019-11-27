package com.nf.shopproject.vo;

public class ResponseVO {
	/**
	 * 编码,比如200,500
	 */
	private String code;
	/**
	 * 错误信息
	 */
	private String msg;
	
	/**
	 * 响应的数据,可能是一个字符串,也可能是一个List集合
	 */
	private Object data;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}
	
	
}

