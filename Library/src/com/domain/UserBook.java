package com.domain;

/**
 *  用户借阅图书登记的信息，类似购物车
 * @author ASUS
 *
 */
import java.sql.Date;

public class UserBook {

     private int id;//编号
     private Book book;//图书
     private BaseReader user;//借阅人
     private int state;//图书借阅状态
     private Date borrowTime;//图书借阅时间
     private Date recieveTime;//图书归还时间
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Book getBook() {
		return book;
	}
	public void setBook(Book book) {
		this.book = book;
	}
	public BaseReader getUser() {
		return user;
	}
	public void setUser(BaseReader user) {
		this.user = user;
	}
	public int getState() {
		return state;
	}
	public void setState(int state) {
		this.state = state;
	}
	public Date getBorrowTime() {
		return borrowTime;
	}
	public void setBorrowTime(Date borrowTime) {
		this.borrowTime = borrowTime;
	}
	public Date getRecieveTime() {
		return recieveTime;
	}
	public void setRecieveTime(Date recieveTime) {
		this.recieveTime = recieveTime;
	}
     
}
