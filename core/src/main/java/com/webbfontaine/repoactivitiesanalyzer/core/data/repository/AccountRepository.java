package com.webbfontaine.repoactivitiesanalyzer.core.data.repository;

import com.webbfontaine.repoactivitiesanalyzer.core.data.entity.Account;

public interface AccountRepository extends AbstractJpaRepository<Account> {
    Account findByUsername(String username);
}
