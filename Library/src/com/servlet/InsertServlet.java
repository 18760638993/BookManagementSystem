package com.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.AdminDao;
import com.domain.Admin;

/**
 * 添加管理员信息
 */
@WebServlet("/InsertServlet")
public class InsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		response.setCharacterEncoding("utf-8");
		// 获取页面输入的内容
		String adminname = request.getParameter("adminname");
		String pwd = request.getParameter("pwd");
		String repwd = request.getParameter("repwd");
		int sex = Integer.parseInt(request.getParameter("sex"));
		String tel = request.getParameter("mobile");
		String email = request.getParameter("email");
		if (pwd.equals(repwd)) {
			AdminDao dao = new AdminDao();
			Admin admin = new Admin();
			admin.setUserName(adminname);
			admin.setPwd(pwd);
			admin.setSex(sex);
			admin.setMobile(tel);
			admin.setEmail(email);
			int count = dao.insertUser(admin);
			if (count > 0) {
				// 请求转发
				RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
				rd.forward(request, response);
			} else {
				request.setAttribute("msg", "添加失败");
				// 请求转发
				RequestDispatcher rd = request.getRequestDispatcher("insertAdmin.jsp");
				rd.forward(request, response);
			}
		} else {
			request.setAttribute("msg", "两次密码不一致");
			// 请求转发
			RequestDispatcher rd = request.getRequestDispatcher("insertAdmin.jsp");
			rd.forward(request, response);
		}
	}

}
