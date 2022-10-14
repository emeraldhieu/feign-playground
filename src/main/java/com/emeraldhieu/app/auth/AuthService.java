package com.emeraldhieu.app.auth;

public interface AuthService {

    LoginResponse login(String header, LoginRequest loginRequest);
}
