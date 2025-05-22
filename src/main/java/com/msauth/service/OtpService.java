package com.msauth.service;

import static com.msauth.exception.constant.ErrorMessage.OTP_DOES_NOT_MATCH;
import static com.msauth.exception.constant.ErrorMessage.OTP_IS_EXPIRED_OR_NOT_FOUND;

import com.msauth.dao.EmailOtpRepository;
import com.msauth.exception.InputMismatchException;
import com.msauth.exception.OtpExpiredException;
import com.msauth.messaging.OtpProducer;
import com.msauth.model.OtpRequest;
import java.security.SecureRandom;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class OtpService {
    private final OtpProducer otpProducer;
    private final EmailOtpRepository emailOtpRepository;

    private String generateOtp() {
        return String.format("%06d", new SecureRandom().nextInt(1000000));
    }

    public void optSender(String email) {
        final String otp = generateOtp();

        OtpRequest message = OtpRequest.builder()
                .email(email)
                .otp(otp).build();

        emailOtpRepository.save(email, otp);
        otpProducer.sendOtpMessage(message);
    }


    public void verifyOtp(String email, String otp) {
        String storedOtp = emailOtpRepository.read(email);

        if (storedOtp == null) {
            throw OtpExpiredException.of(OTP_IS_EXPIRED_OR_NOT_FOUND);
        }

        if (!otp.equals(storedOtp)) {
            throw InputMismatchException.of(OTP_DOES_NOT_MATCH);
        }

        emailOtpRepository.delete(email);
    }

}