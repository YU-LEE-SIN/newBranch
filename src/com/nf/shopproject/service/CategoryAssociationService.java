package com.nf.shopproject.service;

import com.nf.shopproject.dao.CategroryAssociationDao;
import com.nf.shopproject.entity.CategoryAssociation;

public class CategoryAssociationService {
	CategroryAssociationDao categoryADao=new CategroryAssociationDao();
	
	public CategoryAssociation getById(Integer pid){
		return categoryADao.getById(pid);
	}
}
