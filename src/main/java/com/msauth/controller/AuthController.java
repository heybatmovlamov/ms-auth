package com.msauth.controller;

import lombok.RequiredArgsConstructor;
import com.msauth.model.TokenResponse;
import com.msauth.model.UserRequest;
import com.msauth.service.AuthService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/v1/auth")
public class AuthController {

    private final AuthService service;

    @PostMapping("/authenticate")
    public ResponseEntity<TokenResponse> authenticate(UserRequest userRequest) {
        return ResponseEntity.ok(service.authenticate(userRequest));
    }
}
