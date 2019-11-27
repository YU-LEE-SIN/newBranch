package com.nf.shopproject.controller.be.product;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import com.nf.shopproject.controller.BaseServlet;
import com.nf.shopproject.entity.Category;
import com.nf.shopproject.entity.Product;
import com.nf.shopproject.service.CategoryService;
import com.nf.shopproject.service.ProductService;

@MultipartConfig
@WebServlet("/admin/product/insert")
public class ProductInsertServlet extends BaseServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html;charset=UTF-8");
		//获取file 对象
		Part part=req.getPart("pimage");
		System.out.println(part);
		//获得上传路径
		String filename = generateFileName(part); 
		System.out.println(filename);
		Product product=null;
		try {
			product=getProduct(req,filename);
			//得到文件的物理路径,以便保存文件到部署目录
			String reqlPath=req.getServletContext().getRealPath(filename);
			writeFile(reqlPath,part);//调用上传/保存文件到服务器
			//进行数据库操作
			insertProduct(product);
			//保存成功重定向去到主页
			resp.sendRedirect("/admin/product/index");
		}catch (RuntimeException e) {
			//保存失败转发到添加页面
			e.printStackTrace();
			//传一个实体类,作用域
			req.setAttribute("product", product);
			//查询类型
			CategoryService categoryService=new CategoryService();
			List<Category> category= categoryService.getAll();//查询类型 
			req.setAttribute("category",category);
			req.setAttribute("msg",e.getMessage());//给自己看错误信息
			//	req.setAttribute("msg", "出错了...");
			//转发到添加页面
			req.getRequestDispatcher("/WEB-INF/view/be/add.jsp").forward(req, resp);
		}
	}
	/**
	  *这个方法是返回实体类，是为了上面的方法进行添加数据的操作
	 */
	private Product getProduct(HttpServletRequest req, String filename) {
		//Integer pid=Integer.valueOf(req.getParameter("pid"));//返回一个表示指定的 int 值
		Integer cid=Integer.valueOf(req.getParameter("cid"));
		String pname=req.getParameter("pname");
		String about=req.getParameter("about");
		String original_priceString = req.getParameter("original_price");
		String remark=req.getParameter("remark");
		BigDecimal original_price = BigDecimal.valueOf(0);
		if(original_priceString != null && original_priceString.length()>0) {
			original_price = new BigDecimal(original_priceString);
		}
		return new Product(pname,original_price,filename,about,remark);
	}
	/**
	 * 数据库操作
	 * @param product
	 */
	private void insertProduct(Product product) {
		// TODO Auto-generated method stub
		ProductService productSerice=new ProductService();
		productSerice.insert(product);
	}
	 /**
	 * 生成上传的文件名
	 * uuid:全局唯一标识
	 * @param part
	 * @return
	 */
	 private String generateFileName(Part part) {
		 if(part.getSize() == 0) {
	            return "";
	        }
	        //得到的是:1.jpg
	        String submittedFileName = part.getSubmittedFileName();
	        //得到文件扩展名,包含点:比如: .jpg
	        String fileExt = submittedFileName
	        		.substring(submittedFileName.lastIndexOf('.'));
	        //此时返回的仍然是一个虚拟路径,不能进行保存操作,
	        // 必须转换为物理路径才能保存
	        return "Image/" + UUID.randomUUID() + fileExt;
	    }     
	/**
	 * 上传到服务器
	 * 利用getSize判断是否上传文件,有就写入
	 * @param fileName
	 * @param part
	 * @throws IOException
	 */
	private void writeFile(String fileName, Part part) throws IOException {
		if(part.getSize()<=0) {
			return;
		}
		part.write(fileName);//上传
	}
	

}
