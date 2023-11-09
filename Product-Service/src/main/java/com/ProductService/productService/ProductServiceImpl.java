package com.ProductService.productService;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ProductService.Exception.ProductNotFoundException;
import com.ProductService.ProductRepository.ProductRepo;
import com.ProductService.productEntity.ProductEntity;

@Service
public class ProductServiceImpl implements ProductService{

	@Autowired
	private ProductRepo repo;

	@Override
	public ProductEntity save(ProductEntity product) {
		return repo.save(product);
	}

	@Override
	public List<ProductEntity> getAllProducts() {
		// TODO Auto-generated method stub
		return repo.findAll();
	}

	@Override
	public ProductEntity getById(String id) {
		// TODO Auto-generated method stub
		ProductEntity entity = repo.findById(id).orElse(null);
		return entity;
		
	}

	@Override
	public List<ProductEntity> findByProductCategory(String productCategory) {
		// TODO Auto-generated method stub
		return repo.findByProductCategory(productCategory);
	}
	
	@Override
	public String deleteId(String id) {
		// TODO Auto-generated method stub
		Optional<ProductEntity> entity = repo.findById(id);
		if(entity.isPresent()) {
			repo.deleteById(id);
			return "product deleted";
		}
			return "product not found";
	}
	
//	or
//	@Override
//	public ProductEntity deleteById(String productId) {
//		// TODO Auto-generated method stub
//		ProductEntity entity = repo.findById(productId).orElse(null);
//		if(entity == null) {
//			repo.delete(entity);
//			return entity;
//		}
//		else {
//			return null;
//		}
//	}

	@Override
	public ProductEntity updateProducts(String id, ProductEntity product) {
		// TODO Auto-generated method stub
		
		ProductEntity entity = repo.findById(id).orElse(null);
		
		entity.setDescription(product.getDescription());
		entity.setImage(product.getImage());
		entity.setPrice(product.getPrice());
		entity.setProductCategory(product.getProductCategory());
		entity.setProductName(product.getProductName());
		entity.setProductType(product.getProductType());
		entity.setRating(product.getRating());
		entity.setReview(product.getReview());
		entity.setSpecification(product.getSpecification());
		repo.save(entity);
		return entity;
	}
	
	@Override
	public ProductEntity updateByProductName(String productName, ProductEntity product) {
		// TODO Auto-generated method stub
		ProductEntity entity = repo.findByProductName(productName);
		entity.setProductName(product.getProductName());
		entity.setProductType(product.getProductType());
		entity.setProductCategory(product.getProductCategory());
		entity.setImage(product.getImage());
		entity.setPrice(product.getPrice());
		entity.setDescription(product.getDescription());
		repo.save(entity);
		return entity;
	}

	@Override
	public ProductEntity findByProductName(String productName) {
		// TODO Auto-generated method stub
		return repo.findByProductName(productName);
	}

	@Override
	public List<ProductEntity> findByProductType(String productType) {
		// TODO Auto-generated method stub
		return repo.findByProductType(productType);
	}

	

}
