package com.codecool.spingboot_tasks.rest_api_client.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class GitHubUserInfoResponse {
    private String login;

    private String name;

    @JsonProperty("public_repos")
    private int publicRepos;

    private int followers;
}
