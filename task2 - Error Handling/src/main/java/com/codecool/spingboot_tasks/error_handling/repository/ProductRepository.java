package com.codecool.spingboot_tasks.error_handling.repository;

import com.codecool.spingboot_tasks.error_handling.exeption.ProductCreateException;
import com.codecool.spingboot_tasks.error_handling.exeption.ProductNotFoundException;
import com.codecool.spingboot_tasks.error_handling.exeption.ProductUpdateException;
import com.codecool.spingboot_tasks.error_handling.model.Product;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;
import java.util.List;

@Repository
public class ProductRepository {

    public List<Product> findAll(){
        throw new IllegalStateException();
    }

    public List<Product> findById(long id) {
        throw new ProductNotFoundException("There is no product with id: " + id);
    }

    public Product save(Product product) {
        throw new ProductCreateException(BigInteger.valueOf(12345));
    }

    public Product update(Product product) {
        throw new ProductUpdateException("Nie udało się zaktualizwać danych o produkcie");
    }
}
