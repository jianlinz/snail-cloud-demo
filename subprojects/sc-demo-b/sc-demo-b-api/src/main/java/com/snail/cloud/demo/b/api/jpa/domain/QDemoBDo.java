package com.snail.cloud.demo.b.api.jpa.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QDemoBDo is a Querydsl query type for DemoBDo
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QDemoBDo extends EntityPathBase<DemoBDo> {

    private static final long serialVersionUID = 365222739L;

    public static final QDemoBDo demoBDo = new QDemoBDo("demoBDo");

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

    public QDemoBDo(String variable) {
        super(DemoBDo.class, forVariable(variable));
    }

    public QDemoBDo(Path<? extends DemoBDo> path) {
        super(path.getType(), path.getMetadata());
    }

    public QDemoBDo(PathMetadata metadata) {
        super(DemoBDo.class, metadata);
    }

}

