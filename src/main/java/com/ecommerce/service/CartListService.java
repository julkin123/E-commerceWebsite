package com.ecommerce.service;

import com.ecommerce.Dto.CartListDto;

public interface CartListService {

	// create cartList
	CartListDto createCartList(int userId);

	// update cartLit
	CartListDto updateList(CartListDto cartListDto, int cartListId);

	// remove from cartList
	// get by userIFd
	CartListDto getCartListByUserId(int userId);

}
