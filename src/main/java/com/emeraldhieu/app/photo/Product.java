package com.emeraldhieu.app.photo;

import lombok.Builder;
import lombok.Getter;
import lombok.extern.jackson.Jacksonized;

@Builder
@Getter
@Jacksonized
public class Product {

    private final int id;
    private final String title;
    private final String description;
    private final int price;
}
