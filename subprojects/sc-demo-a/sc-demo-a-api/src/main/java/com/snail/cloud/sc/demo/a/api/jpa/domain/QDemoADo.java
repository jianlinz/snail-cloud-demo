package com.snail.cloud.sc.demo.a.api.jpa.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QDemoADo is a Querydsl query type for DemoADo
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QDemoADo extends EntityPathBase<DemoADo> {

    private static final long serialVersionUID = -9416053L;

    public static final QDemoADo demoADo = new QDemoADo("demoADo");

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

    public QDemoADo(String variable) {
        super(DemoADo.class, forVariable(variable));
    }

    public QDemoADo(Path<? extends DemoADo> path) {
        super(path.getType(), path.getMetadata());
    }

    public QDemoADo(PathMetadata metadata) {
        super(DemoADo.class, metadata);
    }

}

