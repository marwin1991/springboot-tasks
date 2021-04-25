package com.codecool.spingboot_tasks.rest_api_client.controller;

import com.codecool.spingboot_tasks.rest_api_client.model.GitHubInfoDTO;
import com.codecool.spingboot_tasks.rest_api_client.model.GitHubRepoResponse;
import com.codecool.spingboot_tasks.rest_api_client.model.GitHubUserResponse;
import com.codecool.spingboot_tasks.rest_api_client.service.GitHubService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GitHubController {

    private final GitHubService gitHubService;

    @Autowired
    public GitHubController(GitHubService gitHubService) {
        this.gitHubService = gitHubService;
    }

    @GetMapping("/info")
    public GitHubInfoDTO getInfo(@RequestParam(defaultValue = "marwin1991") String userName){
        return gitHubService.getInfo(userName);
    }

    @GetMapping("/stars")
    public GitHubRepoResponse getReposWithGivenStar(@RequestParam(defaultValue = "marwin1991") String userName){
        return gitHubService.getReposWithGivenStar(userName);
    }

    @GetMapping("/repo")
    public void getReposWithGivenStar(@RequestParam(defaultValue = "marwin1991") String userName, @RequestParam(defaultValue = "AlaMaKota") String repoName){
        gitHubService.createRepo(userName, repoName);
    }
}
