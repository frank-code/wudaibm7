package com.jdbc.statement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.jdbc.utils.JdbcUtils;
 
/**
 * 测试CRUD操作
 *
 */
public class MainStatement {
 
	public static void main(String[] args) throws SQLException, ClassNotFoundException {
//		 testInsert();
		 testDelete();
//		testUpdate();
		
		testQuery();
	}
 
	private static void testInsert() throws SQLException, ClassNotFoundException {
		Connection conn = JdbcUtils.getConnection();
		
		Statement stmt = null;
		if (null != conn) {
			try {
				stmt = conn.createStatement();
				stmt.executeUpdate("insert into user(username) values('张三')");
//				conn.commit();
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				JdbcUtils.release(null, stmt, conn);
			}
		}
 
	}
 
	private static void testDelete() {
		Connection conn = JdbcUtils.getConnection();
		Statement stmt = null;
		if (null != conn) {
			try {
				stmt = conn.createStatement();
				stmt.executeUpdate("delete from user where username='李四'");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				JdbcUtils.release(null, stmt, conn);
			}
		}
	}
	
	private static void testUpdate() {
		Connection conn = JdbcUtils.getConnection();
		Statement stmt = null;
		if (null != conn) {
			try {
				stmt = conn.createStatement();
				stmt.executeUpdate("update  user set username='李四'  where username='张三' ");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				JdbcUtils.release(null, stmt, conn);
			}
		}
	}
	private static void testQuery() {
		Connection conn = JdbcUtils.getConnection();
		Statement stmt = null;
		ResultSet rs = null;
		if (null != conn) {
			try {
				stmt = conn.createStatement();
				rs=	stmt.executeQuery("select * from user");
				if(null !=rs) {
					while(rs.next()) {
						System.out.println("id:"+rs.getInt("id")+" name:"+rs.getString("username"));
					}
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				JdbcUtils.release(rs, stmt, conn);
			}
		}
	}
}