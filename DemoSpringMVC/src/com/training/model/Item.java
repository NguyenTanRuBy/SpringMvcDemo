package com.training.model;

public class Item {
	private int id;
	private String name;
	private double price;
	private int discountPercent;
	private String img;
	
	public Item() {
		// TODO Auto-generated constructor stub
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
	public int getDiscountPercent() {
		return discountPercent;
	}
	public void setDiscountPercent(int discountPercent) {
		this.discountPercent = discountPercent;
	}
	
	public String getImg() {
		return img;
	}
	public void setImg(String img) {
		this.img = img;
	}
	

	@Override
	public String toString() {
		return "Item [id=" + id + ", name=" + name + ", price=" + price + ", discountPercent=" + discountPercent + "]";
	}
	

}
