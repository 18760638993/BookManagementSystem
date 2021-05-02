package com.servlet.booktype;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.BookTypeDao;
import com.domain.Type;
import com.google.gson.Gson;

@WebServlet("/getAllType.action")
public class getAllType extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private BookTypeDao typeDao = new BookTypeDao();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/json;charset=utf-8");
		List<Type> types = typeDao.getAllType();
		Gson gson = new Gson();
		String string = gson.toJson(types);

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
