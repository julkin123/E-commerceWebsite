package com.ecommerce.service.serviceImpl;

import java.nio.file.attribute.UserPrincipalNotFoundException;


import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
 
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.ecommerce.Dto.UserDto;
import com.ecommerce.Exception.ResourceNotFoundException;
import com.ecommerce.Exception.UserAlreadyExistException;
import com.ecommerce.Exception.UserNotFoundException;
import com.ecommerce.config.JWTService;
import com.ecommerce.config.MyUSerDetailsService;
import com.ecommerce.model.MyUser;

import com.ecommerce.modelMapper.UserModelMapper;
import com.ecommerce.repo.UserRepo;
import com.ecommerce.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	UserRepo userRepo;
	@Autowired
	private MyUSerDetailsService myUSerDetailsService;

	@Autowired
	AuthenticationManager authenticationManager;
	@Autowired
	JWTService jwtservice;
	@Autowired
	PasswordEncoder encoder;

	@Override
	public UserDto createUser(UserDto userDto) {
		
		Optional<MyUser> userExist=userRepo.findByEmail(userDto.getEmail());
		
		if(userExist==null) {
			MyUser user = UserModelMapper.dtoToEntity(userDto);
			user.setPassword(encoder.encode(userDto.getPassword()));
			userRepo.save(user);
			return UserModelMapper.entityToDto(user);
	
			
		}
		else {
			throw new UserAlreadyExistException("User is already Exits");
		}
	}

	@Override
	public UserDto updteUser(UserDto userDto, int userId) {
		MyUser user = userRepo.findById(userId)
				.orElseThrow(() -> new UserNotFoundException("User not found with id:" + userId));

		user.setName(userDto.getName());
		user.setCountry(userDto.getCountry());
		user.setEmail(userDto.getEmail());
		if(userDto.getPassword().length()<50) {
			user.setPassword(encoder.encode(userDto.getPassword()));
		}else {
			user.setPassword(userDto.getPassword());
		}
		
		
		user.setPincode(userDto.getPincode());
		user.setState(userDto.getState());
		userRepo.save(user);

		return UserModelMapper.entityToDto(user);
	}

	@Override
	public List<UserDto> getAllUser() {
		List<MyUser> user = userRepo.findAll();
		List<UserDto> userdto = user.stream().map(users -> UserModelMapper.entityToDto(users))
				.collect(Collectors.toList());
		return userdto;
	}

	@Override
	public void deleteUser(int userId) {
		MyUser user = userRepo.findById(userId)
				.orElseThrow(() -> new UserNotFoundException("USer Not Exist with Id:" + userId));
		userRepo.delete(user);

	}

	@Override
	public UserDto getUserById(int userId) {
		MyUser user = userRepo.findById(userId)
				.orElseThrow(() -> new UserNotFoundException("User not Exist with Id:" + userId));
		return UserModelMapper.entityToDto(user);
	}

	public String verify(UserDto user) throws UserPrincipalNotFoundException {
		// TODO Auto-generated method stub
		Authentication authentication = authenticationManager
				.authenticate(new UsernamePasswordAuthenticationToken(user.getEmail(), user.getPassword()));

		if (authentication.isAuthenticated()) {
			return jwtservice.generateToken(myUSerDetailsService.loadUserByUsername(user.getEmail()));
		} else {
			throw new UserPrincipalNotFoundException("invalid");
		}

	}

}
