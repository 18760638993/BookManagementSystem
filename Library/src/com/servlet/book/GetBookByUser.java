package com.servlet.book;

import java.io.IOException;

import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.BookDao;
import com.domain.PageBean;
import com.domain.UserBook;

@WebServlet("/getbookbyuserid.action")
public class GetBookByUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private BookDao bookDao = new BookDao();

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");
		Integer userid = Integer.parseInt(request.getParameter("userid"));
		String pageString = request.getParameter("pageIndex");
		Integer page = 1;
		if (pageString != null) {
			page = Integer.parseInt(pageString);
		}
		String stateString = request.getParameter("state");
		Integer state = 2;
		if (stateString != null) {
			state = Integer.parseInt(stateString);
		}
		System.out.println(userid);
		List<UserBook> userbooks = bookDao.getUserBook(userid, page - 1, state);
		System.out.println(userbooks);
		PageBean<UserBook> pageBean = new PageBean<UserBook>();
		pageBean.setLimit(5);
		pageBean.setList(userbooks);

		pageBean.setPage(page);
		int totalCount = bookDao.getCountByUserid(userid);
		pageBean.setTotalCount(totalCount);
		pageBean.setTotalPage((totalCount + 5) / 5);
		request.setAttribute("bookstate", state);
		request.setAttribute("pageBean", pageBean);
		request.getRequestDispatcher("mybook.jsp").forward(request, response);
	}

}
