package com.servlet.book;


import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.BookDao;
import com.domain.Book;
import com.domain.PageBean;
import com.google.gson.Gson;

@WebServlet("/getAllBook.action")
public class GetAllBookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private BookDao bookDao=new BookDao();

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/json;charset=utf-8");
        System.out.println("mie:"+request.getParameter("typeid"));
		Integer typeid=Integer.parseInt(request.getParameter("typeid"));
		Integer pageIndex=null;
		if(request.getParameter("pageIndex")==null||Integer.parseInt(request.getParameter("pageIndex"))==0) {
			pageIndex=1;
		}else {
			pageIndex=Integer.parseInt(request.getParameter("pageIndex"));
		}
		
		
		List<Book> books=bookDao.findAllBook(typeid,pageIndex-1);
		PageBean<Book> pageBean=new PageBean<Book>();
		pageBean.setPage(pageIndex);
		pageBean.setList(books);
		int totalCount=bookDao.getCount(typeid);
		pageBean.setTotalCount(totalCount);
		int limit=6;
		pageBean.setLimit(limit);
		if(totalCount==0) {
			pageBean.setPage(0);
		}
		pageBean.setTotalPage((totalCount+limit-1)/limit);
		
		Gson gson=new Gson();
		String string=gson.toJson(pageBean);
		PrintWriter pWriter=response.getWriter();
		pWriter.print(string);
		pWriter.flush();
		pWriter.close();
	}

}
