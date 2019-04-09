package com.webbfontaine.repoactivitiesanalyzer.core.data.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QBookmark is a Querydsl query type for Bookmark
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QBookmark extends EntityPathBase<Bookmark> {

    private static final long serialVersionUID = -1792677048L;

    public static final QBookmark bookmark = new QBookmark("bookmark");

    public final QAbstractUidAwareDomainEntity _super = new QAbstractUidAwareDomainEntity(this);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createdAt = _super.createdAt;

    //inherited
    public final NumberPath<Long> id = _super.id;

    public final StringPath repoFullName = createString("repoFullName");

    //inherited
    public final StringPath uid = _super.uid;

    //inherited
    public final DateTimePath<java.time.LocalDateTime> updatedAt = _super.updatedAt;

    public QBookmark(String variable) {
        super(Bookmark.class, forVariable(variable));
    }

    public QBookmark(Path<? extends Bookmark> path) {
        super(path.getType(), path.getMetadata());
    }

    public QBookmark(PathMetadata metadata) {
        super(Bookmark.class, metadata);
    }

}

