package com.ecommerce.repo;

import java.util.Optional;

import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ecommerce.model.MyUser;

@Repository
public interface UserRepo extends JpaRepository<MyUser, Integer> {

	Optional<MyUser> findByEmail(String email);

}
