package com.amazon.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.amazon.bean.Order;
import com.amazon.bean.Product;

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
	public List<Order> getOrdersByUsername(String username) {
		//"select * from orderTb where username = ?"
		ArrayList<Order> list = new ArrayList<>();
		try {
			Connection conn = BaseDao.getConnection();
			String sql = "select * from orderTb,productTb where username = ? and productTb.no = pNO";
			PreparedStatement psta = conn.prepareStatement(sql);
			psta.setString(1, username);
			ResultSet rs =  psta.executeQuery();
			
			while(rs.next()) {
				Product p = new Product(rs.getInt(6),rs.getString("name"),rs.getInt(8),rs.getString(9),rs.getString(10));
				
				Order o = new Order(rs.getInt(1), rs.getString(2), p, rs.getInt(4), rs.getString(5));
				list.add(o);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
}










