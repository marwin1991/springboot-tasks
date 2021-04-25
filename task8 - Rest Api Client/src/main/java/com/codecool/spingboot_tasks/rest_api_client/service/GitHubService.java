package com.codecool.spingboot_tasks.rest_api_client.service;

import com.codecool.spingboot_tasks.rest_api_client.client.GitHubClient;
import com.codecool.spingboot_tasks.rest_api_client.model.GitHubInfoDTO;
import com.codecool.spingboot_tasks.rest_api_client.model.GitHubRepo;
import com.codecool.spingboot_tasks.rest_api_client.model.GitHubRepoResponse;
import com.codecool.spingboot_tasks.rest_api_client.model.GitHubUserResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GitHubService {

    private final GitHubClient client;

    @Autowired
    public GitHubService(GitHubClient client) {
        this.client = client;
    }

    public GitHubInfoDTO getInfo(String userName) {
        GitHubUserResponse response = client.getGitHubUserInfo(userName);

        GitHubInfoDTO dto = new GitHubInfoDTO();
        dto.setLocation(response.getLocation());
        dto.setName(response.getName());
        dto.setPublicRepos(response.getPublicRepos());

        GitHubRepoResponse repoResponse = client.getRepos(response.getReposUrl());

        int stars = 0;
        int watchers = 0;
        int forks = 0;
        int forkRepos = 0;

        for(GitHubRepo repo : repoResponse.getRepos()){
            stars += repo.getStarsCount();
            watchers += repo.getWatchersCount();
            forks += repo.getForks();
            if(repo.isFork()){
                forkRepos += 1;
            }
        }

        dto.setStars(stars);
        dto.setWatchers(watchers);
        dto.setForks(forks);
        dto.setForkRepos(forkRepos);

        return dto;
    }

    public GitHubRepoResponse getReposWithGivenStar(String userName){
        return client.getReposWithGivenStar(userName);
    }

    public void createRepo(String userName, String repoName){
        client.createRepo(userName, repoName);
    }

}
