package com.snail.cloud.demo.c.service.impl;

import com.snail.cloud.demo.c.jpa.dao.DemoCDao;
import com.snail.cloud.demo.c.api.jpa.domain.DemoCDo;
import com.snail.cloud.demo.c.service.DemoCService;
import org.springframework.beans.factory.annotation.Autowired;
import indi.jl.sp.core.domain.PageChunk;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DemoCServiceImpl implements DemoCService {

    private final DemoCDao demoCDao;

    @Autowired
    public DemoCServiceImpl(DemoCDao demoCDao) {
        this.demoCDao = demoCDao;
    }

    @Override
    public Optional<DemoCDo> get(Long id) {
        return demoCDao.getById(id);
    }

    @Override
    public DemoCDo save(DemoCDo demoCDo) {
        return demoCDao.save(demoCDo);
    }

    @Override
    public DemoCDo update(DemoCDo demoCDo) {
        return demoCDao.update(demoCDo);
    }

    @Override
    public void deleteByIds(List<Long> ids) {
        demoCDao.deleteByIds(ids);
    }
    
    @Override
    public List<DemoCDo> findAll(DemoCDo demoCDo) {
        return demoCDao.findAll(demoCDo);
    }

    @Override
    public PageChunk<DemoCDo> findAll(DemoCDo demoCDo, Pageable pageable) {
        return demoCDao.findAll(demoCDo, pageable);
    }

}