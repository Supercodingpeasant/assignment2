package com.briup.ch08.common.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ConnectionFactory {
	private static String driver;
	private static String url;
	private static String user;
	private static String password;
	
	static {
		driver = "com.mysql.jdbc.Driver";
		//jdbc:mysql://ip:port/dbName
		url="jdbc:mysql://127.0.0.1:3306/wan";
		user = "root";
		password = "123456";
		
	}
	/**
	 * 静态方法
	 * */
	public static Connection getConn() throws Exception{
		//加载驱动
		Class.forName(driver);
		//获取连接
		return DriverManager.getConnection(url, user, password);
		
	}
	public static void close(ResultSet rs,PreparedStatement pstmt,Connection conn) throws SQLException{
		if(rs!=null){
			rs.close();
		}
		if(pstmt!=null){
			pstmt.close();
		}
		if(conn!=null){
			conn.close();
		}
	}
}
