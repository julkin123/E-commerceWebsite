package com.ecommerce.Dto;

public class ReviewUserDto {
	
	int reviewId;
	String content;
	public ReviewUserDto() {
		super();
		// TODO Auto-generated constructor stub
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
	public ReviewUserDto(int reviewId, String content) {
		super();
		this.reviewId = reviewId;
		this.content = content;
	}
	
	

}
