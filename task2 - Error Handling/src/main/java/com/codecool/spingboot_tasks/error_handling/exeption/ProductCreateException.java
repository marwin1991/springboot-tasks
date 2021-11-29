package com.codecool.spingboot_tasks.error_handling.exeption;

import lombok.Getter;

import java.math.BigInteger;

@Getter
public class ProductCreateException extends RuntimeException {
    private final BigInteger someValue;

    public ProductCreateException(BigInteger someValue) {
        this.someValue = someValue;
    }
}
