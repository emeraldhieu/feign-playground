package com.emeraldhieu.app.photo;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

/**
 * The first way of using feign that is via Spring Cloud Open Feign.
 */
@FeignClient(value = "photo", url = "https://dummyjson.com",
    configuration = ProductFeignConfiguration.class)
public interface ProductClient {

    @GetMapping("products")
    ProductResponse getProducts();
}
