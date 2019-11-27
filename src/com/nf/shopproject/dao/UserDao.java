package com.nf.shopproject.dao;

import org.apache.commons.dbutils.handlers.BeanHandler;

import com.nf.shopproject.entity.Product;
import com.nf.shopproject.entity.User;

public class UserDao extends BaseDao{
	public boolean insertUser(User user) {
		String sql = "insert into [user] values(?,?)";
		   int affectedRows = queryRunner.modify(sql, user.getName(), user.getPassword());
		   return  affectedRows==1? true :false;
	} 
	
	public User getByCondition(User user) {
		String sql="select * from [user] where name=? and [password]=?";
		BeanHandler<User> product=new BeanHandler<>(User.class);
		User result=queryRunner.query(sql, product,user.getName(),user.getPassword());
		return result;
	}
}
