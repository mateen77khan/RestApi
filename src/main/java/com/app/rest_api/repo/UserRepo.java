package com.app.rest_api.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.rest_api.model.User;

public interface UserRepo extends JpaRepository<User, Long>{
	Optional<User> findByUsername(String username);
}
