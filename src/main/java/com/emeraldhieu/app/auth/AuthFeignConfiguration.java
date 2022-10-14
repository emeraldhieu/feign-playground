package com.emeraldhieu.app.auth;

import feign.Logger;
import feign.RequestInterceptor;
import org.springframework.context.annotation.Bean;

public class AuthFeignConfiguration {

    @Bean
    public RequestInterceptor requestInterceptor() {
        return template -> {
            template.header("Pizza", "Pepperoni");
        };
    }

    /**
     * See https://docs.spring.io/spring-cloud-openfeign/docs/current/reference/html/#feign-logging
     */
    @Bean
    Logger.Level logLevel() {
        return Logger.Level.FULL;
    }
}
