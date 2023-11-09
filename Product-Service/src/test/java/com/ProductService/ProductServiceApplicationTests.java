package com.ProductService;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
//import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
//import org.springframework.test.context.junit4.SpringRunner;

import com.ProductService.ProductRepository.ProductRepo;
import com.ProductService.productEntity.ProductEntity;
import com.ProductService.productService.ProductService;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class ProductServiceApplicationTests {

	@Autowired
	private ProductService service;
	
	@MockBean
	private ProductRepo repo;
	
	
	ProductEntity samples = new ProductEntity(
	        "Smart Tv",                 // productName
	        "6524f9139a6df91de2592ee4", // productId
	        "Electronic",               // productType
	        "Tv",                       // productCategory
	        Map.of(1, 4.5),             // rating (as a Map)
	        Map.of(1, "Good product"),  // review (as a Map)
	        List.of("https://m.media-amazon.com/images/I/71d5fMDvq9L._AC_UF1000,1000_QL80_.jpg"), // image (as a List)
	        40000.0,                    // price
	        "OnePlus 80 cm (32 inches) Y Series HD Ready LED Smart Android TV 32Y1 (Black)", // description
	        Map.of("watch", "Android")  // specification (as a Map)
	    );
	
	@Test
	@DisplayName("Get product by Id")
	public void getByIdTest() {
		
	    Optional<ProductEntity> product = Optional.of(samples);
	    String productId = "6524f9139a6df91de2592ee4";
	    when(repo.findById(productId)).thenReturn(product);
	    ProductEntity retrivedProduct = service.getById(productId);
	    assertEquals(samples, retrivedProduct);
	}
	
	@Test
	@DisplayName("Get product by name")
	public void getByNameTest() {
	    String productName = "Smart Tv";
	    when(repo.findByProductName(productName)).thenReturn(samples);
	    ProductEntity retrievedProduct = service.findByProductName(productName);
	    assertEquals(samples, retrievedProduct);
	}
	
	@Test
	@DisplayName("Get product by category")
	public void getByProductCategoryTest() {
	    String productCategory = "Tv";
	    
	    // Create a list containing the 'samples' object
	    List<ProductEntity> productList = Collections.singletonList(samples);
	    
	    // Configure the behavior of the 'repo' mock to return the list when 'findByProductCategory' is called
	    when(repo.findByProductCategory(productCategory)).thenReturn(productList);
	    
	    // Call the service method that retrieves products by product category
	    List<ProductEntity> retrievedProducts = service.findByProductCategory(productCategory);
	    
	    // Perform assertions to verify that the retrieved products match the expected ones
	    assertEquals(productList, retrievedProducts);
	}
	
	@Test
	@DisplayName("Get product by type")
	public void findByProductTypeTest() {
		String productType = "Electronic";
	    List<ProductEntity> productList = Collections.singletonList(samples);
	    when(repo.findByProductType(productType)).thenReturn(productList);
	    List<ProductEntity> retrievedProducts = service.findByProductType(productType);
	    assertEquals(productList, retrievedProducts);
	}
	
	@Test
    @DisplayName("Delete product by Id")
    public void deleteByIdTest() {
        String productId = "6524f9139a6df91de2592ee4";
        ProductEntity sampleProduct = new ProductEntity();
        Optional<ProductEntity> optionalProduct = Optional.of(sampleProduct);

        // Mock the repository to return the product when findById is called
        when(repo.findById(productId)).thenReturn(optionalProduct);

        // Call the deleteId method with the sample product ID
        String result = service.deleteId(productId);

        // Verify that the 'repo.deleteById' method was called with the sample product ID
        verify(repo).deleteById(productId);

        // Verify the result is as expected (e.g., "product deleted" or "product not found")
        assertEquals("product deleted", result);
    }



	@Test
	@DisplayName("Update product by Id")
	public void updateProductsTest() {
		 String productId = "6524f9139a6df91de2592ee4";
	        when(repo.findById(productId)).thenReturn(Optional.of(samples));
	        ProductEntity result = service.updateProducts(productId, samples);
	        verify(repo).save(samples);
	        assertEquals(samples, result);
	}
	
	@Test
	@DisplayName("Add product")
	public void testAddProducts() {
        service.save(samples);
        verify(repo).save(samples);
	}

	@Test
	@DisplayName("Get all the products")
	public void getAllProductsTest() {
	    
	    // Convert the ProductEntity object to a List
	    List<ProductEntity> productList = Collections.singletonList(samples);

	    // Mock the behavior of the repository to return the List<ProductEntity> when findAll is called
	    when(repo.findAll()).thenReturn(productList);

	 // Call the service method that retrieves all products
	    List<ProductEntity> retrievedProducts = service.getAllProducts();

	    // Perform assertions to verify that the retrieved products match the expected ones
	    assertEquals(productList, retrievedProducts);
	
	}
	
	
	
	
	
	
}
