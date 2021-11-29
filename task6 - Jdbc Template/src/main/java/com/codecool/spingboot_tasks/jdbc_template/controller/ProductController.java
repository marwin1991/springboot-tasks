package com.codecool.spingboot_tasks.jdbc_template.controller;

import com.codecool.spingboot_tasks.jdbc_template.NotFoundException;
import com.codecool.spingboot_tasks.jdbc_template.model.Product;
import com.codecool.spingboot_tasks.jdbc_template.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpClientErrorException;

import java.util.List;

@RestController
public class ProductController {

    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/products")
    public List<Product> getProducts(){
        return productService.getProducts();
    }

    @GetMapping("/products/{id}")
    public Product getProduct(@PathVariable long id){
        return productService.getProduct(id).orElseThrow(NotFoundException::new);
    }

    @PostMapping("/products")
    public Product createProducts(@RequestBody Product product){
        return productService.createProduct(product);
    }



}
