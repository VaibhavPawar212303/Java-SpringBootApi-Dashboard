package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.dto.LoginRequest;
import com.example.dto.RegisterRequest;
import com.example.service.UserService;

@RestController
public class UserController {

	@Autowired
	private UserService userService;

	@PostMapping("/login")
	public ResponseEntity<?> loginUser(@RequestBody LoginRequest loginRequest) {
		try {
			return ResponseEntity.ok(userService.loginUser(loginRequest));
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Internal Server Error");
		}
	}

	@PostMapping("/register")
	public ResponseEntity<?> registerUser(@RequestBody RegisterRequest registerRequest) {
		try {
			userService.registerUser(registerRequest);
			return ResponseEntity.ok("User registered successfully");
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Internal Server Error");
		}
	}
}
