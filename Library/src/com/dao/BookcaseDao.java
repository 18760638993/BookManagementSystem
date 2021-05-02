package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.domain.BookCase;
import com.util.DBUtils;

public class BookcaseDao {

		DBUtils dbUtils = new DBUtils();
		//三个对象是全局变量
		Connection connection = null;
		PreparedStatement pstm = null;
		ResultSet rsSet = null;
		
	public List<BookCase> findAllBookcase(Integer typeid) {
		List<BookCase> list = new ArrayList<BookCase>();
		//连接数据库
		connection = dbUtils.getConn();
		String sql=null;
		List<Object> list2=new ArrayList<Object>();
		if(typeid==0) {
			sql = "select c.id,c.bookcase,c.booktype,t.name from tb_bookcase c,tb_type t where c.booktype=t.id";
			
		}else {
			sql = "select c.id,c.bookcase,c.booktype,t.name from tb_bookcase c,tb_type t where c.booktype=t.id and c.booktype=?";
			list2.add(typeid);
		}
		Object[] obj=list2.toArray();
		
		 rsSet = dbUtils.query(sql, obj);
		try {
			while(rsSet.next()) {
				BookCase bkcase = new BookCase();
				String bookcase = rsSet.getString(2);
				
				bkcase.setBookcase(bookcase);
				bkcase.setBookTypeId(rsSet.getInt(3));
				bkcase.setBookType(rsSet.getString(4));
				bkcase.setId(rsSet.getInt(1));
				list.add(bkcase);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			dbUtils.closeAll(connection, pstm, rsSet);
		}
		return list;
	}
	/**
	 * @param 添加书架
	 */
	public int insertBookcase(BookCase bkcase) {
		int count=0;
		connection = dbUtils.getConn();
		String sql = "insert into tb_bookcase (bookcase,booktype) values(?,?)";
		Object obj[]= {bkcase.getBookcase(),bkcase.getBookTypeId()};
		count = dbUtils.editSql(sql, obj);
		dbUtils.closeAll(connection, null, null);
		return count;
	}
	/**
	 * @param 修改书架信息
	 */
	public int updateBookcase(BookCase bkcase) {
		int count=0;
		connection = dbUtils.getConn();
		String sql = "update tb_bookcase set bookcase=?,booktype=? where id=?";
		Object obj[]= {bkcase.getBookcase(),bkcase.getBookTypeId(),bkcase.getId()};
		count = dbUtils.editSql(sql, obj);
		dbUtils.closeAll(connection, null, null);
		return count;
	}
	  /**
     * 通过用户Id获取用户所有信息，返回BookCase实体类，实体类的get/set方法可以传输数据
     * */
	public BookCase findBookcaseById(int id) {
		// 连接数据库
				connection = dbUtils.getConn();
				String sql = "select c.id,c.bookcase,c.booktype,t.name from tb_bookcase c,tb_type t where c.booktype=t.id and c.id=?";
				Object obj[] = {id};
			 rsSet = dbUtils.query(sql, obj);
				 BookCase bkcase = new BookCase();
				try {
					if (rsSet.next()) {
						// BookCase里面的set的数据：页面所需和id
						String bookcase = rsSet.getString(2);
						String booktype = rsSet.getString(4);
						bkcase.setBookcase(bookcase);
						bkcase.setBookType(booktype);
						bkcase.setBookTypeId(rsSet.getInt(3));
						bkcase.setId(rsSet.getInt(1));// id后面还要做更新使用
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} finally {
					dbUtils.closeAll(connection, pstm, rsSet);
				}
				return bkcase;
	}
	/**
	 * @param 删除书架
	 */
	public int delBookcaseById(int id) {
		int count=0;
		connection=dbUtils.getConn();
		String sql="delete from tb_bookcase where id=?";
		Object obj[]= {id};
		count=dbUtils.editSql(sql, obj);
		dbUtils.closeAll(connection, null, null);
		return count;
	}

}
