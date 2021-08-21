package com.codecool.spingboot_tasks.jdbc_template.repository;

import com.codecool.spingboot_tasks.jdbc_template.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class ProductRepository {

    public List<Product> findAll(){
        return null
    }

    public List<Integer> findAllPrices(){
        return null
    }

    public List<String> findAllNames(){
        return null
    }

    public Product findById(long id) {
        return null
    }

    public Product create(Product product) {
        return null;
    }
}
