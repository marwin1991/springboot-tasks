## Story
Recently, concurrency is rarely used in applications in the Spring ecosystem, but it is worth knowing to be able to create more efficient applications.
Our service performs very long calculations one by one, are we able to increase the efficiency of our application?

## What you are going to learn
- Java Future mechanism
- First steps in concurrency and multithreading

## Tasks
- Add log before calculations starts
- Add log after calculations ends
- Use Future to parallel calculations

```java
    private ExecutorService executor = Executors.newSingleThreadExecutor();
```
- Test different `Executors` implementations


## Links
https://www.baeldung.com/java-future
https://www.baeldung.com/java-executor-service-tutorial
https://stackoverflow.com/questions/4956822/whats-the-difference-between-future-and-futuretask-in-java
