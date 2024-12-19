package com.ecommerce.service;

import java.util.List;

import com.ecommerce.Dto.ReviewDto;

public interface ReviewService {

	ReviewDto createReview(ReviewDto rewiew, int userId, int productId);

	ReviewDto updateReview(ReviewDto rewiew, int reviewId);

	void deleteReview(int rewiewId);

	List<ReviewDto> getallReviewByProdct(int productId);

}
