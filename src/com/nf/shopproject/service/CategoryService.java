package com.nf.shopproject.service;

import java.util.List;

import com.nf.shopproject.dao.CategoryDao;
import com.nf.shopproject.entity.Category;

public class CategoryService {
	CategoryDao categoryDao=new CategoryDao();
	public List<Category> getAll() {
		return categoryDao.getAll();
	}
	/**
	 * 根据商城类型来查询
	 * @param id
	 * @return
	 */
	public List<Category> getBysId(Integer id){
		return categoryDao.getBysId(id);
	}
	//后
	public  boolean deleteById(Integer id){
		return categoryDao.deleteById(id);
	}
	public  boolean insert(Category category){
		return categoryDao.insert(category);
	}
	public  boolean update(Category category){
		return categoryDao.update(category);
	}
}
