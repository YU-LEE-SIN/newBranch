package com.nf.shopproject.controller.fe;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nf.shopproject.controller.BaseServlet;
import com.nf.shopproject.entity.Cart;
import com.nf.shopproject.entity.CartItem;


@WebServlet("/viewcart")
public class ViewCartServlet extends BaseServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		req.getRequestDispatcher("/WEB-INF/view/fe/viewcart.jsp").forward(req, resp);
	}
}