package com.codecool.spingboot_tasks.rest_api_client.model;

import lombok.Data;

@Data
public class GitHubInfoDTO {

    private String name;
    private String location;
    private int publicRepos;

    private int stars;
    private int watchers;
    private int forks;
    private int forkRepos;

}
