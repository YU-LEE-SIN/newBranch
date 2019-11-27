package com.nf.shopproject.controller.text;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.nf.shopproject.controller.BaseServlet;
import com.nf.shopproject.entity.CartItem;
import com.nf.shopproject.entity.ProductSpecification;
import com.nf.shopproject.entity.Store;
import com.nf.shopproject.service.ProductService;
import com.nf.shopproject.service.StoreService;

@WebServlet("/textaddToCart")
public class TextAddToCartServlet extends BaseServlet{
	@Override
	/**
	 * ������Ʒ���������
	 */
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Integer pid = Integer.parseInt(req.getParameter("pk_pid"));//��Ʒ����pk_id //����123,��ɫ123
		//Integer count=Integer.parseInt(req.getParameter("count"));//����
		ProductSkuService productSkuService=new ProductSkuService();
		ProductSpecification productSpe=productSkuService.getproductByid(pid);//������Ʒ����pk_id��ѯ�۸�
		//referer �ĵ���һ�����ʵ�ַ,�����ֵ������Ʒҳ��
		String referer=req.getHeader("referer");
		CartItemText cartItem=new CartItemText(productSpe, 5);
		addToCartServlet(req,cartItem);
		resp.sendRedirect(referer);
	}

	private void addToCartServlet(HttpServletRequest req, CartItemText cartItem) {
		HttpSession session=req.getSession();
		CartText cart=(CartText)session.getAttribute("cart");
		if(cart!=null) {
			cart.addCartItem(cartItem);
		}else {
			cart=new CartText();
			cart.addCartItem(cartItem);
			session.setAttribute("cart", cart);
		}
	}

}
