package com.ecommerce.service.serviceImpl;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Optional;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.ecommerce.Dto.CartDto;
import com.ecommerce.Dto.ReviewDto;
import com.ecommerce.Dto.ReviewUserDto;
import com.ecommerce.model.Category;
import com.ecommerce.model.MyUser;
import com.ecommerce.model.Product;
import com.ecommerce.model.Review;
import com.ecommerce.model.WatchList;
import com.ecommerce.modelMapper.CartModelMapper;
import com.ecommerce.modelMapper.ReviewModelMapper;
import com.ecommerce.repo.CategoryRepo;
import com.ecommerce.repo.ProductRepo;
import com.ecommerce.repo.ReviewRepo;
import com.ecommerce.repo.UserRepo;

class ReviewServiceImplTest {
	@Mock
	private ReviewRepo reviewRepo;
	@Mock
	private CategoryRepo categoryRepo;
	@Mock
	private UserRepo userRepo;
	@Mock
	private ProductRepo productRepo;
	@InjectMocks
	private ReviewServiceImpl reviewService;
	AutoCloseable autoCloseable;
	private Review review;
	
	private MyUser user;
	private Product product;

	private Category category;
	@BeforeEach
	void setUp() throws Exception {
		autoCloseable = MockitoAnnotations.openMocks(this);
		user=new MyUser();
		user.setUserId(1);
		user.setName("user");
		user.setCountry("Country name");
		user.setState("State name");
		user.setEmail("user@gmail.com");

		userRepo.save(user);
		
		category = new Category();
		category.setCategoryId(1);
		category.setCategoryName("Laptops");
		categoryRepo.save(category);

		product=new Product();
	
		product.setProductId(1);
		product.setCategory(category);
		product.setProductName("Dell");
		product.setDescription("Its good laptop");
		product.setUser(user);
		product.setStock(10);
		product.setPrice(20);
		
		productRepo.save(product);
		
		review=new Review();
		review.setReviewId(1);
		review.setContent("good laptop");
		review.setProduct(product);
		review.setUser(user);
		
	}

	@AfterEach
	void tearDown() throws Exception {
		autoCloseable.close();
	}

//	@Test
//	void testCreateReview() {
//		when(userRepo.findById(1)).thenReturn(Optional.of(user));
//		when(categoryRepo.findById(1)).thenReturn(Optional.of(category));
//		when(productRepo.findById(1)).thenReturn(Optional.of(product));
//
//		when(reviewRepo.save(review)).thenReturn(review);
//
//		ReviewDto reviewDto = ReviewModelMapper.entityToDto(review);
//		ReviewUserDto reviewUserDto=new ReviewUserDto();
//		reviewUserDto.setReviewId(reviewDto.getReviewId());
//		reviewUserDto.setContent(reviewDto.getContent());
//
//		ReviewUserDto result = reviewService.createReview(reviewUserDto,1,1);
//		assertThat(result.getReviewId()).isEqualTo(review.getReviewId());
//		
//		assertThat(result.getContent()).isEqualTo(review.getContent());
////		assertThat(result.getProduct().getProductName()).isEqualTo(reviewDto.getProduct().getProductName());
////		assertThat(result.getUser().getUserId()).isEqualTo(reviewDto.getUser().getUserId());
//// 
//	}

	@Test
	void testUpdateReview() {
		 
		 
		when(reviewRepo.findById(1)).thenReturn(Optional.of(review));

		when(reviewRepo.save(review)).thenReturn(review);

		ReviewDto reviewDto = ReviewModelMapper.entityToDto(review);

		ReviewDto result = reviewService.updateReview(reviewDto,1);
		assertThat(result.getReviewId()).isEqualTo(review.getReviewId());
		
		assertThat(result.getContent()).isEqualTo(review.getContent());
		
	}

	@Test
	void testDeleteReview() {
		when(reviewRepo.findById(1)).thenReturn(Optional.of(review));
	 reviewRepo.delete(review);
	 verify(reviewRepo,times(1)).delete(review);
		
	}

	@Test
	void testGetallReviewByProdct() {
when(productRepo.findById(1)).thenReturn(Optional.of(product));
		
		when(reviewRepo.findReviewByProduct(product)).thenReturn(new ArrayList<Review>(Collections.singleton(review)));

		assertThat(reviewService.getallReviewByProdct(1).get(0).getReviewId()).isEqualTo(review.getReviewId());
	 
	}

}
