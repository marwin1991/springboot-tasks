package com.codecool.spingboot_tasks.rest_api_client.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class GitHubRepoInfoResponse {
    @JsonProperty("stargazers_count")
    private int stars;

    @JsonProperty("watchers_count")
    private int watchers;
}
