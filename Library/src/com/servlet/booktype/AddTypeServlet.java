package com.servlet.booktype;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.BookTypeDao;
import com.domain.Type;
import com.google.gson.Gson;

@WebServlet("/addType.action")
public class AddTypeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private BookTypeDao bookTypeDao = new BookTypeDao();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/json;charset=utf-8");
		response.setCharacterEncoding("utf-8");
		String name = request.getParameter("name");

		Type type = new Type();
		type.setName(name);

		Map<String, Object> map = new HashMap<String, Object>();

		if (bookTypeDao.addType(type) > 0) {
			map.put("result", 1);
		} else {
			map.put("result", 0);
		}

		Gson gson = new Gson();
		String string = gson.toJson(map);
		PrintWriter pWriter = response.getWriter();
		pWriter.print(string);
		pWriter.flush();
		pWriter.close();

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
