package com.codecool.spingboot_tasks.swagger.controller;

import com.codecool.spingboot_tasks.swagger.model.Product;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

@RestController
public class ProductController {

    @ApiOperation("Operation to list all products")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Powodzenie / Success", response = Product.class),
            @ApiResponse(code = 400, message = "Błędne żądanie / Bad request", response = Error.class)})
    @GetMapping("/products")
    public List<Product> getProducts() {
        return Collections.emptyList();
    }

    @GetMapping("/products/{id}")
    public Product getProduct(@PathVariable long id) {
        return new Product();
    }

    @PostMapping("/products")
    public Product createProducts(@RequestBody Product product) {
        return new Product();
    }

    @PatchMapping("/products")
    public Product updateProducts(@RequestBody Product product) {
        return new Product();
    }

    @DeleteMapping("/products")
    public void createProducts(@PathVariable long id) {

    }


}
