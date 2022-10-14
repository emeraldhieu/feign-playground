package com.emeraldhieu.app.auth;

import lombok.Builder;
import lombok.Getter;
import lombok.extern.jackson.Jacksonized;

@Builder
@Getter
@Jacksonized
public class LoginRequest {
    private final String username;
    private final String password;
}
