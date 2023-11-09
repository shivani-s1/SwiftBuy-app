package com.cartService.CartService.service;

import java.util.ArrayList;
import java.util.List;

import com.cartService.CartService.entity.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.cartService.CartService.Repository.CartRepository;
import com.cartService.CartService.Repository.ItemRepository;

@Service
public class CartServiceImpl implements CartService{
	
	@Autowired 
	private CartRepository repo;
	
	@Autowired
	private ItemRepository itemsRepo;
	
	@Autowired
	private RestTemplate restTemplate;

	@Override
	public Cart save(String customerId) {
		Cart cart =new Cart();
		List<Items> items =new ArrayList<Items>();
		cart.setCustomerId(customerId);
		cart.setTotalPrice(0);
		cart.setItems(items);
		return repo.save(cart);
	}

	@Override
	public double calculateTotalPrice(String cartId) {
		Cart cart = repo.findById(cartId).orElse(null);
		if (cart != null) {
			double totalPrice = 0.0;
			List<Items> itemList = cart.getItems();
			for (Items item : itemList) {
				totalPrice += (item.getPrice() * item.getQuantity());
			}
			cart.setTotalPrice(totalPrice);
			repo.save(cart);
			return totalPrice;
		}
		return 0.0;
	}


	@Override
	public Cart findByCustomerId(String customerId) {
		Cart cart = repo.findByCustomerId(customerId).orElse(null);
		return cart;
	}

	@Override
	public Cart addProduct(String productId, String customerId) {
		Cart cart = repo.findByCustomerId(customerId).orElse(null);
		ProductEntity product = restTemplate.getForObject("http://localhost:8083/product/getById/" + productId, ProductEntity.class);
		Items item = new Items();
		item.setId(product.getProductId());
		item.setProductName(product.getProductName());
		item.setImage(product.getImage());
		item.setPrice(product.getPrice());
		item.setQuantity(1);
		List<Items> cartItems = cart.getItems();
		if (cartItems == null) {
			cartItems = new ArrayList<Items>();
			cartItems.add(item);
		} else {
			cartItems.add(item);
		}
		return repo.save(cart);
	}

	@Override
	public List<Items> deleteProduct(String productId, String cartId) {
		Cart cart = repo.findById(cartId).orElse(null);
		List<Items> cartItems = new ArrayList<>(); // Initialize outside the if block
		if (cart != null) {
			cartItems = new ArrayList<>(cart.getItems()); // Make a copy
			Items deletingItem = null;
			for (Items item : cartItems) {
				if (item.getId().equals(productId)) {
					deletingItem = item;
					break; // Exit loop once item is found
				}
			}
			if (deletingItem != null) {
				cartItems.remove(deletingItem);
				cart.setItems(cartItems);
				repo.save(cart);
			}
		}
		return cartItems; // Return modified list or empty list if cart is null
	}


	@Override
	public String addProductQuantity(String productId, String cartId) {
		Cart cart = repo.findById(cartId).orElse(null);
		List<Items> cartItems = cart.getItems();
		for (Items item : cartItems) {
			if (item.getId().equals(productId)) {
				item.setQuantity(item.getQuantity() + 1);
				break;
			}
		}
		cart.setItems(cartItems);
		repo.save(cart);
		return "Item Quantity Increased";
	}

	@Override
	public String subtractProductQuantity(String productId, String cartId) {
		Cart cart = repo.findById(cartId).orElse(null);
		List<Items> cartItems = cart.getItems();
		for (Items item : cartItems) {
			if (item.getId().equals(productId)) {
				if (item.getQuantity() > 1) {
					item.setQuantity(item.getQuantity() - 1);
				}
				break;
			}
		}
		cart.setItems(cartItems);
		repo.save(cart);
		return "Item Quantity Decreased";
	}

	@Override
	public Cart findById(String id) {
		// TODO Auto-generated method stub
		Cart cart = repo.findById(id).orElse(null);
		return cart;
	}

	@Override
	public List<Cart> findAll() {
		return repo.findAll();
	}


}
