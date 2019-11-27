package com.nf.shopproject.controller.text;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.PreparedStatement;

import org.apache.commons.dbutils.QueryRunner;
import com.nf.shopproject.entity.Product;
import com.nf.shopproject.util.JDBCutil;
/**
 * 添加后
 * 获取自动生成的键
 * @author Yu
 *
 */
public class Text {
	public static void demo() {
		try {
			Connection conn=JDBCutil.getConnection();
	        String sql = "insert into [user] values('hehe','haha')";
//	可以	    Statement stmt = conn.createStatement();
//	        stmt.execute(sql, Statement.RETURN_GENERATED_KEYS);
	        PreparedStatement stmt=conn.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
	        stmt.executeUpdate();
	        // 得到生成的键值
	        ResultSet rs = stmt.getGeneratedKeys();
	        while (rs.next()) {
	            System.out.println(rs.getInt(1));
	        }
	    } catch (SQLException e) {
	        // TODO A1uto-generated catch block
	        e.printStackTrace();
	    }
	}
	public int modifytwo(String sql, Object...objects) throws SQLException{
		Connection conn=JDBCutil.getConnection();
		 PreparedStatement stmt=conn.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
		 for(int i=0;i<objects.length;i++){
				stmt.setObject(i+1, objects[i]);
			}
		 	stmt.executeUpdate();
		// 得到生成的键值
	        ResultSet rs = stmt.getGeneratedKeys();
	        int a=0;
	        while (rs.next()) {
	            //System.out.println(rs.getInt(1));
	        	a=rs.getInt(1);
	        }
			return a;
	}
	
	public int modifythree(String sql, Object...objects) throws SQLException{
		Connection conn=JDBCutil.getConnection();
		QueryRunner queryRunner=new QueryRunner();
		int a=queryRunner.update(conn, sql, objects);
		//PreparedStatement stmt=null;
		 //ResultSet rs =stmt .getGeneratedKeys();
		return 0;
	}
	
	public int productDao(Product product) throws SQLException {
		Text t=new Text();
		 String sql = "insert into product(pname,original_price,images,about,remark) values(?,?,?,?,?)";
	        int affectedRows =t.modifytwo(sql,product.getPname(),
	                product.getOriginal_price(),
	                product.getImages(),
	                product.getAbout(),
	                product.getRemark());
	        return affectedRows;
	}
	public static void main(String[] args) throws SQLException {
		demo();
		// TODO Auto-generated method stub
		Product pr=new Product();
		Text t=new Text();
		pr.setPname("122");
		pr.setOriginal_price(new BigDecimal(12));
		pr.setImages("12");
		pr.setAbout("12");
		pr.setRemark("12");
		int a=t.productDao(pr);
		System.out.print(a);
	}

}
