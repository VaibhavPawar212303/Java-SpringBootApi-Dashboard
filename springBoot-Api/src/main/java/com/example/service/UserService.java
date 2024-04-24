package com.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dto.LoginRequest;
import com.example.dto.LoginResponse;
import com.example.dto.RegisterRequest;
import com.example.entities.User;
import com.example.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;

	public LoginResponse loginUser(LoginRequest loginRequest) {
		String email = loginRequest.getEmail();
		String password = loginRequest.getPassword();

		if (email == null || email.isEmpty()) {
			throw new IllegalArgumentException("Please Add Email");
		} else if (password == null || password.isEmpty()) {
			throw new IllegalArgumentException("Please Add Password");
		}

		User user = userRepository.findByEmail(email);
		if (user != null && user.getPassword().equals(password)) {
			// String token = generateToken(user.getId());
			// return new LoginResponse(user, token);
			return new LoginResponse(user);
		} else {
			throw new IllegalArgumentException("Invalid email or password");
		}
	}
	
	public void registerUser(RegisterRequest registerRequest) {
        User user = new User();
        user.setFname(registerRequest.getFname());
        user.setLname(registerRequest.getLname());
        user.setEmail(registerRequest.getEmail());
        user.setPassword(registerRequest.getPassword());
        // You can add additional fields as needed
        
        userRepository.save(user);
    }
	
	
	

	// JWT Token Creation
//    private String generateToken(Long id) {
//        return jwtTokenUtil.generateToken(id);
//    }
}
