package com.msauth.controller;

import com.msauth.client.UserClient;
import com.msauth.client.model.UserView;
import com.msauth.model.TokenResponse;
import com.msauth.model.UserRequest;
import com.msauth.service.AuthService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/v1/auth")
public class AuthController {

    private final AuthService service;
    private final UserClient userClient;

    @PostMapping("/authenticate")
    public ResponseEntity<TokenResponse> authenticate(@Valid @RequestBody UserRequest userRequest) {
        return ResponseEntity.ok(service.authenticate(userRequest));
    }

    @GetMapping("/test/{email}")
    public ResponseEntity<UserView> test(@PathVariable String email) {
        UserView userByEmail = userClient.getUserByEmail(email);
        return ResponseEntity.ok(userByEmail);
    }
}
