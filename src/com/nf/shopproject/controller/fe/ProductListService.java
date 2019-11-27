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
import com.nf.shopproject.entity.Category;
import com.nf.shopproject.entity.Product;
import com.nf.shopproject.entity.Store;
import com.nf.shopproject.page.PageInfo;
import com.nf.shopproject.service.CategoryService;
import com.nf.shopproject.service.ProductService;
import com.nf.shopproject.service.StoreService;
import com.nf.shopproject.vo.ProductCategoryVO;
@WebServlet("/product")
public class ProductListService extends BaseServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		StoreService storeService=new StoreService();
		List<Store> store=storeService.listAll();
		req.setAttribute("store",store);//父类
		Integer cid=getParamInteger(req, "pk_cid", 0);
		CategoryService categoryService=new CategoryService();
		ProductService productService=new ProductService();
		//查询全部的类型
		List<Category> categories=categoryService.getAll();
		Map<String,Object> conditions=generateSearchCondition(req);//查询条件
		//System.out.println("条件"+conditions);
		//总数
		int recordCount=productService.getProductsCountByCondition(conditions);
		//System.out.println("总数"+recordCount);
		PageInfo pageInfo=new PageInfo(getParamInteger(req, "pageno", 1), recordCount,PAGE_SIZE);
		//查询分页得到数据
		List<Product>products=productService.getProductByCondition(conditions, 
				pageInfo.getStart(), pageInfo.getEnd());
		//System.out.println("商品"+products);
		ProductCategoryVO productCategoryVO=new ProductCategoryVO(products, 
				categories, pageInfo,cid);
		
		req.setAttribute("pvo", productCategoryVO);
		req.getRequestDispatcher("WEB-INF/view/fe/product.jsp").forward(req, resp);
		//req.getRequestDispatcher("WEB-INF/view/fe/text.jsp").forward(req, resp);
	}
	
	//查询条件方法
	private Map<String,Object> generateSearchCondition(HttpServletRequest req){
		Integer cid = getParamInteger(req,"pk_cid",0);
		String pname = req.getParameter("pname");
		Map<String,Object> conditions = new HashMap<>(16);
		if(cid==0) {
			conditions.put("cid",1);//key是字段
		}
		if(cid != null) {
			conditions.put("cid",cid);//key是字段
		}
		if(pname != null) {
			conditions.put("pname", "%"+pname+"%");
		}
		return conditions;
	}
	

}
