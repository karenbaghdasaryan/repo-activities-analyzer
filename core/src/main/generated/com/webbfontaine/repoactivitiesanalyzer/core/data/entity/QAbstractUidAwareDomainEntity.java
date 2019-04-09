package com.webbfontaine.repoactivitiesanalyzer.core.data.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QAbstractUidAwareDomainEntity is a Querydsl query type for AbstractUidAwareDomainEntity
 */
@Generated("com.querydsl.codegen.SupertypeSerializer")
public class QAbstractUidAwareDomainEntity extends EntityPathBase<AbstractUidAwareDomainEntity> {

    private static final long serialVersionUID = -1900142295L;

    public static final QAbstractUidAwareDomainEntity abstractUidAwareDomainEntity = new QAbstractUidAwareDomainEntity("abstractUidAwareDomainEntity");

    public final QAbstractDomainEntity _super = new QAbstractDomainEntity(this);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createdAt = _super.createdAt;

    //inherited
    public final NumberPath<Long> id = _super.id;

    public final StringPath uid = createString("uid");

    //inherited
    public final DateTimePath<java.time.LocalDateTime> updatedAt = _super.updatedAt;

    public QAbstractUidAwareDomainEntity(String variable) {
        super(AbstractUidAwareDomainEntity.class, forVariable(variable));
    }

    public QAbstractUidAwareDomainEntity(Path<? extends AbstractUidAwareDomainEntity> path) {
        super(path.getType(), path.getMetadata());
    }

    public QAbstractUidAwareDomainEntity(PathMetadata metadata) {
        super(AbstractUidAwareDomainEntity.class, metadata);
    }

}

