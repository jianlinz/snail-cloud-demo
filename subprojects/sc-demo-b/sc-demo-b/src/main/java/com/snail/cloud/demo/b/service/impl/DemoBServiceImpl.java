package com.snail.cloud.demo.b.service.impl;

import com.snail.cloud.demo.b.jpa.dao.DemoBDao;
import com.snail.cloud.demo.b.api.jpa.domain.DemoBDo;
import com.snail.cloud.demo.b.service.DemoBService;
import org.springframework.beans.factory.annotation.Autowired;
import indi.jl.sp.core.domain.PageChunk;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DemoBServiceImpl implements DemoBService {

    private final DemoBDao demoBDao;

    @Autowired
    public DemoBServiceImpl(DemoBDao demoBDao) {
        this.demoBDao = demoBDao;
    }

    @Override
    public Optional<DemoBDo> get(Long id) {
        return demoBDao.getById(id);
    }

    @Override
    public DemoBDo save(DemoBDo demoBDo) {
        return demoBDao.save(demoBDo);
    }

    @Override
    public DemoBDo update(DemoBDo demoBDo) {
        return demoBDao.update(demoBDo);
    }

    @Override
    public void deleteByIds(List<Long> ids) {
        demoBDao.deleteByIds(ids);
    }
    
    @Override
    public List<DemoBDo> findAll(DemoBDo demoBDo) {
        return demoBDao.findAll(demoBDo);
    }

    @Override
    public PageChunk<DemoBDo> findAll(DemoBDo demoBDo, Pageable pageable) {
        return demoBDao.findAll(demoBDo, pageable);
    }

}