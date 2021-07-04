package com.adtech.ecommerce.controller;

import com.adtech.ecommerce.domain.request.LoginRequest;
import com.adtech.ecommerce.domain.request.SignupRequest;
import com.adtech.ecommerce.security.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private AuthService authService;

    @PostMapping("/login")
    public ResponseEntity login(@RequestBody LoginRequest loginRequest) {
        return ResponseEntity.ok(authService.login(loginRequest));
    }

    @PostMapping("/signup")
    public ResponseEntity signup(@RequestBody SignupRequest signUpRequest) {
        return ResponseEntity.ok(authService.signUp(signUpRequest));
    }
}
