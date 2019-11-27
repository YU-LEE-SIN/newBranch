package com.nf.shopproject.controller.be.category;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nf.shopproject.controller.BaseServlet;
import com.nf.shopproject.entity.Category;
import com.nf.shopproject.service.CategoryService;

@WebServlet("/admin/category/update")
public class CategoryUpdateServlet extends BaseServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Integer sid=Integer.parseInt(req.getParameter("sid"));
		String cname=req.getParameter("cname");
		Integer cid=Integer.parseInt(req.getParameter("cid"));
		System.out.print(cid);
		Category category=new Category();
		category.setPk_cid(cid);
		category.setSid(sid);
		category.setCname(cname);
		CategoryService categoryService=new CategoryService();
		boolean b=categoryService.update(category);
		resp.getWriter().print(b);
	}
}
