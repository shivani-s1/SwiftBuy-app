package com.cartService.CartService.entity;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
@Document
public class CartEntity {
	
	@Id
	private String id;
	private double totalPrice;
	private String productName;
	private int quantity;
	private String emailId;

	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
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
	@DBRef
    private List<Items> items;
	
	public String getCartId() {
		return id;
	}
	public List<Items> getItems() {
		return items;
	}
	public void setItems(List<Items> items) {
		this.items = items;
	}
	public void setCartId(String id) {
		this.id = id;
	}
	public double getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}
	
	public CartEntity(String id, double totalPrice, String productName, int quantity, String emailId,
			List<Items> items) {
		super();
		this.id = id;
		this.totalPrice = totalPrice;
		this.productName = productName;
		this.quantity = quantity;
		this.emailId = emailId;
		this.items = items;
	}
	public CartEntity() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	

}
