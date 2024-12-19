package com.ecommerce.modelMapper;

import com.ecommerce.Dto.UserDto;
import com.ecommerce.model.MyUser;

public class UserModelMapper {

	public static MyUser dtoToEntity(UserDto userDto) {

		return new MyUser(userDto.getUserId(), userDto.getName(), userDto.getCountry(), userDto.getState(),
				userDto.getPincode(), userDto.getEmail(), userDto.getPassword(), userDto.getRole());

	}

	public static UserDto entityToDto(MyUser user) {

		return new UserDto(user.getUserId(), user.getName(), user.getCountry(), user.getState(), user.getPincode(),
				user.getEmail(), user.getPassword(), user.getRole());

	}

}
