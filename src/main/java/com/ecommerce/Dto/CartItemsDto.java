package com.ecommerce.Dto;

import com.ecommerce.model.Cart;
import com.ecommerce.model.Product;

public class CartItemsDto {
	private int id;

	private double subTotal;

	private Product product;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getSubTotal() {
		return subTotal;
	}

	public void setSubTotal(double subTotal) {
		this.subTotal = subTotal;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public CartItemsDto(int id, double subTotal, Product product) {
		super();
		this.id = id;
		this.subTotal = subTotal;
		this.product = product;
	}

	public CartItemsDto(Cart cart) {

		this.id = cart.getCartId();
		this.subTotal = cart.getSubTotal();
		this.product = cart.getProduct();
	}

	public CartItemsDto() {

	}

}
