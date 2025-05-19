package com.msauth.service;

import com.msauth.messaging.OtpProducer;
import com.msauth.model.OtpRequest;
import java.security.SecureRandom;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class OtpService {
    private final OtpProducer otpProducer;

    private String generateOtp() {
        return String.format("%06d", new SecureRandom().nextInt(1000000));
    }

    public void optSender(String email) {
        final String otp = generateOtp();

        OtpRequest message = OtpRequest.builder()
                .email(email)
                .otp(otp).build();

        otpProducer.sendOtpMessage(message);
    }

    public boolean verifyOtp(String email, String otp) {
        return true;
    }
}