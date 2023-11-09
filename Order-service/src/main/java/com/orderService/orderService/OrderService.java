package com.orderService.orderService;

import java.util.List;

import com.orderService.entity.Address;
import com.orderService.entity.Orders;

public interface OrderService {

	Orders getById(String orderId);
	Orders saveOrder(Address address, String customerId);
	List<Orders> getAllOrders();
	String deleteOrder(String orderId);

}
