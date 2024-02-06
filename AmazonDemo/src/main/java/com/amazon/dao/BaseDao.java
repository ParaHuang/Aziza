package com.amazon.dao;

import java.sql.Connection;
import java.sql.DriverManager;
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
	
	
}









