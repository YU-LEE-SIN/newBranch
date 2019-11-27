package com.nf.shopproject.controller.text;

import java.util.List;
import java.util.Map;

import com.nf.shopproject.dao.ProductSKUDao;
import com.nf.shopproject.entity.ProductSpecification;

public class ProductSkuService {
	ProductSKUDao productSKUDao=new ProductSKUDao();
	public List<ProductSpecification> getProductByConditionTwo(Map<String,Object>conditions){
		return productSKUDao.getProductByConditionTwo(conditions);
	}
	
	public List<ProductSpecification> getproductBypid(Integer id) {
		return  productSKUDao.getproductBypid(id);
	}
	
	public ProductSpecification getproductByid(Integer id) {
		return productSKUDao.getproductByid(id);
	}
}
