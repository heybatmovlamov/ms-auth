package com.msauth.client.model;

import java.util.List;
import lombok.Data;

@Data
public class UserView {
    private final String email;
    private final String password;
    private final List<String> role;
}
