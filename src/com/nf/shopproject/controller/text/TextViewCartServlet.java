package com.nf.shopproject.controller.text;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nf.shopproject.controller.BaseServlet;

@WebServlet("/textviewcart")
public class TextViewCartServlet extends BaseServlet{
protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/WEB-INF/view/fe/textviewcart.jsp").forward(req, resp);
	}
}
