package com.ecommerce.service.serviceImpl;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.ecommerce.Dto.CartDto;
import com.ecommerce.Dto.CartItemsDto;
import com.ecommerce.Dto.CategoryDto;
import com.ecommerce.Dto.FinalCartDto;
import com.ecommerce.Dto.ProductDto;
import com.ecommerce.Dto.UserDto;
import com.ecommerce.model.Cart;
import com.ecommerce.model.Category;
import com.ecommerce.model.MyUser;
import com.ecommerce.model.Product;
import com.ecommerce.modelMapper.CartModelMapper;
import com.ecommerce.repo.CartRepo;
import com.ecommerce.repo.CategoryRepo;
import com.ecommerce.repo.ProductRepo;
import com.ecommerce.repo.UserRepo;

class CartServiceImplTest {
	@InjectMocks
	private CartServiceImpl cartService;
	@Mock
	private CartRepo cartRepo;
	@Mock
	private UserRepo userRepo;
	@Mock
	private ProductRepo productRepo;
	@Mock
	private CategoryRepo categoryRepo;

	AutoCloseable autoCloseable;
	MyUser user;
	Product product;
	Category category;
	Cart cart;

	@BeforeEach
	void setUp() throws Exception {
		autoCloseable = MockitoAnnotations.openMocks(this);
		Date date = new Date();
		user = new MyUser();
		user.setUserId(1);
		user.setName("user");
		user.setCountry("Country name");
		user.setState("State name");
		user.setEmail("user@gmail.com");
		user.setPassword("user123");
		userRepo.save(user);

		category = new Category();
		category.setCategoryId(1);
		category.setCategoryName("Laptops");
		categoryRepo.save(category);

		product = new Product();
		product.setProductId(1);
		product.setCategory(category);
		product.setProductName("Dell");
		product.setDescription("Its good laptop");
		product.setUser(user);
		product.setStock(10);
		product.setPrice(20);
		product.setCreatedDate(date);
		productRepo.save(product);

		cart = new Cart();
		cart.setCartId(1);
		cart.setPrice(20);
		cart.setProduct(product);
		cart.setQuantity(10);
		cart.setUser(user);

	}

	@AfterEach
	void tearDown() throws Exception {
		autoCloseable.close();
	}

	@Test
	void testCreateCart() {
		when(userRepo.findById(1)).thenReturn(Optional.of(user));
		when(categoryRepo.findById(1)).thenReturn(Optional.of(category));
		when(productRepo.findById(1)).thenReturn(Optional.of(product));

		when(cartRepo.save(cart)).thenReturn(cart);

		CartDto cartDto = CartModelMapper.entityToDto(cart);

		CartDto result = cartService.createCart(cartDto, 1, 1);
		assertThat(result.getCartId()).isEqualTo(cartDto.getCartId());
		assertThat(result.getPrice()).isEqualTo(cartDto.getPrice());
		assertThat(result.getQuantity()).isEqualTo(cartDto.getQuantity());
		assertThat(result.getProduct().getProductName()).isEqualTo(cartDto.getProduct().getProductName());
		assertThat(result.getUser().getUserId()).isEqualTo(cartDto.getUser().getUserId());
	}

	@Test
	void testUpdateCart() {
		when(userRepo.findById(1)).thenReturn(Optional.of(user));
		when(categoryRepo.findById(1)).thenReturn(Optional.of(category));
		when(productRepo.findById(1)).thenReturn(Optional.of(product));
		when(cartRepo.findById(1)).thenReturn(Optional.of(cart));

		when(cartRepo.save(cart)).thenReturn(cart);

		CartDto cartDto = CartModelMapper.entityToDto(cart);

		CartDto result = cartService.updateCart(cartDto, 1);
		assertThat(result.getCartId()).isEqualTo(cartDto.getCartId());
		assertThat(result.getPrice()).isEqualTo(cartDto.getPrice());
		assertThat(result.getQuantity()).isEqualTo(cartDto.getQuantity());
		assertThat(result.getProduct().getProductName()).isEqualTo(cartDto.getProduct().getProductName());
		assertThat(result.getUser().getUserId()).isEqualTo(cartDto.getUser().getUserId());
		verify(cartRepo, times(1)).findById(1);
	}

	@Test
	void testDeleteCart() {

		cartRepo.delete(cart);
		verify(cartRepo, times(1)).delete(cart);
		
	}

	@Test
	void testGetCartByUser() {
		when(userRepo.findById(1)).thenReturn(Optional.of(user));
		when(cartRepo.findCartByUser(user)).thenReturn(new ArrayList<Cart>(Collections.singleton(cart)));

		when(cartRepo.findById(1)).thenReturn(Optional.of(cart));
//
//		when(cartRepo.save(cart)).thenReturn(cart);

		
		assertThat(cartService.getCartByUser(user.getUserId()).get(0).getCartId()).isEqualTo(cart.getCartId());
	}

	

}
