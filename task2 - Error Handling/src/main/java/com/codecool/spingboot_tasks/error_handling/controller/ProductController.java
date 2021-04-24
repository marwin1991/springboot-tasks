package com.codecool.spingboot_tasks.error_handling.controller;

import com.codecool.spingboot_tasks.error_handling.model.Product;
import com.codecool.spingboot_tasks.error_handling.service.ProductService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

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

//    @ExceptionHandler({ IllegalStateException.class})
//    public void handleException(Exception e) {
//        System.out.println(e.getMessage());
//    }

//    @ExceptionHandler(Exception.class)
//    //@ExceptionHandler({ ProductCreateException.class, ProductCreateException2.class })
//    public ResponseEntity<String> handleProductCreateException(Exception e) {
//        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
//    }
}
