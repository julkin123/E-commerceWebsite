package com.ecommerce.service;

import java.util.List;

import com.ecommerce.Dto.CartDto;
import com.ecommerce.Dto.CartUserDto;
import com.ecommerce.Dto.FinalCartDto;

public interface CartService {
	// item added to cart
	void createCart(CartUserDto cartdto, int userId, int productId);

	// item update
	CartDto updateCart(CartDto cartDto, int cartId);

	// remove item from cart
	void deleteCart(int cartId);

	// get caertitems By User
	List<CartDto> getCartByUser(int userId);

	FinalCartDto getFinalCartByUser(int userId);
}
