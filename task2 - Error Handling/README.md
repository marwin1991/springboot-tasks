## Story
Error handling is one of the most important aspects of web application development.

## What you are going to learn
- Exceptions classifications in Java
- Handling exceptions in Spring

## Tasks

### Exceptions in Java
- Add new type of exception `ProductNotFoundException` that extends RuntimeException
- Implement `findById` in `ProductRepository` to always throw `ProductNotFoundException`
- Add new field `private String errorMsg` in `ProductNotFoundException` and set up this in `ProductRepository` by
  calling constructor with argument `"There is no product with id: " + id`
- Change `extends RuntimeException` in `ProductNotFoundException` to `extends Exception`. What changed?
- Read about https://howtodoinjava.com/java/exception-handling/checked-vs-unchecked-exceptions-in-java/

### Handling exceptions in Spring

#### First, the simplest handling
- Add on your exception

```java
    @ResponseStatus(value = HttpStatus.NOT_FOUND)
    public class MyResourceNotFoundException extends RuntimeException {
        public MyResourceNotFoundException() {
            super();
        }
    }
```

#### In controller
- Add new method in a controller, service and repository to create new product
- Add ProductCreateException and throw
- Add in your controller
```java
    @ExceptionHandler(ProductCreateException.class)
    //@ExceptionHandler({ ProductCreateException.class, ProductCreateException2.class })
    public void handleProductCreateException() {
        //
    }
```

- Change implementation of handleException to return ResponseEntity and as method argument it
  takes `MyResourceNotFoundException ex` or `RuntimeException ex` or `Exception ex`
- Add some implementation to handleException to print `errorMsg` (Don't forget about getter)


#### ControllerAdvice
- Add new method in a controller, service and repository to update new product
- Add ProductUpdateException and throw
- Add in your controller
```java
@ControllerAdvice
public class GeneralExceptionHandler {

  @ResponseBody
  @ExceptionHandler(ProductUpdateException.class)
  @ResponseStatus(HttpStatus.FORBIDEN)
  public String productUpdateExceptionHandler(ProductUpdateException ex) {
    return ex.getMessage();
  }
}
```


## Links

- https://www.javamex.com/tutorials/exceptions/ExceptionHierarchy.png
- https://developer.mozilla.org/en-US/docs/Web/HTTP/Methods
- https://developer.mozilla.org/en-US/docs/Web/HTTP/Status
- https://howtodoinjava.com/java/exception-handling/checked-vs-unchecked-exceptions-in-java/
