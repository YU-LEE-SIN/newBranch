package com.nf.shopproject.controller.fe;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nf.shopproject.controller.BaseServlet;
import com.nf.shopproject.controller.text.ProductSkuService;
import com.nf.shopproject.entity.Category;
import com.nf.shopproject.entity.Product;
import com.nf.shopproject.entity.ProductSpecification;
import com.nf.shopproject.entity.Store;
import com.nf.shopproject.page.PageInfo;
import com.nf.shopproject.service.CategoryService;
import com.nf.shopproject.service.ProductService;
import com.nf.shopproject.service.StoreService;
import com.nf.shopproject.vo.ProductCategoryVO;

@WebServlet("/buy")
public class BuyProductServlet extends BaseServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//父类
		StoreService storeService=new StoreService();
		List<Store> store=storeService.listAll();
		req.setAttribute("store",store);
		Integer pid=Integer.parseInt(req.getParameter("pk_pid"));
		//商品表查询
		ProductService productService=new ProductService();
		Product product=productService.getById(pid);
		req.setAttribute("product",product);
		//商品规格表查询
		ProductSkuService productSkuService=new ProductSkuService();
		List<ProductSpecification> productspe=productSkuService.getproductBypid(pid);
		//System.out.println(productspe);
		req.setAttribute("productspe", productspe);
		req.getRequestDispatcher("/WEB-INF/view/fe/buy.jsp").forward(req, resp);
	}
}
