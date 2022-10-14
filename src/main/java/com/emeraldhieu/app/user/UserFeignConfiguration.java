package com.emeraldhieu.app.user;

import feign.Feign;
import feign.Logger;
import feign.jackson.JacksonDecoder;
import feign.jackson.JacksonEncoder;
import feign.slf4j.Slf4jLogger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UserFeignConfiguration {

    @Bean
    public UserClient userClient() {
        /**
         * Since Open Feign doesn't have a name,
         * headers and logging level can't be configured via application.yml.
         * They all have to be set here.
         */
        return Feign.builder()
            .encoder(new JacksonEncoder())
            .decoder(new JacksonDecoder())
            .logger(new Slf4jLogger(UserClient.class))
            .logLevel(Logger.Level.FULL)
            .target(UserClient.class, "https://dummyjson.com/users");
    }
}
