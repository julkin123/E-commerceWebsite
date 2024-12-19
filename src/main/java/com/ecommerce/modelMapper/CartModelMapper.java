package com.ecommerce.modelMapper;

import com.ecommerce.Dto.CartDto;

import com.ecommerce.model.Cart;

public class CartModelMapper {

	public static Cart dtoToEntity(CartDto cartDto) {

		return new Cart(cartDto.getCartId(), cartDto.getPrice(), cartDto.getQuantity(), cartDto.getSubTotal(),
				cartDto.getUser(), cartDto.getProduct());
	}

	public static CartDto entityToDto(Cart cart) {

		return new CartDto(cart.getCartId(), cart.getPrice(), cart.getQuantity(), cart.getSubTotal(), cart.getUser(),
				cart.getProduct());
	}

}
