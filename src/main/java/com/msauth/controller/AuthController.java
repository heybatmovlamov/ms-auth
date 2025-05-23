package com.msauth.controller;

import com.msauth.model.AuthenticateRequest;
import com.msauth.model.TokenResponse;
import com.msauth.model.ValidateRequest;
import com.msauth.service.AuthService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/v1/auth")
public class AuthController {

    private final AuthService service;

    @PostMapping("/authenticate")
    public ResponseEntity<TokenResponse> authenticate(@Valid @RequestBody AuthenticateRequest userRequest) {
        return ResponseEntity.ok(service.authenticate(userRequest));
    }

    @PostMapping("/validate")
    public ResponseEntity<String> validate(@Valid @RequestBody ValidateRequest validateRequest) {
        return ResponseEntity.ok(service.validateUser(validateRequest));
    }
}
