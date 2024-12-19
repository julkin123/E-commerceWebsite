package com.ecommerce.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import jakarta.persistence.ManyToOne;

import jakarta.persistence.Table;

@Entity
@Table(name = "review")
@JsonIdentityInfo(generator = ObjectIdGenerators.IntSequenceGenerator.class, property = "reviewId")
public class Review {

	@Id
	@Column(name = "review_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int reviewId;
	private String content;
	@ManyToOne
	private MyUser user;
	@ManyToOne
	private Product product;

	public Review(int reviewId, String content, MyUser user, Product product) {
		super();
		this.reviewId = reviewId;
		this.content = content;
		this.user = user;
		this.product = product;
	}

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

	public Review() {
		super();
	}

}
