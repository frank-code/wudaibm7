package com.jdbc.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
 
/**
 * jdbc操作的工具类
 *
 */
public class JdbcUtils {
 
	private static String driverClass = null;
	private static String url = null;
	private static String username;
	private static String password;
 
	static {
		//读取配置文件
//		ResourceBundle bundle = ResourceBundle.getBundle("jdbc");
		
		
		driverClass = "com.mysql.cj.jdbc.Driver";
		url = "jdbc:mysql://localhost:3306/TEST?serverTimezone=UTC";
		username = "root";
		password = "123";
 
		try {
			//加载驱动
			Class.forName(driverClass);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/**
	 * 获取mysql连接
	 * @return
	 */
	public static Connection getConnection() {
		try {
			return DriverManager.getConnection(url, username, password);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * 释放资源
	 * @param rs
	 * @param stmt
	 * @param conn
	 */
	public static void release(ResultSet rs, Statement stmt, Connection conn) {
		if (null != rs)
			try {
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				rs = null;
			}
 
		if (null != stmt)
			try {
				stmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				stmt = null;
			}
 
		if (null != conn)
			try {
//				conn.commit();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				conn = null;
			}
	}
	
	
	public static void release(ResultSet rs, PreparedStatement stmt, Connection conn) {
		if (null != rs)
			try {
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				rs = null;
			}
 
		if (null != stmt)
			try {
				stmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				stmt = null;
			}
 
		if (null != conn)
			try {
//				conn.commit();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				conn = null;
			}
	}
}