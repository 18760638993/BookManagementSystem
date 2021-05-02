package com.servlet;

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
import com.dao.BookcaseDao;
import com.google.gson.Gson;

@WebServlet("/delBookCase.action")
public class DeleteBookcaseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private BookDao bookDao = new BookDao();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/json;charset=utf-8");
		response.setCharacterEncoding("utf-8");
		String bookcaseId = request.getParameter("id");
		int id = Integer.parseInt(bookcaseId);
		BookcaseDao dao = new BookcaseDao();
		int count = dao.delBookcaseById(id);
		Map<String, Object> map = new HashMap<String, Object>();
		if (bookDao.getBookByCase(id) == 0) {
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
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
