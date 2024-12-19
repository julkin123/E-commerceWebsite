package com.ecommerce.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.Dto.CartListDto;
import com.ecommerce.service.CartListService;

@RestController
@RequestMapping("/api")
public class CartListController {
	@Autowired
	CartListService cartListService;

	@GetMapping("/user/{userId}/cartList")
	public ResponseEntity<CartListDto> getCartListByUserId(@PathVariable int userId) {

		return new ResponseEntity<CartListDto>(cartListService.getCartListByUserId(userId), HttpStatus.OK);
	}

}
