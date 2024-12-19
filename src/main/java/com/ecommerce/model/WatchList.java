package com.ecommerce.model;

 

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
 
import jakarta.persistence.ManyToOne;
 
import jakarta.persistence.Table;

@Entity
@Table(name = "watch_list")

public class WatchList {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	@ManyToOne()
	private Product product;
	@ManyToOne
	private MyUser user;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public WatchList() {
		super();

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

	public WatchList(int id, Product product, MyUser user) {
		super();
		this.id = id;
		this.product = product;
		this.user = user;
	}

}
