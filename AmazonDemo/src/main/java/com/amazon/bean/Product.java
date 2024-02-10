package com.amazon.bean;

//POJO:Plain Ordinary Java Object
//a map class for the database table
public class Product {
	private int no;
	private String name;
	private double price;
	private String picture;
	private String descirption;
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getPicture() {
		return picture;
	}
	public void setPicture(String picture) {
		this.picture = picture;
	}
	public String getDescirption() {
		return descirption;
	}
	public void setDescirption(String descirption) {
		this.descirption = descirption;
	}
	@Override
	public String toString() {
		return "Product [no=" + no + ", name=" + name + ", price=" + price + ", picture=" + picture + ", descirption="
				+ descirption + "]";
	}
	public Product(int no, String name, double price, String picture, String descirption) {
		super();
		this.no = no;
		this.name = name;
		this.price = price;
		this.picture = picture;
		this.descirption = descirption;
	}
	public Product() {
		super();
	}
	
	
}

