package com.nf.shopproject.entity;

import java.math.BigDecimal;

public class CartItem {
	private ProductSpecification prt_specification;
	private int count;//����
	

	public ProductSpecification getPrt_specification() {
		return prt_specification;
	}

	public void setPrt_specification(ProductSpecification prt_specification) {
		this.prt_specification = prt_specification;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}
	//���캯��
	public CartItem(){
		
	}
	public CartItem(ProductSpecification prt_specification){
		this(prt_specification,1);

	}
	public CartItem(ProductSpecification prt_specification,int count){
		this.prt_specification=prt_specification;
		this.count=count;
	}
	//������ С��
	public BigDecimal getSubTotal() {
		return this.prt_specification.getPrt_sp_price().multiply(new BigDecimal(count));
	}
}
