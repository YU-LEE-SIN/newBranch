package com.nf.shopproject.util;

import java.sql.Connection;
import java.sql.SQLException;

import org.apache.commons.dbutils.DbUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;

import com.nf.shopproject.exception.DaoException;

import javax.sql.DataSource;

/**
 * 此类主要是用来包装Apache的DbUtils库
 * 把其SqlException检查异常转换为自己编写的运行时异常DaoException
 * 同时调用每个db操作的时候关掉Connection。
 */
public class QueryRunnerWrapper {
	/**
	 * 处理普通的增删改操作，不处理增加时提取数据库生成的值的问题。
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
	 * 查询数据库
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
