package com.codecool.spingboot_tasks.rest_api_client.controller;

import com.codecool.spingboot_tasks.rest_api_client.service.GitHubService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GitHubController {

    private final GitHubService gitHubService;

    @Autowired
    public GitHubController(GitHubService gitHubService) {
        this.gitHubService = gitHubService;
    }

    @GetMapping("/info")
    public String getInfo(){
        return gitHubService.getInfo();
    }
}
