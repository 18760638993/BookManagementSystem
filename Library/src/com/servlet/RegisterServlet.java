package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.UserDao;
import com.domain.BaseReader;
import com.google.gson.Gson;

/**
 * 注册
 */
@WebServlet("/register.action")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		System.out.println("register");
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/json;charset=utf-8");
		response.setCharacterEncoding("utf-8");
		// 获取页面输入的内容
		String username = request.getParameter("username");
		String pwd = request.getParameter("pwd");

		int sex = Integer.parseInt(request.getParameter("sex"));
		String tel = request.getParameter("mobile");
		String email = request.getParameter("email");

		UserDao dao = new UserDao();
		BaseReader user = new BaseReader();
		user.setUserName(username);
		user.setPassword(pwd);
		user.setSex(sex);
		user.setMobile(tel);
		user.setEmail(email);

		Gson gson = new Gson();
		Map<String, Object> map = new HashMap<String, Object>();
		if (dao.checkUser(username) == 0) {
			int count = dao.registUser(user);
			if (count > 0) {
				map.put("result", 1);
			} else {
				map.put("result", 0);
			}
		} else {
			map.put("result", 2);
		}
		String string = gson.toJson(map);
		PrintWriter pWriter = response.getWriter();
		pWriter.print(string);
		pWriter.flush();
		pWriter.close();

	}

}
