package com.ProductService.ProductRepository;

import java.util.List;
import java.util.Optional;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.ProductService.productEntity.ProductEntity;
@Repository
public interface ProductRepo extends MongoRepository<ProductEntity, String>{

	List<ProductEntity> findByProductCategory(String productCategory);

	ProductEntity findByProductName(String productName);

	List<ProductEntity> findByProductType(String productType);

//	void deleteById(Optional<ProductEntity> entity);

	

}
