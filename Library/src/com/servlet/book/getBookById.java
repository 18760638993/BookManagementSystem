package com.servlet.book;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.BookDao;
import com.domain.Book;

@WebServlet("/getBookById.action")
public class getBookById extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private BookDao bookDao = new BookDao();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		Integer id = Integer.parseInt(request.getParameter("id"));
		Book book = bookDao.getBookBy(id);
		request.setAttribute("book", book);
		System.out.println(book);
		request.getRequestDispatcher("updateBook.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
