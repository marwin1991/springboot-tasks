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

    public List<Integer> findAllPrices(){
        String query = "SELECT price FROM products";
        return template.queryForList(query, Integer.class);
    }

    public List<String> findAllNames(){
        String query = "SELECT name FROM products";
        return template.queryForList(query, String.class);
    }

    public Product findById(long id) {
        String query = "SELECT * FROM products WHERE id = :id";

//        Alternative
//        Map<String, Object> params = new HashMap<>();
//        params.put("id", id);

        SqlParameterSource params = new MapSqlParameterSource()
                .addValue("id", id);

        return namedTemplate.queryForObject(query, params, new ProductMapper());
    }

    public Product create(Product product) {
        return null;
    }
}
