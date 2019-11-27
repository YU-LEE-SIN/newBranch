package com.nf.shopproject.controller.text;

import java.math.BigDecimal;

import com.nf.shopproject.entity.ProductSpecification;

public class CartItemText {
	private ProductSpecification prt_specification;
	private int count;
	
	public CartItemText() {}
	public CartItemText(ProductSpecification prt_specification){
		this(prt_specification,1);
	}

	public CartItemText(ProductSpecification prt_specification, int count) {
		this.prt_specification=prt_specification;
		this.count=count;
	}
	public BigDecimal getSubTotal() {//购物项小计
		return this.prt_specification.getPrt_sp_price().multiply(new BigDecimal(count));
	}
	
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
}
