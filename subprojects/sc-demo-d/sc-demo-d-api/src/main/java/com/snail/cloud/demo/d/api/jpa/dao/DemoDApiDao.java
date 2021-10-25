package com.snail.cloud.demo.d.api.jpa.dao;

import com.querydsl.core.types.dsl.EntityPathBase;
import indi.jl.sp.data.jpa.annotation.SpDao;
import indi.jl.sp.data.jpa.dao.BaseDao;
import com.snail.cloud.demo.d.api.jpa.domain.DemoDApiDo;
import com.snail.cloud.demo.d.api.jpa.domain.QDemoDApiDo;
import indi.jl.sp.data.jpa.repository.AbstractJpaRepository;
import com.snail.cloud.demo.d.api.jpa.repository.DemoDApiRepository;
import org.springframework.beans.factory.annotation.Autowired;

@SpDao
public class DemoDApiDao extends BaseDao<DemoDApiDo> {

    private final DemoDApiRepository demoDApiRepository;

    @Autowired
    public DemoDApiDao(DemoDApiRepository demoDApiRepository) {
        this.demoDApiRepository = demoDApiRepository;
    }
    
    @Override
    protected AbstractJpaRepository<DemoDApiDo, Long> getRepository() {
        return demoDApiRepository;
    }

    @Override
    protected EntityPathBase<DemoDApiDo> getEntityPathBase() {
        return QDemoDApiDo.demoDApiDo;
    }
}