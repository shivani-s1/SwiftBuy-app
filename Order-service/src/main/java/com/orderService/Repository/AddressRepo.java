package com.orderService.Repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.orderService.entity.Address;

@Repository
public interface AddressRepo extends MongoRepository<Address, String>{

}
