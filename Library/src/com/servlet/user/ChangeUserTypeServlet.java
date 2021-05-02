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

@WebServlet("/changeUserType.action")
public class ChangeUserTypeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private UserDao userDao=new UserDao();

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int userid=Integer.parseInt(request.getParameter("id"));
		Integer userType=Integer.parseInt(request.getParameter("userType"));
		response.setContentType("text/json;charset=utf-8");
		BaseReader user=new BaseReader();
		user.setId(userid);
		user.setUserType(userType);
		Map<String, Object> map=new HashMap<String, Object>();
		
		if(userDao.changeUserType(user)>0) {
			map.put("result", 1);
		}else {
			map.put("result", 0);
		}
		Gson gson=new Gson();
		String string=gson.toJson(map);
		PrintWriter pWriter=response.getWriter();
		pWriter.print(string);
		pWriter.flush();
		pWriter.close();
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
