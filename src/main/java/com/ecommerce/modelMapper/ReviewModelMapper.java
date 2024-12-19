package com.ecommerce.modelMapper;

import com.ecommerce.Dto.ReviewDto;
import com.ecommerce.model.Review;

public class ReviewModelMapper {

	public static ReviewDto entityToDto(Review review) {

		return new ReviewDto(review.getReviewId(), review.getContent(), review.getUser(), review.getProduct());

	}

	public static Review dtoToEntity(ReviewDto review) {

		return new Review(review.getReviewId(), review.getContent(), review.getUser(), review.getProduct());

	}

}
