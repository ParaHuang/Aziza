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
	Connection conn;		//default value :null
	PreparedStatement psta;
	ResultSet rs;
	public int addOrder(String username,String pNo,String price){
		String sql = "insert into orderTb values (null,?,?,?,now())";
		int row = BaseDao.dbUtil(sql, username,pNo,price);
		return row;
	}
	
	//1.Order.java
	//2.getOrdersByUsername
	public List<Order> getOrdersByUsername(String username) {
		//"select * from orderTb where username = ?"
		ArrayList<Order> list = new ArrayList<>();
		try {
			conn = BaseDao.getConnection();
			String sql = "select * from orderTb,productTb where username = ? and productTb.no = pNO";
			psta = conn.prepareStatement(sql);
			psta.setString(1, username);
			rs =  psta.executeQuery();
			
			while(rs.next()) {
				Product p = new Product(rs.getInt(6),rs.getString("name"),rs.getInt(8),rs.getString(9),rs.getString(10));
				
				Order o = new Order(rs.getInt(1), rs.getString(2), p, rs.getInt(4), rs.getString(5));
				list.add(o);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			BaseDao.close(conn, psta, rs);
		}
		return list;
	}
}










