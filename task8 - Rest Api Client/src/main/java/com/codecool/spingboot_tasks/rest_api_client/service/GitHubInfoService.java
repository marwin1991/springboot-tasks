package com.codecool.spingboot_tasks.rest_api_client.service;

import com.codecool.spingboot_tasks.rest_api_client.client.GitHubClient;
import com.codecool.spingboot_tasks.rest_api_client.dto.GitHubInfo;
import com.codecool.spingboot_tasks.rest_api_client.dto.GitHubRepoInfoResponse;
import com.codecool.spingboot_tasks.rest_api_client.dto.GitHubUserInfoResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GitHubInfoService {

    private final GitHubClient client;

    @Autowired
    public GitHubInfoService(GitHubClient client) {
        this.client = client;
    }

    public GitHubInfo getInfo(String username){
        GitHubUserInfoResponse userInfoResponse = client.getInfo(username);
        List<GitHubRepoInfoResponse> reposInfoReposne = client.getReposInfo(username);

        GitHubInfo info = new GitHubInfo();
        info.setLogin(userInfoResponse.getLogin());
        info.setName(userInfoResponse.getName());
        info.setPublicRepos(userInfoResponse.getPublicRepos());
        info.setFollowers(userInfoResponse.getFollowers());

        info.setStars(reposInfoReposne.stream()
                .map(GitHubRepoInfoResponse::getStars)
                .reduce(0, Integer::sum)
        );

        info.setWatchers(reposInfoReposne.stream()
                .map(GitHubRepoInfoResponse::getWatchers)
                .reduce(0, Integer::sum)
        );

        return info;
    }

    public void createRepo(String username, String repoName) {
        client.createRepo(username, repoName);
    }
}
