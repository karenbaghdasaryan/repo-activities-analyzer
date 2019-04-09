package com.webbfontaine.repoactivitiesanalyzer.core.data.repository;

import com.webbfontaine.repoactivitiesanalyzer.core.data.entity.AbstractDomainEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

public interface AbstractJpaRepository<T extends AbstractDomainEntity>
        extends JpaRepository<T, Long>, QuerydslPredicateExecutor<T> {
}
