package com.snail.cloud.demo.d.jpa.dao;

import com.querydsl.core.types.dsl.EntityPathBase;
import indi.jl.sp.data.jpa.annotation.SpDao;
import indi.jl.sp.data.jpa.dao.BaseDao;
import com.snail.cloud.demo.d.jpa.domain.DemoDDo;
import com.snail.cloud.demo.d.jpa.domain.QDemoDDo;
import indi.jl.sp.data.jpa.repository.AbstractJpaRepository;
import com.snail.cloud.demo.d.jpa.repository.DemoDRepository;
import org.springframework.beans.factory.annotation.Autowired;

@SpDao
public class DemoDDao extends BaseDao<DemoDDo> {

    private final DemoDRepository demoDRepository;

    @Autowired
    public DemoDDao(DemoDRepository demoDRepository) {
        this.demoDRepository = demoDRepository;
    }
    
    @Override
    protected AbstractJpaRepository<DemoDDo, Long> getRepository() {
        return demoDRepository;
    }

    @Override
    protected EntityPathBase<DemoDDo> getEntityPathBase() {
        return QDemoDDo.demoDDo;
    }
}