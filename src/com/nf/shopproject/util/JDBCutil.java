package com.nf.shopproject.util;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class JDBCutil {
	//ʹ��Ĭ������
	private static ComboPooledDataSource source = new ComboPooledDataSource();
	/**���һ�����ӳ�
	 * @return DataSource ����javax.sql.DataSource
	 * */
	public static DataSource getDataSource() {
		return source;
	}
	/**���һ��Connection����
	 * @return Connection
	 * */
	public static Connection getConnection() {
		Connection conn = null;
		try {
			conn = source.getConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return conn;
	}
//	public static void main(String[] args) throws SQLException {
//		   System.out.println(">>>> ");
//		   DataSource  cpds=JDBCutil.getDataSource();
//		   Connection con = null;
//		    Statement stmt = null;
//		    ResultSet rs = null;
//		   con=cpds.getConnection();
//		  //con=JDBCutil.getConnection();
//		    stmt=con.createStatement();
//		    rs=stmt.executeQuery("select * from product");
//		    while(rs.next()){
//		     System.out.println(rs.getString(2));
//		   }
//	}
}