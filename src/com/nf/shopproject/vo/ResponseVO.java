package com.nf.shopproject.vo;

public class ResponseVO {
	/**
	 * ����,����200,500
	 */
	private String code;
	/**
	 * ������Ϣ
	 */
	private String msg;
	
	/**
	 * ��Ӧ������,������һ���ַ���,Ҳ������һ��List����
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

