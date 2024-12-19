package com.ecommerce.controller;

import java.nio.file.attribute.UserPrincipalNotFoundException;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.Dto.UserDto;
import com.ecommerce.model.MyUser;
import com.ecommerce.service.UserService;

@CrossOrigin
@RestController
@RequestMapping("/api")
public class UserController {
	@Autowired
	UserService userService;

	@GetMapping("/admin/getall")
	ResponseEntity<List<UserDto>> getAllUser() {

		List<UserDto> user = userService.getAllUser();

		return new ResponseEntity<List<UserDto>>(user, HttpStatus.OK);
	}

	@PostMapping("/register")
	ResponseEntity<UserDto> createUser(@RequestBody UserDto userDto) {

		return new ResponseEntity<UserDto>(userService.createUser(userDto), HttpStatus.OK);
	}

	@GetMapping("/admin/user/{userId}")
	ResponseEntity<UserDto> getUserById(@PathVariable int userId) {

		return new ResponseEntity<UserDto>(userService.getUserById(userId), HttpStatus.OK);
	}

	@DeleteMapping("/admin/user/{userId}")
	ResponseEntity<String> deleteUser(@PathVariable int userId) {
		userService.deleteUser(userId);
		return new ResponseEntity<String>("User Deleted", HttpStatus.OK);
	}

	@PutMapping("/user/{userId}")
	ResponseEntity<UserDto> updateUser(@PathVariable int userId, @RequestBody UserDto userDto) {

		return new ResponseEntity<UserDto>(userService.updteUser(userDto, userId), HttpStatus.OK);

	}

	@PostMapping("/authenticate/login")
	public ResponseEntity<String> login(@RequestBody UserDto user) throws UserPrincipalNotFoundException {
		String token = userService.verify(user);

		return new ResponseEntity<String>(token, HttpStatus.OK);

	}

}
