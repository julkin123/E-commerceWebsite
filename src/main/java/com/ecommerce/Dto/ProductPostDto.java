package com.ecommerce.Dto;

import java.util.Date;

public class ProductPostDto {

	private int productId;

	private String productName;

	private String description;

	private String ImageName;

	private Date createdDate;

	private double price;
	private long stock;
	private String imageUrl;

	public ProductPostDto() {
		super();

	}

	public ProductPostDto(int productId, String productName, String description, String imageName, Date createdDate,
			double price, long stock, String imageUrl) {
		super();
		this.productId = productId;
		this.productName = productName;
		this.description = description;
		ImageName = imageName;
		this.createdDate = createdDate;
		this.price = price;
		this.stock = stock;
		this.imageUrl = imageUrl;
	}

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

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

}
