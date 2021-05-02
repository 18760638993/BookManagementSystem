package com.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.domain.BaseReader;

public class behindServlet implements Filter {

	public void destroy() {
		
	}
	
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

		System.out.println("behindIndex.jsp");
		HttpServletRequest req=(HttpServletRequest)request;
		HttpServletResponse resp=(HttpServletResponse) response;
		HttpSession session=req.getSession();
		BaseReader userReader=(BaseReader) session.getAttribute("sessionuser");
		
		if(userReader.getUserState()==0) {
			chain.doFilter(request, response);
		}
		else {
			resp.sendRedirect("login.jsp");
		}
	}
	
	public void init(FilterConfig fConfig) throws ServletException {
	}

}
