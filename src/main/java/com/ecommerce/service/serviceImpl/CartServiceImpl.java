package com.ecommerce.service.serviceImpl;

import java.util.ArrayList;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.Dto.CartDto;
import com.ecommerce.Dto.CartItemsDto;
import com.ecommerce.Dto.CartListDto;
import com.ecommerce.Dto.CartUserDto;
import com.ecommerce.Dto.FinalCartDto;
import com.ecommerce.Exception.CartNotFoundException;
import com.ecommerce.Exception.ProductNotFoundException;
import com.ecommerce.Exception.ResourceNotFoundException;
import com.ecommerce.Exception.UserNotFoundException;
import com.ecommerce.model.Cart;
import com.ecommerce.model.CartList;
import com.ecommerce.model.MyUser;
import com.ecommerce.model.Product;

import com.ecommerce.modelMapper.CartListModelMapper;
import com.ecommerce.modelMapper.CartModelMapper;
import com.ecommerce.repo.CartRepo;
import com.ecommerce.repo.ProductRepo;
import com.ecommerce.repo.UserRepo;
import com.ecommerce.service.CartService;

@Service
public class CartServiceImpl implements CartService {
	@Autowired
	UserRepo userRepo;
	@Autowired
	ProductRepo productRepo;

	@Autowired
	CartRepo cartRepo;

	@Override
	public void createCart(CartUserDto cartdto, int userId, int productId) {
		MyUser user = userRepo.findById(userId)
				.orElseThrow(() -> new UserNotFoundException("User is not exist with id:" + userId));
		Product product = productRepo.findById(productId)
				.orElseThrow(() -> new ProductNotFoundException("User is not exist with id:" + productId));

		Cart cart = new Cart();
		cart.setProduct(product);
		cart.setPrice(product.getPrice());
		cart.setQuantity(cartdto.getQuantity());
		cart.setSubTotal(product.getPrice() * cartdto.getQuantity());
		cart.setUser(user);
		cartRepo.save(cart);

		
	}

	@Override
	public CartDto updateCart(CartDto cartDto, int cartId) {
		Cart cart = cartRepo.findById(cartId)
				.orElseThrow(() -> new CartNotFoundException("item is not exist with id:" + cartId));

		cart.setQuantity(cartDto.getQuantity());
		cart.setSubTotal(cart.getPrice() * cartDto.getQuantity());
		cartRepo.save(cart);

		return CartModelMapper.entityToDto(cart);
	}

	@Override
	public void deleteCart(int cartId) {
		Cart cart = cartRepo.findById(cartId)
				.orElseThrow(() -> new CartNotFoundException("item is not exist with id:" + cartId));

		cartRepo.deleteById(cartId);
	}

	@Override
	public List<CartDto> getCartByUser(int userId) {
		MyUser user = userRepo.findById(userId)
				.orElseThrow(() -> new UserNotFoundException("User is not exist with id:" + userId));
		List<Cart> carts = cartRepo.findCartByUser(user);
		List<CartDto> cartDto = carts.stream().map((cart) -> CartModelMapper.entityToDto(cart))
				.collect(Collectors.toList());

		return cartDto;
	}

	@Override
	public FinalCartDto getFinalCartByUser(int userId) {
		long total = 0;
		MyUser user = userRepo.findById(userId)
				.orElseThrow(() -> new UserNotFoundException("User is not exist with id:" + userId));
		List<Cart> CartList = cartRepo.findCartByUser(user);

		List<CartItemsDto> cartItems = new ArrayList<>();

		for (Cart cart : CartList) {

			CartItemsDto cartItemsDto = new CartItemsDto(cart);
			total += cart.getSubTotal();
			cartItems.add(cartItemsDto);
		}

		FinalCartDto cartDto = new FinalCartDto(cartItems, total);
		cartDto.setTotalAmount(total);
		cartDto.setFullCartItems(cartItems);

		return cartDto;

	}

}
