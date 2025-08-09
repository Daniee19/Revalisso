package com.revalisso.backend.service;

import com.revalisso.backend.dto.ChangePasswordRequest;
import com.revalisso.backend.dto.LoginRequest;
import com.revalisso.backend.dto.RegisterRequest;
import org.springframework.http.ResponseEntity;


public interface IAuthService {

    public ResponseEntity<?> register(RegisterRequest request);
    public String login(LoginRequest request);
    public boolean changePassword(ChangePasswordRequest request);
}
