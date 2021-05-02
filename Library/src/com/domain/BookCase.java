package com.domain;

import lombok.Data;
/**
 *  书架
 * @author ASUS
 *
 */
@Data
public class BookCase {

	private Integer id;//id号
	private String bookcase;//书架
	private Integer bookTypeId;//书架类型编号
	private String bookType;//书架类型名称
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getBookcase() {
		return bookcase;
	}
	public void setBookcase(String bookcase) {
		this.bookcase = bookcase;
	}
	public Integer getBookTypeId() {
		return bookTypeId;
	}
	public void setBookTypeId(Integer bookTypeId) {
		this.bookTypeId = bookTypeId;
	}
	public String getBookType() {
		return bookType;
	}
	public void setBookType(String bookType) {
		this.bookType = bookType;
	}
	
}
