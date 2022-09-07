package com.revature.gymapp.api.dto.security;

import lombok.Data;

@Data
public class RegistrationRequest {

    private String username;
    private String password;
}
