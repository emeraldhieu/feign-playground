package com.emeraldhieu.app.auth;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController("auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @GetMapping("login")
    public LoginResponse login(@RequestBody LoginRequest loginRequest) {
        return authService.login("", loginRequest);
    }
}
