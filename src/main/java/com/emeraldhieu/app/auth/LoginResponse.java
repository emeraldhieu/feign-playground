package com.emeraldhieu.app.auth;

import lombok.Builder;
import lombok.Getter;
import lombok.extern.jackson.Jacksonized;

@Builder
@Getter
@Jacksonized
public class LoginResponse {

    private final String id;
    private final String username;
    private final String email;
    private final String firstName;
    private final String lastName;
    private final String gender;
    private final String image;
    private final String token;
}
