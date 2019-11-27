package com.nf.shopproject.controller.be.category;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nf.shopproject.controller.BaseServlet;
import com.nf.shopproject.service.CategoryService;

@WebServlet("/admin/category/delete")
public class CategoryDeleteServlet extends BaseServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Integer cid = Integer.parseInt(req.getParameter("cid"));
		System.out.print(cid);
		CategoryService categoryService=new CategoryService();
		boolean b=categoryService.deleteById(cid);
		String msg="";
		if(b){
			msg+="删除成功";
		}
		resp.getWriter().println(msg);
	}
}
