package com.codecool.spingboot_tasks.swagger.controller;

import com.codecool.spingboot_tasks.swagger.model.BackendError;
import com.codecool.spingboot_tasks.swagger.model.Product;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

@RestController
public class ProductController {

    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Powodzenie / Success", response = Product.class),
            @ApiResponse(code = 400, message = "Błędne żądanie / Bad request", response = BackendError.class)})
    @ApiOperation("Operation to list all products")
    @GetMapping("/products")
    public List<Product> getProducts() {
        return Collections.emptyList();
    }

    @ApiOperation("Operation to get one product by ID")
    @GetMapping("/products/{id}")
    public Product getProduct(@PathVariable long id) {
        return new Product();
    }

    @ApiOperation("Operation to create new product")
    @PostMapping("/products")
    public Product createProducts(@RequestBody Product product) {
        return new Product();
    }

    @ApiOperation("Operation to list all products")
    @PatchMapping("/products")
    public Product updateProducts(@RequestBody Product product) {
        return new Product();
    }

    @ApiOperation("Operation to list all products")
    @DeleteMapping("/products")
    public void createProducts(@PathVariable long id) {

    }


}
