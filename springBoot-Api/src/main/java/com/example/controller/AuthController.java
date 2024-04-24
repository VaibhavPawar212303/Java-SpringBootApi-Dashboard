//package com.example.controller;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RestController;
//
//import com.example.dto.JwtTokenUtil;
//import com.example.dto.LoginRequest;
//import com.example.dto.LoginResponse;
//
//@RestController
//public class AuthController {
//
//	@Autowired
//	private JwtTokenUtil jwtTokenUtil;
//
//	@PostMapping("/login")
//	public ResponseEntity<LoginResponse> login(@RequestBody LoginRequest loginRequest) {
//		// Your login logic
//		Long userId = 123L; // Assuming you retrieve the user ID after successful login
//		String token = generateToken(userId);
//		// Return the response with user and token
//	}
//
//	private String generateToken(Long id) {
//		return jwtTokenUtil.generateToken(id);
//	}
//}
