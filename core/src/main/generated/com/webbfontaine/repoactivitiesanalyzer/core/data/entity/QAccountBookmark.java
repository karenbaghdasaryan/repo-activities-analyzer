package com.webbfontaine.repoactivitiesanalyzer.core.data.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QAccountBookmark is a Querydsl query type for AccountBookmark
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QAccountBookmark extends EntityPathBase<AccountBookmark> {

    private static final long serialVersionUID = 2060400689L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QAccountBookmark accountBookmark = new QAccountBookmark("accountBookmark");

    public final QAbstractUidAwareDomainEntity _super = new QAbstractUidAwareDomainEntity(this);

    public final QAccount account;

    public final QBookmark bookmark;

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createdAt = _super.createdAt;

    //inherited
    public final NumberPath<Long> id = _super.id;

    //inherited
    public final StringPath uid = _super.uid;

    //inherited
    public final DateTimePath<java.time.LocalDateTime> updatedAt = _super.updatedAt;

    public QAccountBookmark(String variable) {
        this(AccountBookmark.class, forVariable(variable), INITS);
    }

    public QAccountBookmark(Path<? extends AccountBookmark> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QAccountBookmark(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QAccountBookmark(PathMetadata metadata, PathInits inits) {
        this(AccountBookmark.class, metadata, inits);
    }

    public QAccountBookmark(Class<? extends AccountBookmark> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.account = inits.isInitialized("account") ? new QAccount(forProperty("account")) : null;
        this.bookmark = inits.isInitialized("bookmark") ? new QBookmark(forProperty("bookmark")) : null;
    }

}

