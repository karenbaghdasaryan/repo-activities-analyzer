package com.webbfontaine.repoactivitiesanalyzer.core.data.dto;

public class BookmarkDTO {
    private Long id;
    private String repoFullName;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRepoFullName() {
        return repoFullName;
    }

    public void setRepoFullName(String repoFullName) {
        this.repoFullName = repoFullName;
    }
}
