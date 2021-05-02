package com.dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.domain.BaseReader;
import com.util.DBUtils;


public class UserDao {

	DBUtils dbUtils = new DBUtils();
	//三个对象是全局变量
	Connection connection = null;
	PreparedStatement pstm = null;
	ResultSet rsSet = null;
	//验证登录
	public BaseReader checkLogin(String userName,String pwd) {
		BaseReader user = null;
		
		//创建类的对象
		
		try {
			//类名.方法名
			connection = dbUtils.getConn();
			//3.创建PreparedStatement对象，参数使用？作为占位符
			String sql = "select * from tb_user where username = ? and password = ?";
			Object obj[]= {userName,pwd};
			rsSet = dbUtils.query(sql, obj);
			if (rsSet.next()) {
				user = new BaseReader();
				
				int sex = rsSet.getInt("sex");
				String tel = rsSet.getString("mobile");
				user.setUserName(userName);
				user.setPassword(pwd);
				user.setSex(sex);
				user.setMobile(tel);
				user.setEmail(rsSet.getString("email"));
				user.setUserState(rsSet.getInt("userState"));
				user.setId(rsSet.getInt("id"));
				user.setUserType(rsSet.getInt("usertype"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			//关闭程序：由内到外：结果集-->preparedstatement-->connection
			dbUtils.closeAll(connection, pstm, rsSet);
		}
		return user;
	}
	//新增用户
	/**
	 * 查询数据库所有的用户
	 * @param pageIndex 
	 * @param id 
	 */
	public List<BaseReader> findAllUser(int pageIndex, int id){
		List<BaseReader> list = new ArrayList<BaseReader>();
		//连接数据库
		connection = dbUtils.getConn();
		String sql = "select * from tb_user where id not in (1,?) limit "+5*pageIndex+",5 ";
		Object obj[] = {id};
		ResultSet rSet = dbUtils.query(sql, obj);
		try {
			while(rSet.next()) {
				BaseReader user = new BaseReader();
				
				int sex = rSet.getInt("sex");
				String tel = rSet.getString("mobile");
				user.setUserName(rSet.getString("username"));
				user.setSex(sex);
				user.setMobile(tel);
				user.setUserType(rSet.getInt("usertype"));
				user.setEmail(rSet.getString("email"));
				user.setUserState(rSet.getInt("userState"));
				user.setId(rSet.getInt("id"));
				list.add(user);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			dbUtils.closeAll(connection, pstm, rSet);
		}
		return list;
	}

	
	//注册用户
	public int registUser(BaseReader user) {
		int count=0;
		connection = dbUtils.getConn();
		String sql = "insert into tb_user (username,password,sex,mobile,email,usertype) value(?,?,?,?,?,?)";
		Object obj[]= {user.getUserName(),user.getPassword(),user.getSex(),user.getMobile(),user.getEmail(),user.getUserType()};
		count = dbUtils.editSql(sql, obj);
		dbUtils.closeAll(connection, null, null);
		return count;
	}
	/**
	 * 修改用户信息
	 */
	public int updateUser(BaseReader user) {
		int count=0;
		connection = dbUtils.getConn();
		String sql = "update tb_user set username=?,sex=?,mobile=?,email=? where id=?";
		Object obj[]= {user.getUserName(),user.getSex(),user.getMobile(),user.getEmail(),user.getId()};
		count = dbUtils.editSql(sql, obj);
		dbUtils.closeAll(connection, null, null);
		return count;
	}
    /**
     * 通过用户Id获取用户所有信息，返回BaseReader实体类，实体类的get/set方法可以传输数据
     * */
	public BaseReader findUserById(int id) {
		//连接数据库
		connection = dbUtils.getConn();
		String sql = "select * from tb_user where id=?";
		Object obj[]= {id};
		ResultSet rSet = dbUtils.query(sql, obj);
		BaseReader user = new BaseReader();
		try {
			if(rSet.next()) {
				int sex = rSet.getInt("sex");
				String tel = rSet.getString("mobile");
				//BaseReader里面的set的数据：页面所需和id
				user.setUserName(rSet.getString("username"));
				user.setPassword(rSet.getString("password"));
				user.setSex(sex);
				user.setMobile(tel);
				user.setUserType(rSet.getInt("usertype"));
				user.setEmail(rSet.getString("email"));
				user.setId(rSet.getInt("id"));//id后面还要做更新使用
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			dbUtils.closeAll(connection, pstm, rSet);
		}
		return user;
	
	}
	/**
	 * 通过id删除某个用户
	 */
	public int delUserById(int id) {
		int count=0;
		connection=dbUtils.getConn();
		String sql="delete from tb_user where id=?";
		Object obj[]= {id};
		count=dbUtils.editSql(sql, obj);
		dbUtils.closeAll(connection, null, null);
		return count;
	}
	public int getCount() {
		// TODO Auto-generated method stub
		 connection=dbUtils.getConn();
		String sql="select count(*) from tb_user";
		
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
		dbUtils.closeAll(connection, pstm, rsSet);
		
		return rs;
	}
	public int changeState(BaseReader user) {
		int count=0;
		connection = dbUtils.getConn();
		String sql = "update tb_user set userState=? where id=?";
		Object obj[]= {user.getUserState(),user.getId()};
		count = dbUtils.editSql(sql, obj);
		dbUtils.closeAll(connection, null, null);
		return count;
	}
	public int changeUserType(BaseReader user) {
		// TODO Auto-generated method stub
		int count=0;
		connection = dbUtils.getConn();
		String sql = "update tb_user set userType=? where id=?";
		Object obj[]= {user.getUserType(),user.getId()};
		count = dbUtils.editSql(sql, obj);
		dbUtils.closeAll(connection, null, null);
		return count;
	}
	public int checkUser(String username) {
		// TODO Auto-generated method stub
		int count=0;
		connection = dbUtils.getConn();
		String sql="select count(*) from tb_user where username=?";
		Object[] obj= {username};
		 rsSet=dbUtils.query(sql, obj);
		
		try {
			while(rsSet.next()) {
				try {
					count=rsSet.getInt(1);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		dbUtils.closeAll(connection, pstm, rsSet);
		
		return count;
	}
}
