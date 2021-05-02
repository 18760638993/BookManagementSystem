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

@WebServlet("/delBook.action")
public class DeleteBook extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private BookDao bookDao=new BookDao();
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/json;charset=utf-8");
		int id=Integer.parseInt(request.getParameter("id"));
		
		int bookstate=Integer.parseInt(request.getParameter("bookstate"));
		
		Gson gson=new Gson();
		Map<String, Object> map=new HashMap<String, Object>();
		if(bookDao.changeState(id,bookstate)>0) {
			map.put("result", 1);
		}else {
			map.put("result", 0);
		}
		String string=gson.toJson(map);
		PrintWriter pWriter=response.getWriter();
		pWriter.print(string);
		pWriter.flush();
		pWriter.close();
	}

}
