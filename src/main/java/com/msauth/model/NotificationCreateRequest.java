package com.msauth.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.msauth.model.enums.ChannelType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.validation.annotation.Validated;

@Data
@Builder
@Validated
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class NotificationCreateRequest {

    private ChannelType channelType;
    private String email;
    private String phoneNumber;
    private String otp;
}
