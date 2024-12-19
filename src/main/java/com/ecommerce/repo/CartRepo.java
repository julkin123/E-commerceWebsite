package com.ecommerce.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ecommerce.model.Cart;
import com.ecommerce.model.MyUser;

@Repository
public interface CartRepo extends JpaRepository<Cart, Integer> {

	List<Cart> findCartByUser(MyUser user);

}
