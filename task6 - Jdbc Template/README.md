## Story

Using Spring JPA is a great help in quick application development, but we can meet with projects where it cannot be used.

## What you are going to learn
- Usage JdbcTemplates

## Tasks
- Add `Spring Boot Starter JDBC` to your dependencies.
- Configure connection to postgres database in `application.properties`
```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/postgres
spring.datasource.username=postgres
spring.datasource.password=password
```
- Use `NamedParameterJdbcTemplate` and `JdbcTemplate` to implement `ProductRepository`
```java
private final NamedParameterJdbcTemplate namedTemplate;
private final JdbcTemplate template;
```
- Implement `findAll` with usage of `NamedParameterJdbcTemplate`
- Implement `create` with usage of `JdbcTemplate`
- Implement whole `delete` and `update` functionality


## Links
- https://spring.io/guides/gs/relational-data-access/
- https://dzone.com/articles/bounty-spring-boot-and-postgresql-database
- https://www.baeldung.com/spring-jdbc-jdbctemplate