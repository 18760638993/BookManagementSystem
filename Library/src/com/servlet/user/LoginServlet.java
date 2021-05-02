package com.servlet.user;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.UserDao;
import com.domain.BaseReader;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	// static final常量 serialVersionUID序列号以1开始
	// long长整型
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		response.setCharacterEncoding("utf-8");
		// PrintWriter out= response.getWriter();
		// out.print("进入servlet");
		// 获取登录页面的用户名和密码
		String Username = request.getParameter("username");// 参数对应html中标签的name属性
		String pwd = request.getParameter("userpwd");
		System.out.println(Username);
		UserDao dao = new UserDao();
		BaseReader user = dao.checkLogin(Username, pwd);

		// 判断对象是否为空，用null进行比较
		if (user != null) {
			// 请求转发
			/*
			 * RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
			 * rd.forward(request, response);
			 */
			HttpSession session = request.getSession();// 获取session对象

			// 使用session存储用户信息
			if (user.getUserState() == 1) {

				session.setAttribute("username", Username);
				session.setAttribute("sessionuser", user);

				System.out.println(user);
				// 重定向
				// response.sendRedirect("index.jsp");
				// 请求转发
				if (user.getUserType() == 1) {
					RequestDispatcher rd = request.getRequestDispatcher("behindIndex.jsp");
					rd.forward(request, response);
				} else {
					RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
					rd.forward(request, response);
				}
			} else {
				request.setAttribute("msg", "该用户已被冻结，请与管理员联系");
				// 请求转发
				RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
				rd.forward(request, response);
				return;
			}

		} else {
			// 给页面传回错误信息
			request.setAttribute("msg", "用户名和密码不匹配");
			// 请求转发
			RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
			rd.forward(request, response);
			return;
		}
	}

}