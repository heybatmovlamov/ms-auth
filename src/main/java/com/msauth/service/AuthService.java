package com.msauth.service;

import static com.msauth.exception.constant.ErrorMessage.EMAIL_OR_PASSWORD_IS_INCORRECT;
import static com.msauth.exception.constant.ErrorMessage.USER_NOT_FOUND;

import com.msauth.client.UserClient;
import com.msauth.client.model.UserView;
import com.msauth.exception.BadCredentialsException;
import com.msauth.exception.DataNotFoundException;
import com.msauth.model.OtpRequest;
import com.msauth.model.TokenResponse;
import com.msauth.model.UserRequest;
import com.msauth.security.JwtService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Slf4j
@RequiredArgsConstructor
@Service
public class AuthService {

    private final JwtService jwtService;
    private final PasswordEncoder passwordEncoder;
    private final OtpService otpService;
    private final UserClient userClient;

    public TokenResponse authenticate(OtpRequest request) {
        final String email = request.getEmail();
        final String otp = request.getOtp();

        otpService.verifyOtp(email, otp);

        final UserView user = userClient.getUserByEmail(email);

        final Authentication authentication = new UsernamePasswordAuthenticationToken(
                request.getEmail()
                , null
                , List.of(new SimpleGrantedAuthority(user.getRole().name())));

        return jwtService.generateToken(authentication);
    }

    public String validateUser(UserRequest signInRequest) {
        String email = signInRequest.getEmail();
        final UserView user = userClient.getUserByEmail(email);

        if (user == null) {
            throw DataNotFoundException.of(USER_NOT_FOUND);
        }

        if (!passwordEncoder.matches(signInRequest.getPassword(), user.getPassword())) {
            throw BadCredentialsException.of(EMAIL_OR_PASSWORD_IS_INCORRECT);
        }
        otpService.optSender(email);
        return "OTP sent to your email. Please verify.";
    }
}
