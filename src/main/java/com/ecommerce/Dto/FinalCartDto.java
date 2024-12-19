package com.ecommerce.Dto;

import java.util.List;

public class FinalCartDto {
	private List<CartItemsDto> fullCartItems;
	private long totalAmount;

	public List<CartItemsDto> getFullCartItems() {
		return fullCartItems;
	}

	public void setFullCartItems(List<CartItemsDto> fullCartItems) {
		this.fullCartItems = fullCartItems;
	}

	public long getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(long totalAmount) {
		this.totalAmount = totalAmount;
	}

	public FinalCartDto(List<CartItemsDto> fullCartItems, long totalAmount) {
		super();
		this.fullCartItems = fullCartItems;
		this.totalAmount = totalAmount;
	}

}
