package com.nf.shopproject.controller.fe;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nf.shopproject.controller.BaseServlet;
import com.nf.shopproject.entity.Cart;

@WebServlet("/removefromcart")
public class RemoveFromCartServlet extends BaseServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String count=req.getParameter("qty");
		String [] pids=req.getParameterValues("pk_pid");
		Cart cart=(Cart) req.getSession().getAttribute("cart");
		if(cart==null) {
			resp.sendRedirect("/index");
			return;
		}
		if(count == null || count.isEmpty()) {
			removeProductspe(pids,cart);
		}else {
			cart.removeItems(Integer.valueOf(pids[0]),Integer.valueOf(count));
		}
		resp.sendRedirect("/viewcart");
	}
	private void removeProductspe(String[] pids, Cart cart) {
		// TODO Auto-generated method stub
		if(pids!=null && pids.length>0) {
			for(String id : pids) {
				cart.removeItems(Integer.valueOf(id));
			}

		}
	}
}
