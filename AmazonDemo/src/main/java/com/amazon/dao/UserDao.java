package com.amazon.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.amazon.bean.User;

public class UserDao {
	//add User
	public int addUser(String username,String password,String phoneNumber,String name,String email,String location) {
		try {
			//1.get Connection
			Connection conn = BaseDao.getConnection();
			//2.get Statement object (a tool created based on command/sql)
			String sql = "insert into userTb VALUES (?,?,?,?,?,?)";
			PreparedStatement psta = conn.prepareStatement(sql);
			//3.set up those ?
//			psta.setDouble(0, 0);
//			psta.setInt(0, 0);
//			psta.setString(which ?, what value);
			psta.setString(1, username);
			psta.setString(2, password);
			psta.setString(3, phoneNumber);
			psta.setString(4, name);
			psta.setString(5, email);
			psta.setString(6, location);
			
			int rows = psta.executeUpdate();
			//reaction should be done at where this method is used
			return rows;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}
	
	
	//delete User
	
	
	
	//update User
	
	
	//query all the users
	public ArrayList<User> queryAllUsers() {
		ArrayList<User> list = new ArrayList<User>();
		try {
			Connection conn = BaseDao.getConnection();
			String sql = "select * from userTb";
			PreparedStatement psta = conn.prepareStatement(sql);
			ResultSet rs =  psta.executeQuery();
			//rs.next();	//move pointer to next row,return boolean data, if it's true, it means there is data in this row, if it's false, which means you reach the end
			
			while(rs.next()) {
//				System.out.println(rs.getString(1));//number:column position, start from 1
//				System.out.println(rs.getString(2));
//				System.out.println(rs.getString(3));
//				System.out.println(rs.getString(4));
//				System.out.println(rs.getString(5));
//				System.out.println(rs.getString(6));
//				System.out.println();
				User u = new User(rs.getString(1), rs.getString(2), rs.getString(3), 
						rs.getString(4), rs.getString(4), rs.getString(6));
//				System.out.println(u);
				list.add(u);
			}
//			rs.getInt(0)
//			rs.getDate(0)
//			rs.getDouble(0)
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	
	public static void main(String[] args) {
		new UserDao().queryAllUsers();
	}
	
	public User loginByUsernamePassword(String username,String password) {
		try {
			Connection conn = BaseDao.getConnection();
			String sql = "select * from userTb where username=? and password=?";
			PreparedStatement psta = conn.prepareStatement(sql);
			psta.setString(1, username);
			psta.setString(2, password);
			
			ResultSet rs =  psta.executeQuery();
			if(rs.next()) {
				User u = new User(rs.getString(1), null, rs.getString(3), 
						rs.getString(4), rs.getString(5), rs.getString(6));
				return u;
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	
	
	
	
	
	
	
}









