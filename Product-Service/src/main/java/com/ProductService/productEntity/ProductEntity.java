package com.ProductService.productEntity;

import java.util.List;
import java.util.Map;
import java.util.Objects;

import javax.persistence.Id;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;



@Document
public class ProductEntity {

	private String productName;
	@Id
	private String id;
	private String productType;
	private String productCategory;
	private Map<Integer,Double> rating;
	private Map<Integer,String> review;
	private List<String> image;
	private double price;
	private String description;
	private Map<String,String> specification;
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getProductId() {
		return id;
	}
	public void setProductId(String id) {
		this.id = id;
	}
	public String getProductType() {
		return productType;
	}
	public void setProductType(String productType) {
		this.productType = productType;
	}
	public String getProductCategory() {
		return productCategory;
	}
	public void setProductCategory(String productCategory) {
		this.productCategory = productCategory;
	}
	public Map<Integer, Double> getRating() {
		return rating;
	}
	public void setRating(Map<Integer, Double> rating) {
		this.rating = rating;
	}
	public Map<Integer, String> getReview() {
		return review;
	}
	public void setReview(Map<Integer, String> review) {
		this.review = review;
	}
	public List<String> getImage() {
		return image;
	}
	public void setImage(List<String> image) {
		this.image = image;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Map<String, String> getSpecification() {
		return specification;
	}
	public void setSpecification(Map<String, String> specification) {
		this.specification = specification;
	}
	public ProductEntity(String productName, String id, String productType, String productCategory,
			Map<Integer, Double> rating, Map<Integer, String> review, List<String> image, double price,
			String description, Map<String, String> specification) {
		super();
		this.productName = productName;
		this.id = id;
		this.productType = productType;
		this.productCategory = productCategory;
		this.rating = rating;
		this.review = review;
		this.image = image;
		this.price = price;
		this.description = description;
		this.specification = specification;
	}
	public ProductEntity() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "ProductEntity [productName=" + productName + ", productId=" + id + ", productType=" + productType
				+ ", productCategory=" + productCategory + ", rating=" + rating + ", review=" + review + ", image="
				+ image + ", price=" + price + ", description=" + description + ", specification=" + specification
				+ "]";
	}
	@Override
	public int hashCode() {
		return Objects.hash(description, image, price, productCategory, id, productName, productType, rating,
				review, specification);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ProductEntity other = (ProductEntity) obj;
		return Objects.equals(description, other.description) && Objects.equals(image, other.image)
				&& Double.doubleToLongBits(price) == Double.doubleToLongBits(other.price)
				&& Objects.equals(productCategory, other.productCategory) && id == other.id
				&& Objects.equals(productName, other.productName) && Objects.equals(productType, other.productType)
				&& Objects.equals(rating, other.rating) && Objects.equals(review, other.review)
				&& Objects.equals(specification, other.specification);
	}
	
	
}
