package com.codecool.spingboot_tasks.error_handling.controller;

import com.codecool.spingboot_tasks.error_handling.exeption.ProductCreateException;
import com.codecool.spingboot_tasks.error_handling.model.Product;
import com.codecool.spingboot_tasks.error_handling.service.ProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/products")
    public List<Product> getProducts() {
        return productService.getProducts();
    }

    @GetMapping("/products/{id}")
    public List<Product> getProducts(@PathVariable long id) {
        return productService.getProduct(id);
    }

    @PostMapping("/products")
    public Product createProduct(@RequestBody Product product){
        return productService.createProduct(product);
    }

    @PatchMapping("/products")
    public Product updateProduct(@RequestBody Product product){
        return productService.updateProduct(product);
    }

//    @ExceptionHandler(ProductCreateException.class)
//    //@ExceptionHandler({ ProductCreateException.class, ProductCreateException2.class })
//    public ResponseEntity<String> handleProductCreateException(ProductCreateException e) {
//        System.out.println(e.getSomeValue());
//        return ResponseEntity.status(400).body("Nie udało utworzyć się produktu");
//    }

}
