package com.ecommerce.Dto;

import java.util.Objects;

import com.ecommerce.model.MyUser;
import com.ecommerce.model.Product;

public class WatchListDto {

	private int id;

	private Product product;

	private MyUser user;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public MyUser getUser() {
		return user;
	}

	public void setUser(MyUser user) {
		this.user = user;
	}

	public WatchListDto(int id, Product product, MyUser user) {
		super();
		this.id = id;
		this.product = product;
		this.user = user;

	}

	@Override
	public int hashCode() {
		return Objects.hash(id, product, user);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		WatchListDto other = (WatchListDto) obj;
		return id == other.id && Objects.equals(product, other.product) && Objects.equals(user, other.user);
	}

}
