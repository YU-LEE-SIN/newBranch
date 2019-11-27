package com.nf.shopproject.controller.be.category;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.nf.shopproject.controller.BaseServlet;
import com.nf.shopproject.entity.Category;
import com.nf.shopproject.service.CategoryService;

@WebServlet("/admin/category/list")
public class CategoryListServlet extends BaseServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("application/json");
		resp.setCharacterEncoding("UTF-8");
		CategoryService categoryService=new CategoryService();
		List<Category> list=categoryService.getAll();
		ObjectMapper mapper=new ObjectMapper();
		String jsonText=mapper.writeValueAsString(list);
		resp.getWriter().print(jsonText);
	}
}
