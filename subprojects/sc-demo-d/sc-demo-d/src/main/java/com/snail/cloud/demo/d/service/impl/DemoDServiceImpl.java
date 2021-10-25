package com.snail.cloud.demo.d.service.impl;

import com.snail.cloud.demo.d.service.DemoDService;
import com.snail.cloud.demo.d.jpa.dao.DemoDDao;
import com.snail.cloud.demo.d.jpa.domain.DemoDDo;
import org.springframework.beans.factory.annotation.Autowired;
import indi.jl.sp.core.domain.PageChunk;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DemoDServiceImpl implements DemoDService {

    private final DemoDDao demoDDao;

    @Autowired
    public DemoDServiceImpl(DemoDDao demoDDao) {
        this.demoDDao = demoDDao;
    }

    @Override
    public Optional<DemoDDo> get(Long id) {
        return demoDDao.getById(id);
    }

    @Override
    public DemoDDo save(DemoDDo demoDDo) {
        return demoDDao.save(demoDDo);
    }

    @Override
    public DemoDDo update(DemoDDo demoDDo) {
        return demoDDao.update(demoDDo);
    }

    @Override
    public void deleteByIds(List<Long> ids) {
        demoDDao.deleteByIds(ids);
    }
    
    @Override
    public List<DemoDDo> findAll(DemoDDo demoDDo) {
        return demoDDao.findAll(demoDDo);
    }

    @Override
    public PageChunk<DemoDDo> findAll(DemoDDo demoDDo, Pageable pageable) {
        return demoDDao.findAll(demoDDo, pageable);
    }

}