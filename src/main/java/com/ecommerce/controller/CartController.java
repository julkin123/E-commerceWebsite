package com.ecommerce.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.Dto.CartDto;
import com.ecommerce.Dto.FinalCartDto;
import com.ecommerce.service.CartService;

@RestController
@RequestMapping("/api")
public class CartController {
	@Autowired
	CartService cartService;

	@PostMapping("/user/{userId}/product/{productId}/cart")
	public ResponseEntity<CartDto> createCart(@RequestBody CartDto cartdto, @PathVariable int userId,
			@PathVariable int productId) {

		return new ResponseEntity<CartDto>(cartService.createCart(cartdto, userId, productId), HttpStatus.CREATED);
	}

	@PutMapping("/user/cart/{cartId}")
	public ResponseEntity<CartDto> updateCart(@RequestBody CartDto cartDto, @PathVariable int cartId) {

		return new ResponseEntity<CartDto>(cartService.updateCart(cartDto, cartId), HttpStatus.OK);
	}

	@DeleteMapping("/user/cart/{cartId}")
	public ResponseEntity<String> deleteCart(@PathVariable int cartId) {
		cartService.deleteCart(cartId);

		return new ResponseEntity<String>("cart item removed", HttpStatus.OK);
	}

	// @GetMapping("user/{userId}/cart")
	public ResponseEntity<List<CartDto>> getCartByUser(@PathVariable int userId) {

		return new ResponseEntity<List<CartDto>>(cartService.getCartByUser(userId), HttpStatus.OK);
	}

	@GetMapping("/user/{userId}/cart")
	public ResponseEntity<FinalCartDto> getFinalCartByUser(@PathVariable int userId) {
		FinalCartDto finalCartDto = cartService.getFinalCartByUser(userId);

		return new ResponseEntity<FinalCartDto>(finalCartDto, HttpStatus.OK);
	}

}
