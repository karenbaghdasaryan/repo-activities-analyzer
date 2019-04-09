package com.webbfontaine.repoactivitiesanalyzer.core.data.model.github;

import java.util.List;

public class GitHubResponse<T> {
    private List<T> items;

    public List<T> getItems() {
        return items;
    }

    public void setItems(List<T> items) {
        this.items = items;
    }
}
