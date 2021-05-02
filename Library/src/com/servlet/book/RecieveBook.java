package com.servlet.book;

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
import com.google.gson.Gson;

@WebServlet("/recieveBook.action")
public class RecieveBook extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private BookDao bookDao = new BookDao();

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/json;charset=utf-8");
		int id = Integer.parseInt(request.getParameter("id"));
		int bookid = Integer.parseInt(request.getParameter("bookid"));
		Map<String, Object> map = new HashMap<String, Object>();
		Gson gson = new Gson();
		PrintWriter pWriter = response.getWriter();
		if (bookDao.deleteUserBook(id, bookid) > 0) {
			map.put("code", 1);
		} else {
			map.put("code", 0);
		}
		String string = gson.toJson(map);
		pWriter.print(string);
		pWriter.flush();
		pWriter.close();
	}

}
