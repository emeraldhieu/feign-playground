package com.emeraldhieu.app.photo;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

/**
 * The first way of using feign that is via Spring Cloud Open Feign.
 */
@FeignClient(value = "photo", url = "https://jsonplaceholder.typicode.com", path = "photos",
    configuration = PhotoFeignConfiguration.class)
public interface PhotoClient {

    @GetMapping
    List<Photo> getPhotos();
}
