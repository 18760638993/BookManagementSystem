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

@WebServlet("/getbookbyuser.action")
public class GetUserBookByUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private BookDao bookDao = new BookDao();

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

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

		List<UserBook> userbooks = bookDao.getUserBook(userid, page - 1, state);
		PageBean<UserBook> pageBean = new PageBean<UserBook>();
		pageBean.setLimit(5);
		pageBean.setList(userbooks);

		pageBean.setPage(page);
		int totalCount = bookDao.getCountByUserid(userid);
		pageBean.setTotalCount(totalCount);
		pageBean.setTotalPage((totalCount + 5) / 5);

		request.setAttribute("state", state);
		request.setAttribute("page", pageBean);
		request.getRequestDispatcher("userBookInfo.jsp").forward(request, response);
	}

}
