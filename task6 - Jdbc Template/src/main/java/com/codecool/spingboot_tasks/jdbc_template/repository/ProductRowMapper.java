package com.codecool.spingboot_tasks.jdbc_template.repository;

import com.codecool.spingboot_tasks.jdbc_template.model.Product;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ProductRowMapper implements RowMapper<Product> {

    @Override
    public Product mapRow(ResultSet rs, int rowNum) throws SQLException {
        Product product = new Product();

        product.setId(rs.getInt("id"));
        product.setName(rs.getString("name"));
        product.setPrice(rs.getInt("price"));

        return product;
    }

}
