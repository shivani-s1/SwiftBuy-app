package com.orderService.entity;

import javax.persistence.Id;

import org.springframework.data.mongodb.core.mapping.Document;
@Document(collection = "address")
public class Address {
	@Id
	private int addressId;
	private String fullName;
	private String mobileNumber;
	private int flatNumber;
	private String city;
	private int pinCode;
	private String state;
	
	
	public Address(int addressId, String fullName, String mobileNumber, int flatNumber, String city, int pinCode,
			String state, String emailId) {
		super();
		this.addressId = addressId;
		this.fullName = fullName;
		this.mobileNumber = mobileNumber;
		this.flatNumber = flatNumber;
		this.city = city;
		this.pinCode = pinCode;
		this.state = state;
		this.emailId = emailId;
	}

	private String emailId;

	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public int getCustomerId() {
		return addressId;
	}
	public void setCustomerId(int customerId) {
		this.addressId = customerId;
	}
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	public String getMobileNumber() {
		return mobileNumber;
	}
	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
	public int getFlatNumber() {
		return flatNumber;
	}
	public void setFlatNumber(int flatNumber) {
		this.flatNumber = flatNumber;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public int getPinCode() {
		return pinCode;
	}
	public void setPinCode(int pinCode) {
		this.pinCode = pinCode;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}

	public Address() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
