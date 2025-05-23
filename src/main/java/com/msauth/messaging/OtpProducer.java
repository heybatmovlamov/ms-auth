package com.msauth.messaging;

import com.msauth.model.NotificationCreateRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class OtpProducer {

    private final RabbitTemplate rabbitTemplate;

    public void sendOtpMessage(NotificationCreateRequest message) {
        rabbitTemplate.convertAndSend("otp.exchange", "otp.routing.key", message);
    }
}
