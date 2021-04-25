package com.codecool.spingboot_tasks.rest_api_client.client;

import com.codecool.spingboot_tasks.rest_api_client.model.CreateRepoRequest;
import com.codecool.spingboot_tasks.rest_api_client.model.GitHubRepo;
import com.codecool.spingboot_tasks.rest_api_client.model.GitHubRepoResponse;
import com.codecool.spingboot_tasks.rest_api_client.model.GitHubUserResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.support.BasicAuthorizationInterceptor;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Base64;

@Slf4j
@Component
public class GitHubClient {

    @Value("${github.token}")
    private String githubToken;

    public GitHubUserResponse getGitHubUserInfo(String userName){
        RestTemplate restTemplate = new RestTemplate();
        String url = "https://api.github.com/users/" + userName;
        ResponseEntity<GitHubUserResponse> response =
                restTemplate.getForEntity(
                        url, GitHubUserResponse.class);

        log.info(response.getStatusCode().toString());
        GitHubUserResponse bodyResponse = response.getBody();
        log.info(bodyResponse.toString());
        return bodyResponse;
    }

    public GitHubRepoResponse getRepos(String reposUrl){
        RestTemplate restTemplate = new RestTemplate();

        ResponseEntity<GitHubRepo[]> response = restTemplate.getForEntity(reposUrl, GitHubRepo[].class);
        log.info(response.getStatusCode().toString());

        GitHubRepo[] bodyResponse = response.getBody();
        log.info(bodyResponse.toString());

        GitHubRepoResponse finalResponse = new GitHubRepoResponse();
        finalResponse.setRepos(Arrays.asList(bodyResponse));

        return finalResponse;
    }

    public GitHubRepoResponse getReposWithGivenStar(String userName){
        RestTemplate restTemplate = new RestTemplate();

        String url = "https://api.github.com/user/starred";
        HttpHeaders headers = new HttpHeaders();
        headers.setBasicAuth(userName, githubToken);

//        String originalInput = userName + ":" + githubToken;
//        String encodedString = Base64.getEncoder().encodeToString(originalInput.getBytes(StandardCharsets.UTF_8));
//        headers.set("Authorization", "Basic " + encodedString);

        HttpEntity entity = new HttpEntity<>(headers);
        ResponseEntity<GitHubRepo[]> response = restTemplate.exchange(url, HttpMethod.GET, entity, GitHubRepo[].class);

        log.info(response.getStatusCode().toString());
        GitHubRepo[] bodyResponse = response.getBody();
        log.info(bodyResponse.toString());

        GitHubRepoResponse finalResponse = new GitHubRepoResponse();
        finalResponse.setRepos(Arrays.asList(bodyResponse));

        return finalResponse;
    }

    public void createRepo(String userName, String repoName) {
        RestTemplate restTemplate = new RestTemplate();

        String url = "https://api.github.com/user/repos";

        HttpHeaders headers = new HttpHeaders();
        headers.setBasicAuth(userName, githubToken);

        CreateRepoRequest requestBody = new CreateRepoRequest();
        requestBody.setName(repoName);

        HttpEntity<CreateRepoRequest> entity = new HttpEntity<>(requestBody, headers);
        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.POST, entity, String.class);
        log.info(response.getStatusCode().toString());
        log.info(response.getBody());
    }

}
