package com.amazon.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.amazon.bean.Product;

//dao: data access object (deal with database)
public class ProductDao {

	public ArrayList<Product> queryAllProducts() {
		ArrayList<Product> list = new ArrayList<>();
		try {
			Connection conn = BaseDao.getConnection();
			String sql = "select * from productTb";
			PreparedStatement psta = conn.prepareStatement(sql);
			ResultSet rs =  psta.executeQuery();
			
			while(rs.next()) {
				Product p = new Product(rs.getInt(1), rs.getString(2), rs.getDouble(3),
						rs.getString(4), rs.getString(5));

				list.add(p);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	public Product queryProductByNo(String no) {
		
		try {
			Connection conn = BaseDao.getConnection();
			String sql = "select * from productTb where no = "+no;
			PreparedStatement psta = conn.prepareStatement(sql);
			ResultSet rs =  psta.executeQuery();
			
			if(rs.next()) {
				Product p = new Product(rs.getInt(1), rs.getString(2), rs.getDouble(3),
						rs.getString(4), rs.getString(5));
				return p;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}
}

