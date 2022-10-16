package com.emeraldhieu.app.post;

import io.github.resilience4j.circuitbreaker.CircuitBreakerConfig;
import io.github.resilience4j.timelimiter.TimeLimiterConfig;
import org.springframework.cloud.circuitbreaker.resilience4j.Resilience4JCircuitBreakerFactory;
import org.springframework.cloud.circuitbreaker.resilience4j.Resilience4JConfigBuilder;
import org.springframework.cloud.client.circuitbreaker.Customizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.Duration;

@Configuration
public class DefaultPostFeignConfiguration {

    @Bean
    public Customizer<Resilience4JCircuitBreakerFactory> defaultResilience() {
        return factory -> {
            factory.configureDefault(id -> new Resilience4JConfigBuilder(id)
                /**
                 * Change default request timeout of all time limiters.
                 * See https://docs.spring.io/spring-cloud-circuitbreaker/docs/current/reference/html/#default-configuration
                 * See https://github.com/resilience4j/resilience4j/blob/master/resilience4j-timelimiter/src/main/java/io/github/resilience4j/timelimiter/TimeLimiterConfig.java#L14
                 * Otherwise, the request fails with TimeoutException.
                 * See https://github.com/resilience4j/resilience4j/blob/master/resilience4j-timelimiter/src/main/java/io/github/resilience4j/timelimiter/internal/TimeLimiterImpl.java#L51
                 */
                .timeLimiterConfig(TimeLimiterConfig.custom()
                    .timeoutDuration(Duration.ofSeconds(10))
                    .build())
                .circuitBreakerConfig(CircuitBreakerConfig.ofDefaults())
                .build());
        };
    }
}
