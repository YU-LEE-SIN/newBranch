package com.nf.shopproject.controller.fe;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.nf.shopproject.controller.BaseServlet;
import com.nf.shopproject.entity.User;
import com.nf.shopproject.service.UserService;

import sun.print.resources.serviceui;

@WebServlet("/userlogin")
public class LoginServlet extends BaseServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		 String username=req.getParameter("email");
		 String pwd=req.getParameter("password");
		 User userEn=new User();
		 userEn.setName(username);
		 userEn.setPassword(pwd);
		 //System.out.println(username+pwd);
		 UserService userService=new UserService();
		userEn=userService.getByCondition(userEn);
		//System.out.println("查询"+userEn);
			//数据库取出的数据不为空,输入的数据和数据库一置
			if(userEn!=null){
				//保存到session
				HttpSession session=req.getSession();
				session.setAttribute("Uname",username);
				req.setAttribute("user", username);
				resp.getWriter().print(userEn);
			}else {
				resp.getWriter().print(userEn);
			}
	}
}