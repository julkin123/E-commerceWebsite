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
import org.springframework.security.crypto.password.PasswordEncoder;

import com.ecommerce.Dto.UserDto;
import com.ecommerce.model.MyUser;
import com.ecommerce.modelMapper.UserModelMapper;
import com.ecommerce.repo.UserRepo;

class UserServiceImplTest {
	@Mock
	private UserRepo userRepo;
	@InjectMocks
	private UserServiceImpl userService;
	MyUser user;
	AutoCloseable autoCloseable;
	@Mock
	private PasswordEncoder encoder;

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
	}

	@AfterEach
	void tearDown() throws Exception {
		autoCloseable.close();
	}

	@Test
	void testCreateUser() {
		
		when(userRepo.save(user)).thenReturn(user);
		UserDto userDto=UserModelMapper.entityToDto(user);
		UserDto result=userService.createUser(userDto);
		assertThat(result).isEqualTo(userDto);
	
		
	}

	@Test
	void testUpdteUser() {
		when(userRepo.findById(1)).thenReturn(Optional.of(user));
		UserDto userDto=UserModelMapper.entityToDto(user);
		UserDto result=userService.updteUser(userDto,1);
		assertThat(result).isEqualTo(userDto);
	}

	@Test
	void testGetAllUser() {
		when(userRepo.findAll()).thenReturn(
				new ArrayList<MyUser>( Collections.singleton(user)));
		assertThat(userService.getAllUser().get(0).getEmail()).isEqualTo(user.getEmail());
		
		
	}

	@Test
	void testDeleteUser() {
		userRepo.delete(user);
		verify(userRepo,times(1)).delete(user);
		
		
	}

	@Test
	void testGetUserById() {
		   when(userRepo.findById(1)).thenReturn(Optional.of(user));
		   assertEquals(userService.getUserById(1).getEmail(), user.getEmail());
		
	}

}
