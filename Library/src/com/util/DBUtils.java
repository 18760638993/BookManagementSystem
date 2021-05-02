
package com.util;
//操作数据库的工具
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBUtils {

	Connection conn = null;
	PreparedStatement pstm = null;
	ResultSet rs = null;

	// 1、连接数据库
	public Connection getConn() {

		try {
			// 加载驱动
			Class.forName("com.mysql.jdbc.Driver");
			//useUnicode=true&amp;characterEncoding=UTF-8
			String url = "jdbc:mysql://localhost:3306/library?useUnicode=true&characterEncoding=UTF-8";
			// 数据库用户名
			String user = "root";
			// 数据库密码
			String password = "747638";
			conn = DriverManager.getConnection(url, user, password);

		} catch (ClassNotFoundException e) {
			System.out.println("加载驱动失败...");
			e.printStackTrace();
		} catch (SQLException e) {
			System.out.println("连接数据库失败...");
			e.printStackTrace();
		}

		return conn;
	}

	// 2.关闭资源
	public void closeAll(Connection conn, PreparedStatement pstm, ResultSet rs) {
		try {
			if (rs != null) {
				rs.close();
			}
			if (pstm != null) {
				pstm.close();
			}
			if (conn != null) {
				conn.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// 对查询的封装
	public ResultSet query(String sql, Object obj[]) {

		try {

			pstm = conn.prepareStatement(sql);
			// 占位符赋值
			if (obj != null) {

				for (int i = 0; i < obj.length; i++) {
					pstm.setObject(i + 1, obj[i]);
				}
			}
			rs = pstm.executeQuery();
			System.out.println(pstm.toString());
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return rs;
	}

	// 对增删改的封装
	public int editSql(String sql, Object obj[]) {
		int count = 0;
		try {
			// 创建SQL命令对象
			pstm = conn.prepareStatement(sql);

			// 占位符赋值
			if (obj != null) {
				for (int i = 0; i < obj.length; i++) {
					pstm.setObject(i + 1, obj[i]);
				}
			}
			System.out.println(pstm.toString());
			count = pstm.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return count;
	}

}
