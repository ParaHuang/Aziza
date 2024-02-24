package com.amazon.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class OrderDao {
	
	public int addOrder(String username,String pNo,String price){
		try {
			Connection conn = BaseDao.getConnection();
			String sql = "insert into orderTb values (null,?,?,?,now())";
			PreparedStatement psta = conn.prepareStatement(sql);
			//set up arguments
			psta.setString(1, username);
			psta.setString(2, pNo);
			psta.setString(3, price);
			//execute operation
			int rows = psta.executeUpdate();
			return rows;//1
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		return 0;
	}
	
	//1.Order.java
	//2.getOrdersByUsername
//	public List<Order> getOrdersByUsername(String username) {
//		//"select * from orderTb where username = ?"
//	}
}










