package com.cartService.CartService.entity;


import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

//@Document(collection = "custom_items")
public class Items {

	//@Id
	private String id;
	private String productName;
	private double price;
	private List<String> image;

	private	int quantity;

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public List<String> getImage() {
		return image;
	}

	public void setImage(List<String> image) {
		this.image = image;
	}

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

	public Items(String id, String productName, double price, List<String> image, int quantity) {
		this.id = id;
		this.productName = productName;
		this.price = price;
		this.image = image;
		this.quantity = quantity;
	}

	public Items() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
}
