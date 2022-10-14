package com.emeraldhieu.app.post;

import feign.Logger;
import feign.RequestInterceptor;
import org.springframework.context.annotation.Bean;

public class PostFeignConfiguration {

    @Bean
    public RequestInterceptor requestInterceptor() {
        return template -> {
            if (template.method().equals("POST")) {
                template.header("Pizza", "Pepperoni");
            }
            template.header("Pasta", "Ravioli");
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
