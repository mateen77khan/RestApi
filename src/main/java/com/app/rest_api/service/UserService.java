package com.app.rest_api.service;

import java.util.List;
import java.util.Optional;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.app.rest_api.model.User;
import com.app.rest_api.repo.UserRepo;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class UserService {

    private final UserRepo userRepo;
    private final PasswordEncoder encoder;

    public User register(String username, String rawPassword) {
        User user = new User();
        user.setUsername(username);
        user.setPassword(encoder.encode(rawPassword));
        return userRepo.save(user);
    }

    public User findByUsername(String username) {
        return userRepo.findByUsername(username).orElse(null);
    }

	public User save(User user) {
		return userRepo.save(user);
	}

	public List<User> findAll() {
		return userRepo.findAll();
	}

	public User findById(Long id) {
		return userRepo.findById(id).orElseThrow();
	}

	public void deleteById(Long id) {
		userRepo.deleteById(id);
	}
    
    
}

