package com.codecool.spingboot_tasks.rest_api_client.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class GitHubUserResponse {

    private String name;
    private String location;

    @JsonProperty("public_repos")
    private int publicRepos;

    @JsonProperty("repos_url")
    private String reposUrl;
}
