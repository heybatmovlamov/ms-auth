package com.msauth.model;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class UserRequest {

    @NotBlank
    private String email;

    @NotBlank
    private String password;
}
