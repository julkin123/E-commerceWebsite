package com.ecommerce.Dto;

import java.util.Date;

import com.ecommerce.model.Category;
import com.ecommerce.model.MyUser;

public class ProductDto {

	private int productId;

	private String productName;

	private String description;

	private String ImageName;

	private Date createdDate;

	private double price;
	private long stock;

	private Category category;

	private MyUser user;
	private String imageUrl;

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getImageName() {
		return ImageName;
	}

	public void setImageName(String imageName) {
		ImageName = imageName;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public long getStock() {
		return stock;
	}

	public void setStock(long stock) {
		this.stock = stock;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public MyUser getUser() {
		return user;
	}

	public void setUser(MyUser user) {
		this.user = user;
	}

	public ProductDto(int productId, String productName, String description, String imageName, Date createdDate,
			double price, long stock, Category category, MyUser user, String imageUrl) {
		super();
		this.productId = productId;
		this.productName = productName;
		this.description = description;
		ImageName = imageName;
		this.createdDate = createdDate;
		this.price = price;
		this.stock = stock;
		this.category = category;
		this.user = user;
		this.imageUrl = imageUrl;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

//	public ProductDto(int productId, String productName, String description, String imageName, Date createdDate,
//			long price, long stock, Set<Review> review, Category category, User user, Set<Cart> cart) {
//		super();
//		this.productId = productId;
//		this.productName = productName;
//		this.description = description;
//		ImageName = imageName;
//		this.createdDate = createdDate;
//		this.price = price;
//		this.stock = stock;
//		this.review = review;
//		this.category = category;
//		this.user = user;
//		this.cart = cart;
//	}

//	public Set<Cart> getCart() {
//		return cart;
//	}
//
//	public void setCart(Set<Cart> cart) {
//		this.cart = cart;
//	}

}
