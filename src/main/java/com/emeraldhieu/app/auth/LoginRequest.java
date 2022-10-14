package com.emeraldhieu.app.auth;

import lombok.Builder;

@Builder
public class LoginRequest {
    private final String username;
    private final String password;
}
