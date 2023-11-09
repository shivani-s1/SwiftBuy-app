package com.orderService.entity;

import java.util.List;

import javax.persistence.Id;

import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

public class CartEntity {
	
	@Id
	private String cartId;
	private double totalPrice;
	private String productName;
	private int quantity;
	
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public String getId() {
		return cartId;
	}
	public void setId(String cartId) {
		this.cartId = cartId;
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
		return cartId;
	}
	public List<Items> getItems() {
		return items;
	}
	public void setItems(List<Items> items) {
		this.items = items;
	}
	public void setCartId(String cartId) {
		this.cartId = cartId;
	}
	public double getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}
	
	public CartEntity(String cartId, double totalPrice, String productName, int quantity, List<Items> items) {
		super();
		this.cartId = cartId;
		this.totalPrice = totalPrice;
		this.productName = productName;
		this.quantity = quantity;
		this.items = items;
	}
	public CartEntity() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	

}
