package com.ecommerce.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ecommerce.model.Product;
import com.ecommerce.model.Review;

@Repository
public interface ReviewRepo extends JpaRepository<Review, Integer> {

	List<Review> findReviewByProduct(Product product);

}
