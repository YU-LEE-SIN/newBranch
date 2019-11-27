package com.nf.shopproject.controller.be.category;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.nf.shopproject.controller.BaseServlet;
import com.nf.shopproject.entity.Category;
import com.nf.shopproject.service.CategoryService;

@WebServlet("/admin/category/insert")
public class CategoryInsertServlet extends BaseServlet{

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//req.setCharacterEncoding("UTF-8");
		//resp.setContentType("text/html;charset=UTF-8");
		Integer sid=Integer.parseInt(req.getParameter("sid"));
		String cname=req.getParameter("cname");
		Category category=new Category();
		category.setSid(sid);
		category.setCname(cname);
		CategoryService categoryService=new CategoryService();
		boolean b=categoryService.insert(category);
		resp.getWriter().print(b);
	}
}
