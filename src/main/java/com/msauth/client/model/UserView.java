package com.msauth.client.model;

import com.msauth.client.model.enums.UserRole;
import com.msauth.client.model.enums.UserStatus;
import lombok.Data;

@Data
public class UserView {

    private Long id;
    private String username;
    private String email;
    private UserRole role;
    private UserStatus status;
    private String password;
}
