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
import com.domain.Book;
import com.google.gson.Gson;

@WebServlet("/addBook.action")
public class AddBook extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private BookDao bookDao=new BookDao();
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		response.setContentType("text/json;charset=utf-8");
		
		String bookName=request.getParameter("name");
		int bookTypeId=Integer.parseInt(request.getParameter("bookType"));
		int bookCaseId=Integer.parseInt(request.getParameter("bookCase"));
		String author=request.getParameter("author");
		String url=request.getParameter("url");
		System.out.println(url);
		Book book=new Book();
		book.setAuthor(author);
		book.setBookCaseId(bookCaseId);
		book.setBookname(bookName);
		book.setBookTypeId(bookTypeId);
		book.setUrl(url);
		Gson gson=new Gson();
		Map<String, Object> map=new HashMap<String, Object>();
		if(bookDao.addBook(book)>0) {
			map.put("result", 1);
		}else {
			map.put("result", 0);
		}
		String string=gson.toJson(map);
		System.out.println(string );
		PrintWriter pWriter=response.getWriter();
		pWriter.print(string);
		pWriter.flush();
		pWriter.close();
	}

}
