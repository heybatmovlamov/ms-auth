package com.msauth.model;

import com.msauth.model.enums.ChannelType;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class ValidateRequest {

    @NotBlank
    private String email;

    @NotBlank
    private String password;

    @NotNull
    private ChannelType channelType;

    private String phoneNumber;
}
