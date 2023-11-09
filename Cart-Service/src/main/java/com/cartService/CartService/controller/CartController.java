package com.cartService.CartService.controller;

import java.util.List;

import com.cartService.CartService.entity.Cart;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.cartService.CartService.Repository.CartRepository;
import com.cartService.CartService.Repository.ItemRepository;
import com.cartService.CartService.entity.CartEntity;
import com.cartService.CartService.entity.Items;
import com.cartService.CartService.entity.ProductEntity;
import com.cartService.CartService.service.CartService;

@RestController
@RequestMapping("/cart")
@CrossOrigin(origins = "*")
public class CartController {
	
	@Autowired
	private RestTemplate restTemplate;

	@Autowired
	private CartService service;
	
	@Autowired
	private ItemRepository repo;
	
	@GetMapping("/getById/{id}")
	public Cart getById(@PathVariable String id) {
		return service.findById(id);
	}

	@GetMapping("/getCart/{customerId}")
	public Cart getByCustomerId(@PathVariable String customerId) {
		return service.findByCustomerId(customerId);
	}

	@PostMapping("/saveCart/{customerId}")
	public Cart addCart(@PathVariable String customerId) {
		return service.save(customerId);
	}
	
	@GetMapping("/getAll")
	public List<Cart> getAllCarts(){
		return service.findAll();
	}
	
	@GetMapping("/cartTotal/{cartId}")
	public double getCartTotal(@PathVariable String cartId) {
		return service.calculateTotalPrice(cartId);
	}

	@DeleteMapping("productDelete/{productId}/{cartId}")
	public List<Items> deleteProduct(@PathVariable String productId,@PathVariable String cartId){
		return service.deleteProduct(productId,cartId);
	}

	@PutMapping("addQuantity/{productId}/{cartId}")
	public String addProductQuantity(@PathVariable String productId,@PathVariable String cartId){
		return service.addProductQuantity(productId,cartId);
	}

	@PutMapping("subtractQuantity/{productId}/{cartId}")
	public String subtractProductQuantity(@PathVariable String productId,@PathVariable String cartId){
		return service.subtractProductQuantity(productId,cartId);
	}
	@PostMapping("/addProduct/{productId}/{customerId}")
	public Cart addProduct(@PathVariable String productId,@PathVariable String customerId){
		return service.addProduct(productId,customerId);
	}

	/*@GetMapping("/getProductById/{productId}")
	public Items getProductById(@PathVariable String productId) {
		// Define the URL of the Product Service endpoint
		String productUrl = "http://localhost:8083/product/getById/" + productId;

		// Send a GET request and receive the response
		ResponseEntity<Items> response = restTemplate.exchange(
				productUrl, HttpMethod.GET, null, Items.class);

		Items item = response.getBody();
		Items savedItem = repo.save(item);
		return item;

	}*/

}
