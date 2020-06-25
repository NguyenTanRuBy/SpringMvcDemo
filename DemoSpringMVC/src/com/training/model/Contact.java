package com.training.model;

public class Contact {
	
	private String phone;
	private String address;
	private String email;
	private String openTime;
	private String closeTime;

	public Contact(String phone, String address, String email, String openTime, String closeTime) {
		super();
		this.phone = phone;
		this.address = address;
		this.email = email;
		this.openTime = openTime;
		this.closeTime = closeTime;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getOpenTime() {
		return openTime;
	}

	public void setOpenTime(String openTime) {
		this.openTime = openTime;
	}

	public String getCloseTime() {
		return closeTime;
	}

	public void setCloseTime(String closeTime) {
		this.closeTime = closeTime;
	}
	
	
	

}
