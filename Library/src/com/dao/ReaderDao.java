package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.domain.BaseReader;
import com.util.DBUtils;

public class ReaderDao {

	DBUtils dbUtils = new DBUtils();
	
	public BaseReader checkLogin(String readerName,String pwd) {
		BaseReader user = null;
		Connection connection = null;
		PreparedStatement pstm = null;
		ResultSet rsSet = null;
	
		
		try {
			
			connection = dbUtils.getConn();
			//创建SQL命令
			String sql = "select id,username,password,sex,mobile,email,usertype from tb_reader where readerName = ? and password = ?";
			Object obj[]= {readerName,pwd};
			rsSet = dbUtils.query(sql, obj);
			while (rsSet.next()) {
				user = new BaseReader();
				user.setId(rsSet.getInt(1));
				user.setUserName(readerName);
				user.setPassword(pwd);
				user.setSex(rsSet.getInt(4));
				user.setEmail(rsSet.getString(5));				
				user.setUserType(rsSet.getInt(6));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			//关闭所有资源
			dbUtils.closeAll(connection, pstm, rsSet);
		}
		return user;
	}
	
	/**
	 * 查询所有用户
	 */
	public List<BaseReader> findAllUser(){
		List<BaseReader> list = new ArrayList<BaseReader>();
		//获取数据库连接
		dbUtils.getConn();
		String sql = "select * from tb_reader";
		Object obj[] = {};
		ResultSet rSet = dbUtils.query(sql, obj);
		try {
			while(rSet.next()) {
				BaseReader user = new BaseReader();
				
				user.setUserName(rSet.getString("readerName"));
				user.setSex(rSet.getInt("sex"));
				user.setMobile(rSet.getString("mobile"));
				user.setEmail(rSet.getString("email"));
				user.setId(rSet.getInt("id"));
				user.setUserType(rSet.getInt("userType"));
				list.add(user);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	public int registUser(BaseReader user) {
		// TODO Auto-generated method stub
		return 0;
	}
}
