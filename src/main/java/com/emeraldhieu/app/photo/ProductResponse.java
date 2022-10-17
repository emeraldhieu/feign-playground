package com.emeraldhieu.app.photo;

import lombok.Builder;
import lombok.Getter;
import lombok.extern.jackson.Jacksonized;

import java.util.List;

@Builder
@Getter
@Jacksonized
public class ProductResponse {

    private final List<Product> products;
}
