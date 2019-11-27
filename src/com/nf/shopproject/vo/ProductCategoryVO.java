package com.nf.shopproject.vo;

import java.util.List;

import com.nf.shopproject.entity.Category;
import com.nf.shopproject.entity.Product;
import com.nf.shopproject.page.PageInfo;

public class ProductCategoryVO {
	private List<Product> products;
	private List<Category> categories;
	private PageInfo pageInfo;
	private Integer currentCid;
	
	public List<Product> getProducts() {
		return products;
	}
	public void setProducts(List<Product> products) {
		this.products = products;
	}
	public List<Category> getCategories() {
		return categories;
	}
	public void setCategories(List<Category> categories) {
		this.categories = categories;
	}
	public PageInfo getPageInfo() {
		return pageInfo;
	}
	public void setPageInfo(PageInfo pageInfo) {
		this.pageInfo = pageInfo;
	}
	public Integer getCurrentCid() {
		return currentCid;
	}
	public void setCurrentCid(Integer currentCid) {
		this.currentCid = currentCid;
	}
	
	public ProductCategoryVO(List<Product> products, PageInfo pageInfo,Integer currentCid) {
		this.products = products;
		this.pageInfo = pageInfo;
	}
	public ProductCategoryVO(List<Product> products,
			List<Category> categories, PageInfo pageInfo) {
		this.products = products;
		this.categories = categories;
		this.pageInfo = pageInfo;
	}
	public ProductCategoryVO(List<Product> products, 
			List<Category> categories, PageInfo pageInfo,
			Integer currentCid) {
		this.products = products;
		this.categories = categories;
		this.pageInfo = pageInfo;
		this.currentCid = currentCid;
	}
}
