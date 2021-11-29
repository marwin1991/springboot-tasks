package com.codecool.spingboot_tasks.jdbc_template.repository;

import com.codecool.spingboot_tasks.jdbc_template.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.List;
import java.util.Optional;

@Repository
public class ProductRepository {

    private static final String FIND_ALL = "SELECT id, name, price FROM products";
    private static final String CREATE = "INSERT INTO public.products(name, price) VALUES (?, ?)";

    private static final String FIND_BY_ID = "SELECT id, name, price FROM products WHERE id = :id";

    private final NamedParameterJdbcTemplate namedTemplate;
    private final JdbcTemplate template;

    @Autowired
    public ProductRepository(DataSource dataSource) {
        this.namedTemplate = new NamedParameterJdbcTemplate(dataSource);
        this.template = new JdbcTemplate(dataSource);
    }

    public List<Product> findAll(){
        MapSqlParameterSource source = new MapSqlParameterSource();
        return namedTemplate.query(FIND_ALL, source, new ProductRowMapper());
    }

    public List<Integer> findAllPrices(){
        return null;
    }

    public List<String> findAllNames(){
        return null;
    }

    public Optional<Product> findById(long id) {
        MapSqlParameterSource source = new MapSqlParameterSource();
        source.addValue("id", id);
        try {
            return Optional.ofNullable(namedTemplate.queryForObject(FIND_BY_ID, source, new ProductRowMapper()));
        } catch (EmptyResultDataAccessException e){
            //log.info("Nie znaleziono pordukut dla id" + id);
            return Optional.empty();
        }
    }

    public Product create(Product product) { //można skorzystac z SimpleJdbcInsert
        KeyHolder keyHolder = new GeneratedKeyHolder();

        template.update(connection -> {
            PreparedStatement ps = connection.prepareStatement(CREATE, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, product.getName());
            ps.setInt(2, product.getPrice());
            return ps;
        }, keyHolder);

        product.setId((Long) keyHolder.getKeyList().get(0).get("id"));

        return product;
    }
}
