package com.orderService.orderService;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.orderService.Repository.AddressRepo;
import com.orderService.Repository.OrderRepo;
import com.orderService.entity.Address;
import com.orderService.entity.CartEntity;
import com.orderService.entity.Orders;

@Service
public class OrderServiceImpl implements OrderService{
	
	@Autowired
	private OrderRepo repo;
	
	@Autowired
	private AddressRepo addressRepo;
	
	@Autowired
	private RestTemplate restTemplate;


	@Override
    public Orders saveOrder(Address address,String customerId) {
        CartEntity cart = restTemplate.getForObject("http://localhost:8082/cart/getCart/"+customerId, CartEntity.class );
        if(cart==null) {
        	return null;
        }
       // Items product = restTemplate.getForObject("http://localhost:8083/product/getAll", Items.class);
        //"http://localhost:8084/profile/getByEmailId/"+entity.getEmailId(),Profile.class
        Orders request = new Orders();
        request.setAddress(address);
        System.out.println(address);
        addressRepo.save(address);
        request.setCart(cart);
        request.setOrderDate(LocalDate.now());
        request.setAmountPaid(cart.getTotalPrice());
        request.setOrderStatus("Order placed");
        request.setCustomerId(customerId);
//        Orders result = restTemplate.postForObject("http://localhost:8085/order/getById/", request, Orders.class);
        return repo.save(request);
    }	

	@Override
	public Orders getById(String orderId) {
		Orders order = repo.findById(orderId).orElse(null);
		return order;
	}

	@Override
	public List<Orders> getAllOrders(){
		return repo.findAll();
	}

	@Override
	public String deleteOrder(String orderId) {
		// TODO Auto-generated method stub
		Optional<Orders> order = repo.findById(orderId);
		if(order.isPresent()) {
			repo.deleteById(orderId);
			return "order deleted";
		}
		return "order not deleted";
		
	}
	



	
}
