package com.msauth.service;

import com.msauth.model.OtpRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MailService {

    private final JavaMailSender mailSender;

    @Value("$(spring.mail.username)")
    private String fromMailId;

    public void sendEmail(OtpRequest request) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(request.getEmail());
        message.setSubject("OTP CONFIRMATION");
        message.setText(String.valueOf(request.getOtp()));
        message.setFrom(fromMailId);

        mailSender.send(message);
    }
}
