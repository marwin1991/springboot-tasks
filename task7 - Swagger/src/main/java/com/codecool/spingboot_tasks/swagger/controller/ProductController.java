package com.codecool.spingboot_tasks.swagger.controller;

import com.codecool.spingboot_tasks.swagger.model.Product;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

@RestController
public class ProductController {


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
