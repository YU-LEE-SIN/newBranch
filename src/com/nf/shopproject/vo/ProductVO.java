package com.nf.shopproject.vo;

import java.util.List;

import com.nf.shopproject.entity.Product;
import com.nf.shopproject.page.PageInfo;

public class ProductVO {
	public PageInfo getPageInfo() {
		return pageInfo;
	}
	public void setPageInfo(PageInfo pageInfo) {
		this.pageInfo = pageInfo;
	}
	public List<Product> getProducts() {
		return products;
	}
	public void setProducts(List<Product> products) {
		this.products = products;
	}
	private PageInfo pageInfo;
	private List<Product> products;
	
	public ProductVO() {}
	public ProductVO(PageInfo pageInfo,List<Product> products) {
		this.pageInfo=pageInfo;
		this.products=products;
	}
}
