package com.nf.shopproject.controller.be.product;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nf.shopproject.controller.BaseServlet;
import com.nf.shopproject.service.ProductService;

@WebServlet("/admin/product/delete")
public class ProductDelectServlet extends BaseServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int pid=Integer.parseInt(req.getParameter("pid"));
		ProductService productService=new ProductService();
		String str="";
		if(productService.deleteById(pid)){
			str="删除成功";
		}else {
			str="删除失败";
		}
		resp.sendRedirect("/admin/product/index");
	}
}
