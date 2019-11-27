package com.nf.shopproject.exception;

public class DaoException extends RuntimeException {
	/**
	 * 此异常用在Dao层，所有db操作的异常都转换为此异常重新抛出去。
	 */
	public DaoException() {}
	public DaoException(String message) {
		super(message);
	}
	public DaoException(String message,Throwable cause) {
		super(message,cause);
	}
}
