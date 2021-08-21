## Story
This assignment is a list of exercises for practicing creation of Web applications. You can find multiple features which you can accomplish separately after the Preparation part. Do not forget to commit after you completed a part.

## What you are going to learn
- How to create Web API using SpringBoot 
- How to test your API with postman
- How to use Filters
- Get familiar with one of multithreading problems – race condition and know basic way of prevention

## Tasks
Start project with your IDE and begging developing SpringBoot Web application

### Create main endpoint
- Create RequestCounterController which provides http methods GET, POST, PUT, PATCH, DELETE on each return status  code 200 with no data in it (url: /api/requests).
- Use postman to test each http method execution 

### Create route to request counter
- Using dependency inversion pattern add RequestCountStatsService to RequestCounter controller
- Inside RequestCountStatsService implement method increaseCounter, and getStatistics (it should throw NotImplemented exception when one tries to execute method) – store statistics in-memory for now.
- Use increaseCounter method in Request Counter controller methods
- Use postman to test and debug to check if counter increases properly and its state is not reset between requests. 
- Extra tasks:
- Change scope of RequestCountStatsService to prototype and test it again
- What other scopes do Spring supports ?
- Try to add print when bean is created and when it is destroyed. Hint: bean lifecycle

### Create statistics endpoint
- Create new Statistics controller
- Created endpoint available under [url]/api/statistics
- Expose method GET which will return statistics
- Inject `RequestCountStatsService` into newly created controller
- Implement method inside class implementing `RequestCountStatsService`
- What type of injecting do we have ? What is the best and why?


### Use Filters (javax.servlet)
- Define a `Filter` that will print "Hello Filter" everytime any endpoint is started and "Bye, from Filter" any endpoint is ended.
```java
@Component
@Order(1)
public class TransactionFilter implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
 
        //HttpServletRequest req = (HttpServletRequest) request; // use it to get http method: req.getMethod()
        //HttpServletRequest res = (HttpServletRequest) response; 
        //action before request
        chain.doFilter(request, response);
        //action after request
    }
    
}
```
- Use Filter approach to define stats counting.
- Extras: 
- Read about Spring Interceptors Handlers here: https://www.tutorialspoint.com/spring_boot/spring_boot_interceptor.htm


### Extra Task: Spring Boot Actuator 
- Add Spring Boot Actuator and Micrometer to your `pom.xml`
```xml
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-actuator</artifactId>
        </dependency>
        <dependency>
            <groupId>io.micrometer</groupId>
            <artifactId>micrometer-registry-prometheus</artifactId>
        </dependency>
```
- Configure application in `application.properties`
```properties
management.endpoint.info.enabled=true
#management.endpoint.shutdown.enabled=true #dangerous 
management.endpoints.web.exposure.include=*
```
- How can we use Spring Boot Actuator to achieve 'request counting' functionality ?
- Test capabilities Spring Boot Actuator with your browser.
- Why to use metrics?
- WARNING: Make sure that diagnostic endpoints are only available to you!

## Links

- https://developer.mozilla.org/en-US/docs/Web/HTTP/Methods
- https://developer.mozilla.org/en-US/docs/Web/HTTP/Status
- https://docs.spring.io/spring-framework/docs/current/reference/html/core.html#beans-factory-scopes
- https://docs.spring.io/spring-framework/docs/current/reference/html/core.html#beans-factory-lifecycle
- https://docs.spring.io/spring-boot/docs/current/reference/html/production-ready-features.html#production-ready-enabling
- https://docs.spring.io/spring-framework/docs/current/reference/html/core.html#beans-postconstruct-and-predestroy-annotations