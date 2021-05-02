package com.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.domain.Type;
import com.mysql.jdbc.PreparedStatement;
import com.util.DBUtils;

public class BookTypeDao {

	DBUtils dbUtils=new DBUtils();
	Connection conn=null;
	PreparedStatement ps=null;
	ResultSet reSet=null;
    
	public List<Type> getAllType(){
		String sql="select id,name from tb_type";
		conn=dbUtils.getConn();
		reSet=dbUtils.query(sql, null);
		List<Type> types=new ArrayList<Type>();
		try {
			while(reSet.next()) {
				Type type=new Type();
				type.setId(reSet.getInt(1));
				type.setName(reSet.getString(2));
				types.add(type);
			}
			dbUtils.closeAll(conn, ps, reSet);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return types;
	}
	public Type getTypeById(Integer id) {
		String sql="select id,name from tb_type where id=?";
		Object obj[]= {id};
		conn=dbUtils.getConn();
		reSet=dbUtils.query(sql, obj);
		
		
		Type type=new Type();
		try {
			while(reSet.next()) {
				
				type.setId(reSet.getInt(1));
				type.setName(reSet.getString(2));
				
			}
			dbUtils.closeAll(conn, ps, reSet);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return type;
		
	}
	public int updateType(Type type) {
		String sql="update tb_type set name=?  where id=?";
		Object obj[]= {type.getName(),type.getId()};
		conn=dbUtils.getConn();
		int count=dbUtils.editSql(sql, obj);
		dbUtils.closeAll(conn, null, null);
		return count;
		
		
		
		
	}
	public int deleteType(Integer id) {
		String sql="delete from tb_type where id=?";
		Object obj[]= {id};
		conn=dbUtils.getConn();
		int count =dbUtils.editSql(sql, obj);
		dbUtils.closeAll(conn, null, null);
		return count;
		
	}
	public int addType(Type type) {
		// TODO Auto-generated method stub
		conn=dbUtils.getConn();
		String sql="insert into tb_type(name) values(?)";
		Object[] obj= {type.getName()};
		int count=dbUtils.editSql(sql, obj);
		dbUtils.closeAll(conn, null, null);
		return count;
	}
	
}
