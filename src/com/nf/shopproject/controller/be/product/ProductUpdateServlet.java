package com.nf.shopproject.controller.be.product;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import com.nf.shopproject.controller.BaseServlet;
import com.nf.shopproject.entity.Product;
import com.nf.shopproject.service.ProductService;

@MultipartConfig
@WebServlet("/admin/product/update")
public class ProductUpdateServlet extends BaseServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
 		resp.setContentType("text/html;charset=UTF-8");
		//获取file 对象
		Part part=req.getPart("pimage");
		//System.out.println(part);
		//获得上传路径
		String filename = generateFileName(part); 
		//System.out.println(filename);		
		//如果为空串的情况，需要得到产品原本的图片，
		if(filename.isEmpty()) {
			 // 利用隐藏域保存原本图片的路径，下面的代码就是取出原本图片的文件名
			filename = req.getParameter("oldimage");
		}
		Product product=getProduct(req,filename);
		System.out.println(product);	
		try {
		//把虚拟路径转换为物理路径，以便保存文件
		String realPath=req.getServletContext().getRealPath(filename);
		//调用上传文件
		writeFile(realPath,part);
		//执行数据库
		updateProduct(product);
		
		resp.sendRedirect("/admin/product/index");
		
		}catch (RuntimeException re){
            //出了错误就回到修改页面，继续修改，并带上本次修改的一些数据，以避免用户重新填写。
            req.setAttribute("product", product);
            req.getRequestDispatcher("/admin/product/edit").forward(req, resp);
        }
	}
	
	/**
	 * 数据库操作
	 * @param product
	 */
	private void updateProduct(Product product) throws ServletException, IOException {
		ProductService productSerice=new ProductService();
		productSerice.update(product);
	}
	/**
	 * 这个方法是返回实体类
	 * @param req
	 * @param filename
	 * @return
	 */
	private Product getProduct(HttpServletRequest req, String filename) {
		Integer cid=Integer.valueOf(req.getParameter("pid"));
		String pname=req.getParameter("pname");
		String about=req.getParameter("about");
		BigDecimal original_price = new BigDecimal(req.getParameter("original_price"));
		String remark=req.getParameter("remark");
		 return new Product(pname, original_price, filename, about, remark,cid);
	}

	/**
	 * 用来生成上传文件的文件名。
	 * uuid：universal unique identity，全局唯一标识符
	 * @param part
	 * @return
	 */
	private String generateFileName(Part part) {
		if(part.getSize() == 0) {
			return "";
		}
		//文件名
		String submittedFileName=part.getSubmittedFileName();
		//文件后缀名   .jpg
		 String fileExt = submittedFileName.substring(submittedFileName.lastIndexOf('.'));
	     //上传过来的文件放在images目录下，记住这个images目录是部署到tomcat之后的目录，不是
	     //工程目录下面的images目录。
		 return "Image/" + UUID.randomUUID() + fileExt;
	}
	/**
     * 把文件写到服务端。
     * 利用getSize判断是否有上传文件。有的话才写文件
     * @param fileName
     * @param part
     * @throws IOException
     */
    private void writeFile(String fileName,Part part) throws IOException {
        if(part.getSize() <= 0) {
            return;
        }
        part.write(fileName);
    }
}