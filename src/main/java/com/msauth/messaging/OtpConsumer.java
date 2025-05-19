package com.msauth.messaging;

import com.msauth.model.OtpRequest;
import com.msauth.service.MailService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class OtpConsumer {

    private final MailService emailService;

    @RabbitListener(queues = "otp.queue")
    public void consumeOtp(OtpRequest otpRequest) {
        log.info("Consuming OTP request: {}", otpRequest);
        emailService.sendEmail(otpRequest);
    }
}
