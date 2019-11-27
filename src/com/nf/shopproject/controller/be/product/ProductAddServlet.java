package com.nf.shopproject.controller.be.product;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.nf.shopproject.controller.BaseServlet;
import com.nf.shopproject.entity.Category;
import com.nf.shopproject.entity.Product;
import com.nf.shopproject.service.CategoryService;

@WebServlet("/admin/product/add")
public class ProductAddServlet extends BaseServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setAttribute("product",new Product());//作用域
		CategoryService categoryService=new CategoryService();
		List<Category> category= categoryService.getAll();//商品类型
		req.setAttribute("category",category);
		req.getRequestDispatcher("/WEB-INF/view/be/add.jsp").forward(req, resp);
	}
}
