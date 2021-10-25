package com.snail.cloud.demo.d.api.jpa.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QDemoDApiDo is a Querydsl query type for DemoDApiDo
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QDemoDApiDo extends EntityPathBase<DemoDApiDo> {

    private static final long serialVersionUID = -1118661827L;

    public static final QDemoDApiDo demoDApiDo = new QDemoDApiDo("demoDApiDo");

    public final indi.jl.sp.data.jpa.domain.QBaseDo _super = new indi.jl.sp.data.jpa.domain.QBaseDo(this);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createTime = _super.createTime;

    //inherited
    public final StringPath createUserName = _super.createUserName;

    //inherited
    public final NumberPath<Long> id = _super.id;

    public final NumberPath<Integer> test = createNumber("test", Integer.class);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> updateTime = _super.updateTime;

    //inherited
    public final StringPath updateUserName = _super.updateUserName;

    public QDemoDApiDo(String variable) {
        super(DemoDApiDo.class, forVariable(variable));
    }

    public QDemoDApiDo(Path<? extends DemoDApiDo> path) {
        super(path.getType(), path.getMetadata());
    }

    public QDemoDApiDo(PathMetadata metadata) {
        super(DemoDApiDo.class, metadata);
    }

}

