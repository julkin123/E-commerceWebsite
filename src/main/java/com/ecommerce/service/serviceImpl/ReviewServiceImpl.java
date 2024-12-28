package com.ecommerce.service.serviceImpl;

import java.util.List;

import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.Dto.ReviewDto;
import com.ecommerce.Dto.ReviewUserDto;
import com.ecommerce.Exception.ProductNotFoundException;
import com.ecommerce.Exception.ResourceNotFoundException;
import com.ecommerce.Exception.UserNotFoundException;
import com.ecommerce.model.MyUser;
import com.ecommerce.model.Product;
import com.ecommerce.model.Review;

import com.ecommerce.modelMapper.ReviewModelMapper;
import com.ecommerce.repo.ProductRepo;
import com.ecommerce.repo.ReviewRepo;
import com.ecommerce.repo.UserRepo;
import com.ecommerce.service.ReviewService;

@Service
public class ReviewServiceImpl implements ReviewService {
	@Autowired
	ReviewRepo reviewRepo;
	@Autowired
	ProductRepo productRepo;
	@Autowired
	UserRepo userRepo;

	@Override
	public ReviewUserDto createReview(ReviewUserDto rewiewDto, int userId, int productId) {

		Product product = productRepo.findById(productId)
				.orElseThrow(() -> new ProductNotFoundException("Product is not exist with id:" + productId));
		MyUser user = userRepo.findById(userId)
				.orElseThrow(() -> new UserNotFoundException("user is not exist with id:" + userId));
		Review review = new Review();
		review.setReviewId(rewiewDto.getReviewId());
		review.setContent(rewiewDto.getContent());
		review.setProduct(product);
		review.setUser(user);

		Review review2= reviewRepo.save(review);
		
		ReviewUserDto reviewDto1=new ReviewUserDto();
		reviewDto1.setReviewId(review2.getReviewId());
		reviewDto1.setContent(review2.getContent());

		return reviewDto1;
	}

	@Override
	public ReviewDto updateReview(ReviewDto rewiewDto, int reviewId) {
		Review review = reviewRepo.findById(reviewId)
				.orElseThrow(() -> new ResourceNotFoundException("review is not exist with Id:" + reviewId));
		review.setContent(rewiewDto.getContent());
		reviewRepo.save(review);

		return ReviewModelMapper.entityToDto(review);
	}

	@Override
	public void deleteReview(int rewiewId) {
		reviewRepo.deleteById(rewiewId);

	}

	@Override
	public List<ReviewDto> getallReviewByProdct(int productId) {
		Product product = productRepo.findById(productId)
				.orElseThrow(() -> new ProductNotFoundException("product is not exist with Id:" + productId));
		List<Review> reviews = reviewRepo.findReviewByProduct(product);
		List<ReviewDto> reviewDto = reviews.stream().map((review) -> ReviewModelMapper.entityToDto(review))
				.collect(Collectors.toList());
		return reviewDto;
	}

}
