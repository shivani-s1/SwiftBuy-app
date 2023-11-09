package com.orderService.entity;

import javax.persistence.Id;

import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;


public class Items {

	@Id
	private String id;
	private String productName;
	private double price;
	
	@DBRef
    private CartEntity cart;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}


	public Items(String id, String productName, double price) {
		super();
		this.id = id;
		this.productName = productName;
		this.price = price;
	}

	public Items() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
}
