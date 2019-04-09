package com.webbfontaine.repoactivitiesanalyzer.core.data.dto;

import com.webbfontaine.repoactivitiesanalyzer.core.data.entity.Account;
import com.webbfontaine.repoactivitiesanalyzer.core.data.entity.Bookmark;

import java.time.LocalDateTime;

public class AccountBookmarkDTO {
    private Long id;
    private Account account;
    private Bookmark bookmark;
    private LocalDateTime createdAt;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public Bookmark getBookmark() {
        return bookmark;
    }

    public void setBookmark(Bookmark bookmark) {
        this.bookmark = bookmark;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
}
