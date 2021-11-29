package com.codecool.spingboot_tasks.rest_api_client.client;

import com.codecool.spingboot_tasks.rest_api_client.dto.GitHubCreateRepoRequest;
import com.codecool.spingboot_tasks.rest_api_client.dto.GitHubRepoInfoResponse;
import com.codecool.spingboot_tasks.rest_api_client.dto.GitHubUserInfoResponse;
import lombok.Singular;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Slf4j
@Component
public class GitHubClient {

    @Value("${github.url:https://api.github.com/}")
    private String baseUrl;

    public GitHubUserInfoResponse getInfo(String username){
        RestTemplate restTemplate = new RestTemplate();
        String url = baseUrl + "users/" + username;

        ResponseEntity<GitHubUserInfoResponse> response
                = restTemplate.getForEntity(url, GitHubUserInfoResponse.class);

        log.info(response.getStatusCode().toString());
        log.info(response.getBody().toString());

        return response.getBody();
    }

    public List<GitHubRepoInfoResponse> getReposInfo(String username){
        RestTemplate restTemplate = new RestTemplate();
        String url = baseUrl + "users/" + username + "/repos?per_page=100";

        ResponseEntity<GitHubRepoInfoResponse[]> response
                = restTemplate.getForEntity(url, GitHubRepoInfoResponse[].class);

        log.info(response.getStatusCode().toString());
        List<GitHubRepoInfoResponse> reposInfo = Arrays.asList(response.getBody());

        log.info("Ilość repo:" + reposInfo.size());

        return reposInfo;
    }

    @SneakyThrows
    public void createRepo(String username, String repoName) {
        RestTemplate restTemplate = new RestTemplate();
        String url = baseUrl + "user/repos";

        URI uri = new URI(url);

        GitHubCreateRepoRequest requestData = new GitHubCreateRepoRequest();
        requestData.setName(repoName);

        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", "token tutaj_github_PAT");

        HttpEntity<GitHubCreateRepoRequest> request = new HttpEntity<>(requestData, headers);

        ResponseEntity<String> result = restTemplate.postForEntity(uri, request, String.class);

        log.info(result.getStatusCode().toString());
        log.info(result.getBody());
    }
}
