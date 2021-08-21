package com.codecool.spingboot_tasks.error_handling.model;

import lombok.Data;

@Data
public class Product {
    private final long id;
    private final String name;
    private final int price;
}
