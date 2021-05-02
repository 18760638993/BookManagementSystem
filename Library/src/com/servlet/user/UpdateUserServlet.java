package com.servlet.user;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.UserDao;
import com.domain.BaseReader;

@WebServlet("/getmyInfo")
public class UpdateUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		response.setCharacterEncoding("utf-8");
		// 获取按钮传递的userId，url地址？之后的参数名
		// getParameter()返回类型是String
		String userId = request.getParameter("userid");
		// 数据库Id字段是整数，要强制转换
		int id = Integer.parseInt(userId);// 强制转换：字符串--->整型
		UserDao dao = new UserDao();
		BaseReader user = dao.findUserById(id);
		// 往前台传输数据
		request.setAttribute("user", user);
		// 请求转发
		RequestDispatcher rd = request.getRequestDispatcher("behindMyInfo.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
