package com.ProductService.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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

import com.ProductService.productEntity.ProductEntity;
import com.ProductService.productService.ProductService;



@RestController
@RequestMapping("/product")
@CrossOrigin(origins = "*")
public class ProductController {

	@Autowired
	private ProductService service;
	
	@PostMapping("/save")
	public ResponseEntity<ProductEntity> addProducts(@RequestBody ProductEntity product) {
		ProductEntity productTemp = service.save(product);
	return new ResponseEntity<ProductEntity>(productTemp,HttpStatus.CREATED);
	}
	
	@GetMapping("/findall")
	public List<ProductEntity> getAllProducts(){
		return service.getAllProducts();
	}
	
	@GetMapping("/getById/{id}")
		public ProductEntity getById(@PathVariable String id) {
			return service.getById(id);
		}
	
	@GetMapping("/getByName/{productName}")
	public ProductEntity getByName(@PathVariable String productName) {
		return service.findByProductName(productName);
	}
	
	@GetMapping("/getByCategory/{productCategory}")
	public List<ProductEntity> getByProductCategory(@PathVariable String productCategory) {
		return service.findByProductCategory(productCategory);
	}
	
	@GetMapping("/getByType/{productType}")
	public List<ProductEntity> getByType(@PathVariable String productType) {
		return service.findByProductType(productType);
	}
	
	@DeleteMapping("/deleteById/{id}")
	public String deleteId(@PathVariable String id) {
		 return service.deleteId(id);
	}
	
	@PutMapping("/update/{id}")
	public ProductEntity updateProducts(@PathVariable String id , @RequestBody ProductEntity product) {
		return service.updateProducts(id,product);
	}
	
	@PutMapping("/updateByName/{productName}")
	public ProductEntity updateByProductName(@PathVariable String productName, @RequestBody ProductEntity product) {
		return service.updateByProductName(productName, product);
	}
	
}
