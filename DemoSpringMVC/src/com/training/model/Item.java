package com.training.model;

public class Item {
	private int id;
	private String name;
	private double price;
	private int discountPercent;
	
	public Item(int id, String name, double price, int discountPercent) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.discountPercent = discountPercent;
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
	
	
}
