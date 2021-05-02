package com.domain;
/**
 *  图书信息
 * @author ASUS
 *
 */
public class Book {

	
	private Integer bid;//图书编号
	private String bookname;//图书名称
	private String author;//图书作者
	private Integer bookTypeId;//图书归属书架类型的id号
	private Integer bookCaseId;//图书归属书架名称的id号
	private Integer bookState;//图书当前状态，用于管理图书
	private String bookType;//图书类型
	private String bookCase;//图书种类
	private String url;//图书的图片地址
	public Integer getBid() {
		return bid;
	}
	public void setBid(Integer bid) {
		this.bid = bid;
	}
	public String getBookname() {
		return bookname;
	}
	public void setBookname(String bookname) {
		this.bookname = bookname;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public Integer getBookTypeId() {
		return bookTypeId;
	}
	public void setBookTypeId(Integer bookTypeId) {
		this.bookTypeId = bookTypeId;
	}
	public Integer getBookCaseId() {
		return bookCaseId;
	}
	public void setBookCaseId(Integer bookCaseId) {
		this.bookCaseId = bookCaseId;
	}
	public Integer getBookState() {
		return bookState;
	}
	public void setBookState(Integer bookState) {
		this.bookState = bookState;
	}
	public String getBookType() {
		return bookType;
	}
	public void setBookType(String bookType) {
		this.bookType = bookType;
	}
	public String getBookCase() {
		return bookCase;
	}
	public void setBookCase(String bookCase) {
		this.bookCase = bookCase;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	
	
	
	
}
