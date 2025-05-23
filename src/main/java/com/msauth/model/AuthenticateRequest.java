package com.msauth.model;

import jakarta.validation.constraints.NotBlank;
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
public class AuthenticateRequest {

    @NotBlank
    private String email;

    @NotBlank
    private String password;

    @NotBlank
    private String otp;
}
