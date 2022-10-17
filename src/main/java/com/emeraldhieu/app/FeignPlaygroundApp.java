package com.emeraldhieu.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.retry.annotation.EnableRetry;

@EnableFeignClients
@EnableRetry
@SpringBootApplication
public class FeignPlaygroundApp {

    public static void main(String[] args) {
        SpringApplication.run(FeignPlaygroundApp.class, args);
    }
}
