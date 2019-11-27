package com.nf.shopproject.controller.be.product;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nf.shopproject.controller.BaseServlet;
import com.nf.shopproject.entity.Category;
import com.nf.shopproject.entity.CategoryAssociation;
import com.nf.shopproject.entity.Product;
import com.nf.shopproject.service.CategoryAssociationService;
import com.nf.shopproject.service.CategoryService;
import com.nf.shopproject.service.ProductService;

@WebServlet("/admin/product/edit")
public class ProductEditServlet extends BaseServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int pid=Integer.parseInt(req.getParameter("pid"));
		ProductService productService=new ProductService();
		Product product = productService.getById(pid);
        req.setAttribute("product", product);
        
        CategoryAssociationService categoryAss=new CategoryAssociationService();
        CategoryAssociation categoryAssociation=categoryAss.getById(pid); 
        req.setAttribute("categoryAssociation",categoryAssociation);
        
		CategoryService categoryService=new CategoryService();
        List<Category> categories = categoryService.getAll();//分类信息
        req.setAttribute("categories", categories);
        
        req.getRequestDispatcher("/WEB-INF/view/be/edit.jsp").forward(req, resp);
	}
}
