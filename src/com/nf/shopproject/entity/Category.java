package com.nf.shopproject.entity;

public class Category {
	private Integer pk_cid;
	private Integer sid;  //Íâ¼üÉÌ³Ç
	private String cname;
	public Integer getPk_cid() {
		return pk_cid;
	}
	public void setPk_cid(Integer pk_cid) {
		this.pk_cid = pk_cid;
	}
	public Integer getSid() {
		return sid;
	}
	public void setSid(Integer sid) {
		this.sid = sid;
	}
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
}
