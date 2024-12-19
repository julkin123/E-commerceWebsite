package com.ecommerce.service;

import java.nio.file.attribute.UserPrincipalNotFoundException;
import java.util.List;

import com.ecommerce.Dto.UserDto;

public interface UserService {

	UserDto createUser(UserDto userDto);

	UserDto updteUser(UserDto userDto, int userId);

	List<UserDto> getAllUser();

	UserDto getUserById(int userId);

	void deleteUser(int userId);

	String verify(UserDto user) throws UserPrincipalNotFoundException;

}
