package com.amazon.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.amazon.bean.Product;

//dao: data access object (deal with database)
public class ProductDao {
	Connection conn;		//default value :null
	PreparedStatement psta;
	ResultSet rs;
	public ArrayList<Product> queryAllProducts(int start,int count) {
		ArrayList<Product> list = new ArrayList<>();
		try {
			conn = BaseDao.getConnection();
			String sql = "select * from productTb limit "+start+","+count;
			psta = conn.prepareStatement(sql);
			rs =  psta.executeQuery();
			
			while(rs.next()) {
				Product p = new Product(rs.getInt(1), rs.getString(2), rs.getDouble(3),
						rs.getString(4), rs.getString(5));

				list.add(p);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			//no matter there is exception or not, this will be execute in the end
			BaseDao.close(conn, psta, rs);
		}
		return list;
	}

	public Product queryProductByNo(String no) {
		
		try {
			conn = BaseDao.getConnection();
			String sql = "select * from productTb where no = "+no;
			psta = conn.prepareStatement(sql);
			rs =  psta.executeQuery();
			
			if(rs.next()) {
				Product p = new Product(rs.getInt(1), rs.getString(2), rs.getDouble(3),
						rs.getString(4), rs.getString(5));
				return p;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			//no matter there is exception or not, this will be execute in the end
			BaseDao.close(conn, psta, rs);
		}
		
		return null;
	}

	public int getTotalCounts() {
		
		try {
			conn = BaseDao.getConnection();
			String sql = "select count(*) from productTb";
			psta = conn.prepareStatement(sql);
			rs =  psta.executeQuery();
			
			if(rs.next()) {
				return rs.getInt(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			//no matter there is exception or not, this will be execute in the end
			BaseDao.close(conn, psta, rs);
		}
		
		return -1;
	}
}

