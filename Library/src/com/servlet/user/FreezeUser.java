package com.servlet.user;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.UserDao;
import com.domain.BaseReader;
import com.google.gson.Gson;

@WebServlet("/freezeUser.action")
public class FreezeUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserDao userDao = new UserDao();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		Integer id = Integer.parseInt(request.getParameter("id"));
		Integer userState = Integer.parseInt(request.getParameter("userState"));
		BaseReader user = new BaseReader();
		user.setId(id);
		if (userState == 1) {
			userState = 0;
		} else {
			userState = 1;
		}
		user.setUserState(userState);
		response.setContentType("text/json,charset=utf-8");
		Map<String, Object> map = new HashMap<String, Object>();
		if (userDao.changeState(user) > 0) {
			map.put("result", 1);
		} else {
			map.put("result", 0);
		}
		Gson gson = new Gson();
		String string = gson.toJson(map);
		PrintWriter printWriter = response.getWriter();
		printWriter.print(string);
		printWriter.flush();
		printWriter.close();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
