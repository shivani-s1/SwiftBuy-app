package com.orderService.Repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.orderService.entity.Orders;

@Repository
public interface OrderRepo extends MongoRepository<Orders, String>{

}
