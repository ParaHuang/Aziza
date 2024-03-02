package com.amazon.bean;

public class Order {
	private int no;
	private String username;
	private Product p;  //->replace int pNo
	private int price;
	private String time;
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public Product getP() {
		return p;
	}
	public void setP(Product p) {
		this.p = p;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public Order(int no, String username, Product p, int price, String time) {
		super();
		this.no = no;
		this.username = username;
		this.p = p;
		this.price = price;
		this.time = time;
	}
	public Order() {
		super();
	}
	@Override
	public String toString() {
		return "Order [no=" + no + ", username=" + username + ", p=" + p + ", price=" + price + ", time=" + time + "]";
	}
	
}












