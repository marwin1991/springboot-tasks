## Story
Logging in is the primary mechanism for keeping information about events in our application, but it also helps in resolving errors.

## What you are going to learn
- What logging is
- Convection in logging
- Configuring logging in SpringBoot application

## Tasks
- Add logger to `ProductController`
```java
    private final Logger logger = LoggerFactory.getLogger(ProductController.class);
```
- Use different logging methods in any way you want:
```java
        logger.trace("A TRACE Message");
        logger.debug("A DEBUG Message");
        logger.info("An INFO Message");
        logger.warn("A WARN Message");
        logger.error("An ERROR Message");
```
- Add to application.properties `logging.level.com.codecool.spingboot_tasks.logger.=INFO`. What has changed?
- Add to application.properties `logging.level.root=debug`. What has changed?
- Create logger filter to log all incoming requests (Hint: CommonsRequestLoggingFilter or create custom with knowledge from task 1)
- Configure logger to log to ./logs directory but keep logging to console

## Links
https://docs.spring.io/spring-boot/docs/current/reference/html/howto.html#howto-logging
https://docs.spring.io/spring-boot/docs/current/reference/html/spring-boot-features.html#boot-features-logging