package com.nf.shopproject.exception;

public class DaoException extends RuntimeException {
	/**
	 * ���쳣����Dao�㣬����db�������쳣��ת��Ϊ���쳣�����׳�ȥ��
	 */
	public DaoException() {}
	public DaoException(String message) {
		super(message);
	}
	public DaoException(String message,Throwable cause) {
		super(message,cause);
	}
}
