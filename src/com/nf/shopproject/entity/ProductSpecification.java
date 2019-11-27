package com.nf.shopproject.entity;

import java.math.BigDecimal;

public class ProductSpecification {
	private Integer pid;
	private Integer cid;
	private String sp_pr_one_name;
	private String sp_pr_two_name;
	private Integer pk_id;
	private String prt_sp_one_name;
	private String prt_sp_two_name;
	private BigDecimal prt_sp_price;
	private String prt_stock;
	private String is_prt_state;
	@Override
	public String toString() {
		return "ProductSpecification [pid=" + pid + ", cid=" + cid + ", sp_pr_one_name=" + sp_pr_one_name
				+ ", sp_pr_two_name=" + sp_pr_two_name + ", pk_id=" + pk_id + ", prt_sp_one_name=" + prt_sp_one_name
				+ ", prt_sp_two_name=" + prt_sp_two_name + ", prt_sp_price=" + prt_sp_price + ", prt_stock=" + prt_stock
				+ ", is_prt_state=" + is_prt_state + "]";
	}
	public Integer getPid() {
		return pid;
	}
	public void setPid(Integer pid) {
		this.pid = pid;
	}
	public Integer getCid() {
		return cid;
	}
	public void setCid(Integer cid) {
		this.cid = cid;
	}
	public String getSp_pr_one_name() {
		return sp_pr_one_name;
	}
	public void setSp_pr_one_name(String sp_pr_one_name) {
		this.sp_pr_one_name = sp_pr_one_name;
	}
	public String getSp_pr_two_name() {
		return sp_pr_two_name;
	}
	public void setSp_pr_two_name(String sp_pr_two_name) {
		this.sp_pr_two_name = sp_pr_two_name;
	}
	public Integer getPk_id() {
		return pk_id;
	}
	public void setPk_id(Integer pk_id) {
		this.pk_id = pk_id;
	}
	public String getPrt_sp_one_name() {
		return prt_sp_one_name;
	}
	public void setPrt_sp_one_name(String prt_sp_one_name) {
		this.prt_sp_one_name = prt_sp_one_name;
	}
	public String getPrt_sp_two_name() {
		return prt_sp_two_name;
	}
	public void setPrt_sp_two_name(String prt_sp_two_name) {
		this.prt_sp_two_name = prt_sp_two_name;
	}
	public BigDecimal getPrt_sp_price() {
		return prt_sp_price;
	}
	public void setPrt_sp_price(BigDecimal prt_sp_price) {
		this.prt_sp_price = prt_sp_price;
	}
	public String getPrt_stock() {
		return prt_stock;
	}
	public void setPrt_stock(String prt_stock) {
		this.prt_stock = prt_stock;
	}
	public String getIs_prt_state() {
		return is_prt_state;
	}
	public void setIs_prt_state(String is_prt_state) {
		this.is_prt_state = is_prt_state;
	}
}
