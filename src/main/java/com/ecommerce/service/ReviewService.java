package com.ecommerce.service;

import java.util.List;

import com.ecommerce.Dto.ReviewDto;
import com.ecommerce.Dto.ReviewUserDto;

public interface ReviewService {

	ReviewUserDto createReview(ReviewUserDto rewiew, int userId, int productId);

	ReviewDto updateReview(ReviewDto rewiew, int reviewId);

	void deleteReview(int rewiewId);

	List<ReviewDto> getallReviewByProdct(int productId);

}
