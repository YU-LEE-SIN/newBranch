package com.nf.shopproject.controller.text;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.nf.shopproject.controller.BaseServlet;

@WebServlet("/removes")
public class TextRemoveServlet extends BaseServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String count=req.getParameter("qty");
		String [] pids=req.getParameterValues("pk_pid");
		CartText cart=(CartText) req.getSession().getAttribute("cart");
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

	private void removeProductspe(String[] pids, CartText cart) {
		// TODO Auto-generated method stub
		if(pids!=null && pids.length>0) {
			for(String id : pids) {
				cart.removeItems(Integer.valueOf(id));
			}

		}
	}
	
}
