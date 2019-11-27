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
	//���еĲ���Ҫ����Ȩ����֤��url
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
		String url=req.getRequestURI();// ��ȡ��ǰ�����URI 
		boolean isAllowedUrl=isallURLs(url);
		if(isAllowedUrl) {
			//�˵�ַ����Ҫ����Ȩ����֤,����ֱ�ӷ���
			chain.doFilter(req, resp);
		}else {
			HttpSession session=req.getSession();
			Object username=session.getAttribute("Uname");
			if(null==username) {
				// ���û���û���Ϣ,�ͱ���û�е�¼,��Ҫȥ��¼
				//�����ض��򵽵�¼ҳ��,���Ҳ����ж���Ҫ��֤��Դ�ķ���
				resp.sendRedirect("/HomeWork/Login.html");
			}else {
				// ������û���Ϣ,�ͱ����Ѿ���¼��.ֱ�ӷ���
				chain.doFilter(req, resp);
			}
		}
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		//loginUrl = config.getInitParameter("loginUrl");//����д��xml����/�ָ�
		//allowList = config.getInitParameter("allowList").split(",");//����д��xml����,�ָ�
		//����ֱ�ӷ��ʵ�url,������List������,
		//allURLs.add("");//ע��ҳ��
	}

	private boolean isallURLs(String url) {
		boolean bool=false;
		for(String u:allURLs) {//ѭ���������url
			if(url.equals(u)) {//url=��ǰ��ҳ·��
				bool=true;
				break;
			}
		}
		return bool;
	}
}
