package com.orderService.entity;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Id;

import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "orders")
public class Orders {

	@Id
	private String orderId;
	private LocalDate orderDate;
	private String customerId;
	private double amountPaid;
	private String orderStatus;
	
	private Address address;
	private CartEntity cart;

	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	
	
	public CartEntity getCart() {
		return cart;
	}
	public void setCart(CartEntity cart) {
		this.cart = cart;
	}
	public Orders() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Orders(String orderId, LocalDate orderDate, String emailId, double amountPaid, 
			String orderStatus) {
		super();
		this.orderId = orderId;
		this.orderDate = orderDate;
		this.emailId = emailId;
		this.amountPaid = amountPaid;
		this.orderStatus = orderStatus;
	}
	public String getId() {
		return orderId;
	}
	public void setId(String id) {
		this.orderId = orderId;
	}
	public LocalDate getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(LocalDate orderDate) {
		this.orderDate = orderDate;
	}
	public String getCustomerId() {
		return customerId;
	}
	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}
	public double getAmountPaid() {
		return amountPaid;
	}
	public void setAmountPaid(double amountPaid) {
		this.amountPaid = amountPaid;
	}

	public String getOrderStatus() {
		return orderStatus;
	}
	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}

	
	
}
