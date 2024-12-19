package com.ecommerce.config;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.ecommerce.model.MyUser;
import com.ecommerce.repo.UserRepo;

import org.springframework.security.core.userdetails.User;

@Component
public class MyUSerDetailsService implements UserDetailsService {
	@Autowired
	UserRepo userRepo;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		Optional<MyUser> user = userRepo.findByEmail(username);
		if (user.isPresent()) {
			var userobj = user.get();
			return User.builder().username(userobj.getEmail()).password(userobj.getPassword()).roles(getRoles(userobj))
					.build();

		} else {
			throw new UsernameNotFoundException(username);
		}
	}

	private String[] getRoles(MyUser user) {
		if (user.getRole() == null) {
			return new String[] { "USER" };
		}

		return user.getRole().split(",");

	}

}
