package com.emeraldhieu.app.product;

import java.util.List;

public interface ProductService {

    List<Product> getProducts();

    List<Product> failToGetProducts();
}
