package com.codecool.spingboot_tasks.logger.repository;

import com.codecool.spingboot_tasks.logger.model.Product;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ProductRepository {

    public List<Product> findAll(){
        throw new IllegalStateException();
    }

    public List<Product> findById(long id) {
        return null;
    }
}
