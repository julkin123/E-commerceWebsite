package com.ecommerce.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.Dto.ReviewDto;

import com.ecommerce.service.ReviewService;

import org.springframework.web.bind.annotation.GetMapping;

@RestController
@RequestMapping("/api")
public class ReviewController {
	@Autowired
	ReviewService reviewService;

	@PostMapping("user/{userId}/product/{productId}/review")
	public ResponseEntity<ReviewDto> createReview(@RequestBody ReviewDto reviewDto, @PathVariable int userId,
			@PathVariable int productId) {

		return new ResponseEntity<ReviewDto>(reviewService.createReview(reviewDto, userId, productId),
				HttpStatus.CREATED);

	}

	@PutMapping("user/product/review/{reviewId}")
	public ResponseEntity<ReviewDto> updateReview(@RequestBody ReviewDto reviewDto, @PathVariable int reviewId) {

		return new ResponseEntity<ReviewDto>(reviewService.updateReview(reviewDto, reviewId), HttpStatus.OK);
	}

	@DeleteMapping("user/product/review/{reviewId}")
	public ResponseEntity<String> deleteReview(@PathVariable int reviewId) {

		reviewService.deleteReview(reviewId);

		return new ResponseEntity<String>("review deleted", HttpStatus.OK);

	}

	@GetMapping("user/product/{productId}/review")
	public ResponseEntity<List<ReviewDto>> getAllReviewByProduct(@PathVariable int productId) {
		return new ResponseEntity<List<ReviewDto>>(reviewService.getallReviewByProdct(productId), HttpStatus.OK);
	}

}
