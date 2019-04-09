package com.webbfontaine.repoactivitiesanalyzer.core.data.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QAbstractDomainEntity is a Querydsl query type for AbstractDomainEntity
 */
@Generated("com.querydsl.codegen.SupertypeSerializer")
public class QAbstractDomainEntity extends EntityPathBase<AbstractDomainEntity> {

    private static final long serialVersionUID = 482139675L;

    public static final QAbstractDomainEntity abstractDomainEntity = new QAbstractDomainEntity("abstractDomainEntity");

    public final DateTimePath<java.time.LocalDateTime> createdAt = createDateTime("createdAt", java.time.LocalDateTime.class);

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final DateTimePath<java.time.LocalDateTime> updatedAt = createDateTime("updatedAt", java.time.LocalDateTime.class);

    public QAbstractDomainEntity(String variable) {
        super(AbstractDomainEntity.class, forVariable(variable));
    }

    public QAbstractDomainEntity(Path<? extends AbstractDomainEntity> path) {
        super(path.getType(), path.getMetadata());
    }

    public QAbstractDomainEntity(PathMetadata metadata) {
        super(AbstractDomainEntity.class, metadata);
    }

}

