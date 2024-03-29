package com.emeraldhieu.app.auth;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DefaultAuthService implements AuthService {

    private final AuthClient authClient;

    @Override
    public LoginResponse login(LoginRequest loginRequest) {
        return authClient.login(loginRequest);
    }
}
