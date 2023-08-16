package com.tvt.lifungbetest.service;

import com.tvt.lifungbetest.dto.user.LoginRequest;
import com.tvt.lifungbetest.dto.user.SignupRequest;
import org.springframework.http.ResponseEntity;

public interface AuthService {
    ResponseEntity<?> authenticateUser(LoginRequest loginRequest);

    ResponseEntity<?> registerUser(SignupRequest signupRequest);

    ResponseEntity<?> logoutUser();
}
