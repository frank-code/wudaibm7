package com.jdbc.preparestatement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.jdbc.utils.JdbcUtils;
 
/**
 * PreparedStatement 的使用
 *
 */
public class MainPrepareStatement {
 
	public static void main(String[] args) {
//		 testInsert();
		 testDelete();
//		testUpdate();
		
		testQuery();
	}
 
	private static void testInsert() {
		Connection conn = JdbcUtils.getConnection();
		PreparedStatement stmt = null;
		if(null !=conn) {
			try {
				stmt = conn.prepareStatement("insert into user(username) values (?)");
				stmt.setString(1, "P小王"); //替换?,索引从1开始
			
				stmt.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			}finally {
				JdbcUtils.release(null, stmt, conn);
			}
		}
	}
	
	private static void testDelete() {
		Connection conn = JdbcUtils.getConnection();
		PreparedStatement stmt = null;
		if(null !=conn) {
			try {
				stmt = conn.prepareStatement("delete from user where username=?");
				stmt.setString(1, "P王蒙"); //替换?,索引从1开始
				stmt.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			}finally {
				JdbcUtils.release(null, stmt, conn);
			}
		}
	}
 
	private static void testUpdate() {
		Connection conn = JdbcUtils.getConnection();
		PreparedStatement stmt = null;
		if(null !=conn) {
			try {
				stmt = conn.prepareStatement("update user set username=? where username=?");
				stmt.setString(1, "P王蒙"); 
				stmt.setString(2, "P小王"); 
				stmt.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			}finally {
				JdbcUtils.release(null, stmt, conn);
			}
		}
	}
	
	private static void testQuery() {
		Connection conn = JdbcUtils.getConnection();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		if(null !=conn) {
			try {
				stmt = conn.prepareStatement("select * from user");
				rs=	stmt.executeQuery();
				if(null !=rs) {
					while(rs.next()) {
						System.out.println("id:"+rs.getString("id")+" name:"+rs.getString("username"));
					}
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}finally {
				JdbcUtils.release(rs, stmt, conn);
			}
		}
	}
 
}