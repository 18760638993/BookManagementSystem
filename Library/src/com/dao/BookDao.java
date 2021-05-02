package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.domain.BaseReader;
import com.domain.Book;
import com.domain.UserBook;
import com.util.DBUtils;

public class BookDao {
	
	Connection conn = null;
	PreparedStatement pstm = null;
	ResultSet rsSet = null;
	DBUtils dbUtils=new DBUtils();
	public List<Book> findAllBook(Integer id,Integer pageIndex){
		List<Book> books = new ArrayList<Book>();
		//获取数据库连接
		conn=dbUtils.getConn();
		String sql=null;
		if(id>0) {
		 sql= "select b.bid,b.bookname,b.author,b.booktype,bookcase,b.bookstate,t.name,b.url from tb_book b,tb_type t where b.booktype=t.id and booktype=? and bookstate=1 limit "+6*pageIndex+",6 ";
		 Object obj[] = {id};
			rsSet = dbUtils.query(sql, obj);
		}else {
		 sql= "select  b.bid,b.bookname,b.author,b.booktype,bookcase,b.bookstate,t.name,b.url from tb_book b,tb_type t where b.booktype=t.id and bookstate=1 limit "+6*pageIndex+",6 ";
		
			rsSet = dbUtils.query(sql, null);
		}
		
		
		try {
			while(rsSet.next()) {
				Book book=new Book();
				book.setBid(rsSet.getInt(1));
				book.setBookname(rsSet.getString(2));
				book.setAuthor(rsSet.getString(3));
				book.setBookTypeId(rsSet.getInt(4));
				book.setBookCaseId(rsSet.getInt(5));
				book.setBookState(rsSet.getInt(6));
				book.setBookType(rsSet.getString(7));
				book.setUrl(rsSet.getString(8));
				books.add(book);	
				}
			dbUtils.closeAll(conn, pstm, rsSet);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return books;
	}
	
	public int  updateBook(Book book) {
		conn=dbUtils.getConn();
		String sql="update tb_book set bookname=?,booktype=?, bookcase=?,author=?,url=? where bid=? ";
		
		
		Object []obj= {book.getBookname(),book.getBookTypeId(),book.getBookCaseId(),book.getAuthor(),book.getUrl(),book.getBid()};
		int rs=dbUtils.editSql(sql, obj);
		dbUtils.closeAll(conn, pstm, rsSet);
		return rs;
	}
	public int addBook(Book book) {
		conn=dbUtils.getConn();
		String sql="insert into tb_book(bookname,booktype,bookcase,author,url) values(?,?,?,?,?)"  ;
		
		Object[] obj= {book.getBookname(),book.getBookTypeId(),book.getBookCaseId(),book.getAuthor(),book.getUrl()};
		int rs=dbUtils.editSql(sql, obj);
		dbUtils.closeAll(conn, pstm, rsSet);
		return rs;
		
	}
	public int deleteBook(int id) {
		conn=dbUtils.getConn();
		String sql="delete from tb_book where bid=?";
		Object[] obj= {id};
		int rs=dbUtils.editSql(sql, obj);
		dbUtils.closeAll(conn, pstm, rsSet);
		return rs;
	}
	public int addUserBook(int userid,int bookid) {
		conn=dbUtils.getConn();
		int result=0;
		try {
			conn.setAutoCommit(false);
			
			String sql="insert into t_userbook(user_id,book_id,borrowTime) values(?,?,?)";
			String sql2="update tb_book set bookstate=0 where bid=?";
			Object[] obj= {userid,bookid,new Date()};
			Object []obj2= {bookid};
			int rs=dbUtils.editSql(sql, obj);
			int rs1=dbUtils.editSql(sql2, obj2);
			if(rs>0&&rs1>0) {
				result=1;
				conn.commit();
			}
			
		} catch (SQLException e) {
			try {
				conn.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			e.printStackTrace();
		}
		
		dbUtils.closeAll(conn, pstm, rsSet);
		return result;
		
	}
	public int deleteUserBook(int id,int bookid) {
		conn=dbUtils.getConn();
		int result=0;
		try {
			conn.setAutoCommit(false);
			String sql="update t_userbook set state=0,recieveTime=? where id=?";
			String sql2="update tb_book set bookstate=1 where bid=?";
			Object [] obj= {new Date(),id};
			Object []obj2= {bookid};
			int rs=dbUtils.editSql(sql, obj);
			int rs1=dbUtils.editSql(sql2, obj2);
			if(rs==1&&rs1==1) {
				result=1;
				conn.commit();
			}
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			try {
				conn.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			e.printStackTrace();
		}
		dbUtils.closeAll(conn, pstm, rsSet);
		return result;
	}

	public int getCount(Integer typeid) {
		// TODO Auto-generated method stub
		conn=dbUtils.getConn();
		String sql=null;
		List<Object> list=new ArrayList<Object>();
		if(typeid==0) {
			sql="select count(*) from tb_book where bid not in(select book_id from t_userbook where state=1) ";
			
		}else {
			sql="select count(*) from tb_book where booktype=? and bid not in(select book_id from t_userbook where state=1)";
			list.add(typeid);
		}
		Object[] obj= list.toArray();
		 rsSet=dbUtils.query(sql, obj);
		int rs=0;
		try {
			while(rsSet.next()) {
				try {
					rs=rsSet.getInt(1);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		dbUtils.closeAll(conn, pstm, rsSet);
		
		return rs;
	}
	public List<UserBook> getUserBook(Integer userid, int pageIndex,Integer state){
		conn=dbUtils.getConn();
		String sql=null;
		List<Object> list=new ArrayList<Object>();
		if(state==2) {
			 sql="select ub.id,b.bid,b.bookname,b.author,t.name,ub.state,ub.borrowTime,ub.recieveTime from t_userbook ub ,tb_book b,tb_type t where  ub.book_id=b.bid and t.id=b.booktype and ub.book_id in (select book_id from t_userbook where user_id=?)  limit "+5*pageIndex+",5 ";
		       list.add(userid);
		}else {
			sql="select ub.id,b.bid,b.bookname,b.author,t.name,ub.state,ub.borrowTime,ub.recieveTime from t_userbook ub ,tb_book b,tb_type t where  ub.book_id=b.bid and t.id=b.booktype and ub.state=? and ub.book_id in (select book_id from t_userbook where user_id=?)  limit "+5*pageIndex+",5 ";
		     
			list.add(state);
			list.add(userid);
		}
		
		Object[] obj=list.toArray();
		ResultSet rsSet=dbUtils.query(sql, obj);
		List<UserBook> userbooks=new ArrayList<UserBook>();
		try {
			while(rsSet.next()) {
				UserBook userBook=new UserBook();
				userBook.setId(rsSet.getInt(1));
				Book book=new Book();
				book.setBid(rsSet.getInt(2));
				book.setBookname(rsSet.getString(3));
				book.setAuthor(rsSet.getString(4));
				book.setBookType(rsSet.getString(5));
				userBook.setState(rsSet.getInt(6));
				userBook.setBorrowTime(rsSet.getDate(7));
				userBook.setRecieveTime(rsSet.getDate(8));
				userBook.setBook(book);
				userbooks.add(userBook);	
				}
			dbUtils.closeAll(conn, pstm, rsSet);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return userbooks;
	}
	public List<UserBook> getAllUserBook(Integer pageIndex){
		conn=dbUtils.getConn();
		String sql= "select ub.id,u.username,b.bookname,b.author,ub.borrowTime,ub.recieveTime from t_userbook ub , tb_user u ,tb_book b  where  ub.book_id=u.id and ub.book_id=b.bid limit "+5*pageIndex+",5 " ;
		List<UserBook> userBooks=new ArrayList<UserBook>();
		rsSet=dbUtils.query(sql, null);
		try {
		while (rsSet.next()) {
			UserBook userBook=new UserBook();
			userBook.setId(rsSet.getInt(1));
			Book book=new Book();
			
		    book.setBid(rsSet.getInt(3));
			
			book.setAuthor(rsSet.getString(4));
			BaseReader user=new BaseReader();
			user.setUserName(rsSet.getString(2));
			userBook.setBook(book);
			userBook.setUser(user);
			userBooks.add(userBook);
			userBook.setBorrowTime(rsSet.getDate(5));
			userBook.setRecieveTime(rsSet.getDate(6));
		}
		dbUtils.closeAll(conn, pstm, rsSet);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		
		}
		return userBooks;
		
	}
	public int getUserBookCount() {
		// TODO Auto-generated method stub
		conn=dbUtils.getConn();
		String sql="select count(*) from t_userbook";
		
		 rsSet=dbUtils.query(sql, null);
		int rs=0;
		try {
			while(rsSet.next()) {
				try {
					rs=rsSet.getInt(1);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		dbUtils.closeAll(conn, pstm, rsSet);
		
		return rs;
	}

	public Book getBookBy(Integer id) {
		// TODO Auto-generated method stub
		conn=dbUtils.getConn();
		 String sql= "select  b.bid,b.bookname,b.author,b.booktype,b.bookcase,b.bookstate,t.name,c.bookcase,b.url from tb_book b,tb_type t ,tb_bookcase c where b.booktype=t.id and b.bookcase=c.id and b.bid=? ";
		 Object [] obj= {id};
		 rsSet=dbUtils.query(sql, obj);
		 Book book=new Book();
		 try {
			while(rsSet.next()) {
				 
				 book.setBid(rsSet.getInt(1));
				 book.setBookname(rsSet.getString(2));
				 book.setAuthor(rsSet.getString(3));
				 book.setBookTypeId(rsSet.getInt(4));
				 book.setBookCaseId(rsSet.getInt(5));
				 book.setBookState(rsSet.getInt(6));
				 book.setBookType(rsSet.getString(7));
				 book.setBookCase(rsSet.getString(8));
				 book.setUrl(rsSet.getString(9));
			 }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			dbUtils.closeAll(conn, pstm, rsSet);
		}
		 return book;
	}

	public int getBookByCase(int id) {
		// TODO Auto-generated method stub
		conn=dbUtils.getConn();
		String sql="select count(*) from tb_book where bookcase=?";
		 Object [] obj= {id};
		 int result=0;
		 rsSet=dbUtils.query(sql, obj);
		 try {
				while (rsSet.next()){
					result=rsSet.getInt(1);
					
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {
				dbUtils.closeAll(conn, pstm, rsSet);
			}
			 return result;
		
	}
	public int getCountByUserid(int userid) {
		conn=dbUtils.getConn();
		String sql="select count(*) from t_userbook where user_id=?";
		Object [] obj= {userid};
		int result=0;
		 rsSet=dbUtils.query(sql, obj);
		 try {
				while (rsSet.next()){
					result=rsSet.getInt(1);
					
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {
				dbUtils.closeAll(conn, pstm, rsSet);
			}
			 return result;
	}

	public List<Book> findAllBooks(Integer typeid, int pageIndex) {
		// TODO Auto-generated method stub
		conn=dbUtils.getConn();
		String sql=null;
		if(typeid>0) {
		 sql= "select b.bid,b.bookname,b.author,b.booktype,bookcase,b.bookstate,t.name,b.url from tb_book b,tb_type t where b.booktype=t.id and booktype=? and b.bid not in(select book_id from t_userbook where state=1)   limit "+6*pageIndex+",6 ";
		 Object obj[] = {typeid};
			rsSet = dbUtils.query(sql, obj);
		}else {
		 sql= "select  b.bid,b.bookname,b.author,b.booktype,bookcase,b.bookstate,t.name,b.url from tb_book b,tb_type t where b.booktype=t.id and b.bid not in(select book_id from t_userbook where state=1) limit "+6*pageIndex+",6 ";
		
			rsSet = dbUtils.query(sql, null);
		}
		
		List<Book> books=new ArrayList<Book>();
		try {
			while(rsSet.next()) {
				Book book=new Book();
				book.setBid(rsSet.getInt(1));
				book.setBookname(rsSet.getString(2));
				book.setAuthor(rsSet.getString(3));
				book.setBookTypeId(rsSet.getInt(4));
				book.setBookCaseId(rsSet.getInt(5));
				book.setBookState(rsSet.getInt(6));
				book.setBookType(rsSet.getString(7));
				book.setUrl(rsSet.getString(8));
				books.add(book);	
				}
			dbUtils.closeAll(conn, pstm, rsSet);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return books;
	}

	public int changeState(int id,int bookstate) {
		// TODO Auto-generated method stub
		conn=dbUtils.getConn();
		String sql="update tb_book set bookstate=? where bid=?";
		Object [] obj= {bookstate,id};
		int count=dbUtils.editSql(sql, obj);
		dbUtils.closeAll(conn, pstm, null);
		return count;
	}
}
