package com.ecommerce.service.serviceImpl;

import java.util.List;

import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.annotation.Immutable;
import org.springframework.stereotype.Service;

import com.ecommerce.Dto.CartListDto;
import com.ecommerce.Exception.ResourceNotFoundException;
import com.ecommerce.model.Cart;
import com.ecommerce.model.CartList;
import com.ecommerce.model.MyUser;

import com.ecommerce.modelMapper.CartListModelMapper;
import com.ecommerce.modelMapper.CartModelMapper;
//import com.ecommerce.repo.CartListRep;
import com.ecommerce.repo.CartRepo;
import com.ecommerce.repo.UserRepo;
import com.ecommerce.service.CartListService;

@Service
public class CartListImpl implements CartListService {

	@Override
	public CartListDto createCartList(int userId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CartListDto updateList(CartListDto cartListDto, int cartListId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CartListDto getCartListByUserId(int userId) {
		// TODO Auto-generated method stub
		return null;
	}
//	@Autowired
//	UserRepo userRepo;
//	@Autowired
//	CartRepo cartRepo;
//	@Autowired
//	CartListRep cartListRepo;
//	
//
//	@Override
//	public CartListDto updateList(CartListDto cartListDto, int cartListId) {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public CartListDto createCartList(int userId) {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
////	@Override
////	public CartListDto getCartListByUserId(int userId) {
////		// TODO Auto-generated method stub
////		return null;
////	}
//
//	@Override
//	public CartListDto getCartListByUserId(int userId) {
//		double total = 0 ;
//		MyUser user=userRepo.findById(userId).orElseThrow(()-> new ResourceNotFoundException("user is not exist"));
//		List<Cart> carts=cartRepo.findCartByUser(user);
//		List<Double> subTotals=carts.stream().map((cart)->cart.getSubTotal()).collect(Collectors.toList());
//		
//	        for (int i = 0; i < subTotals.size(); i++)
//	            total += subTotals.get(i);
//	        
//		CartList cartList=new CartList();
//		Set<Cart> cars=carts.stream().collect(Collectors.toSet());
//
//		cartList.setTotal(total);
//		cartList.setUser(user);
////		String cart=cartListRepo.findOne("julkin");
////		System.out.println(cart);
//		cartListRepo.save(cartList);
//		
//		
//	CartListDto cartListDto	=CartListModelMapper.entityToDto(cartList);
//	cartListDto.setCart(cars);
//				
//		
//		
//		
//		
//		return cartListDto ;
//	}

}
