package com.nf.shopproject.filter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

//@WebFilter("/*")
public class LoginAuthFilter implements Filter{
	//所有的不需要进行权限验证的url
	private List<String> allURLs=new ArrayList<String>();
	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse respon, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest req=(HttpServletRequest) request;
		HttpServletResponse resp=(HttpServletResponse) respon;
		String url=req.getRequestURI();// 获取当前请求的URI 
		boolean isAllowedUrl=isallURLs(url);
		if(isAllowedUrl) {
			//此地址不需要进行权限验证,所以直接放行
			chain.doFilter(req, resp);
		}else {
			HttpSession session=req.getSession();
			Object username=session.getAttribute("Uname");
			if(null==username) {
				// 如果没有用户信息,就表明没有登录,需要去登录
				//所以重定向到登录页面,并且不放行对需要验证资源的访问
				resp.sendRedirect("/HomeWork/Login.html");
			}else {
				// 如果有用户信息,就表明已经登录了.直接放行
				chain.doFilter(req, resp);
			}
		}
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		//loginUrl = config.getInitParameter("loginUrl");//可以写在xml中用/分割
		//allowList = config.getInitParameter("allowList").split(",");//可以写在xml中用,分割
		//可以直接访问的url,储存在List集合里,
		//allURLs.add("");//注册页面
	}

	private boolean isallURLs(String url) {
		boolean bool=false;
		for(String u:allURLs) {//循环集合里的url
			if(url.equals(u)) {//url=当前网页路径
				bool=true;
				break;
			}
		}
		return bool;
	}
}
