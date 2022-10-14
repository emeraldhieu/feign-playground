package com.emeraldhieu.app.auth;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;

@FeignClient(name = "auth", url = "https://dummyjson.com", path = "auth",
    configuration = AuthFeignConfiguration.class)
public interface AuthClient {

    @PostMapping("/login")
    LoginResponse login(@RequestHeader("Content-type") String requestHeader,
                        @RequestBody LoginRequest loginRequest);
}
