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

@WebServlet("/updateUser.action")
public class EditUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		response.setCharacterEncoding("utf-8");
		
		int sex = Integer.parseInt(request.getParameter("sex"));
		String email = request.getParameter("email");
		String mobile = request.getParameter("mobile");
		String userName=request.getParameter("username");
		int id = Integer.parseInt(request.getParameter("id"));
		
			BaseReader user = new BaseReader();
			user.setId(id);
			user.setUserName(userName);
			user.setSex(sex);
			user.setEmail(email);
			user.setMobile(mobile);
			UserDao dao = new UserDao();
			Gson gson=new Gson();
			Map<String, Object> map=new HashMap<String, Object>();
			
			int count = dao.updateUser(user);
			if (count > 0) {
				// 请求转发
				map.put("result",1);
			} else {
				map.put("result", 0);
			}
		String string=gson.toJson(map);
		PrintWriter pWriter=response.getWriter();
		pWriter.print(string);
		pWriter.flush();
		pWriter.close();
	}

}
