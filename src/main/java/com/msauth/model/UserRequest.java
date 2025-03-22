package com.msauth.model;

import lombok.Data;

@Data
public class UserRequest {
    private String email;
    private String password;
}
