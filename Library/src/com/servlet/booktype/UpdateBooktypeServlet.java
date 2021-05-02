package com.servlet.booktype;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.BookTypeDao;
import com.domain.Type;

@WebServlet("/getBookTypeById.action")
public class UpdateBooktypeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		response.setCharacterEncoding("utf-8");
		// 获取按钮传递的bookcaseId，url地址？之后的参数名
		// getParameter()返回类型是String
		String bookcaseId = request.getParameter("id");
		// 数据库Id字段是整数，要强制转换
		int id = Integer.parseInt(bookcaseId);// 强制转换：字符串--->整型
		BookTypeDao bookTypeDao = new BookTypeDao();
		Type type = bookTypeDao.getTypeById(id);
		// 往前台传输数据
		request.setAttribute("booktype", type);
		// 请求转发
		RequestDispatcher rd = request.getRequestDispatcher("updateType.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
