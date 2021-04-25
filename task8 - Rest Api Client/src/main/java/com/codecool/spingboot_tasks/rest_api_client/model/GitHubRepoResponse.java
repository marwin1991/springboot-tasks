package com.codecool.spingboot_tasks.rest_api_client.model;

import lombok.Data;

import java.util.List;

@Data
public class GitHubRepoResponse {
    private List<GitHubRepo> repos;
}
