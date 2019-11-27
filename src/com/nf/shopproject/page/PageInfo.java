package com.nf.shopproject.page;

public class PageInfo {
    private int pageNo = 1;
    private int recordCount;
    private int pageSize = 4;

    public PageInfo() {
    }

    public PageInfo(int pageNo, int recordCount) {
        this.pageNo = pageNo;
        this.recordCount = recordCount;
    }

    public PageInfo(int pageNo, int recordCount, int pageSize) {
        this.pageNo = pageNo;
        this.recordCount = recordCount;
        this.pageSize = pageSize;
    }

    public int getPageNo() {
        return pageNo;
    }

    public void setPageNo(int pageNo) {
        this.pageNo = pageNo;
    }

    public int getRecordCount() {
        return recordCount;
    }


    public int getPageSize() {
        return pageSize;
    }
    //尾页
    public int getLast() {
        return  getPageCount();
    }
    //总页数
    public int getPageCount(){
        return (int)Math.ceil(this.recordCount * 1.0 / this.pageSize);
    }
    //上一页
    public int getPrev() {
        return Math.max(pageNo-1, 1);
    }
    //下一页
    public int getNext() {
        return Math.min(pageNo+1, getPageCount());
    }
    //首页
    public int getFirst() {
        return 1;
    }


    public int getOffset(){
        return (this.pageNo-1) * this.pageSize;
    }
    
    //开始
    public int getStart() {
    	return (this.pageNo-1)* this.pageSize  + 1;
    }
    //结束
    public int getEnd() {
    	return this.pageNo* this.pageSize ;
    }

}
