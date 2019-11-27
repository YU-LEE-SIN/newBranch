package com.nf.shopproject.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import com.nf.shopproject.dao.BaseDao;
import com.nf.shopproject.dao.ProductDao;
import com.nf.shopproject.entity.Product;

public class ProductService extends BaseDao{
	ProductDao productDao=new ProductDao();
	//Ç°¶Ë
	public List<Product> getProductByCondition(Map<String,Object>conditions, int offset, int count){
		return productDao.getProductByCondition(conditions, offset, count);
	}
	public int getProductsCountByCondition(Map<String,Object> conditions) {
		return productDao.getProductsCountByCondition(conditions);
	}
	public Product getById(Integer pid){
		return productDao.getById(pid);
	}
	//ºó
	public List<Product> getPagedRecords(int start, int end){
		return productDao.getPagedRecords(start, end);
	}
	public int getRecordCount(){
		return productDao.getRecordCount();
	}
	public boolean deleteById(Integer id) {
		return productDao.deleteById(id);
	}
	public  boolean insert(Product product){
		return productDao.insert(product);
	}
	public boolean update(Product product) {
		return productDao.update(product);
	}
}
