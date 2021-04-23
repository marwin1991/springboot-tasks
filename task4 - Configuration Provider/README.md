## Story
How to create an application in the Spring ecosystem that can be freely configured? Let's assume our application displays the name "CodeCool" on the `/about` page. However, it turned out that we have a requirement from the client to have a second instance
display "CodeCool B2B" on this page.

## What you are going to learn
- Providing configuration to Spring application
- How to create spring bean from class from other library like "GSON" ?

## Tasks
- Provide a way to run application with configurable name
- What implementation can be considered to solve this problem?
- If you have not used, try to use `@Value` to provide name
- Add Gson to `pom.xml`
```xml
<dependency>
    <groupId>com.google.code.gson</groupId>
    <artifactId>gson</artifactId>
    <version>2.8.6</version>
</dependency>
```
- Create a Spring bean that will expose all gson functionality (Hint: `@Configuration` and `@Bean`)


## Links
https://docs.spring.io/spring-framework/docs/current/reference/html/core.html#beans-value-annotations
