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


/**
 * 登录过滤器
 * 
 * @author 
 *
 */
public class LoginFilter implements Filter {

	public LoginFilter() {

	}

	public void destroy() {
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		request.setCharacterEncoding("utf-8");

		response.setCharacterEncoding("utf-8");

		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse resp = (HttpServletResponse) response;
		HttpSession session = req.getSession();
		BaseReader userReader = (BaseReader) session.getAttribute("sessionuser");
		String path = req.getServletPath();// 获取url地址
		System.out.println("user:" + userReader);

		if (path.indexOf("login.jsp") > 0 || path.indexOf("register.jsp") > 0 || path.indexOf("index.jsp") > 0
				|| path.indexOf("style") > 0 || path.indexOf("LoginServlet") > 0 || path.indexOf("register.action") > 0
				|| path.indexOf("getAllBook.action") > 0 || path.indexOf("getAllType.action") > 0
				|| path.indexOf("gonggao.jsp") > 0 || path.indexOf("getBookByBId.action") > 0 || userReader != null) {

			chain.doFilter(req, resp);
		} else {

			resp.sendRedirect("login.jsp");
			return;

		}

	}

	public void init(FilterConfig fConfig) throws ServletException {
	}

}
