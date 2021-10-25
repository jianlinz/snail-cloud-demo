package com.snail.cloud.demo.b.jpa.dao;

import com.querydsl.core.types.dsl.EntityPathBase;
import com.snail.cloud.demo.b.api.jpa.domain.QDemoBDo;
import indi.jl.sp.data.jpa.annotation.SpDao;
import indi.jl.sp.data.jpa.dao.BaseDao;
import com.snail.cloud.demo.b.api.jpa.domain.DemoBDo;
import indi.jl.sp.data.jpa.repository.AbstractJpaRepository;
import com.snail.cloud.demo.b.jpa.repository.DemoBRepository;
import org.springframework.beans.factory.annotation.Autowired;

@SpDao
public class DemoBDao extends BaseDao<DemoBDo> {

    private final DemoBRepository demoBRepository;

    @Autowired
    public DemoBDao(DemoBRepository demoBRepository) {
        this.demoBRepository = demoBRepository;
    }
    
    @Override
    protected AbstractJpaRepository<DemoBDo, Long> getRepository() {
        return demoBRepository;
    }

    @Override
    protected EntityPathBase<DemoBDo> getEntityPathBase() {
        return QDemoBDo.demoBDo;
    }
}