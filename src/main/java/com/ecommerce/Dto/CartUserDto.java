package com.ecommerce.Dto;

public class CartUserDto {
private double quantity;

public CartUserDto() {
	super();
	// TODO Auto-generated constructor stub
}

public CartUserDto(double quantity) {
	super();
	this.quantity = quantity;
}

public double getQuantity() {
	return quantity;
}

public void setQuantity(double quantity) {
	this.quantity = quantity;
}


}
