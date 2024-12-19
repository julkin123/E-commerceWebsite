package com.ecommerce.Dto;

import com.ecommerce.model.MyUser;
import com.ecommerce.model.Product;

public class CartDto {
	private int cartId;
	private double price;
	private long quantity;

	private double subTotal;

	private MyUser user;

	private Product product;

	public int getCartId() {
		return cartId;
	}

	public void setCartId(int cartId) {
		this.cartId = cartId;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public long getQuantity() {
		return quantity;
	}

	public void setQuantity(long quantity) {
		this.quantity = quantity;
	}

	public double getSubTotal() {
		return subTotal;
	}

	public void setSubTotal(double subTotal) {
		this.subTotal = subTotal;
	}

	public MyUser getUser() {
		return user;
	}

	public void setUser(MyUser user) {
		this.user = user;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public CartDto(int cartId, double price, long quantity, double subTotal, MyUser user, Product product) {
		super();
		this.cartId = cartId;
		this.price = price;
		this.quantity = quantity;
		this.subTotal = subTotal;
		this.user = user;
		this.product = product;

	}

}
