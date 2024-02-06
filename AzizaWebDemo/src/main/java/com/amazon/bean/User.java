package com.amazon.bean;

public class User {
	private String username;
	private String password;
	private String phonenumber;
	private String name;
	private String email;
	private String location;
	//getters and setters
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getPhonenumber() {
		return phonenumber;
	}
	public void setPhonenumber(String phonenumber) {
		this.phonenumber = phonenumber;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public User(String username, String password, String phonenumber, String name, String email, String location) {
		super();
		this.username = username;
		this.password = password;
		this.phonenumber = phonenumber;
		this.name = name;
		this.email = email;
		this.location = location;
	}
	public User() {
		super();
	}
	
	@Override
	public String toString() {
		return "User [username=" + username + ", password=" + password + ", phonenumber=" + phonenumber + ", name="
				+ name + ", email=" + email + ", location=" + location + "]";
	}
	
	
}

