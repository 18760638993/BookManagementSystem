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

@WebServlet("/updateBookType.action")
public class EditBooktypeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private BookTypeDao typeDao = new BookTypeDao();

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
		String booktype = request.getParameter("name");

		String bookcaseId = request.getParameter("id");
		int id = Integer.parseInt(bookcaseId);
		Type type = new Type();
		type.setId(id);
		type.setName(booktype);

		Gson gson = new Gson();
		Map<String, Object> map = new HashMap<String, Object>();
		int count = typeDao.updateType(type);
		if (count > 0) {
			// 请求转发
			map.put("result", 1);
		} else {
			map.put("result", 0);
		}
		String string = gson.toJson(map);
		PrintWriter pWriter = response.getWriter();
		pWriter.print(string);
		pWriter.flush();
		pWriter.close();

	}

}
