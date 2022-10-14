package com.emeraldhieu.app.user;

import lombok.Builder;
import lombok.Getter;
import lombok.extern.jackson.Jacksonized;

@Builder
@Getter
@Jacksonized
public class User {

    private final String id;
    private final String firstName;
    private final String lastName;
    private final int age;
    private final String username;
    private final String password;
}
