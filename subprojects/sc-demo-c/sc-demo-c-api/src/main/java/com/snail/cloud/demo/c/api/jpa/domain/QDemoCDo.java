package com.snail.cloud.demo.c.api.jpa.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QDemoCDo is a Querydsl query type for DemoCDo
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QDemoCDo extends EntityPathBase<DemoCDo> {

    private static final long serialVersionUID = 298216947L;

    public static final QDemoCDo demoCDo = new QDemoCDo("demoCDo");

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

    public QDemoCDo(String variable) {
        super(DemoCDo.class, forVariable(variable));
    }

    public QDemoCDo(Path<? extends DemoCDo> path) {
        super(path.getType(), path.getMetadata());
    }

    public QDemoCDo(PathMetadata metadata) {
        super(DemoCDo.class, metadata);
    }

}

