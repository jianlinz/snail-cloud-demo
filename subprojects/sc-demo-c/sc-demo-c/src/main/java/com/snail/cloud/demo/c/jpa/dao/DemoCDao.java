package com.snail.cloud.demo.c.jpa.dao;

import com.querydsl.core.types.dsl.EntityPathBase;
import com.snail.cloud.demo.c.api.jpa.domain.QDemoCDo;
import indi.jl.sp.data.jpa.annotation.SpDao;
import indi.jl.sp.data.jpa.dao.BaseDao;
import com.snail.cloud.demo.c.api.jpa.domain.DemoCDo;
import indi.jl.sp.data.jpa.repository.AbstractJpaRepository;
import com.snail.cloud.demo.c.jpa.repository.DemoCRepository;
import org.springframework.beans.factory.annotation.Autowired;

@SpDao
public class DemoCDao extends BaseDao<DemoCDo> {

    private final DemoCRepository demoCRepository;

    @Autowired
    public DemoCDao(DemoCRepository demoCRepository) {
        this.demoCRepository = demoCRepository;
    }
    
    @Override
    protected AbstractJpaRepository<DemoCDo, Long> getRepository() {
        return demoCRepository;
    }

    @Override
    protected EntityPathBase<DemoCDo> getEntityPathBase() {
        return QDemoCDo.demoCDo;
    }
}