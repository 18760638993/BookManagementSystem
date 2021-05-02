package com.servlet.user;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.UserDao;
import com.domain.BaseReader;
import com.domain.PageBean;
import com.google.gson.Gson;

@WebServlet("/UserServlet")
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/json;charset=utf-8");
		response.setCharacterEncoding("utf-8");
		int id = Integer.parseInt(request.getParameter("id"));
		Integer pageIndex = null;
		if (request.getParameter("pageIndex") == null || Integer.parseInt(request.getParameter("pageIndex")) == 0) {
			pageIndex = 1;
		} else {
			pageIndex = Integer.parseInt(request.getParameter("pageIndex"));
		}
		UserDao dao = new UserDao();
		// 去DB查询所有的数据
		List<BaseReader> list = dao.findAllUser(pageIndex - 1, id);
		PageBean<BaseReader> pageBean = new PageBean<BaseReader>();
		int limit = 5;
		pageBean.setLimit(limit);
		pageBean.setList(list);
		int totalPage = dao.getCount();
		pageBean.setTotalCount(totalPage);
		pageBean.setPage(pageIndex);
		pageBean.setTotalPage((totalPage + limit - 1) / limit);
		Gson gson = new Gson();
		String string = gson.toJson(pageBean);
		PrintWriter printWriter = response.getWriter();
		printWriter.print(string);
		printWriter.flush();
		printWriter.close();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
