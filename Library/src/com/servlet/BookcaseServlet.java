package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.BookcaseDao;
import com.domain.BookCase;
import com.google.gson.Gson;

@WebServlet("/getBookCase.action")
public class BookcaseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
    public BookcaseServlet() {
        super();
      
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/json;charset=utf-8");
		response.setCharacterEncoding("utf-8");
		BookcaseDao dao = new BookcaseDao();
		String typeidString=request.getParameter("typeid");
		int typeid=0;
		//去DB查询所有的数据
		if(typeidString!=null) {
			typeid=Integer.parseInt(typeidString);
		}
		List<BookCase> list = dao.findAllBookcase(typeid);
		Gson gson=new Gson();
		String string=gson.toJson(list);
		PrintWriter printWriter=response.getWriter();
		printWriter.print(string);
		printWriter.flush();
		printWriter.close();
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
