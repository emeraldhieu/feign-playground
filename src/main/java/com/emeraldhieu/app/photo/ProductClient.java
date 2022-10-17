package com.emeraldhieu.app.photo;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * The first way of using feign that is via Spring Cloud Open Feign.
 */
@FeignClient(value = "photo", url = "https://dummyjson.com",
    configuration = ProductFeignConfiguration.class)
public interface ProductClient {

    @GetMapping("/products")
    ProductResponse getProducts();

    /**
     * Assuming getting all products fails due to 500.
     */
    @GetMapping("/http/500")
    ProductResponse failToGetProducts();
}
