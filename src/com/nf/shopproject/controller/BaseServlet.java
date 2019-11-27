package com.nf.shopproject.controller;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;



public abstract class BaseServlet extends HttpServlet{
	protected static final int PAGE_SIZE = 2;
	//protected ProductService productService=new ProductService();
	//protected CategoryService categoryService=new CategoryService();
	
	protected Integer getParamInteger(HttpServletRequest req,String key, int defaultValue) {
		Integer returnValue=defaultValue;
		try {
			returnValue=Integer.valueOf(req.getParameter(key));
		}catch(NumberFormatException nfe) {}
		//���ص�ǰҳ��
		return returnValue;
	}
}
