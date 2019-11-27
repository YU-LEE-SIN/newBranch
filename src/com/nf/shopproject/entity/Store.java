package com.nf.shopproject.entity;

public class Store {
	private Integer pk_sid;
	private String sname;
	public Integer getPk_sid() {
		return pk_sid;
	}
	public void setPk_sid(Integer pk_sid) {
		this.pk_sid = pk_sid;
	}
	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}
	@Override
	public String toString() {
		return "Store [pk_sid=" + pk_sid + ", sname=" + sname + "]";
	}
}
