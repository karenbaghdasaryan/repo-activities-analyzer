package com.webbfontaine.repoactivitiesanalyzer.core.data.model.github;

public class GitHubRepositoriesResponse extends GitHubResponse<Repository> {
    private Integer total_count;

    public Integer getTotal_count() {
        return total_count;
    }

    public void setTotal_count(Integer total_count) {
        this.total_count = total_count;
    }
}
