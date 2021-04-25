package com.codecool.spingboot_tasks.rest_api_client.client;

import com.codecool.spingboot_tasks.rest_api_client.model.GitHubRepo;
import com.codecool.spingboot_tasks.rest_api_client.model.GitHubRepoResponse;
import com.codecool.spingboot_tasks.rest_api_client.model.GitHubUserResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;

@Slf4j
@Component
public class GitHubClient {

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

}
