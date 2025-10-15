package com.olp.service;

import com.olp.dto.AuthResponse;
import com.olp.dto.LoginRequest;

public interface AuthService {
    AuthResponse login(LoginRequest loginRequest);
}
