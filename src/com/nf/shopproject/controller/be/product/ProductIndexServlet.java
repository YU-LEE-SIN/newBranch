package com.nf.shopproject.controller.be.product;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nf.shopproject.controller.BaseServlet;
import com.nf.shopproject.entity.Product;
import com.nf.shopproject.page.PageInfo;
import com.nf.shopproject.service.ProductService;
import com.nf.shopproject.vo.ProductVO;

@WebServlet("/admin/product/index")
public class ProductIndexServlet extends BaseServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ProductService productService=new ProductService();
		int recordCount=productService.getRecordCount();////商品总数量
		PageInfo pageInfo=new PageInfo(getParamInteger(req, "pageno", 1),recordCount,PAGE_SIZE);
		List<Product> product=productService.getPagedRecords(pageInfo.getStart(),pageInfo.getEnd());
		
		ProductVO productVO=new ProductVO(pageInfo,product);
		req.setAttribute("pvo",productVO);
		req.getRequestDispatcher("/WEB-INF/view/be/pagelist.jsp").forward(req, resp);
	}
}
