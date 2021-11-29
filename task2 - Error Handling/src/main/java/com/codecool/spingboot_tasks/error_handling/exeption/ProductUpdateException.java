package com.codecool.spingboot_tasks.error_handling.exeption;

public class ProductUpdateException extends RuntimeException{
    public ProductUpdateException(String message) {
        super(message);
    }
}
