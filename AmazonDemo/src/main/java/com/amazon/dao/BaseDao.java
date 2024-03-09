package com.amazon.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BaseDao {
	
	static {//code in here will be execute automatically before everything, and only once
		//1.get permission(once)
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//get Connection
	public static Connection getConnection() throws SQLException {
		//2.get Connection  
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/amazon?useSSL=false",
				"root", "a123");
		return conn;
	}
	
	//close Connection
	public static void close(Connection conn,PreparedStatement psta,ResultSet rs) {
		try {
			if(rs!=null) {
				rs.close();
			}
			if(psta!=null) {
				psta.close();
			}
			if(conn!=null) {
				conn.close();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//the database tool method for insert,delete, update
	public static int dbUtil(String sql,String... params) {
		Connection conn = null;
		PreparedStatement psta = null;
		try {
			//1.get Connection
			conn = BaseDao.getConnection();
			//2.get Statement object (a tool created based on command/sql)
			
			psta = conn.prepareStatement(sql);
			//3.set up those ?
			for(int i=0 ; i<params.length ; i++) {
				psta.setString(i+1, params[i]);
			}
			
			int rows = psta.executeUpdate();
			//reaction should be done at where this method is used
			return rows;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close(conn,psta,null);
		}
		return 0;
	}
	
	
}









