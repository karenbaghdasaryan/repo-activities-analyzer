package com.webbfontaine.repoactivitiesanalyzer.core.service;

import com.webbfontaine.repoactivitiesanalyzer.core.data.entity.AccountBookmark;
import com.webbfontaine.repoactivitiesanalyzer.core.data.repository.AccountBookmarkRepository;
import com.webbfontaine.repoactivitiesanalyzer.core.utils.ErrorMessageUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.Optional;

@Service
public class AccountBookmarkService {

    @Autowired
    private AccountBookmarkRepository accountBookmarkRepository;

    public Optional<AccountBookmark> findById(Long id) {
        return accountBookmarkRepository.findById(id);
    }

    public Optional<AccountBookmark> findByBookmarkId(Long id) {
        return accountBookmarkRepository.findByBookmarkId(id);
    }

    public AccountBookmark save(final AccountBookmark accountBookmark) {
        Assert.notNull(accountBookmark, ErrorMessageUtils.notNull("accountBookmark"));
        return accountBookmarkRepository.save(accountBookmark);
    }
}
