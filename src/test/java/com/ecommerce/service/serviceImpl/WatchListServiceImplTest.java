package com.ecommerce.service.serviceImpl;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Optional;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.ecommerce.Dto.WatchListDto;
import com.ecommerce.model.Cart;
import com.ecommerce.model.Category;
import com.ecommerce.model.MyUser;
import com.ecommerce.model.Product;
import com.ecommerce.model.WatchList;
import com.ecommerce.modelMapper.WatchListModelMapper;
import com.ecommerce.repo.ProductRepo;
import com.ecommerce.repo.UserRepo;
import com.ecommerce.repo.WatchListRepo;


class WatchListServiceImplTest {
	@InjectMocks
	private WatchListServiceImpl watchListService;
	@Mock
	private WatchListRepo watchListRepo;
	@Mock
	UserRepo userRepo;
	@Mock
	ProductRepo productRepo;
	AutoCloseable autoCloseable;
	private Product product;
	private MyUser user;
	private WatchList watchList;

	@BeforeEach
	void setUp() throws Exception {
		autoCloseable=MockitoAnnotations.openMocks(this);
		
		
		user = new MyUser();
		user.setUserId(1);
		user.setName("user");
		user.setCountry("Country name");
		user.setState("State name");
		user.setEmail("user@gmail.com");
		
		userRepo.save(user);

		
		product = new Product();
		product.setProductId(1);
		
		product.setProductName("Dell");
		product.setDescription("Its good laptop");
		product.setUser(user);
		product.setStock(10);
		product.setPrice(20);
		
		productRepo.save(product);
		
		watchList =new WatchList();
		watchList.setId(1);
		watchList.setProduct(product);
		watchList.setUser(user);
	}

	@AfterEach
	void tearDown() throws Exception {
		autoCloseable.close();
	}

	@Test
	void testCreateWatchList() {
		  when(userRepo.findById(1)).thenReturn(Optional.of(user));
		  when(productRepo.findById(1)).thenReturn(Optional.of(product));
		when(watchListRepo.save(watchList)).thenReturn(watchList);
		
		WatchListDto watchListDto=WatchListModelMapper.entityToDto(watchList);
		

		
		WatchListDto result=watchListService.createWatchList(1,1);
		result.setId(1);
		
		assertThat(result.getId()).isEqualTo(watchListDto.getId());
		assertThat(result.getProduct().getProductId()).isEqualTo(watchListDto.getProduct().getProductId());
		assertThat(result.getUser().getUserId()).isEqualTo(watchListDto.getUser().getUserId());
	
	
		
	}

	@Test
	void testDeleteWatchList() {
		watchListRepo.delete(watchList);
		verify(watchListRepo,times(1)).delete(watchList);
		
	}

	@Test
	void testGetWatchListByUser() {
		when(userRepo.findById(1)).thenReturn(Optional.of(user));
		
		when(watchListRepo.getWatchListByUser(user)).thenReturn(new ArrayList<WatchList>(Collections.singleton(watchList)));

		assertThat(watchListService.getWatchListByUser(1).get(0).getId()).isEqualTo(watchList.getId());
	}

}
