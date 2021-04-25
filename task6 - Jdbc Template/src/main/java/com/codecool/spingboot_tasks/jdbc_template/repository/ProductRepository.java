package com.codecool.spingboot_tasks.jdbc_template.repository;

import com.codecool.spingboot_tasks.jdbc_template.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ProductRepository {

    private final NamedParameterJdbcTemplate namedTemplate;
    private final JdbcTemplate template;

    @Autowired
    public ProductRepository(NamedParameterJdbcTemplate namedTemplate, JdbcTemplate template) {
        this.namedTemplate = namedTemplate;
        this.template = template;
    }

    public List<Product> findAll(){
        String query = "SELECT * FROM products";
        return template.query(query, new ProductMapper());
    }

    public Product findById(long id) {
        return null;
    }

    public Product create(Product product) {
        return null;
    }
}
