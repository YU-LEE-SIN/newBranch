package com.nf.shopproject.controller.fe;

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

@WebServlet("/category")
public class CategoryGetSidService extends BaseServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Integer id=Integer.parseInt(req.getParameter("id"));
		//System.out.print(id);
		CategoryService categoryService=new CategoryService();
		List<Category> category=categoryService.getBysId(id);
		ObjectMapper mapper=new ObjectMapper();
		String jsonText=mapper.writeValueAsString(category);
		resp.getWriter().print(jsonText);
		//System.out.println(jsonText);
	}

}
