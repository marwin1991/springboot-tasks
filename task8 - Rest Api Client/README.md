## Story
Our task will be to use an external API and download data from it for the needs of our application.

## What you are going to learn
- Creating REST Client and consuming API

## Tasks
- Visit:
    - https://docs.github.com/en/rest/reference
    - https://api.github.com/users/your_git_nick
- Create simple class `GitHubClient` that will use `RestTemplate` to retrieve information user's `name` and `location` and `public_repos`.

```java
      RestTemplate restTemplate = new RestTemplate();
      String url = "https://api.github.com/users/your_git_nick";
      ResponseEntity<String> response = restTemplate.getForEntity(url, String.class);
      log.info(response.getStatusCode().toString());
      log.info(response.getBody());
```  

- Create method that will sum all `stargazers_count` and `watchers_count` for given user
- Create `RestTemplateConfiguration` that will return spring bean with restTemplate
- Post some object:
```java
      RestTemplate restTemplate = new RestTemplate();
      final String baseUrl = "http://localhost:"+randomServerPort+"/employees/";
      URI uri = new URI(baseUrl);
      Employee employee = new Employee(null, "Adam", "Gilly", "test@email.com");
      
      HttpHeaders headers = new HttpHeaders();
      headers.set("SOME-HEADER", "ALA-MA-KOTA");
      
      HttpEntity<Employee> request = new HttpEntity<>(employee, headers);
      
      ResponseEntity<String> result = restTemplate.postForEntity(uri, request, String.class);
```
- Generate GitHub PersonalAccessToken(PAT) and use `https://api.github.com/user/starred` to get information about stars given by user (owner of PersonalAccessToken)
- Create repo by using PAT but first visit
    - https://docs.github.com/en/rest/reference/repos#create-a-repository-for-the-authenticated-user
  
- Extra Tasks:
  - Create 3 SpringBoot applications on ports 8081 8082 8083 and create Rest Client carousel, where 
  each application calls next one  (8081 -> 8082 -> 8083 -> 8081)(Hint: Add some sleep)

## Links
- https://www.baeldung.com/rest-template
- https://www.baeldung.com/spring-webclient-resttemplate
- https://howtodoinjava.com/spring-boot2/resttemplate/spring-restful-client-resttemplate-example/
- https://howtodoinjava.com/spring-boot2/resttemplate/resttemplate-post-json-example/
## Links - Cloud
- https://spring.io/projects/spring-cloud
- https://developer.okta.com/blog/2019/05/22/java-microservices-spring-boot-spring-cloud
