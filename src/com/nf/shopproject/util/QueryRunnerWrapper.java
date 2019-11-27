package com.nf.shopproject.util;

import java.sql.Connection;
import java.sql.SQLException;

import org.apache.commons.dbutils.DbUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;

import com.nf.shopproject.exception.DaoException;

import javax.sql.DataSource;

/**
 * ������Ҫ��������װApache��DbUtils��
 * ����SqlException����쳣ת��Ϊ�Լ���д������ʱ�쳣DaoException
 * ͬʱ����ÿ��db������ʱ��ص�Connection��
 */
public class QueryRunnerWrapper {
	/**
	 * ������ͨ����ɾ�Ĳ���������������ʱ��ȡ���ݿ����ɵ�ֵ�����⡣
	 * @param sql
	 * @param params
	 * @return
	 */
	public int modify(String sql,Object...params) {
		DataSource dataSource=JDBCutil.getDataSource();
		QueryRunner queryRunner=new QueryRunner(dataSource,true);
		int affectedRows;
		try {
			affectedRows=queryRunner.update(sql, params);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new DaoException("update db failed " + e.getMessage());
		}
		return affectedRows;
	}
	/**
	 * ��ѯ���ݿ�
	 * @param <T>
	 * @param sql
	 * @param rsh
	 * @param params
	 * @return
	 */
	public <T> T query(String sql, ResultSetHandler<T> rsh, Object...params) {
		 DataSource dataSource=JDBCutil.getDataSource();
		QueryRunner queryRunner=new QueryRunner(dataSource,true);
		try {
			return queryRunner.query( sql, rsh,params);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			 throw new DaoException("query db failed");
		}
	}
}
