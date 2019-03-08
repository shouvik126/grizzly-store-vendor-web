package com.pack.model;

public class Product {
	private String pid,productname,brand,category,description,usrid;
	private double rating,price;
	private int discount,instock,buffer,pending;
	
	public Product()
	{
		super();
	}
	public Product(String pid, String productname, String brand, String category, String description, double rating,
			double price,int discount,String usrid,int instock,int buffer,int pending) {
		super();
		this.pid = pid;
		this.productname = productname;
		this.brand = brand;
		this.category = category;
		this.description = description;
		this.rating = rating;
		this.price = price;
		this.discount=discount;
	}
	public String getPid() {
		return pid;
	}
	public void setPid(String pid) {
		this.pid = pid;
	}
	public String getProductname() {
		return productname;
	}
	public void setProductname(String productname) {
		this.productname = productname;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public double getRating() {
		return rating;
	}
	public void setRating(double rating) {
		this.rating = rating;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public int getDiscount() {
		return discount;
	}
	public void setDiscount(int discount) {
		this.discount = discount;
	}
	public String getUsrid() {
		return usrid;
	}
	public void setUserid(String usrid) {
		this.usrid = usrid;
	}
	public int getInstock() {
		return instock;
	}
	public void setInstock(int instock) {
		this.instock = instock;
	}
	public int getBuffer() {
		return buffer;
	}
	public void setBuffer(int buffer) {
		this.buffer = buffer;
	}
	public int getPending() {
		return pending;
	}
	public void setPending(int pending) {
		this.pending = pending;
	}
}
