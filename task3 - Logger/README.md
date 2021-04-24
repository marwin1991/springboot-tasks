## Story
Logging in is the primary mechanism for keeping information about events in our application, but it also helps in resolving errors.

## What you are going to learn
- What logging is?
- Convection in logging.
- Configuring logging in SpringBoot application.

## Tasks
- Add logger to `ProductController`
```java
    import org.slf4j.Logger;
    import org.slf4j.LoggerFactory;
    
    private final Logger log = LoggerFactory.getLogger(ProductController.class);
```
- You can add lombok to your project and use `@Slf4j` on your class instead of adding above line in every class in which you want to use logger. 
- Use different logging methods in any way you want:
```java
        log.trace("A TRACE Message");
        log.debug("A DEBUG Message");
        log.info("An INFO Message");
        log.warn("A WARN Message");
        log.error("An ERROR Message");
```
- Add to application.properties `logging.level.com.codecool.spingboot_tasks.logger=DEBUG`. What has changed?
- Add to application.properties `logging.level.root=debug`. What has changed?
- Create logger filter to log all incoming requests (Hint: CommonsRequestLoggingFilter or create custom with knowledge from task 1)
- Configure logger to log to ./logs directory but keep logging to console
- Read about Logback and Log4j implementation of Slf4j API

## Links
https://docs.spring.io/spring-boot/docs/current/reference/html/howto.html#howto-logging
https://docs.spring.io/spring-boot/docs/current/reference/html/spring-boot-features.html#boot-features-logging
http://www.slf4j.org/