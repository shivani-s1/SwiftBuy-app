package com.cartService.CartService.Repository;

import com.cartService.CartService.entity.Cart;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface CartRepository extends MongoRepository<Cart, String>{
 Optional<Cart> findByCustomerId(String customerId);
}
