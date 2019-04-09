package com.webbfontaine.repoactivitiesanalyzer.core.data.repository;

import com.webbfontaine.repoactivitiesanalyzer.core.data.entity.AccountBookmark;

import java.util.Optional;

public interface AccountBookmarkRepository extends AbstractJpaRepository<AccountBookmark> {
    Optional<AccountBookmark> findById(Long id);

    Optional<AccountBookmark> findByBookmarkId(Long bookmarkId);
}
