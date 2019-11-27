package com.nf.shopproject.dao;

import java.util.List;

import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.nf.shopproject.entity.Category;

public class CategoryDao extends BaseDao {
	public List<Category> getAll(){
        String sql = "select * from category";
        BeanListHandler<Category> handler = new BeanListHandler<>(Category.class);
        List<Category> category =  queryRunner.query(sql, handler);
        return  category;
    }

    public Category getById(Integer id){
        String sql = "select * from category where pk_cid = ?";
        BeanHandler<Category> handler = new BeanHandler<>(Category.class);
        Category category =  queryRunner.query(sql, handler,id);
        return  category;
    }
    //根据商城类型来查询
    public List<Category> getBysId(Integer id){
        String sql = "select * from category where sid = ?";
        BeanListHandler<Category> handler = new BeanListHandler<>(Category.class);
        List<Category> category =  queryRunner.query(sql, handler, id);
        return  category;
    }
    
	public  boolean insert(Category category){
	   String sql = "insert into category(sid,cname) values(?,?)";
	   int affectedRows = queryRunner.modify(sql, category.getSid(), category.getCname());
	   return  affectedRows == 1 ? true :false;
	}
	
	public  boolean update(Category category){
	    String sql = "update category set sid=? , cname=? where pk_cid = ?";
	    int affectedRows = queryRunner.modify(sql,category.getSid(),category.getCname(),category.getPk_cid());
	    return  affectedRows==1? true :false;
	}

	public  boolean deleteById(Integer id){
	   String sql = "delete from category where pk_cid = ?";
	   int affectedRows = queryRunner.modify(sql, id);
	   return  affectedRows==1? true :false;
	}
}
