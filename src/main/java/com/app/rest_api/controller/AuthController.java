package com.app.rest_api.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import com.app.rest_api.dto.LoginRequest;
import com.app.rest_api.dto.RegisterRequest;
import com.app.rest_api.model.User;
import com.app.rest_api.service.UserService;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("/auth")
@CrossOrigin(origins = "http://localhost:5173")
public class AuthController {

    private final UserService userService;
    private final PasswordEncoder encoder;

    @PostMapping("/register")
    public ResponseEntity<User> register(@RequestBody RegisterRequest request) {
        User user = userService.register(request.getUsername(), request.getPassword());
        return ResponseEntity.ok(user);
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest request) {
        User user = userService.findByUsername(request.getUsername());
        if (user != null && encoder.matches(request.getPassword(), user.getPassword())) {
            return ResponseEntity.ok("Login successful ✅");
        }
        return ResponseEntity.status(401).body("Invalid credentials ❌");
    }
}

