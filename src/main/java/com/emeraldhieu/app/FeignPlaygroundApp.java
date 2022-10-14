package com.emeraldhieu.app;

import com.emeraldhieu.app.photo.PhotoFeignConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;

@EnableFeignClients()
@SpringBootApplication
@ComponentScan(excludeFilters = {
    @ComponentScan.Filter(type = FilterType.ASSIGNABLE_TYPE, classes = {
        PhotoFeignConfiguration.class
    })
})
public class FeignPlaygroundApp {

    public static void main(String[] args) {
        SpringApplication.run(FeignPlaygroundApp.class, args);
    }
}
