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

@WebServlet("/updateBookCase.action")
public class EditBookcaseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
     
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see post方法
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		response.setCharacterEncoding("utf-8");
		String bookcase = request.getParameter("bookcase");
		String booktype = request.getParameter("bookType");
		String  bookcaseId = request.getParameter("id");
		int id = Integer.parseInt(bookcaseId);
			BookCase bkcase = new BookCase();
			bkcase.setId(id);
			bkcase.setBookcase(bookcase);
			bkcase.setBookTypeId(Integer.parseInt(booktype));
			BookcaseDao dao = new BookcaseDao();
			int count = dao.updateBookcase(bkcase);
			Gson gson=new Gson();
			Map<String, Object> map=new HashMap<String, Object>();
			
			if(count>0) {
				//请求转发
				map.put("result",1);
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
