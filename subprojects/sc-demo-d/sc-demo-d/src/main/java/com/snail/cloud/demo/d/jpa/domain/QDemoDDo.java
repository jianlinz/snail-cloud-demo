package com.snail.cloud.demo.d.jpa.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QDemoDDo is a Querydsl query type for DemoDDo
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QDemoDDo extends EntityPathBase<DemoDDo> {

    private static final long serialVersionUID = 1326836031L;

    public static final QDemoDDo demoDDo = new QDemoDDo("demoDDo");

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

    public QDemoDDo(String variable) {
        super(DemoDDo.class, forVariable(variable));
    }

    public QDemoDDo(Path<? extends DemoDDo> path) {
        super(path.getType(), path.getMetadata());
    }

    public QDemoDDo(PathMetadata metadata) {
        super(DemoDDo.class, metadata);
    }

}

