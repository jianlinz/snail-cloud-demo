package com.snail.cloud.sc.demo.a.jpa.dao;

import com.querydsl.core.types.dsl.EntityPathBase;
import com.snail.cloud.sc.demo.a.api.jpa.domain.QDemoADo;
import indi.jl.sp.data.jpa.annotation.SpDao;
import indi.jl.sp.data.jpa.dao.BaseDao;
import com.snail.cloud.sc.demo.a.api.jpa.domain.DemoADo;
import indi.jl.sp.data.jpa.repository.AbstractJpaRepository;
import com.snail.cloud.sc.demo.a.jpa.repository.DemoARepository;
import org.springframework.beans.factory.annotation.Autowired;

@SpDao
public class DemoADao extends BaseDao<DemoADo> {

    private final DemoARepository demoARepository;

    @Autowired
    public DemoADao(DemoARepository demoARepository) {
        this.demoARepository = demoARepository;
    }
    
    @Override
    protected AbstractJpaRepository<DemoADo, Long> getRepository() {
        return demoARepository;
    }

    @Override
    protected EntityPathBase<DemoADo> getEntityPathBase() {
        return QDemoADo.demoADo;
    }
}