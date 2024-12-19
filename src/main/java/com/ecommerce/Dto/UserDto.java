package com.ecommerce.Dto;

import java.util.Objects;

public class UserDto {

	private int userId;

	private String name;
	private String country;
	private String state;
	private int pincode;
	private String email;
	private String password;
	private String role;

	public UserDto() {
		super();
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public UserDto(int userId, String name, String country, String state, int pincode, String email, String password,
			String role) {
		super();
		this.userId = userId;
		this.name = name;
		this.country = country;
		this.state = state;
		this.pincode = pincode;
		this.email = email;
		this.password = password;
		this.role = role;
	}

	@Override
	public int hashCode() {
		return Objects.hash(country, email, name, password, pincode, role, state, userId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UserDto other = (UserDto) obj;
		return Objects.equals(country, other.country) && Objects.equals(email, other.email)
				&& Objects.equals(name, other.name) && Objects.equals(password, other.password)
				&& pincode == other.pincode && Objects.equals(role, other.role) && Objects.equals(state, other.state)
				&& userId == other.userId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public UserDto(int userId, String name, String country, String state, int pincode, String email, String password) {
		super();
		this.userId = userId;
		this.name = name;
		this.country = country;
		this.state = state;
		this.pincode = pincode;
		this.email = email;
		this.password = password;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public int getPincode() {
		return pincode;
	}

	public void setPincode(int pincode) {
		this.pincode = pincode;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
