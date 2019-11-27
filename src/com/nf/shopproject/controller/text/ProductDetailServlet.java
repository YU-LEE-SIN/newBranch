package com.nf.shopproject.controller.text;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.nf.shopproject.controller.BaseServlet;
import com.nf.shopproject.entity.Product;
import com.nf.shopproject.entity.ProductSpecification;
import com.nf.shopproject.entity.Store;
import com.nf.shopproject.service.ProductService;
import com.nf.shopproject.service.StoreService;
@WebServlet("/productDetails")
public class ProductDetailServlet extends BaseServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("application/json");
		resp.setCharacterEncoding("UTF-8");
		StoreService storeService=new StoreService();
		List<Store> store=storeService.listAll();
		req.setAttribute("store",store);
//		Integer pid=Integer.parseInt(req.getParameter("pid"));
//		System.out.println("商品id"+pid);
		Integer pk_id=Integer.parseInt(req.getParameter("pk_id"));
		System.out.println("规格id"+pk_id);
		//商品表查询
//		ProductService productService=new ProductService();
//		Product product=productService.getById(pid);
//		req.setAttribute("product",product);
		
		//商品规格表查询
		ProductSkuService productSkuService=new ProductSkuService();
		ProductSpecification productspe=productSkuService.getproductByid(pk_id);
		//req.setAttribute("productspe", productspe);
		ObjectMapper mapper=new ObjectMapper();
		String jsonText=mapper.writeValueAsString(productspe);
		req.getSession().setAttribute("proudctspe",productspe);
		System.out.println("jiage"+productspe.getPk_id());
		resp.getWriter().print(jsonText);
		//req.getRequestDispatcher("/WEB-INF/view/fe/text.jsp").forward(req, resp);
	}
}
