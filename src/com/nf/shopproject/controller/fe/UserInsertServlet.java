package com.nf.shopproject.controller.fe;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.nf.shopproject.controller.BaseServlet;
import com.nf.shopproject.entity.User;
import com.nf.shopproject.service.UserService;
import com.nf.shopproject.vo.ResponseVO;

@WebServlet("/userInsert")
public class UserInsertServlet extends BaseServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String username=req.getParameter("email");
		String pwd=req.getParameter("password2");
		//System.out.println(username);
		//System.out.println(pwd);
		UserService userService=new UserService();
		User user=new User();
		user.setName(username);
		user.setPassword(pwd);
		boolean b=userService.insertUser(user);
		resp.getWriter().print(b);
	}
}
