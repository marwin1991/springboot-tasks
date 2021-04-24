package com.codecool.spingboot_tasks.jdbc_template.service;

import com.codecool.spingboot_tasks.jdbc_template.model.Product;
import com.codecool.spingboot_tasks.jdbc_template.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> getProducts(){
        return productRepository.findAll();
    }

    public List<Product> getProduct(long id) {
        return productRepository.findById(id);
    }

    public Product createProduct(Product product) {
        return productRepository.create(product);
    }
}
