//package com.nf.shopproject.filter;
//
//import java.io.IOException;
//
//import javax.servlet.Filter;
//import javax.servlet.FilterChain;
//import javax.servlet.FilterConfig;
//import javax.servlet.ServletException;
//import javax.servlet.ServletRequest;
//import javax.servlet.ServletResponse;
//import javax.servlet.annotation.WebFilter;
//
////@WebFilter("/admin/*")
//@WebFilter (urlPatterns = {"/admin/*","/index","/category","/buy","/product"})
//
//public class EncodingFilter implements Filter{
//	public static String Encoding="UTF-8";
//	@Override
//	public void destroy() {
//		// TODO Auto-generated method stub
//		System.out.println("过滤器关闭");
//	}
//
//	@Override
//	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain)
//			throws IOException, ServletException {
//		req.setCharacterEncoding("UTF-8");
//		resp.setContentType("text/html;charset=UTF-8");
//		chain.doFilter(req, resp);
//		System.out.println("执行过滤器");
//	}
//
//	@Override
//	public void init(FilterConfig fConfig) throws ServletException {
//		// TODO Auto-generated method stub
//		Encoding=fConfig.getInitParameter("encoding");
//		System.out.println("过滤器初始化");
//	}
//
//}