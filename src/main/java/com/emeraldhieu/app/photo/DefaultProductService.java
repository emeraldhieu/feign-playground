package com.emeraldhieu.app.photo;

import feign.FeignException;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class DefaultProductService implements ProductService {

    private final ProductClient productClient;

    @Override
    public List<Product> getProducts() {
        return productClient.getProducts().getProducts();
    }

    @Override
    @Retry(name = "productRetry", fallbackMethod = "retryFallback")
    @CircuitBreaker(name = "productCircuitBreaker", fallbackMethod = "circuitBreakerFallback")
    public List<Product> failToGetProducts() {
        /**
         * (1) After retrying a number of times, the request falls backs to {@link #retryFallback(FeignException)}.
         */
        log.info("Retrying to get products...");

        return productClient.failToGetProducts().getProducts();
    }

    public List<Product> retryFallback(FeignException exception) {
        log.info("Falling back to #retryFallback...");
        /**
         * (2) The fallbacks keeps throwing the exception to open the circuit breaker.
         */
        throw exception;
    }

    public List<Product> circuitBreakerFallback(FeignException exception) {
        /**
         * (3) The open circuit breaker falls back to a default result.
         */
        log.info("Falling back to #circuitBreakerFallback...");
        return List.of(Product.builder()
            .id(42)
            .description("default")
            .title("default")
            .build());
    }
}
