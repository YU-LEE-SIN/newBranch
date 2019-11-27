package com.nf.shopproject.dao;

import org.apache.commons.dbutils.handlers.BeanHandler;
import com.nf.shopproject.entity.CategoryAssociation;

public class CategroryAssociationDao extends BaseDao{
	public CategoryAssociation getById(Integer pid){
		String sql="select *\r\n" + 
				"from category_association c inner join \r\n" + 
				"category s on  c.cid=s.pk_cid\r\n" + 
				"where pid like ?";
		BeanHandler<CategoryAssociation> categoryAss=new BeanHandler<>(CategoryAssociation.class);
		CategoryAssociation result=queryRunner.query(sql, categoryAss, pid);
		return result;
	}	
}
