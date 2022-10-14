package com.emeraldhieu.app.auth;

import feign.RequestInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;

public class AuthFeignConfiguration {

    @Bean
    public RequestInterceptor requestInterceptor() {
        return template -> {
            template.header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE);
            template.header("A-Header-That-Auth-Requests-Should-Have", "Whatever");
        };
    }
}
