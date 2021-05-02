package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.domain.Admin;
import com.util.DBUtils;

public class AdminDao {

	DBUtils dbUtils = new DBUtils();
	//三个对象是全局变量
	Connection connection = null;
	PreparedStatement pstm = null;
	ResultSet rsSet = null;
	//验证登录
	public Admin checkLogin(String adminName,String pwd) {
		Admin admin = null;
		
		//创建类的对象
		
		try {
			//类名.方法名
			connection = dbUtils.getConn();
			//3.创建PreparedStatement对象，参数使用？作为占位符
			String sql = "select * from tb_manager where adminname = ? and pwd = ?";
			Object obj[]= {adminName,pwd};
			rsSet = dbUtils.query(sql, obj);
			if (rsSet.next()) {
				admin = new Admin();
				int sex = rsSet.getInt("sex");
				String tel = rsSet.getString("mobile");
				admin.setUserName(adminName);
				admin.setPwd(pwd);
				admin.setSex(sex);
				admin.setMobile(tel);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			//关闭程序：由内到外：结果集-->preparedstatement-->connection
			dbUtils.closeAll(connection, pstm, rsSet);
		}
		return admin;
	}
	/**
	 * 查询数据库所有的管理员
	 */
	public List<Admin> findAllAdmin() {
		List<Admin> list = new ArrayList<Admin>();
		//连接数据库
		connection = dbUtils.getConn();
		String sql = "select * from tb_manager";
		Object obj[] = {};
		ResultSet rSet = dbUtils.query(sql, obj);
		try {
			while(rSet.next()) {
				Admin admin = new Admin();
				int sex = rSet.getInt("sex");
				String tel = rSet.getString("mobile");
				admin.setUserName(rSet.getString("adminname"));
				admin.setSex(sex);
				admin.setMobile(tel);
				admin.setEmail(rSet.getString("email"));
				admin.setId(rSet.getInt("id"));
				list.add(admin);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			dbUtils.closeAll(connection, pstm, rSet);
		}
		return list;
	}
	/**
	 * 添加管理员
	 */
	public int insertUser(Admin admin) {
		int count=0;
		connection = dbUtils.getConn();
		String sql = "insert into tb_manager (adminname,pwd,sex,mobile,email) values(?,?,?,?,?)";
		Object obj[]= {admin.getUserName(),admin.getPwd(),admin.getSex(),admin.getMobile(),admin.getEmail()};
		count = dbUtils.editSql(sql, obj);
		dbUtils.closeAll(connection, null, null);
		return count;
	}
	
	public int updateAdmin(Admin admin) {
		int count=0;
		connection = dbUtils.getConn();
		String sql = "update tb_manager set pwd=?,sex=?,mobile=?,email=? where id=?";
		Object obj[]= {admin.getPwd(),admin.getSex(),admin.getMobile(),admin.getEmail(),admin.getId()};
		count = dbUtils.editSql(sql, obj);
		dbUtils.closeAll(connection, null, null);
		return count;
	}
    /**
     * 通过用户Id获取用户所有信息，返回BaseAdmin实体类，实体类的get/set方法可以传输数据
     * */
	public Admin findAdminById(int id) {
		// 连接数据库
		connection = dbUtils.getConn();
		String sql = "select * from tb_manager where id=?";
		Object obj[] = { id };
		ResultSet rSet = dbUtils.query(sql, obj);
		Admin admin = new Admin();
		try {
			if (rSet.next()) {
				int sex = rSet.getInt("sex");
				String tel = rSet.getString("mobile");
				// Baseuser里面的set的数据：页面所需和id
				admin.setUserName(rSet.getString("adminname"));
				admin.setPwd(rSet.getString("pwd"));
				admin.setSex(sex);
				admin.setMobile(tel);
				admin.setEmail(rSet.getString("email"));
				admin.setId(rSet.getInt("id"));// id后面还要做更新使用
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			dbUtils.closeAll(connection, pstm, rSet);
		}
		return admin;

	}
	/**
	 * 通过id删除某个用户
	 */
	public int delAdminById(int id) {
		int count=0;
		connection=dbUtils.getConn();
		String sql="delete from tb_manager where id=?";
		Object obj[]= {id};
		count=dbUtils.editSql(sql, obj);
		dbUtils.closeAll(connection, null, null);
		return count;
	}

}
