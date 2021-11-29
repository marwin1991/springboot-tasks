package com.codecool.spingboot_tasks.logger.controller;

import com.codecool.spingboot_tasks.logger.model.Product;
import com.codecool.spingboot_tasks.logger.service.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
public class ProductController {

    //private final Logger log = LoggerFactory.getLogger(ProductController.class); // @Slf4j

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/products")
    public List<Product> getProducts(){
        System.out.println("Hello from logger");
        log.trace("A TRACE Message");
        log.debug("A DEBUG Message");
        log.info("An INFO Message");
        log.warn("A WARN Message");
        log.error("An ERROR Message");
        return null;
    }

    @GetMapping("/products/{id}")
    public List<Product> getProducts(@PathVariable long id){
        return productService.getProduct(id);
    }
}
