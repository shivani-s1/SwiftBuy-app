package com.orderService.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.orderService.entity.Address;
import com.orderService.entity.Orders;
import com.orderService.orderService.OrderService;
import com.orderService.orderService.OrderServiceImpl;

@RestController
@RequestMapping("/order")
@CrossOrigin(origins = "*")
public class OrderController {
	
	@Autowired
	private OrderServiceImpl service;
	
	@GetMapping("/getById/{id}")
	public Orders getById(@PathVariable String id) {
		return service.getById(id);
	}
	
	@PostMapping("/save/{customerId}")
	public Orders save(@RequestBody Address address,@PathVariable String customerId) {
		return service.saveOrder(address, customerId);
		
	}
	
	@GetMapping("/getall")
	public List<Orders> getAll(){
		return service.getAllOrders();
	}
	
	@DeleteMapping("/delete/{id}")
	public String deleteOrder(@PathVariable String orderId) {
		return service.deleteOrder(orderId);
	}
	
}
