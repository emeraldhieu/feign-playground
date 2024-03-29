package com.emeraldhieu.app.product;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("products")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Product> listProducts() {
        return productService.getProducts();
    }

    @GetMapping("failed")
    @ResponseStatus(HttpStatus.OK)
    public List<Product> failToListProducts() {
        return productService.failToGetProducts();
    }
}
