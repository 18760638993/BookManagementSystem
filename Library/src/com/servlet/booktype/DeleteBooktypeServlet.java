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

import com.dao.BookDao;
import com.dao.BookTypeDao;
import com.google.gson.Gson;

@WebServlet("/delBookType.action")
public class DeleteBooktypeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private BookTypeDao typeDao = new BookTypeDao();
	private BookDao bookDao = new BookDao();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/json;charset=utf-8");
		response.setCharacterEncoding("utf-8");
		String booktypeId = request.getParameter("id");
		int id = Integer.parseInt(booktypeId);

		int count = typeDao.deleteType(id);
		Map<String, Object> map = new HashMap<String, Object>();
		if (bookDao.getCount(id) == 0) {
			if (count > 0) {
				map.put("result", 1);
			} else {
				map.put("result", 0);
			}
		} else {
			map.put("result", 2);
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
