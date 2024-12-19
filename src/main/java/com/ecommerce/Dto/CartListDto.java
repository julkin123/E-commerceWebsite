package com.ecommerce.Dto;

import java.util.HashSet;

import java.util.Set;

import com.ecommerce.model.Cart;
import com.ecommerce.model.MyUser;

public class CartListDto {

	private int cartListId;
	private double total;

	private MyUser user;
	private Set<Cart> cart = new HashSet<>();

	public int getCartListId() {
		return cartListId;
	}

	public void setCartListId(int cartListId) {
		this.cartListId = cartListId;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	public MyUser getUser() {
		return user;
	}

	public void setUser(MyUser user) {
		this.user = user;
	}

	public Set<Cart> getCart() {
		return cart;
	}

	public void setCart(Set<Cart> cart) {
		this.cart = cart;
	}

	public CartListDto(int cartListId, double total, MyUser user, Set<Cart> cart) {
		super();
		this.cartListId = cartListId;
		this.total = total;
		this.user = user;
		this.cart = cart;
	}

//	public CartListDto(int cartListId, long total, User user) {
//		super();
//		this.cartListId = cartListId;
//		this.total = total;
//		this.user = user;
//	}
//	

}
