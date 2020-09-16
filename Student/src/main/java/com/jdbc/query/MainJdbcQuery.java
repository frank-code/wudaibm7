package com.jdbc.query;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
 
public class MainJdbcQuery {
 
	public static void main(String[] args) {
		Connection conn = null;
		Statement statement = null;
		ResultSet resultSet = null;
		try {
			//1.通过字节码对象注册驱动
			Class.forName("com.mysql.cj.jdbc.Driver");
			//2.获得连接对象
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/TEST?serverTimezone=UTC","root","123");
			//3.通过conn对象获得向数据库发送sql语句的statement对象
			statement = conn.createStatement();
			//4.通过stmt对象执行sql语句，拿到执行的结果，返回给rs对象
			resultSet = statement.executeQuery("select * from user");
			//5.解析rs结果集中的数据
			while(resultSet.next()) {
				int id = resultSet.getInt("id")	;
				String name = resultSet.getString("username");
				System.out.println("id:"+id+" name:"+name);
			}
			//6.关闭资源
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			if(null !=resultSet)
				try {
					resultSet.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			
			if(null !=statement)
				try {
					statement.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			
			if(null !=conn)
				try {
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
		
	}
 
}