package com.nf.shopproject.controller.be.category;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nf.shopproject.controller.BaseServlet;
import com.nf.shopproject.entity.Store;
import com.nf.shopproject.service.StoreService;

@WebServlet("/admin/product/category")
public class CategoryIndexServlet extends BaseServlet{

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		StoreService storeService=new StoreService();
		List<Store> store=storeService.listAll();
		req.setAttribute("store",store);//父类
		req.getRequestDispatcher("/WEB-INF/view/be/category.jsp").forward(req, resp);
	}
}