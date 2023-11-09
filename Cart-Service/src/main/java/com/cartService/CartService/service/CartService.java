package com.cartService.CartService.service;

import java.util.List;

import com.cartService.CartService.entity.Cart;
import com.cartService.CartService.entity.CartEntity;
import com.cartService.CartService.entity.Items;

public interface CartService {

	Cart findById(String id);

	List<Cart> findAll();

	Cart save(String customerId);

	double calculateTotalPrice(String cartId);

	Cart findByCustomerId(String customerId);

	Cart addProduct(String productId,String customerId);

	List<Items> deleteProduct(String productId,String cartId);

	String addProductQuantity(String productId,String cartId);

	String subtractProductQuantity(String productId,String cartId);
}
