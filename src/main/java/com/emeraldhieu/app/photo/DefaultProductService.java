package com.emeraldhieu.app.photo;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DefaultProductService implements ProductService {

    private final ProductClient productClient;

    @Override
    public List<Product> getProducts() {
        return productClient.getProducts().getProducts();
    }
}
