package com.nf.shopproject.entity;

public class CategoryAssociation {
	private Integer pk_aid;
	private Integer cid;
	private Integer pid;
	private Integer pk_cid;
	private String cname;
	public Integer getPk_aid() {
		return pk_aid;
	}
	public void setPk_aid(Integer pk_aid) {
		this.pk_aid = pk_aid;
	}
	public Integer getCid() {
		return cid;
	}
	public void setCid(Integer cid) {
		this.cid = cid;
	}
	public Integer getPid() {
		return pid;
	}
	public void setPid(Integer pid) {
		this.pid = pid;
	}
	public Integer getPk_cid() {
		return pk_cid;
	}
	public void setPk_cid(Integer pk_cid) {
		this.pk_cid = pk_cid;
	}
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
}
