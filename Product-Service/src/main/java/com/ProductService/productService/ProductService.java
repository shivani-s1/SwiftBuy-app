package com.ProductService.productService;

import java.util.List;

import com.ProductService.productEntity.ProductEntity;

public interface ProductService {

	ProductEntity save(ProductEntity product);

	List<ProductEntity> getAllProducts();

	ProductEntity getById(String id);

	String deleteId(String id);

	ProductEntity updateProducts(String productId, ProductEntity product);

	List<ProductEntity> findByProductCategory(String productCategory);

	ProductEntity findByProductName(String productName);

	List<ProductEntity> findByProductType(String productType);

	ProductEntity updateByProductName(String productName, ProductEntity product);



	
}
