package com.codecool.spingboot_tasks.rest_api_client.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class GitHubRepo {
    private boolean fork;

    @JsonProperty("stargazers_count")
    private int starsCount;

    @JsonProperty("watchers_count")
    private int watchersCount;

    private int forks;
}
