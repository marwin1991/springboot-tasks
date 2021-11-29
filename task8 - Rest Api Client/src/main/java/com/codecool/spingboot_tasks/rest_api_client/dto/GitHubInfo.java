package com.codecool.spingboot_tasks.rest_api_client.dto;

import lombok.Data;

@Data
public class GitHubInfo {

    private String login;
    private String name;

    private int stars;
    private int watchers;
    private int publicRepos;
    private int followers;
}
