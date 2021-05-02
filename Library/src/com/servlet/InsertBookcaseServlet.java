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

import com.dao.BookcaseDao;
import com.domain.BookCase;
import com.google.gson.Gson;

/**
 * 添加书架信息
 */
@WebServlet("/addCase.action")
public class InsertBookcaseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");
		response.setContentType("text/json;charset=utf-8");
		response.setCharacterEncoding("utf-8");
		// 获取页面输入的内容
		String bookcase = request.getParameter("bookcase");
		int bookTypeId = Integer.parseInt(request.getParameter("bookType"));
		BookcaseDao dao = new BookcaseDao();
		BookCase bkcase = new BookCase();
		bkcase.setBookcase(bookcase);
		bkcase.setBookTypeId(bookTypeId);
		int count = dao.insertBookcase(bkcase);
		Gson gson = new Gson();
		Map<String, Object> map = new HashMap<String, Object>();

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