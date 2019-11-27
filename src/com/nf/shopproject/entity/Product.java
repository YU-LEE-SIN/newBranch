package com.nf.shopproject.entity;

import java.math.BigDecimal;

public class Product {
	private Integer pk_pid;
	private String pname;
	private BigDecimal original_price;
	private String images;
	private String about;
	private String create_time;
	private String remark;
	
	public Product() {}
	public Product(String pname,BigDecimal original_price,String images,String about,String remark) {
		this.pname=pname;
		this.original_price=original_price;
		this.images=images;
		this.about=about;
		this.remark=remark;
	}
	public Product(String pname, BigDecimal original_price, String images, String about, String remark,Integer pk_pid) {
		this.pname=pname;
		this.original_price=original_price;
		this.images=images;
		this.about=about;
		this.remark=remark;
		this.pk_pid=pk_pid;
	}
	public Integer getPk_pid() {
		return pk_pid;
	}
	public void setPk_pid(Integer pk_pid) {
		this.pk_pid = pk_pid;
	}
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	public BigDecimal getOriginal_price() {
		return original_price;
	}
	public void setOriginal_price(BigDecimal original_price) {
		this.original_price = original_price;
	}
	public String getImages() {
		return images;
	}
	public void setImages(String images) {
		this.images = images;
	}
	public String getAbout() {
		return about;
	}
	public void setAbout(String about) {
		this.about = about;
	}
	public String getCreate_time() {
		return create_time;
	}
	public void setCreate_time(String create_time) {
		this.create_time = create_time;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}

	@Override
	public String toString() {
		return "Product [pk_pid=" + pk_pid + ", pname=" + pname + ", original_price=" + original_price + ", images="
				+ images + ", about=" + about + ", create_time=" + create_time + ", remark=" + remark + "]";
	}
}
