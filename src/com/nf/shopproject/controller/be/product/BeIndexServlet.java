package com.nf.shopproject.controller.be.product;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.nf.shopproject.controller.BaseServlet;

@WebServlet("/admin/index")
public class BeIndexServlet extends BaseServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/WEB-INF/view/be/beindex.jsp").forward(req, resp);
	}
}
