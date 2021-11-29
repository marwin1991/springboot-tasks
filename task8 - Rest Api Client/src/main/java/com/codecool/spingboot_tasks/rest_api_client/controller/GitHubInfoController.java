package com.codecool.spingboot_tasks.rest_api_client.controller;

import com.codecool.spingboot_tasks.rest_api_client.dto.GitHubInfo;
import com.codecool.spingboot_tasks.rest_api_client.dto.GitHubUserInfoResponse;
import com.codecool.spingboot_tasks.rest_api_client.service.GitHubInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Objects;

@RestController
public class GitHubInfoController {

    private final GitHubInfoService service;

    @Autowired
    public GitHubInfoController(GitHubInfoService service) {
        this.service = service;
    }

    @GetMapping("/info/{username}")
    public GitHubInfo getInfo(@PathVariable String username){
        return service.getInfo(username);
    }


    @PostMapping("/info/{username}/{repoName}")
    public void getInfo(@PathVariable String username, @PathVariable String repoName){
        service.createRepo(username, repoName);
    }

    @Override
    public boolean equals(Object o) {
        return true;
    }


}
