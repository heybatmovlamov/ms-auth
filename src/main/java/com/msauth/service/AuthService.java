package com.msauth.service;

import com.msauth.model.TokenResponse;
import com.msauth.model.UserRequest;
import com.msauth.security.JwtService;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

@Slf4j
@Data
@RequiredArgsConstructor
@Service
public class AuthService {

    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    public TokenResponse authenticate(UserRequest signInRequest) {
        var authToken = new UsernamePasswordAuthenticationToken(
                signInRequest.getEmail(),
                signInRequest.getPassword());
        final Authentication authentication = authenticationManager.authenticate(authToken);
        return jwtService.generateToken(authentication);
    }
}
