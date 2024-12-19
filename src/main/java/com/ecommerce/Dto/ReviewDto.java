package com.ecommerce.Dto;

import com.ecommerce.model.MyUser;

import com.ecommerce.model.Product;

public class ReviewDto {
	private int reviewId;
	private String content;

	private MyUser user;

	private Product product;

	public int getReviewId() {
		return reviewId;
	}

	public void setReviewId(int reviewId) {
		this.reviewId = reviewId;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public MyUser getUser() {
		return user;
	}

	public void setUser(MyUser user) {
		this.user = user;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public ReviewDto(int reviewId, String content, MyUser user, Product product) {
		super();
		this.reviewId = reviewId;
		this.content = content;
		this.user = user;
		this.product = product;
	}

}
