package com.revature.gymapp.api.dto.security;

import lombok.Data;

@Data
public class AuthenticationRequest {

    private String username;
    private String password;
}
