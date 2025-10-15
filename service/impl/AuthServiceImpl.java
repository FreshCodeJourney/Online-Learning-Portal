package com.olp.service.impl;

import com.olp.dto.AuthResponse;
import com.olp.dto.LoginRequest;
import com.olp.entity.User;
import com.olp.exception.ResourceNotFoundException;
import com.olp.repository.UserRepository;
import com.olp.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthServiceImpl implements AuthService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public AuthResponse login(LoginRequest loginRequest) {
        // Find user by email
        Optional<User> userOptional = userRepository.findByEmail(loginRequest.getEmail());
        
        if (userOptional.isEmpty()) {
            throw new ResourceNotFoundException("User not found with email: " + loginRequest.getEmail());
        }
        
        User user = userOptional.get();
        
        // Verify password (in production, use password encoder)
        if (!user.getPassword().equals(loginRequest.getPassword())) {
            throw new RuntimeException("Invalid password");
        }
        
        // Check if user is active
        if (user.getActive() == null || !user.getActive()) {
            throw new RuntimeException("User account is not active");
        }
        
        // Create response
        AuthResponse response = new AuthResponse();
        response.setId(user.getId());
        response.setFullName(user.getFullName());
        response.setEmail(user.getEmail());
        response.setRole(user.getRole());
        response.setMessage("Login successful");
        
        // In production, generate and set JWT token here
        // response.setToken(jwtService.generateToken(user));
        
        return response;
    }
}
