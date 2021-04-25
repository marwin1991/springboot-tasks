## Story
To provide in a very easy way documentation for our controller layer, it is worth using Swagger.

## What you are going to learn
- Documenting REST API
- Using Swagger


## Task
- Add dependencies:
```xml
<dependency>
    <groupId>io.springfox</groupId>
    <artifactId>springfox-boot-starter</artifactId>
    <version>3.0.0</version>
</dependency>
```
- Add new package called `configuration` and inside it add:
```java
@Configuration
@EnableSwagger2
@Import(SpringDataRestConfiguration.class)
public class SwaggerConfiguration {
    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.any())
                .build();
    }
}
```
- You can add more info by defining ApiInfo in `SwaggerConfiguration` and adding `.apiInfo(apiInfo())` after
line `return new Docket(DocumentationType.SWAGGER_2)`
```java
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
            .title("Some title")
            .description("Lore ipsum, imsum lore")
            .license("")
            .licenseUrl("http://unlicense.org")
            .termsOfServiceUrl("")
            .version("1.0")
            .contact(new Contact("AAA", "BBB", "CCC"))
            .build();
    }
```

- Visit http://localhost:8080/v2/api-docs
- Now, visit: http://localhost:8080/swagger-ui/
- You can change it by using `springfox.documentation.swagger.v2.path` and `springfox.documentation.swagger-ui.base-url`
  property.

```properties
springfox.documentation.swagger.v2.path=/myapi/docs
springfox.documentation.swagger-ui.base-url=/hello
```  

- And now:
    - Visit http://localhost:8080/myapi/docs
    - Now, visit: http://localhost:8080/hello/swagger-ui/

- Add more description to your API:

```java
    @ApiOperation("Operation to list all products")
    @GetMapping("/products")
    public List<Product> getProducts(){
        return Collections.emptyList();
    }
```

- and:
```java
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@ApiResponses(value = {
        @ApiResponse(code = 200, message = "Powodzenie / Success", response = Product.class),
        @ApiResponse(code = 400, message = "Błędne żądanie / Bad request", response = Error.class)})
@GetMapping("/products")
public List<Product> getProducts() {
        return Collections.emptyList();
        }

```
- we can also describe model:
```java
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(description = "Product base information")
public class Product {
    @ApiModelProperty(required = true, value = "Identifier")
    private long id;
    @ApiModelProperty(required = true, value = "Name of the product")
    private String name;
    @ApiModelProperty(value = "Price of the product")
    private int price;
}
```

## Links
- https://swagger.io/
- https://springfox.github.io/springfox/
- https://www.baeldung.com/swagger-2-documentation-for-spring-rest-api
- https://editor.swagger.io/

