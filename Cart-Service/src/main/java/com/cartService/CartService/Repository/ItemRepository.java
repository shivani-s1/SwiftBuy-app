package com.cartService.CartService.Repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.cartService.CartService.entity.Items;

@Repository
public interface ItemRepository extends MongoRepository<Items, String>{

}
